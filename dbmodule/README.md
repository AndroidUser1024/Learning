
移动端的应用，数据库存储作为持久化的一种手段，并非首选，稍微轻量一点的数据一般都存储在 SP 中。现在市面绝大多数应用都是需要注册账号的，如果数据需要长期保存且是跟随账号的，则需要存储在服务器上，移动端的存储大多作为一个缓存的功能存在，但这不代表 Android 的数据库技术不重要，相反，它正是开发人员必须掌握的持久化技术之一。

移动端应用不同于后台应用，没有那么多数据库可供选择，Android 和 iOS 都内置了一个轻量级的数据库——SQLite，Android 原生的数据库操作类 SQLiteOpenHelper，该类是一个抽象类，通过继承该类就可以实现对数据库的操作，但部分 API 比较晦涩，所以出现了一些数据库操作框架，现在主流的数据库框架如 GreenDao，ORMLite，Room 等，都是通过反射来生成 Sql 语句，通过 SQLiteOpenHelper 的实现类去执行这些 Sql，只是有的是编译时反射（GreenDao，Room），相比较运行时反射（ORMLite）效率会更高一些，但其本质最终执行的都是 Sql 语句。了解这一点后，我们再去封装一个数据库框架就会更明白我们要如何去做了。

该库参考 Java 的 MyBatis 思想，作为一个半自动的库，让开发人员编写预定义 Sql（个人建议还是写 Sql，如果你只是会使用 GreenDao，ORMLite 或 Room，那在 Android 平台上可以搞定数据库操作没有问题，但是如果换一个平台，如 iOS、Flutter，那还得去学习新的框架，框架是为了方便开发的，要学会的是技术本质），然后通过一个工具类动态代理获取各 Dao 层实例，去执行我们编写的 Sql。当然，数据库操作 80% 都是查询操作，所以对查询结果映射成实体类这种操作也是要封装的。

# 基本使用
1. 在实体类上添加 @Table 注解，类中属性添加 @Column 注解，那么 DatabaseManager 初始化时就会根据这两个注解生成对应表，每个实体类必须用 @Id 注解指定一个主键。
2. 调用 DatabaseManager.getInstance().init(context, dbName, dbVersion, classArray) 方法初始化数据库工具类，其中 dbName 为数据库名，dbVersion 为数据库版本，classArray 为需要生成对应表的各类。
3. 定义各 Dao 的接口并继承自 IBaseDao<T,ID>，T 为表对应实体类，ID 为表的主键类型，IBaseDao 中内置了一些基本的增删改查操作。
4. 在内置的方法不能满足需求的情况下，需要在自己定义的 Dao 接口中定义方法，并在该方法上使用相应注解，编写预定义 Sql 语句。

    eg：
    ```java
    @Insert("INSERT INTO book(" +
            " name" +
            ",author" +
            ",price" +
            " ) VALUES (" +
            " #{name}" +
            ",#{author}" +
            ",#{price}" +
            ")")
    int insert(@Param("name") String name, @Param("author") String author, @Param("price") float price);

    @Delete("DELETE FROM book" +
            " WHERE" +
            " name=#{name}" +
            " AND" +
            " author=#{author}" +
            " AND" +
            " price=#{price}")
    int delete(@ObjParam BookBean bookBean);

    @Select("SELECT" +
            " name" +
            ",author" +
            ",price" +
            " FROM book" +
            " WHERE" +
            " price=#{price}")
    List<BookBean> selectListByPrice(@Param("price") float price);

    @Select("SELECT" +
            " name" +
            ",author" +
            ",price" +
            " FROM book" +
            " WHERE" +
            " author=#{author}")
    BookBean selectByAuthor(@Param("author") String author);
    ```
    其中 @Insert 对应插入操作，@Delete 对应删除操作，@Update 对应更新操作，@Select 对应查询操作，预定义的 Sql 中，可以使用 #{xxx} 作为参数占位符，传参需要添加 @Param，值与占位符中的值相对应，如上面的 @Param("name") String name 这个参数，就会作为 #{name} 的值。
    
    除了可以使用基本类型传参，也可以所有参数封装成一个实体类传参，需要添加 @ObjParam 注解，内部则会查询该对象中与占位符中的值相对应的成员变量。
5. 调用 DatabaseManager.getDao(Class&lt;T&gt; clazz) 获取对应 Dao，然后调用 Dao 中的方法即可。
   
   eg：
    ```java
    IBookDao bookDao = DatabaseManager.getInstance().getDao(IBookDao.class);
    List<BookBean> bookBeanList = mBookDao.selectList();
    Log.i(TAG, "bookBeanList--->" + bookBeanList);
    ```

# 敬请期待
- 联合主键
- 约束
- 事务
- 分页插件
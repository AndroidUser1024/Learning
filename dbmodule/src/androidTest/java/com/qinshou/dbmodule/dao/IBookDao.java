package com.qinshou.dbmodule.dao;

import com.qinshou.dbmodule.annotation.Insert;
import com.qinshou.dbmodule.annotation.Param;
import com.qinshou.dbmodule.annotation.Select;
import com.qinshou.dbmodule.bean.BookBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/21 16:02
 * Description:类描述
 */
public interface IBookDao extends IBaseDao<BookBean, Integer> {
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
}

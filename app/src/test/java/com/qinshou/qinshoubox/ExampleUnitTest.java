package com.qinshou.qinshoubox;

import androidx.core.app.Person;

import com.qinshou.commonmodule.db.SqlUtil;
import com.qinshou.commonmodule.db.Where;
import com.qinshou.qinshoubox.friend.bean.UserDetailBean;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testSql() {
        SqlUtil.getCreateTableSql(UserDetailBean.class);
        UserDetailBean userDetailBean = new UserDetailBean();
        userDetailBean.setId("10000");
        userDetailBean.setUsername("cqflqinhao");
        userDetailBean.setNickname("Mr禽兽");
        userDetailBean.setGender(1);
        try {
            SqlUtil.getInsertSql(userDetailBean);
            SqlUtil.getDeleteSql(userDetailBean);
            SqlUtil.getDeleteSql(UserDetailBean.class, new Where.Builder()
                    .equal("gender", "0")
                    .build());
            SqlUtil.getDeleteSql(UserDetailBean.class, new Where.Builder()
                    .greaterThanOrEqual("id", "10000")
                    .and()
                    .equal("username", "cqflqinhao")
                    .build());
            userDetailBean.setGender(2);
            SqlUtil.getUpdateSql(userDetailBean);
            SqlUtil.getUpdateSql(userDetailBean, new Where.Builder()
                    .greaterThanOrEqual("id", "10000")
                    .build());
            SqlUtil.getQuerySql(UserDetailBean.class, null);
            SqlUtil.getQuerySql(UserDetailBean.class, new Where.Builder().equal("pid", 1).build());
        } catch (IllegalArgumentException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
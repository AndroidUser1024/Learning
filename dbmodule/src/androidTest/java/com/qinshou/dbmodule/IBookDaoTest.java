package com.qinshou.dbmodule;

import android.content.Context;
import android.util.Log;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.qinshou.dbmodule.bean.BookBean;
import com.qinshou.dbmodule.dao.IBookDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/20 10:31
 * Description:类描述
 */
@RunWith(AndroidJUnit4.class)
public class IBookDaoTest {
    private String TAG = "IBookDaoTest";
    private IBookDao mBookDao;

    @Before
    public void init() {
        Context context = ApplicationProvider.getApplicationContext();
        DatabaseManager.getInstance().init(context
                , "tmp"
                , 1
                , BookBean.class);
        mBookDao = DatabaseManager.getInstance().getDao(IBookDao.class);
        List<BookBean> bookBeanList = mBookDao.selectList();
        Log.i(TAG, "bookBeanList--->" + bookBeanList);
    }

    @Test
    public void testInsert() {
        BookBean bookBean = new BookBean("Android 开发艺术探索", "任玉刚", 45.8f);
        Log.i(TAG, "bookBean--->" + bookBean);
        int insert = mBookDao.insert(bookBean);
        Log.i(TAG, "insert--->" + insert);
        Log.i(TAG, "bookBean--->" + bookBean);
    }

    @Test
    public void testInsert2() {
        int insert = mBookDao.insert("Android 群英传", "徐宜生", 39.8f);
        Log.i(TAG, "insert--->" + insert);
    }

    @Test
    public void testDelete() {
        int delete = mBookDao.deleteById(1);
        Log.i(TAG, "delete--->" + delete);
    }

    @Test
    public void testUpdate() {
        BookBean bookBean = mBookDao.selectById(2);
        if (bookBean != null) {
            bookBean.setPrice(59.8f);
            mBookDao.updateById(bookBean);
        }
    }

    @Test
    public void testSelect() {
        BookBean bookBean = mBookDao.selectById(2);
        Log.i(TAG, "bookBean--->" + bookBean);
    }
    @Test
    public void testSelectByAuthor() {
        BookBean bookBean = mBookDao.selectByAuthor("任玉刚");
        Log.i(TAG, "bookBean--->" + bookBean);
    }

//    @After
    public void testSelectList() {
        List<BookBean> bookBeanList = mBookDao.selectList();
        Log.i(TAG, "bookBeanList--->" + bookBeanList);
    }

    @Test
    public void testSelectListByPrice() {
        List<BookBean> bookBeanList = mBookDao.selectListByPrice(39.8f);
        Log.i(TAG, "bookBeanList--->" + bookBeanList);
    }
}

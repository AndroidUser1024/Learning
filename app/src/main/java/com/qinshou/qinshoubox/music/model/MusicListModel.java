package com.qinshou.qinshoubox.music.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;


import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.music.bean.MusicBean;
import com.qinshou.qinshoubox.music.contract.IMusicListContract;
import com.qinshou.qinshoubox.music.view.fragment.MusicListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:{@link MusicListFragment} 的 CameraModel
 * Author: QinHao
 * Date: 2019/4/4 17:40
 */
public class MusicListModel implements IMusicListContract.IMusicListModel {
    public void getMusicList(Context context, Callback<List<MusicBean>> callback) {
        List<MusicBean> musicBeanList = new ArrayList<>();
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        if (cursor == null) {
            callback.onFailure(new Exception("查询失败"));
            return;
        }
        while (cursor.moveToNext()) {
            MusicBean musicBean = new MusicBean();
            musicBean.setAlbum(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM)));
            musicBean.setArtist(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)));
            musicBean.setDuration(cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION)));
            musicBean.setName(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)));
            musicBean.setPath(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)));
            musicBean.setSize(cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE)));
            musicBeanList.add(musicBean);
        }
        cursor.close();
        callback.onSuccess(musicBeanList);
    }

    public void getMusicList(Context context, int page, int pageSize, Callback<List<MusicBean>> callback) {
        List<MusicBean> musicBeanList = new ArrayList<>();
        ContentResolver contentResolver = context.getContentResolver();
        int offset = (page - 1) * pageSize;
        Cursor cursor = contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, "_ID ASC LIMIT " + pageSize + " OFFSET " + offset);
        if (cursor == null) {
            callback.onFailure(new Exception("查询失败"));
            return;
        }
        while (cursor.moveToNext()) {
            MusicBean musicBean = new MusicBean();
            musicBean.setAlbum(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM)));
            musicBean.setArtist(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)));
            musicBean.setDuration(cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION)));
            musicBean.setName(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)));
            musicBean.setPath(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)));
            musicBean.setSize(cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE)));
            musicBeanList.add(musicBean);
        }
        cursor.close();
        callback.onSuccess(musicBeanList);
    }
}

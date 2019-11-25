package com.qinshou.qinshoubox.music.view.adapter;

import android.content.Context;
import android.os.Bundle;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.commonmodule.rcvbaseadapter.RcvBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.listener.IOnItemClickListener;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.music.bean.MusicBean;
import com.qinshou.qinshoubox.music.view.fragment.MusicPlayFragment;

import java.util.ArrayList;

/**
 * Description:音乐列表适配器
 * Author: QinHao
 * Date: 2019/4/4 18:24
 */
public class RcvMusicAdapter extends RcvBaseAdapter<MusicBean> {

    public RcvMusicAdapter(Context context) {
        super(context, R.layout.item_rcv_music);
        setOnItemClickListener(new IOnItemClickListener<MusicBean>() {
            @Override
            public void onItemClick(BaseViewHolder holder, MusicBean itemData, int position) {
                ArrayList<MusicBean> musicList = new ArrayList<>(getDataList());
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("MusicList", musicList);
                bundle.putInt("index", position);
                getContext().startActivity(ContainerActivity.getJumpIntent(getContext(), MusicPlayFragment.class, bundle));
            }
        });
    }

    @Override
    public void bindViewHolder(BaseViewHolder holder, MusicBean itemData, int position) {
        holder.setTvText(R.id.tv_index, "" + (position + 1));
        holder.setTvText(R.id.tv_name, itemData.getName());
        holder.setTvText(R.id.tv_artist_and_album, itemData.getArtist() + "-" + itemData.getAlbum());
    }
}

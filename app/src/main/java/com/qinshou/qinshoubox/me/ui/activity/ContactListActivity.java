package com.qinshou.qinshoubox.me.ui.activity;

import android.database.Cursor;
import android.provider.ContactsContract;
import androidx.recyclerview.widget.RecyclerView;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.commonmodule.rcvdecoration.StickyDecoration;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSActivity;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.me.ui.adapter.RvContactAdapter;
import com.qinshou.qinshoubox.me.bean.ContactBean;
import com.qinshou.qinshoubox.me.comparator.PinyinComparator;
import com.qinshou.qinshoubox.me.ui.widget.WaveSideBar;
import com.qinshou.qinshoubox.util.PinyinUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 * Created by 禽兽先生
 * Created on 2018/11/8
 */
public class ContactListActivity extends QSActivity<AbsPresenter> {

    private RecyclerView rvContact;
    private RvContactAdapter mRvContactAdapter;
    private WaveSideBar waveSideBar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_contact_list;
    }

    @Override
    public void initView() {
//        rvContact = findViewByID(R.id.rv_contact);
//        rvContact.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
//        mRvContactAdapter = new RvContactAdapter(getContext());
//        rvContact.setAdapter(mRvContactAdapter);
//        waveSideBar = findViewByID(R.id.wave_side_bar);
    }

    @Override
    public void setListener() {
    }

    @Override
    public void initData() {
//        PermissionUtil.requestPermission(getActivity(), Manifest.permission.READ_CONTACTS, new IOnRequestPermissionResultCallBack() {
//            @Override
//            public void onSuccess() {
//                List<ContactBean> contactBeanList = getContactList();
//                //对联系人集合排序
//                Collections.sort(contactBeanList, new ContactComparator());
//                mRvContactAdapter.setDataList(contactBeanList);
//                //添加粘性头部
//                MyStickyHeadDecoration myStickyHeadDecoration = new MyStickyHeadDecoration(contactBeanList);
//                rvContact.addItemDecoration(myStickyHeadDecoration);
//                //为侧边索引设置数据
//                waveSideBar.setIndexItems(getIndexList(contactBeanList));
//                waveSideBar.setOnSelectIndexItemListener(new WaveSideBarListener(contactBeanList));
//            }
//
//            @Override
//            public void onError(List<String> deniedPermissionList) {
//                ShowLogUtil.logi("没有获取联系人权限");
//            }
//        });
    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {
    }

    /**
     * Description:获取系统的所有的联系人信息,为联系人集合和索引集合赋值
     * Date:2018/6/15
     */
    public List<ContactBean> getContactList() {
        List<ContactBean> contactsEntityList = new ArrayList<>();
        String[] cols = {ContactsContract.PhoneLookup.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER};
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, cols, null, null, null);
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                ContactBean contactsEntity = new ContactBean();
                // 取得联系人名字
                int nameColumn = cursor.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME);
                // 取得联系人号码
                int numberColumn = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String name = cursor.getString(nameColumn);
                contactsEntity.setName(name);
                String number = cursor.getString(numberColumn);
                contactsEntity.setPhoneNumber(number);
                String pinyin = PinyinUtil.getPingYin(name);
                String sortString = pinyin.substring(0, 1).toUpperCase();
                if (sortString.matches("[A-Z]")) {
                    contactsEntity.setSortLetter(sortString.toUpperCase());
                } else if (sortString.equals("@")) {
                    contactsEntity.setSortLetter("@");
                } else {
                    contactsEntity.setSortLetter("#");
                }
                contactsEntityList.add(contactsEntity);
            }
            cursor.close();
        }
        return contactsEntityList;
    }

    /**
     * Description:根据联系人集合获取索引集合
     * Date:2018/6/15
     */
    private List<String> getIndexList(List<ContactBean> contactsList) {
        List<String> indexList = new ArrayList<>();
        for (ContactBean contactsEntity : contactsList) {
            if (!indexList.contains(contactsEntity.getSortLetter())) {
                indexList.add(contactsEntity.getSortLetter());
            }
        }
        Collections.sort(indexList, new PinyinComparator());
        return indexList;
    }

    private class MyStickyHeadDecoration extends StickyDecoration {
        private List<ContactBean> mContactBeanList;

        MyStickyHeadDecoration(List<ContactBean> contactBeanList) {
            this.mContactBeanList = contactBeanList;
//            setHeaderHeight(DisplayUtil.dp2px(getContext(), 18));
//            setTextSize(DisplayUtil.sp2px(getContext(), 12));
//            setTextColor(Color.parseColor("#FF454545"));
//            setTextPaddingLeft(DisplayUtil.dp2px(getContext(), 15));
        }

        @Override
        public String getStickyHeaderName(int position) {
            if (mContactBeanList == null || mContactBeanList.isEmpty()) {
                return null;
            }
            return mContactBeanList.get(position).getSortLetter();
        }
    }

//    private class WaveSideBarListener extends WaveSideBar.IOnItemSelectedListener {
//        private List<ContactBean> mContactBeanList;
//
//        WaveSideBarListener(List<ContactBean> contactBeanList) {
//            this.mContactBeanList = contactBeanList;
//        }
//
//        @Override
//        public void onSelectIndexItem(String index) {
//            if (mContactBeanList == null || mContactBeanList.isEmpty()) {
//                return;
//            }
////            tvIndex.setVisibility(View.VISIBLE);
////            tvIndex.setText(index);
//            for (ContactBean contactBean : mContactBeanList) {
//                if (contactBean.getSortLetter().equals(index)) {
//                    LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(getContext()) {
//                        //重新计算滚动时间,保证最长滚动时间不超过多少
//                        @Override
//                        protected int calculateTimeForScrolling(int dx) {
//                            if (dx > 3000) {
//                                dx = 3000;
//                            }
//                            return super.calculateTimeForScrolling(dx);
//                        }
//
//                        //计算滚动位置,让滚动到的目标位置显示在第一个
//                        @Override
//                        public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
//                            return boxStart - viewStart;
//                        }
//                    };
//                    linearSmoothScroller.setTargetPosition(mContactBeanList.indexOf(contactBean));
//                    rvContact.getLayoutManager().startSmoothScroll(linearSmoothScroller);
//                    break;
//                }
//            }
//        }
//
//        @Override
//        public void onCancelSelectIndexItem() {
//            if (mContactBeanList == null || mContactBeanList.isEmpty()) {
//                return;
//            }
////            tvIndex.setVisibility(View.INVISIBLE);
//        }
//    }
}

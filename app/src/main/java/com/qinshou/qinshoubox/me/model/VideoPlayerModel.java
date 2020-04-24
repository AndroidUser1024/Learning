package com.qinshou.qinshoubox.me.model;

import com.qinshou.networkmodule.callback.Callback;
import com.qinshou.qinshoubox.me.bean.MediaSourceBean;
import com.qinshou.qinshoubox.me.contract.IVideoPlayerContract;
import com.qinshou.qinshoubox.me.ui.fragment.VideoPlayerActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 20-2-3 上午9:41
 * Description:{@link VideoPlayerActivity} 的 M 层
 */
public class VideoPlayerModel implements IVideoPlayerContract.IModel {

    @Override
    public void getHlsPlayList(Callback<List<MediaSourceBean>> callback) {
        List<MediaSourceBean> mediaSourceBeanList = new ArrayList<>();

//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-1高清", "http://ivi.bupt.edu.cn//hls/cctv1hd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-2高清", "http://ivi.bupt.edu.cn//hls/cctv2hd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-3高清", "http://ivi.bupt.edu.cn//hls/cctv3hd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-4高清", "http://ivi.bupt.edu.cn//hls/cctv4hd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-5+高清", "http://ivi.bupt.edu.cn//hls/cctv5phd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-6高清", "http://ivi.bupt.edu.cn//hls/cctv6hd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-7高清", "http://ivi.bupt.edu.cn//hls/cctv7hd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-8高清", "http://ivi.bupt.edu.cn//hls/cctv8hd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-9高清", "http://ivi.bupt.edu.cn//hls/cctv9hd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-10高清", "http://ivi.bupt.edu.cn//hls/cctv10hd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-12高清", "http://ivi.bupt.edu.cn//hls/cctv12hd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-14高清", "http://ivi.bupt.edu.cn//hls/cctv14hd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-17高清", "http://ivi.bupt.edu.cn//hls/cctv17hd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CGTN高清", "http://ivi.bupt.edu.cn//hls/cgtnhd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CGTN DOC高清", "http://ivi.bupt.edu.cn//hls/cgtndochd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CHC高清电影", "http://ivi.bupt.edu.cn//hls/chchd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("北京卫视高清", "http://ivi.bupt.edu.cn//hls/btv1hd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("北京文艺高清", "http://ivi.bupt.edu.cn//hls/btv2hd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("北京影视高清", "http://ivi.bupt.edu.cn//hls/btv4hd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("北京新闻高清", "http://ivi.bupt.edu.cn//hls/btv9hd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("北京冬奥纪实高清", "http://ivi.bupt.edu.cn//hls/btv11hd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("湖南卫视高清", "http://ivi.bupt.edu.cn//hls/hunanhd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("浙江卫视高清", "http://ivi.bupt.edu.cn//hls/zjhd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("江苏卫视高清", "http://ivi.bupt.edu.cn//hls/jshd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("东方卫视高清", "http://ivi.bupt.edu.cn//hls/dfhd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("安徽卫视高清", "http://ivi.bupt.edu.cn//hls/ahhd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("黑龙江卫视高清", "http://ivi.bupt.edu.cn//hls/hljhd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("辽宁卫视高清", "http://ivi.bupt.edu.cn//hls/lnhd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("深圳卫视高清", "http://ivi.bupt.edu.cn//hls/szhd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("广东卫视高清", "http://ivi.bupt.edu.cn//hls/gdhd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("天津卫视高清", "http://ivi.bupt.edu.cn//hls/tjhd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("湖北卫视高清", "http://ivi.bupt.edu.cn//hls/hbhd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("山东卫视高清", "http://ivi.bupt.edu.cn//hls/sdhd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("重庆卫视高清", "http://ivi.bupt.edu.cn//hls/cqhd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("上海纪实高清", "http://ivi.bupt.edu.cn//hls/docuchina.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("金鹰纪实高清", "http://ivi.bupt.edu.cn//hls/gedocu.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("福建东南卫视高清", "http://ivi.bupt.edu.cn//hls/dnhd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("四川卫视高清", "http://ivi.bupt.edu.cn//hls/schd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("河北卫视高清", "http://ivi.bupt.edu.cn//hls/hebhd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("江西卫视高清", "http://ivi.bupt.edu.cn//hls/jxhd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("河南卫视高清", "http://ivi.bupt.edu.cn//hls/hnhd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("广西卫视高清", "http://ivi.bupt.edu.cn//hls/gxhd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("吉林卫视高清", "http://ivi.bupt.edu.cn//hls/jlhd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CETV-1高清", "http://ivi.bupt.edu.cn//hls/cetv1hd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("海南卫视高清", "http://ivi.bupt.edu.cn//hls/lyhd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("贵州卫视高清", "http://ivi.bupt.edu.cn//hls/gzhd.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-1综合", "http://ivi.bupt.edu.cn//hls/cctv1.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-2财经", "http://ivi.bupt.edu.cn//hls/cctv2.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-3综艺", "http://ivi.bupt.edu.cn//hls/cctv3.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-4中文国际", "http://ivi.bupt.edu.cn//hls/cctv4.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-6电影", "http://ivi.bupt.edu.cn//hls/cctv6.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-7国防军事", "http://ivi.bupt.edu.cn//hls/cctv7.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-8电视剧", "http://ivi.bupt.edu.cn//hls/cctv8.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-9纪录", "http://ivi.bupt.edu.cn//hls/cctv9.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-10科教", "http://ivi.bupt.edu.cn//hls/cctv10.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-11戏曲", "http://ivi.bupt.edu.cn//hls/cctv11.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-12社会与法", "http://ivi.bupt.edu.cn//hls/cctv12.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-13新闻", "http://ivi.bupt.edu.cn//hls/cctv13.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-14少儿", "http://ivi.bupt.edu.cn//hls/cctv14.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-15音乐", "http://ivi.bupt.edu.cn//hls/cctv15.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CGTN", "http://ivi.bupt.edu.cn//hls/cctv16.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CCTV-17农业农村", "http://ivi.bupt.edu.cn//hls/cctv17.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("北京卫视", "http://ivi.bupt.edu.cn//hls/btv1.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("北京文艺", "http://ivi.bupt.edu.cn//hls/btv2.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("北京科教", "http://ivi.bupt.edu.cn//hls/btv3.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("北京影视", "http://ivi.bupt.edu.cn//hls/btv4.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("北京财经", "http://ivi.bupt.edu.cn//hls/btv5.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("北京生活", "http://ivi.bupt.edu.cn//hls/btv7.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("北京青年", "http://ivi.bupt.edu.cn//hls/btv8.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("北京新闻", "http://ivi.bupt.edu.cn//hls/btv9.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("北京卡酷少儿", "http://ivi.bupt.edu.cn//hls/btv10.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("北京冬奥纪实", "http://ivi.bupt.edu.cn//hls/btv11.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("浙江卫视", "http://ivi.bupt.edu.cn//hls/zjtv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("湖南卫视", "http://ivi.bupt.edu.cn//hls/hunantv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("江苏卫视", "http://ivi.bupt.edu.cn//hls/jstv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("东方卫视", "http://ivi.bupt.edu.cn//hls/dftv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("深圳卫视", "http://ivi.bupt.edu.cn//hls/sztv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("安徽卫视", "http://ivi.bupt.edu.cn//hls/ahtv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("河南卫视", "http://ivi.bupt.edu.cn//hls/hntv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("陕西卫视", "http://ivi.bupt.edu.cn//hls/sxtv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("吉林卫视", "http://ivi.bupt.edu.cn//hls/jltv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("广东卫视", "http://ivi.bupt.edu.cn//hls/gdtv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("山东卫视", "http://ivi.bupt.edu.cn//hls/sdtv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("湖北卫视", "http://ivi.bupt.edu.cn//hls/hbtv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("广西卫视", "http://ivi.bupt.edu.cn//hls/gxtv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("河北卫视", "http://ivi.bupt.edu.cn//hls/hebtv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("西藏卫视", "http://ivi.bupt.edu.cn//hls/xztv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("内蒙古卫视", "http://ivi.bupt.edu.cn//hls/nmtv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("青海卫视", "http://ivi.bupt.edu.cn//hls/qhtv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("四川卫视", "http://ivi.bupt.edu.cn//hls/sctv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("天津卫视", "http://ivi.bupt.edu.cn//hls/tjtv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("山西卫视", "http://ivi.bupt.edu.cn//hls/sxrtv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("辽宁卫视", "http://ivi.bupt.edu.cn//hls/lntv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("厦门卫视", "http://ivi.bupt.edu.cn//hls/xmtv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("新疆卫视", "http://ivi.bupt.edu.cn//hls/xjtv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("黑龙江卫视", "http://ivi.bupt.edu.cn//hls/hljtv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("云南卫视", "http://ivi.bupt.edu.cn//hls/yntv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("江西卫视", "http://ivi.bupt.edu.cn//hls/jxtv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("福建东南卫视", "http://ivi.bupt.edu.cn//hls/dntv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("贵州卫视", "http://ivi.bupt.edu.cn//hls/gztv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("宁夏卫视", "http://ivi.bupt.edu.cn//hls/nxtv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("甘肃卫视", "http://ivi.bupt.edu.cn//hls/gstv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("重庆卫视", "http://ivi.bupt.edu.cn//hls/cqtv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("兵团卫视", "http://ivi.bupt.edu.cn//hls/bttv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("延边卫视", "http://ivi.bupt.edu.cn//hls/ybtv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("三沙卫视", "http://ivi.bupt.edu.cn//hls/sstv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("海南卫视", "http://ivi.bupt.edu.cn//hls/lytv.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CETV-1", "http://ivi.bupt.edu.cn//hls/cetv1.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CETV-3", "http://ivi.bupt.edu.cn//hls/cetv3.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("CETV-4", "http://ivi.bupt.edu.cn//hls/cetv4.m3u8"));
//        mediaSourceBeanList.add(new MediaSourceBean("山东教育", "http://ivi.bupt.edu.cn//hls/sdetv.m3u8"));

        mediaSourceBeanList.add(new MediaSourceBean("【武汉复苏】12小时不间断直播 航拍武汉开城重启", "https://mlivetxyc.liveplay.myqcloud.com/mlive/mlive_sls02_1_hd.m3u8"));
        mediaSourceBeanList.add(new MediaSourceBean("厦门鼓浪屿", "https://gctxyc.liveplay.myqcloud.com/gc/gly01_1_md.m3u8"));
        mediaSourceBeanList.add(new MediaSourceBean("郑东新区千玺广场", "https://gccncc.v.wscdns.com/gc/zdxq01_1/index.m3u8?contentid=2820180516001"));
        mediaSourceBeanList.add(new MediaSourceBean("婺源江岭2号观景台", "https://gcbsc.v.live.baishancdnx.cn/gc/wygjt2_1/index.m3u8?contentid=2820180516001"));
        mediaSourceBeanList.add(new MediaSourceBean("西藏珠峰观景台", "https://gcbsc.v.live.baishancdnx.cn/gc/tyhjrys_1/index.m3u8?contentid=2820180516001"));
        mediaSourceBeanList.add(new MediaSourceBean("千年侗寨，梦幻肇兴", "https://mlivecncc.v.wscdns.com/mlive/cctv_news02_1/index.m3u8?contentid=2820180516001"));

        callback.onSuccess(mediaSourceBeanList);
    }
}

package com.example.administrator.travel_app;

import com.example.administrator.travel_app.bean.ModuleBean;
import com.example.administrator.travel_app.bean.ScenceBean;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private static final String[] SCENCE_TITLE = {"西安钟楼", "大雁塔", "华清池", "回民街","昆明池","大唐芙蓉园"};
    private static final int[][] SCENCE_IMAEG =
            {{R.drawable.view_6_2},
                    {R.drawable.view_2_1, R.drawable.view_2_2},
                    {R.drawable.view_3_1},
                    {R.drawable.view_4_1, R.drawable.view_4_2},
                    {R.drawable.view_5_1},
                    {R.drawable.view_1_1, R.drawable.view_1_2}};

    private static final int[] SCENCE_INTRODUCE = {R.string.view_6,
            R.string.view_2,
            R.string.view_3,
            R.string.view_4,
            R.string.view_5,
            R.string.view_1};

    private static final String[] SCENCE_DESCRIBE = {"暮鼓晨钟、交相辉映、凝望千年",
            "一眼千年、一世信仰",
            "不尽温柔汤泉水，千古风流华清宫",
            "看万象灯火，品陕地美食",
            "千年昆明池，西安新名片",
            "江头宫殿锁千门，细柳新蒲为谁绿"};

    private static final String[] SCENCE_PRICE = {"套票50元，学生票40元",
            "景区免费 大慈恩寺:65元",
            "旺季110元/人：淡季80元/人",
            "无",
            "无",
        "旺季120元/人：淡季90元/人"};

    private static final String[] SCENCE_POSITION= {"陕西省西安市莲湖区东大街和西大街交汇处",
            "陕西省西安市雁塔区大雁塔街道广场东路3号",
            "西安市临潼区华清路38号",
            "西安市莲湖区西大街1号回民街街口",
            "陕西省西安市长安区昆明池",
            "西安市雁塔区曲江新区芙蓉西路99号"};
    private static final String[] SCENCE_LOCATION = {"34.265725,108.95346",
            "34.225619,108.971152",
            "34.370879,109.21814",
            "34.266723,108.950249",
            "34.21099,108.779778",
            "34.218949,108.980724"};
    private static final String[] SCENCE_TIME = {"8:00-22:00",
            "全天 大慈恩寺:9:00-17:00",
            "旺季7:00-18:00  淡季7:30-18:30",
            "全天",
            "全天",
            "9:00——22:00（21:30清园）"};
    private static final String[] SCENCE_PHINE = {"无",
            "029-85527958",
            "029-83812003",
            "无",
            "029-89505555"
            ,"029-85527958"};
    private static final String[] SCENCE_LABLE = {"景点",
            "景点",
            "景点",
            "文化美食街",
            "景点",
            "景点",};
    private static final int[] SCENCE_ID = {0,1,2,3,4,5,6};

    public static List<ScenceBean> getScenceData(boolean isAll){
        List<ScenceBean> scenceBeanList = new ArrayList<>();

        if(isAll){
            for(int x=0;x<SCENCE_TITLE.length;x++){
                ScenceBean bean= new ScenceBean();
                bean.setId(SCENCE_ID[x]);
                bean.setPhone(SCENCE_PHINE[x]);
                bean.setImgID(SCENCE_IMAEG[x]);
                bean.setTime(SCENCE_TIME[x]);
                bean.setIntroduce(SCENCE_INTRODUCE[x]);
                bean.setTitle(SCENCE_TITLE[x]);
                bean.setPosition(SCENCE_POSITION[x]);
                bean.setPrice(SCENCE_PRICE[x]);
                bean.setDescribe(SCENCE_DESCRIBE[x]);
                bean.setLable(SCENCE_LABLE[x]);
                bean.setLocation(SCENCE_LOCATION[x]);
                scenceBeanList.add(bean);
            }
        }else {
            for(int x=0;x<6;x++){
                ScenceBean bean= new ScenceBean();
                bean.setId(SCENCE_ID[x]);
                bean.setTime(SCENCE_TIME[x]);
                bean.setImgID(SCENCE_IMAEG[x]);
                bean.setPhone(SCENCE_PHINE[x]);
                bean.setIntroduce(SCENCE_INTRODUCE[x]);
                bean.setTitle(SCENCE_TITLE[x]);
                bean.setPosition(SCENCE_POSITION[x]);
                bean.setPrice(SCENCE_PRICE[x]);
                bean.setDescribe(SCENCE_DESCRIBE[x]);
                bean.setLable(SCENCE_LABLE[x]);
                bean.setLocation(SCENCE_LOCATION[x]);
                scenceBeanList.add(bean);
            }
        }

        return scenceBeanList;
    }

    public static List<ScenceBean> getModleData(){
        List<ScenceBean> scenceBeanList = new ArrayList<>();
        for(int x=0;x<TITLE.length;x++){
            ScenceBean bean= new ScenceBean();
            bean.setId(SCENCE_ID[x]);
            bean.setPhone(SCENCE_PHINE[x]);
            bean.setImgID(SCENCE_IMAEG[x]);
            bean.setTime(SCENCE_TIME[x]);
            bean.setIntroduce(SCENCE_INTRODUCE[x]);
            bean.setTitle(TITLE[x]);
            bean.setPosition(SCENCE_POSITION[x]);
            bean.setPrice(SCENCE_PRICE[x]);
            bean.setDescribe(SCENCE_DESCRIBE[x]);
            bean.setLable(SCENCE_LABLE[x]);
            bean.setLocation(SCENCE_LOCATION[x]);
            scenceBeanList.add(bean);
        }
        return scenceBeanList;
    }

    private static final String[] TITLE = {"德福巷", "城隍庙", "广济街", "回民街","万达广场","西安城墙"};


    public static List<ScenceBean> getSearchList(String key){
        List<ScenceBean> scenceBeanList = new ArrayList<>();

        if(key.isEmpty()){
            return scenceBeanList;
        }

        for(int x=0;x<SCENCE_TITLE.length;x++) {

            if(SCENCE_TITLE[x].contains(key)) {
                ScenceBean bean = new ScenceBean();
                bean.setId(SCENCE_ID[x]);
                bean.setPhone(SCENCE_PHINE[x]);
                bean.setImgID(SCENCE_IMAEG[x]);
                bean.setIntroduce(SCENCE_INTRODUCE[x]);
                bean.setTime(SCENCE_TIME[x]);
                bean.setTitle(SCENCE_TITLE[x]);
                bean.setPosition(SCENCE_POSITION[x]);
                bean.setPrice(SCENCE_PRICE[x]);
                bean.setDescribe(SCENCE_DESCRIBE[x]);
                bean.setLable(SCENCE_LABLE[x]);
                bean.setLocation(SCENCE_LOCATION[x]);
                scenceBeanList.add(bean);
            }
        }

        return scenceBeanList;
    }

    //========================================================================================================================================================================
    private static final String[] MOUDLE_TITLE = {"古城板块", "曲江板块", "临潼板块", "高新板块", "浐灞板块", "西咸板块"};
    private static final int[] MOUDLE_IMAEG = {R.drawable.model_0, R.drawable.modle_qujiang, R.drawable.modle_lintong, R.drawable.modle_gaoxing, R.drawable.modle_xixian, R.drawable.modle_chanba};

    public static List<ModuleBean> getMoudleData(){
        List<ModuleBean> moduleBeanList = new ArrayList<>();

        for(int x=0;x<MOUDLE_TITLE.length;x++){
            ModuleBean bean= new ModuleBean();
            bean.setImgID(MOUDLE_IMAEG[x]);
            bean.setTitle(MOUDLE_TITLE[x]);
            moduleBeanList.add(bean);
        }
        return moduleBeanList;
    }

    //========================================================================================================================================================================


}

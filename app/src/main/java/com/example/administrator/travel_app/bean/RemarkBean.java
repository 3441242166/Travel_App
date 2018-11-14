package com.example.administrator.travel_app.bean;

import java.util.Random;

public class RemarkBean {

    String[] NAME = {"万浩浩","啥的都","广告费","uuu","上的浩","不然都","天天费","妈妈们u",};
    String[] CONTENT = {"我很喜欢我很喜欢我很喜欢我很喜欢","啦啦啦啦啦啊拉拉拉啊啦啦啦","VS大苏打顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶",
            "我很喜欢我很喜欢我很喜欢我很喜欢","啦啦啦啦啦啊拉拉拉啊啦啦啦","VS大苏打顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶"};

    public String name;
    public String content;

    public RemarkBean(){
        name = NAME[Math.abs(new Random().nextInt())%NAME.length];
        content = CONTENT[Math.abs(new Random().nextInt())%CONTENT.length];
    }

}

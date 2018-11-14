package com.example.administrator.travel_app.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.travel_app.R;
import com.example.administrator.travel_app.activity.ChatActivity;
import com.example.administrator.travel_app.adapter.GridAdapter;
import com.example.administrator.travel_app.adapter.NewsAdapter;
import com.example.administrator.travel_app.adapter.QuestionAdapter;
import com.example.administrator.travel_app.base.LazyLoadFragment;
import com.example.administrator.travel_app.bean.GridBean;
import com.example.administrator.travel_app.bean.NewsBean;
import com.example.administrator.travel_app.bean.QuestionBean;
import com.youth.banner.Banner;

import java.util.ArrayList;

import butterknife.BindView;

public class HelpFragment extends LazyLoadFragment {

    @BindView(R.id.fg_help_recycler)
    RecyclerView news;
    @BindView(R.id.fg_help_bt1)
    Button bt1;
    @BindView(R.id.fg_help_bt2)
    Button bt2;
    @BindView(R.id.fg_help_bt3)
    Button bt3;
    @BindView(R.id.fg_help_qqgroup)
    Button btQQ;
    @BindView(R.id.fg_help_service)
    Button btHelp;

    private static final String[] OTHER_TITLE = {"交流", "组团", "分享","求助"};
    private static final int[] OTHER_IMG = {R.mipmap.gv_animation, R.mipmap.gv_multipleltem, R.mipmap.gv_header_and_footer, R.mipmap.gv_pulltorefresh};



    @Override
    protected int setContentView() {
        return R.layout.fragment_help;
    }

    @Override
    protected void lazyLoad(Bundle savedInstanceStat) {
        initView();
    }

    private void initView() {
        //==========================================================================================

        news.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<QuestionBean> newsList = new ArrayList<>();
        for(int x=0;x<5;x++){
            QuestionBean bean= new QuestionBean(QUESTION[x],ANSWER[x]);
            newsList.add(bean);
        }
        QuestionAdapter newsAdapter = new QuestionAdapter(newsList,getContext());
        news.setAdapter(newsAdapter);
        news.setNestedScrollingEnabled(false);

        //==========================================================================================

        bt1.setOnClickListener(v -> {
            diallPhone(bt1.getText().toString());
        });
        bt2.setOnClickListener(v -> {
            diallPhone(bt2.getText().toString());
        });
        bt3.setOnClickListener(v -> {
            diallPhone(bt3.getText().toString());
        });
        btQQ.setOnClickListener(v -> {
            joinQQGroup("2UR4sV4wbaro2DPukULdbXXE8rH5pY0E");
        });
        btHelp.setOnClickListener(v -> startActivity(new Intent(getContext(), ChatActivity.class)));
    }

    public void diallPhone(String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        startActivity(intent);
    }

    /****************
     *
     * 发起添加群流程。群号：翻转课堂(571451140) 的 key 为： ALNFJm81ZGqJ0bfW0fdgTbKEHZonYsDZ
     * 调用 joinQQGroup(ALNFJm81ZGqJ0bfW0fdgTbKEHZonYsDZ) 即可发起手Q客户端申请加群 翻转课堂(571451140)
     *
     * @param key 由官网生成的key
     * @return 返回true表示呼起手Q成功，返回fals表示呼起失败
     ******************/
    public boolean joinQQGroup(String key) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D" + key));
        // 此Flag可根据具体产品需要自定义，如设置，则在加群界面按返回，返回手Q主界面，不设置，按返回会返回到呼起产品界面    //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        try {
            startActivity(intent);
            return true;
        } catch (Exception e) {
            // 未安装手Q或安装的版本不支持
            return false;
        }
    }

    private static final String[] QUESTION = {"夜间交通安全小贴士", "夜间打车安全小贴士", "夜间独自出行安全小贴士","夜间危急时刻自卫小贴士","外出用餐安全小贴士","夜间出行小贴士"};
    private static final String[] ANSWER = {"1.步行安全常识 \n" +
            "夜间步行外出时要注意行走在人行道内，在没有人行道的地方要靠路边行走。横过马路时须走过街天桥 或地下通道，没有天桥和地下通道的地方应走人行通道；在没划人行横道的地方横过马路时要注意来往车辆 ，不要斜穿、猛跑；在通过十字路口时，要听从交通民警的指挥并遵守交通信号；在设有护栏或隔离墩的道 路上不得横过马路。 \n" +
            "2.骑车安全常识 \n" +
            "骑车外出的同学，出行前要先检查一下车辆的铃、闸、锁、牌是否齐全有效，保证没有问题后方可 上路。在道路上要在非机动车道内行驶，没有划分车道要靠右边行驶。通过路口时要严守信号，停车不要越 过停车线；不要绕过信号行驶；不要骑车逆行；不扶肩并行；不双手离把骑车；不攀扶其他车辆；不在便道 上骑车。在横穿4条以上机动车道或中途车闸失效时，须下车推行；骑车转弯时要伸手示意，不要强行猛拐 。 \n",
            "1独自乘车特别是在深夜时，记下车牌号和司机信息，最好拍下照片，发给亲友。上车后给家里人打个电话，让他们出来接一下。这样司机即使有些想法，听到你这么说就不敢铤而走险了。\n" +
                    "2独自坐上网约车，可以在上车时把方位发给朋友，并在固定时间内持续更新，这样哪怕万一出事，朋友都可以知道大概位置。\n" +
                    "3上车后要坐在副驾驶正后方的座位。不能坐在驾驶后方，也不要坐副驾驶位。坐在司机正后方位置与坐副驾驶一样危险，司机图谋不轨或临起歹意都是车辆在行驶的时候，司机只要重踩刹车，坐在后方会因惯性往前压产生撞击伤害，且由于与司机同侧车门，可能会连开门逃跑的机会都没有。坐在副驾驶后方，可通过后视镜看司机眼神，停车可随时逃跑。\n" +
                    "4不要过多攀谈，不要随意向司机透露个人信息。\n",
            "1夜间独自外出时，提前将目的地、时间、同行人员等告诉父母，保持通讯畅通。\n" +
                    "2在火车站、汽车站等处尽量不要掏钱包买东西,以免被小偷盯上。\n" +
                    "3选择较为正规的酒店，提前在网上了解对酒店的评价。火车站、汽车站周边的宾馆尽量不要住。\n" +
                    "4慎用定位工具，不要把自己的行踪挂在公共平台上。\n" +
                    "5在酒店房间看好路线再出发，不要拿着地图在路口左顾右盼。\n" +
                    "6发现尾随术：走路时，眼睛看向对面街道，并随时回头看看是否有人尾随。一旦发现有人跟随，就走向马路另一侧摆脱。必要时，在马路两侧反复穿行。\n" +
                    "7感到紧张、危险时不要抱有侥幸心理，要立马向人多的地方，如商店、电影院等地方跑，千万别向小胡同、电话亭跑，很可能被罪犯堵住。\n",
            "1记住，生命永远是最宝贵的，不论何时何地何事，一切皆可舍，首先要保命。遇到危险时千万要镇静。想尽一切可保命的办法挣脱控制，然后以最快速度跑开求救，不要与施害者过多纠缠。\n" +
                    "2与男性施害者正面相对，要用膝盖攻击其下体。\n" +
                    "3被施害者从后面勾住脖子，用力掐其大臂内侧。\n" +
                    "4被施害者掐住脖子，用力将其小拇指掰折。\n" +
                    "5突然被施害者拦胸抱住，用力向上击打其下巴。\n",
            "一、就餐前请从三方面查看饭店卫生状况\n" +
                    "1、查看就餐场所的整体卫生状况，看该店是否持有有效的《餐饮服务许可证》、从业人员健康合格证明等证件，并是否予以了公示。\n" +
                    "2、查看该店从业人员是否都穿戴了工作衣帽等。\n" +
                    "3、要查看该店是否配备分别用于餐饮具消毒、存放的消毒柜和保洁柜，并查看这些设施是否正常投入使用，是否存在损坏现象。\n" +
                    "二、点餐时应该避免三点\n" +
                    "1、油多盐多\n" +
                    "中国营养学会建议每天食盐摄入量不宜超过6克(钠2200毫克)，而下馆子的人一顿吃下去的钠就有2902毫克，一顿吃的量比推荐量一天还多。\n",
            "一、出行前准备\n" +
                    "　　1、夜间查询出行期间的天气情况，备好防雨、防晒、防寒等工具和衣物，如果外出旅游还要携带一些常用药品。\n" +
                    "　　2、规整所带物品，尽量减少包、箱（长宽高总长不要超过1.6米）的数量，严禁携带违禁物品乘车。\n" +
                    "　　3、避免身上带有大量的现金，随身携带的现金最好分几处保存，票据与现金、银行卡与身份证要分开保管，路上不用的现金和路上预计使用的现金要分开，现金与贵重物品不得外露和显现。\n" +
                    "　　4、如有小孩同行要在孩子的衣袋内放置紧急联系电话，并告知孩子存放位置。\n" +
                    "　　5、准备旅途所需的手机充电器（电池）、饮食品，洗漱用品、穿着要舒适、便于行动，女士禁穿高跟鞋。\n"};
}

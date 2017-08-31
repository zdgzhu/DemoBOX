package com.demobox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn01,btn02,btn03;
    private String JSON_CONTENT = "{\"weatherinfo\":{\"city\":\"北京\",\"cityid\":\"101010100\"," +
            "\"temp\":\"18\",\"WD\":\"东南风\",\"WS\":\"1级\",\"SD\":\"17%\",\"WSE\":\"1\"," +
            "\"time\":\"17:05\",\"isRadar\":\"1\",\"Radar\":\"JC_RADAR_AZ9010_JB\"," +
            "\"njd\":\"暂无实况\",\"qy\":\"1011\",\"rain\":\"0\"}}";

    private String XML_CONTENT = "<china dn=\"nay\"><city quName=\"黑龙江\" pyName=\"heilongjiang\" " +
            "cityname=\"哈尔滨\" state1=\"1\" state2=\"1\" stateDetailed=\"多云\"/><city quName=\"吉林\"" +
            " pyName=\"jilin\" " +
            "cityname=\"长春\" state1=\"0\" state2=\"0\" stateDetailed=\"晴\"/><city quName=\"辽宁\" " +
            "pyName=\"liaoning\" " +
            "cityname=\"沈阳\" state1=\"1\" state2=\"0\" stateDetailed=\"多云转晴\"/><city " +
            "quName=\"海南\" pyName=\"hainan\" " +
            "cityname=\"海口\" state1=\"22\" state2=\"21\" stateDetailed=\"中到大雨转小到中雨\"/></china>";


    List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layouttest);
        initView();

        // List 类型数据
        list = new ArrayList<>();
        list.add("hello");
        list.add("world");


    }

    private void initView() {

        btn01 = (Button) findViewById(R.id.btn_logger01);
        btn02 = (Button) findViewById(R.id.btn_logger02);
        btn03 = (Button) findViewById(R.id.btn_logger03);

        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
        btn03.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_logger01:
                Log.e("PRETTYLOGGER", "onClick:开始哈哈哈哈 " );
                Toast.makeText(this, "普通格式点击开始", Toast.LENGTH_SHORT).show();
                Logger.d("开始了");
                Logger.d("两个信息","这个是第二个信息 ");
                Logger.d("hello %s %d", "world", 5);//字符串格式化
                Logger.d(list);
                Log.e("PRETTYLOGGER", "end 哈哈哈哈 " );
                Logger.w("-------------","警告");


                break;


            case R.id.btn_logger02:
                Toast.makeText(this, "JSON格式点击开始", Toast.LENGTH_SHORT).show();
                Logger.json(JSON_CONTENT);
                Logger.e("出错了");
                break;


            case R.id.btn_logger03:
                Toast.makeText(this, "XML格式点击开始", Toast.LENGTH_SHORT).show();
                Logger.xml(XML_CONTENT);
                break;

        }

    }


}

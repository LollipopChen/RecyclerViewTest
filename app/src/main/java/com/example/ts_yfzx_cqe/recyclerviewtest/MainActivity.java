package com.example.ts_yfzx_cqe.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Adapter.FruitAdapter;
import bean.Fruit;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> mFruitList = new ArrayList<>();
    private String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple",
            "Staweberry", "Cherry", "Mango"};
    private int[] image = {R.drawable.apple, R.drawable.banana, R.drawable.orange,
            R.drawable.watermelon, R.drawable.pear, R.drawable.grape,
            R.drawable.pineapple, R.drawable.staweberry, R.drawable.cherry, R.drawable.mango};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFruit();//初始化水果数据

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
//        //设置横向的RecyclerView（recyclerView默认显示是纵向的）
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        mRecyclerView.setLayoutManager(linearLayoutManager);

        //瀑布图
        StaggeredGridLayoutManager staggeredLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(staggeredLayoutManager);
        FruitAdapter fruitAdapter = new FruitAdapter(mFruitList);
        mRecyclerView.setAdapter(fruitAdapter);

        //纵向显示的recyclerView（recyclerView默认显示是纵向的）
//        RecyclerView mRecyclerView_v = (RecyclerView) findViewById(R.id.recyclerview_v);
//        LinearLayoutManager linearLayoutManager_v = new LinearLayoutManager(this);
//        mRecyclerView_v.setLayoutManager(linearLayoutManager_v);
//        FruitAdapter fruitAdapter_v = new FruitAdapter(mFruitList);
//        mRecyclerView_v.setAdapter(fruitAdapter_v);
    }

    private void initFruit() {
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < data.length; i++) {
                Fruit fruit = new Fruit(getRandomLengthName(data[i]), image[i]);
                mFruitList.add(fruit);
            }
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20)+1;//1-20的随机数
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i < length; i++){
            builder.append(name);
        }
        return builder.toString();
    }


}

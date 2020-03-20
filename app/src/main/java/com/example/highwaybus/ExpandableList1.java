package com.example.highwaybus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class ExpandableList1 extends AppCompatActivity {
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> dataList;
    private HashMap<String,List<String>> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list1);
        Log.d("appBus","now We are in");
        listView=(ExpandableListView) findViewById(R.id.lvExpand);
        initData();
        Log.d("appBus","now We are out of the init()");
        listAdapter=new ExpandableListAdaptor(this,dataList,hashMap);
    }

    private void initData() {
        Log.d("appBus","now We are in init()");
        dataList=new ArrayList<>();
        hashMap= new HashMap<String, List<String>>();

        dataList.add("test1");
        dataList.add("test2");
        dataList.add("test3");

        List<String> l1=new ArrayList<>();
        l1.add("test1_item1");
        l1.add("test1_item2");
        l1.add("test1_item3");
        l1.add("test1_item4");

        List<String> l2=new ArrayList<>();
        l2.add("test2_item1");
        l2.add("test2_item2");
        l2.add("test2_item3");
        l2.add("test2_item4");

        List<String> l3=new ArrayList<>();
        l3.add("test3_item1");
        l3.add("test3_item2");
        l3.add("test3_item3");
        l3.add("test3_item4");

        hashMap.put(dataList.get(0),l1);
        hashMap.put(dataList.get(1),l2);
        hashMap.put(dataList.get(2),l3);
        Log.d("appBus","now We are in the end of init()");
    }
}

package com.example.highwaybus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class ExpandableList1 extends AppCompatActivity {
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> dataList;
    private HashMap<String,List<String>> hashMap;
    DatabaseReference reference;
    String s2;
    String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list1);
        s2="";
        s1="";
        reference= FirebaseDatabase.getInstance().getReference();

        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            s1=extras.getString("start");
            s2=extras.getString("end");

        }

        Log.d("sppBus","we got"+s1+"\t"+s2);

        String search=s1+"_"+s2;
        setAdapter(search);

        Log.d("appBus","now We are in");
        listView=(ExpandableListView) findViewById(R.id.lvExpand);
//        initData();
        Log.d("appBus","now We are out of the firebaseAdaptor");
        listAdapter=new ExpandableListAdaptor(this,dataList,hashMap);

    }

    private void setAdapter(String search) {
        hashMap=new HashMap<>();
        dataList=new ArrayList<>();
        Log.d("appBus","now We are out of the firebaseSnapshot");
        reference.child(search).addListenerForSingleValueEvent(new ValueEventListener() {
//            Log.d("appBus","now We are out of the firebaseSnapshot");
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int pos=0;
                for(DataSnapshot snapshot :dataSnapshot.getChildren()){
                    Log.d("appBus","now We are out of the firebaseSnapshot");
                    System.out.println("infirebase");
                    List<String> s=new ArrayList<>();
                    s.add("Start time\t:"+snapshot.child("start_time").getValue(String.class));
                    s.add("Start form\t:"+snapshot.child("start_station").getValue(String.class));
                    s.add("Go to\t:"+snapshot.child("end_town").getValue(String.class));
                    s.add("Arrive to "+s2+"\t:"+snapshot.child("arriaval_time").getValue(String.class));
                    s.add("Bus number\t:"+snapshot.child("bus_bumber").getValue(String.class));
                    s.add("Contact\t:"+snapshot.child("bus_contact").getValue(String.class));
                    dataList.add(snapshot.child("start_time").getValue(String.class));
                    hashMap.put(dataList.get(pos),s);
                    pos++;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
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

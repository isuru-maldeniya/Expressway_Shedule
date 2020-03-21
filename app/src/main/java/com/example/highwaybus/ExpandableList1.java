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
    List<String> dataList;
    HashMap<String,List<String>> hashMap;
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
//        Log.d("sppBus","we got"+s1+"\t"+s2);
        String search=s1+"_"+s2;
        setAdapter(search);
        Log.d("appBus","content of list "+0+"  :"+dataList.size());


//        Log.d("appBus","now We are in");
        listView=(ExpandableListView) findViewById(R.id.lvExpand);
        listAdapter=new ExpandableListAdaptor(this,dataList,hashMap);
        printData();
    }
    private void setAdapter(String search) {
        hashMap=new HashMap<String, List<String>>();
        dataList=new ArrayList<String>();
        reference.child(search).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                HashMap<Integer ,List<String>>tmp=new HashMap<>();
                HashMap<String ,List<String>>tmp2=new HashMap<>();
                List<String> stTemp=new ArrayList<String>();
                int pos=0;
                for(DataSnapshot snapshot :dataSnapshot.getChildren()){
                    String Start_time="Start time\t :"+snapshot.child("start_time").getValue(String.class);
                    String Start_from="Start from\t :"+snapshot.child("start_station").getValue(String.class);
                    String go_to="Go to\t :"+snapshot.child("end_town").getValue(String.class);
                    String arrive_time="Arrive time("+s2+")\t :"+snapshot.child("arriaval_time").getValue(String.class);
                    String contact="Contact\t :"+snapshot.child("bus_contact").getValue(String.class);
                    String bus_num="Number\t :"+snapshot.child("bus_bumber").getValue(String.class);
                    Log.d("appBus",Start_time);
                    Log.d("appBus",Start_from);
                    Log.d("appBus",go_to);
                    Log.d("appBus",arrive_time);
                    Log.d("appBus","///////////////////////////////");
                    List<String> datass=new ArrayList<>();
                    datass.add(Start_time);
                    datass.add(Start_from);
                    datass.add(go_to);
                    datass.add(arrive_time);
                    datass.add(contact);
                    datass.add(bus_num);
                    stTemp.add(snapshot.child("start_time").getValue(String.class));
                    dataList.add(snapshot.child("start_time").getValue(String.class));
                    tmp.put(pos,datass);
                    pos++;
                }
                pos=0;
                for(List<String> val: tmp.values()){
                    Log.d("appBus1","this is 3 content"+val.get(3));
                    tmp2.put(stTemp.get(pos),val);
                    hashMap.put(dataList.get(pos),val);
                    pos++;
                }
//                dataList=stTemp;
//                hashMap=tmp2;

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("appBus","The error is"+databaseError.toString());
            }
        });
    }

    private void printData(){
        int i=0;
        Log.d("appBus","we are in dataPrint");
        while (i<dataList.size()){

            Log.d("appBus","content of list "+i+"  :"+dataList.get(i));
            i++;
        }
    }
}

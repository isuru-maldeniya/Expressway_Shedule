package com.example.highwaybus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
    String search;
    String s1;
    private static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list1);
        s2="";
        s1="";
        reference= FirebaseDatabase.getInstance().getReference();
        ExpandableList1.context=getApplicationContext();
        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            s1=extras.getString("start");
            s2=extras.getString("end");

        }
//        Log.d("sppBus","we got"+s1+"\t"+s2);
        search=s1+"_"+s2;
        setAdapter(search);
        Log.d("appBus","content of list "+0+"  :"+dataList.size());


//        Log.d("appBus","now We are in");
        listView=(ExpandableListView) findViewById(R.id.lvExpand);

//        printData();
    }
    private void setAdapter(String search) {
        hashMap=new HashMap<String, List<String>>();
        dataList=new ArrayList<String>();

        /////////////////////cut_upper_bound
        readData(new FirebaseCallBack() {
            @Override
            public void onCallBack(List<String> l1, HashMap<String, List<String>> hMAp) {
                Log.d("appBus", "dataList :" + l1.toString());
                Log.d("appBus", "dataList :" + hMAp.get(l1.get(0)).toString());
                listAdapter=new ExpandableListAdaptor(context,l1,hMAp);
                listView.setAdapter(listAdapter);
            }
        });
        /////////////////////cut_Lower_bound
    }

    public interface FirebaseCallBack{
        void onCallBack(List<String> l1,HashMap<String , List<String>> hMAp);
    }

    private void readData(final FirebaseCallBack firebaseCallBack){
        /////////////////////cut_upper_bound

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                HashMap<Integer, List<String>> tmp = new HashMap<>();
                HashMap<String, List<String>> tmp2 = new HashMap<>();
                List<String> stTemp = new ArrayList<String>();
                int pos = 0;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    List<String> datass = new ArrayList<>();
                    datass.add("Start time\t :" + snapshot.child("start_time").getValue(String.class));
                    datass.add("Start from\t :" + snapshot.child("start_station").getValue(String.class));
                    datass.add("Go to\t :" + snapshot.child("end_town").getValue(String.class));
                    datass.add("Arrive time(" + s2 + ")\t :" + snapshot.child("arriaval_time").getValue(String.class));
                    datass.add("Contact\t :" + snapshot.child("bus_contact").getValue(String.class));
                    datass.add("Number\t :" + snapshot.child("bus_bumber").getValue(String.class));
                    stTemp.add(snapshot.child("start_time").getValue(String.class));
                    dataList.add("@ "+snapshot.child("start_time").getValue(String.class));
                    tmp.put(pos, datass);
                    pos++;
                }
                pos = 0;
                for (List<String> val : tmp.values()) {
                    Log.d("appBus1", "this is 3 content" + val.get(3));
                    tmp2.put(stTemp.get(pos), val);
                    hashMap.put(dataList.get(pos), val);
                    pos++;
                }
                firebaseCallBack.onCallBack(dataList,hashMap);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("appBus", "The error is" + databaseError.toString());
            }
        };
        reference.child(search).addListenerForSingleValueEvent(valueEventListener);

        /////////////////////cut_Lower_bound

    }

//    private void printData(){
//        int i=0;
//        Log.d("appBus","we are in dataPrint");
//        while (i<dataList.size()){
//
//            Log.d("appBus","content of list "+i+"  :"+dataList.get(i));
//            i++;
//        }
//    }
}

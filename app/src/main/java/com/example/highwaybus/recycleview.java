package com.example.highwaybus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class recycleview extends AppCompatActivity {
//    String s1[],s2[];
    List<String>s1,s2;
    RecyclerView recyclerView;
//    String s4;
    String s3;
    DatabaseReference reference;
    private static Context context1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        recyclerView=findViewById(R.id.recyList);
        s1=new ArrayList<>();
        s2=new ArrayList<>();
        List<String> dataList;
        HashMap<String,List<String>> hashMap;
        Bundle extras=getIntent().getExtras();
        reference= FirebaseDatabase.getInstance().getReference();
        recycleview.context1=getApplicationContext();
        if(extras!=null){
            s3=extras.getString("start");
//            s4=extras.getString("end");
        }

//        s2.add("Item1");
//        s2.add("Item2");
//        s2.add("Item3");
//        s2.add("Item4");
//        s2.add("Item5");
//        s2.add("Item6");
//        s2.add("Item7");
//        s2.add("Item8");
//        s2.add("Item9");
//        s2.add("Item10");
//        s2.add("Item11");
//        s2.add("Item12");
//        s2.add("Item13");
//        s2.add("Item14");


//        final Context c=this;
       sendData(new FirebaseCallBack1() {
           @Override
           public void onCallBAck(List<String> list1, List<String> list2) {
               ResAdapter adapter=new ResAdapter(context1,s1,s2);
               recyclerView.setAdapter(adapter);
               recyclerView.setLayoutManager(new LinearLayoutManager(context1));
           }
       });

//        s1.add(s3);
//        s1.add(s3);
//        s1.add(s3);
//        s1.add(s3);
//        s1.add(s3);
//        s1.add(s3);
//        s1.add(s3);
//        s1.add(s3);
//        s1.add(s3);
//        s1.add(s3);
//        s1.add(s3);
//        s1.add(s3);
//        s1.add(s3);
//        s1.add(s3);
//        s1.add(s3);



//        s1=getResources().getStringArray(R.array.arr1);
//        s2=getResources().getStringArray(R.array.arr2);




        ////////////////////////////if there any problem uncomment this




    }

    private void sendData(final FirebaseCallBack1 callBack1){
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<String> s5 = new ArrayList<>();
                Log.d("appBus", "now we are in");
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    String t = snapshot.child("town").getValue().toString();String.valueOf(t)
                    s1.add(snapshot.child("town").getValue().toString());
                }
                int i=0;
                while (i<s1.size()){
                    s2.add(s3);
                    i++;
                }
                callBack1.onCallBAck(s1,s2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("appBus", "Error is" + databaseError.toString());
            }
        };
        reference.child(s3).addListenerForSingleValueEvent(valueEventListener);

    }

    public interface FirebaseCallBack1{
        void onCallBAck(List<String> list1,List<String> list2);
    }
}

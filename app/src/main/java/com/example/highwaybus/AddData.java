package com.example.highwaybus;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.LinkedList;

public class AddData {
    FirebaseDatabase database ;
    DatabaseReference myRef ;
    LinkedList<AddBus> route;

    public AddData() {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Gampaha_Nanwinna(Maharagama)");
        route=new LinkedList<>();
    }
    public void setList(){


//        route.add(new AddBus("Gampaha","5.30 A.M.","6.20 A.M.","Nanwinna(Maharagama)","NA","0773464001"));
//        route.add(new AddBus("Gampaha","6.00 A.M.","7.50 A.M.","Nanwinna(Maharagama)","NA","0773309135"));
//        route.add(new AddBus("Gampaha","6.20 A.M.","7.10 A.M.","Nanwinna(Maharagama)","NA","0770116768"));
//        route.add(new AddBus("Gampaha","6.40 A.M.","7.30 A.M.","Nanwinna(Maharagama)","NA","0713225791"));
//        route.add(new AddBus("Gampaha","7.00 A.M.","7.50 A.M.","Nanwinna(Maharagama)","NA","0773464001"));
//        route.add(new AddBus("Gampaha","7.20 A.M.","8.10 A.M.","Nanwinna(Maharagama)","NA","0770116768"));
//        route.add(new AddBus("Gampaha","7.40 A.M.","8.30 A.M.","Nanwinna(Maharagama)","NA","0773464001"));
//        route.add(new AddBus("Gampaha","8.00 A.M.","8.50 A.M.","Nanwinna(Maharagama)","NA","0773309135"));
//        route.add(new AddBus("Gampaha","8.30 A.M.","9.20 A.M.","Nanwinna(Maharagama)","NA","0773464001"));
//        route.add(new AddBus("Gampaha","9.00 A.M.","9.50 A.M.","Nanwinna(Maharagama)","NA","0770116768"));
//        route.add(new AddBus("Gampaha","9.30 A.M.","10.20 A.M.","Nanwinna(Maharagama)","NA","0773309135"));
//        route.add(new AddBus("Gampaha","10.00 A.M.","10.50 A.M.","Nanwinna(Maharagama)","NA","0773464001"));
//        route.add(new AddBus("Gampaha","10.30 A.M.","11.20 A.M.","Nanwinna(Maharagama)","NA","0770116768"));
//        route.add(new AddBus("Gampaha","11.00 A.M.","11.50 A.M.","Nanwinna(Maharagama)","NA","0773309135"));
//        route.add(new AddBus("Gampaha","11.30 A.M.","12.20 P.M.","Nanwinna(Maharagama)","NA","0773464001"));
//        route.add(new AddBus("Gampaha","12.00 P.M.","12.50 P.M.","Nanwinna(Maharagama)","NA","0770116768"));
//        route.add(new AddBus("Gampaha","1.00 P.M.","1.50 P.M.","Nanwinna(Maharagama)","NA","0773464001"));
//        route.add(new AddBus("Gampaha","1.30 P.M.","2.20 P.M.","Nanwinna(Maharagama)","NA","0770116768"));
//        route.add(new AddBus("Gampaha","2.00 P.M.","2.50 P.M.","Nanwinna(Maharagama)","NA","0773309135"));
//        route.add(new AddBus("Gampaha","2.30 P.M.","3.20 P.M.","Nanwinna(Maharagama)","NA","0770116768"));
//        route.add(new AddBus("Gampaha","3.00 P.M.","3.50 P.M.","Nanwinna(Maharagama)","NA","0773464001"));
//        route.add(new AddBus("Gampaha","3.20 P.M.","4.30 P.M.","Nanwinna(Maharagama)","NA","0773464001"));
//        route.add(new AddBus("Gampaha","3.30 P.M.","4.20 P.M.","Nanwinna(Maharagama)","NA","0773309135"));
//        route.add(new AddBus("Gampaha","3.40 P.M.","4.30 P.M.","Nanwinna(Maharagama)","NA","0770116768"));
//        route.add(new AddBus("Gampaha","4.00 P.M.","4.50 P.M.","Nanwinna(Maharagama)","NA","0773464001"));
//        route.add(new AddBus("Gampaha","4.30 P.M.","5.20 P.M.","Nanwinna(Maharagama)","NA","0773309135"));
//        route.add(new AddBus("Gampaha","5.00 P.M.","5.50 P.M.","Nanwinna(Maharagama)","NA","0770116768"));
//        route.add(new AddBus("Gampaha","5.30 P.M.","6.20 P.M.","Nanwinna(Maharagama)","NA","0773464001"));
//        route.add(new AddBus("Gampaha","6.00 P.M.","6.50 P.M.","Nanwinna(Maharagama)","NA","0773309135"));
//        route.add(new AddBus("Gampaha","6.30 P.M.","7.20 P.M.","Nanwinna(Maharagama)","NA","0770116768"));
//        myRef.setValue(route);
    }


}

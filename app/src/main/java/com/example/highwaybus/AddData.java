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
        myRef = database.getReference("Kandy_Matara");
        route=new LinkedList<>();
    }
    public void setList(){

        route.add(new AddBus("Kandy","5.40 P.M.","NA","Matara","NA","0712080635"));
        route.add(new AddBus("Kandy","7.45 P.M.","NA","Matara","NA","0712080635"));

//        route.add(new AddBus("Matara","8.30 P.M.","+1Hour","Kadawatha","NA","NA"));
//        route.add(new AddBus("Matara","9.00 P.M.","+1Hour","Panadura","NA","NA"));





//        route.add(new AddBus("Kadawatha","12.30 P.M.","1.30 P.M.","Mathugama","NA","0772999904"));
//        route.add(new AddBus("Kadawatha","2.00 P.M.","3.00 P.M.","Mathugama","NA","0772999904"));
//        route.add(new AddBus("Mathugama","2.45 P.M.","3.45 P.M.","Mathugama","NA","0772999904"));
//        route.add(new AddBus("Kadawatha","3.30 P.M.","4.30 P.M.","Mathugama","NA","0772999904"));
//        route.add(new AddBus("Kadawatha","3.45 P.M.","4.45 P.M.","Baduraliya","NA","0711118663"));
//        route.add(new AddBus("Kadawatha","4.15 P.M.","5.15 P.M.","Mathugama","NA","0772999904"));
//        route.add(new AddBus("Kadawatha(Uni Of Kelini)","4.55 P.M.","5.55 P.M.(Mathugama)","Bulathsinhala","NA","0717490749"));
//        route.add(new AddBus("Kadawatha","5.00 P.M.","6.00 P.M.","Mathugama","NA","0772999904"));
//        route.add(new AddBus("Kadawatha","6.20 P.M.","7.20 P.M.","Mathugama","NA","0772999904"));


//        route.add(new AddBus("Matara","12.30 P.M.","2.15 P.M.","Panadura","NA","NA"));
//        route.add(new AddBus("Matara","1.30 P.M.","3.15 P.M.","Panadura","NA","NA"));
//        route.add(new AddBus("Matara","2.30 P.M.","4.15 P.M.","Panadura","NA","NA"));
//        route.add(new AddBus("Matara","3.30 P.M.","5.15 P.M.","Panadura","NA","NA"));
//        route.add(new AddBus("Matara","4.30 P.M.","6.15 P.M.","Panadura","NA","NA"));
//        route.add(new AddBus("Matara","5.30 P.M.","7.15 P.M.","Panadura","NA","NA"));
//        route.add(new AddBus("Matara","6.30 P.M.","8.15 P.M.","Panadura","NA","NA"));
//        route.add(new AddBus("Matara","7.30 P.M.","9.15 P.M.","Panadura","NA","NA"));
        myRef.setValue(route);
    }


}

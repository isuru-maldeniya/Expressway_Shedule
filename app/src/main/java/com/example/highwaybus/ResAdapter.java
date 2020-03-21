package com.example.highwaybus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ResAdapter extends RecyclerView.Adapter<ResAdapter.ResViewholder> {
//    String s1[],s2[];
    List<String> s1,s2;
    Context context;

    public  ResAdapter(Context context1, List<String>s11, List<String> s22){
        s1=s11;
        s2=s22;
        context=context1;
    }
    @NonNull
    @Override
    public ResViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new ResViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResViewholder holder, int position) {
        holder.t1.setText(s1.get(position));
        holder.t2.setText("");
    }

    @Override
    public int getItemCount() {
        return s1.size()-1;
    }

    public class ResViewholder extends RecyclerView.ViewHolder{
        TextView t1,t2;
        public ResViewholder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.txt1);
            t2=itemView.findViewById(R.id.txt2);
        }
    }
}

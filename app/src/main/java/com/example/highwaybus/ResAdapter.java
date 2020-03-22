package com.example.highwaybus;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
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
        holder.t2.setText(s2.get(position));
        final int pos=position;

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,ExpandableList1.class);
                intent.putExtra("start",s1.get(pos));
                intent.putExtra("end",s2.get(pos));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return s1.size()-1;
    }

    public class ResViewholder extends RecyclerView.ViewHolder{
        TextView t1,t2;
        ConstraintLayout layout;
        public ResViewholder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.txt1);
            t2=itemView.findViewById(R.id.txt2);
            layout=itemView.findViewById(R.id.rowLayout);
        }
    }
}

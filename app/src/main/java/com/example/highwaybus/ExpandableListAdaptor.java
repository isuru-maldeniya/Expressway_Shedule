package com.example.highwaybus;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdaptor extends BaseExpandableListAdapter {
    private Context context;
    private List<String> listHeader;
    private HashMap<String,List<String>> listHashMap;

    public ExpandableListAdaptor(Context context, List<String> listHeader, HashMap<String, List<String>> listHashMap) {
        this.context = context;
        this.listHeader = listHeader;
        this.listHashMap = listHashMap;
    }

    @Override
    public int getGroupCount() {
        return listHeader.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return listHashMap.get(listHeader.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return listHeader.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return listHashMap.get(listHeader.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String headerTitle=(String) getGroup(i);
        if(view==null){
            LayoutInflater inflater= (LayoutInflater) this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.list_group,null);
        }
        TextView tv=(TextView) view.findViewById(R.id.listViewHeader);
        tv.setTypeface(null, Typeface.BOLD);
        tv.setText(headerTitle);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        final String childText= (String) getChild(i,i1);
        if(view==null){
            LayoutInflater inflater= (LayoutInflater) this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.list_item,null);
        }
        TextView tV=(TextView) view.findViewById(R.id.list_item);
        tV.setText(childText);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}

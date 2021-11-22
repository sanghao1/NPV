package com.example.alovan;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.sql.Connection;
import java.sql.SQLTransactionRollbackException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Myadapter extends BaseExpandableListAdapter {

    private Context context;
    private Map<String, ArrayList<String>> MobileColeection;
    private List<String> groupList;

    public Myadapter(Context context, List<String> groupList , Map<String, ArrayList<String>> MobileColeection)
    {
        this.context =context;
        this.groupList = groupList;
        this.MobileColeection=MobileColeection;

    }
    @Override
    public int getGroupCount() {
        return MobileColeection.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return MobileColeection.get(groupList.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return groupList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return MobileColeection.get(groupList.get(i)).get(i1);
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
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

String ChucnagA = getGroup(i).toString();
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.activity_group_item ,null);

        }
        TextView item = view.findViewById(R.id.mobile);
        item.setTypeface(null , Typeface.BOLD);
        item.setText(ChucnagA );
    return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String model =getChild(i,i1).toString();
        if (view==null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.chill_item ,null);


        }
        TextView item = view.findViewById(R.id.model);
        item.setTypeface(null , Typeface.BOLD);
        item.setText(model );
        return view;

    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}

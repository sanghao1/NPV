package com.example.alovan;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuntionB extends Fragment {
    ExpandableListView expandableListView;
    List<String> groupList ;
    List<String> chillList ;
    Map<String ,ArrayList<String>> MobileColeection;
       ExpandableListAdapter expandableListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.funtionb, container, false);

        expandableListView=view.findViewById(R.id.expand_activitie);
        creatrGreoupList();
        createConlection();
        expandableListView =view.findViewById(R.id.expand_activitie);
        expandableListAdapter = new Myadapter(getContext(),groupList,MobileColeection);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int lasE = -1;
            @Override
            public void onGroupExpand(int i) {
                if (lasE !=-1 && i != lasE)
                {
                    expandableListView.collapseGroup(lasE);
                }
                lasE=i;

            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                String select = expandableListAdapter.getChild(i,i1).toString();

                return true;
            }
        });

        return view;
    }

    private void createConlection() {
        String[] chunangA={"A","B","C"};
        String[] chunangB={"A","B","C"};
        String[] chunangC={"A","B","C"};
        String[] chunangD={"A","B","C"};
        String[] chunangE={"A","B","C"};
        MobileColeection =new HashMap<String, ArrayList<String>>();
        for (String group : groupList)
        {
            if (group.equals("Chuc 1"))
            {
                loadChild(chunangA);
            }
            else if (group.equals("Chuc 2"))
            {
                loadChild(chunangB);

            }
            else if (group.equals("Chuc 3"))
            {
                loadChild(chunangC);

            }
            else if (group.equals("Chuc 4")) {
                loadChild(chunangD);
            }
                else if (group.equals("Chuc 5"))
            {
                loadChild(chunangD);

            }
            else
                loadChild(chunangE);
            MobileColeection.put(group , (ArrayList<String>) chillList);
        }

    }

    private void loadChild(String[] ModelchunangA) {
        chillList = new ArrayList<>();
        for (String model :ModelchunangA){
            chillList.add(model);

        }

    }


    private void creatrGreoupList() {
        groupList = new ArrayList<>();
        groupList.add("Chuc 1");
        groupList.add("Chuc 2");
        groupList.add("Chuc 3 ");
        groupList.add("Chuc 4");
        groupList.add("Chuc 5");


    }

}
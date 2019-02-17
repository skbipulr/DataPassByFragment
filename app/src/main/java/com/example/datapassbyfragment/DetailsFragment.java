package com.example.datapassbyfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailsFragment extends Fragment {
    private TextView showInfoTV;


    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_details, container, false);
        Employee employee = (Employee) getArguments().getSerializable("emp");
        showInfoTV = v.findViewById(R.id.showTextTV);
        if(employee!=null){
            showInfoTV.setText(employee.getName()+"\n"+employee.getDesignation());
        }


        return v;
    }

}

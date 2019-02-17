package com.example.datapassbyfragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class RagistationFragment extends Fragment {

    private EditText nameET,degicnationET;
    private Button registerBtn;

    private EmployeeRegistrationListener listener;
    private  Context context;


    public RagistationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        listener = (EmployeeRegistrationListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v = inflater.inflate(R.layout.fragment_ragistation, container, false);
       nameET = v.findViewById(R.id.nameET);
       degicnationET = v.findViewById(R.id.degicnationET);
       registerBtn = v.findViewById(R.id.registerBtn);

       registerBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String name = nameET.getText().toString();
               String designation = degicnationET.getText().toString();
               Employee employee = new Employee(name,designation);
               listener.onRegistrationComplete(employee);

           }
       });
        return v;
    }
    interface EmployeeRegistrationListener{
        void onRegistrationComplete(Employee employee);
    }

}

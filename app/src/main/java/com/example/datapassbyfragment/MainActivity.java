package com.example.datapassbyfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements RagistationFragment.EmployeeRegistrationListener {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        RagistationFragment ragistationFragment = new RagistationFragment();
        ft.add(R.id.fragmentContainer, ragistationFragment);
        ft.commit();
    }

    @Override
    public void onRegistrationComplete(Employee employee) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("emp",employee);
        detailsFragment.setArguments(bundle);
        ft.replace(R.id.fragmentContainer, detailsFragment);
        ft.commit();
    }
}

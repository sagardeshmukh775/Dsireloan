package com.smartloan.smtrick.smart_loan_user.view.fragements;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_user.R;

public class Fragment_About_Us extends Fragment {


    TextView first, second,heading;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_us, container, false);

        first = (TextView) view.findViewById(R.id.first);
        second = (TextView) view.findViewById(R.id.second);
        heading = (TextView) view.findViewById(R.id.heading);

        first.setText("     Dreams are for everyone, everyone has a house, a car, bank balances, stains, ornaments," +
                " land, children should be educated in a good college, once in a year, traveling with family," +
                " serving their parents, etc. Dreams are for every common man, but if you want to meet it, then enough " +
                "money is needed.");
        second.setText("     If you want to fulfill this dream then today you will not be able to get in the way of simple job," +
                " so you should have a business with a business or a job, but what business should you do in this competition?" +
                " It is a question that everyone falls. The business said that it is necessary to study capital, human resources," +
                " technology, market and all, and if they do not have complete study, most businesses lose and calculate life's " +
                "calculations.");

        heading.setText("About Us");

        return view;
    }
}

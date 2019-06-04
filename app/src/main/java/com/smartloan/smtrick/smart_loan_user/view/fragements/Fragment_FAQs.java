package com.smartloan.smtrick.smart_loan_user.view.fragements;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.smartloan.smtrick.smart_loan_user.R;
import com.smartloan.smtrick.smart_loan_user.view.adapters.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Fragment_FAQs extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.faq, container, false);

        // get the listview
        expListView = (ExpandableListView) view.findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(getContext(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);


        return view;
    }


    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Registration");
        listDataHeader.add("Lead Generation");
        listDataHeader.add("Earning Structure");
        listDataHeader.add("Customer Application");

        // Adding child data
        List<String> registration = new ArrayList<String>();
        registration.add("1)Is there any criteria to become a Desire Loans Partner?" + "\n" + "\n" +"-> Any individual over the age of 18 years can register to become a Desire Loans Partner.");
        registration.add("2)What documents/details do i require to sign up?" + "\n" + "\n" + "-> No need of any documents, mobile number is enough,After getting the registration number, you can fill the remaining information in My Profile.");
        registration.add("3) What benefit do I get as a Desire Loans Partner?" + "\n" + "\n" + "-> As a Desire Loans Partner,you will be entitled to a commission (or earning) on the total disbursement value of the loan availed by a customer that you have sourced.");
        registration.add("4) I do not have a bank account, can I still get my Payout?" + "\n" + "\n" + "-> After getting the registration number, the bank account number must be provided in 'My Profile'.All payouts are made to the bank account provided by the partner.");
        registration.add("5)How long does it take for my Desire Loans Partner ID to be activated?" + "\n" + "\n" +"-> You will be asked for a mobile number during the registration,after receiving the OTP on your mobile phone, you will get your Partner ID immediately.");

        List<String> Lead_Generation = new ArrayList<String>();
        Lead_Generation.add("1)When can I start generating leads?" + "\n" + "\n" +"-> You can start creating leads once you have received your Desire Loans Partner ID.");
        Lead_Generation.add("2)How do i generate leads?" + "\n" + "\n" +"-> Provide your customer's information about the type of loan to provide, your lead will be generated after submitting.");
        Lead_Generation.add("3)I have generated a lead,what next?" + "\n" + "\n" +"-> We will get the lead you generated, our staff will immediately take full information about your customer and start the loan process,the subsequent status will be updated from time to time, which will appear in 'My Leads'.");

        List<String> Earning_Structure = new ArrayList<String>();
        Earning_Structure.add("1)When will I get the Payout?" + "\n" + "\n" +"-> ");
        Earning_Structure.add("2)I have a problem with a pay-out calculated,What do I do?" + "\n" + "\n" +"-> If you have any problem you can contact our customer care number, we will solve your problem as soon as possible.");

        List<String> Customer_Application = new ArrayList<String>();
        Customer_Application.add("1");
        Customer_Application.add("2");

        listDataChild.put(listDataHeader.get(0), registration); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Lead_Generation);
        listDataChild.put(listDataHeader.get(2), Earning_Structure);
        listDataChild.put(listDataHeader.get(3), Customer_Application);
    }

}

package com.smartloan.smtrick.smart_loan_user.view.fragements;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartloan.smtrick.smart_loan_user.R;
import com.smartloan.smtrick.smart_loan_user.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_user.view.adapters.ViewPagerAdapter;

public class InvoicesTabFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    public InvoicesTabFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mListener != null) {
            mListener.onFragmentInteraction("Leeds");
        }
        View view = inflater.inflate(R.layout.view_pager_tab_layout, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragement(new Fragment_Generated_Leeds(), "Generated");
        viewPagerAdapter.addFragement(new Fragment_Inprocess_Leeds(), "In_Process");
        viewPagerAdapter.addFragement(new Fragment_Dock_pickup_Leeds(), "Dock_Pickup");
        viewPagerAdapter.addFragement(new Fragment_Login_Leeds(), "Login");
        viewPagerAdapter.addFragement(new Fragment_Sanction_Leeds(), "Sanction");
        viewPagerAdapter.addFragement(new Fragment_Subited_For_disbuss(), "Submited_For_disbuss");
        viewPagerAdapter.addFragement(new Fragment_Partialy_disbuss(), "Partly_disbuss");
        viewPagerAdapter.addFragement(new Fragment_Full_disbuss(), "Full_disbuss");
//        viewPagerAdapter.addFragement(new Fragment_Submitted_Leeds(), "Submited");
//        viewPagerAdapter.addFragement(new Fragment_Approved_Leeds(), "Approved");
        viewPagerAdapter.addFragement(new Fragment_Rejected_Leeds(), "Rejected");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
//        tabLayout.setTabMode(1);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else
            {
            // NOTE: This is the part that usually gives you the error
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}

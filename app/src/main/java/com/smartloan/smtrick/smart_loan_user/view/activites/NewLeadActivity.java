package com.smartloan.smtrick.smart_loan_user.view.activites;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.smartloan.smtrick.smart_loan_user.R;
import com.smartloan.smtrick.smart_loan_user.view.fragements.Fragment_GenerateLeads;


public class NewLeadActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{
    ImageView imgPL, imgHL, imgML, imgTUL, imgBTL, imgDL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newleadactivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imgPL = (ImageView) findViewById(R.id.personal_loan);
        imgHL = (ImageView) findViewById(R.id.Home_loan);
        imgML = (ImageView) findViewById(R.id.Morgage_loan);
        imgTUL = (ImageView) findViewById(R.id.Top_up_loan);
        imgBTL = (ImageView) findViewById(R.id.balance_trancefer_loan);
        imgDL = (ImageView) findViewById(R.id.doctor_loan);

        imgPL.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();

                Bundle bundle = new Bundle();
                bundle.putString("edttext", "From Activity");
                Fragment_GenerateLeads fragobj = new Fragment_GenerateLeads();
                fragobj.setArguments(bundle);
                intent.setClass(NewLeadActivity.this, Fragment_GenerateLeads.class);
                startActivity(intent);
            }
        });
    }






    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}

package com.smartloan.smtrick.smart_loan_user.view.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.smartloan.smtrick.smart_loan_user.R;
import com.smartloan.smtrick.smart_loan_user.view.fragements.InvoicesTabFragment;

public class NewLeadSelectActivity extends AppCompatActivity {
    Button btnAccept;
    ImageView imgPL, imgHL, imgML, imgTUL, imgBTL, imgDL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_condition_);

        imgPL = (ImageView) findViewById(R.id.personal_loan);
        imgHL = (ImageView) findViewById(R.id.Home_loan);
        imgML = (ImageView) findViewById(R.id.Morgage_loan);
        imgTUL = (ImageView) findViewById(R.id.Top_up_loan);
        imgBTL = (ImageView) findViewById(R.id.balance_trancefer_loan);
        imgDL = (ImageView) findViewById(R.id.doctor_loan);


        imgHL.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent(NewLeadSelectActivity.this, InvoicesTabFragment.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

            }
        });

    }
}

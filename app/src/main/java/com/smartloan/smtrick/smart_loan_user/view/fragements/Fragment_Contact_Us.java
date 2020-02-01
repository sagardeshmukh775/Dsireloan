package com.smartloan.smtrick.smart_loan_user.view.fragements;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_user.R;

public class Fragment_Contact_Us extends Fragment {

    LinearLayout linearLayoutphone,linearLayoutcall;
    String number,callnumber;
    TextView phone,call;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_us, container, false);

        linearLayoutphone = (LinearLayout) view.findViewById(R.id.layoutAltphone);
        linearLayoutcall = (LinearLayout) view.findViewById(R.id.layoutphone);
        phone = (TextView) view.findViewById(R.id.txtaltphone);
        call = (TextView) view.findViewById(R.id.txtphone);
        number = phone.getText().toString();
        callnumber = call.getText().toString();

        linearLayoutphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://api.whatsapp.com/send?phone="+number;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
//                i.setData(Uri.parse("tel:"+number));
                startActivity(i);
            }
        });
        linearLayoutcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
                i.setData(Uri.parse("tel:"+callnumber));
                startActivity(i);
            }
        });

        return view;
    }
}

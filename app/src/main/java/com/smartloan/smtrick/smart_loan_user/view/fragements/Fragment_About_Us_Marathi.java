package com.smartloan.smtrick.smart_loan_user.view.fragements;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_user.R;

public class Fragment_About_Us_Marathi extends Fragment {


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

        first.setText("आयुष्यात स्वप्न प्रत्येकाची असतात,प्रत्येकाला आपल्याकडे स्वतःचे घर,गाडी,बँक बॅलन्स, दाग-दागिने,जमीन असावी असे वाटते " +
                ",मुलांचे शिक्षण चांगल्या कॉलेजमध्ये व्हावे,वर्षातून एक दोन वेळा कुटुंबासोबत सहली,आई वडिलांची सेवा करणे इ. स्वप्ने प्रत्येक सर्व सामान्य" +
                " माणसाची असतात,परंतु ती पूर्ण करायची असतील तर पुरेसा पैसा असणे गरजेचे आहे.");
        second.setText("ही स्वप्न पूर्ण करायची असतील तर आजच्या काळात साधारण नोकरीच्या मार्गाने कदापि शक्य नाही त्यासाठी व्यवसाय किंवा नोकरी सोबत " +
                "एखादा जोडधंदा हवा,पण या स्पर्धेच्या युगात कोणता व्यवसाय करावा? असा प्रश्न प्रत्येकाला पडतो.व्यवसाय म्हटलं की भांडवल,मनुष्यबळ," +
                " तंत्रज्ञान,मार्केट या गोष्टी व सर्वांच्या अभ्यास करणे गरजेचे आहे आणि यांचा पूर्ण अभ्यास नसेल तर बहुतांश व्यवसाय तोट्यात जातात व आयुष्याची गणिते बिघडतात.");

        heading.setText("आमच्या बद्दल");

        return view;
    }
}

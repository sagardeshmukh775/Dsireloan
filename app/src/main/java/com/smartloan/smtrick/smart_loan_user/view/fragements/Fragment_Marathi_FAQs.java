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

public class Fragment_Marathi_FAQs extends Fragment {

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
        listDataHeader.add("नोंदणी");
        listDataHeader.add("लीड जनरेशन");
        listDataHeader.add("कमाईची संरचना");
        listDataHeader.add("ग्राहक अनुप्रयोग");

        // Adding child data
        List<String> registration = new ArrayList<String>();
        registration.add("1) डिझायर लोन्स चा पार्टनर बनण्याचे काही निकष आहेत का?" + "\n" + "\n" +"-> १८ वर्षाहून अधिक वय असलेली कोणीही व्यक्ती डिझायर लोन्स भागीदार होण्यासाठी नोंदणी करू शकते.");
        registration.add("2) पार्टनर नोंदणी साठी मला कोणती कागदपत्रे/तपशील आवश्यक आहेत?" + "\n" + "\n" + "-> कोणत्याही कागदपत्रांची आवश्यकता नाही फक्त मोबाइल क्रमांक पुरेसा आहे.नोंदणी क्रमांक मिळाल्यावर आपण उर्वरित माहिती My Profile मध्ये भरू शकता.");
        registration.add("3)डिझायर लोन्स चा पार्टनर म्हणून मला काय फायदा मिळेल?" + "\n" + "\n" + "-> डिझायर लोन्स चा पार्टनर म्हणून,आपण पाठवलेल्या ग्राहकाने घेतलेल्या कर्जाच्या एकूण वितरणाच्या मूल्यावर आपल्याला आकर्षक कमिशन(किंवा कमाई) मिळण्याचा हक्क असेल.");
        registration.add("4)माझ्याकडे बँक खाते नाही,तरीही मी माझे पे-आऊट मिळवू शकतो का?" + "\n" + "\n" + "-> नोंदणी क्रमांक मिळाल्यावर My Profile मध्ये बँक खाते क्रमांक प्रदान करणे आवश्यक आहे,सर्व पे-आऊट भागीदाराद्वारे प्रदान केलेल्या बँक खात्यात जमा केले जातात.");
        registration.add("5)डिझायर लोन्स पार्टनर म्हणून नोंदणीसाठी किती वेळ लागतो?" + "\n" + "\n" +"-> आपल्याला नोंदणीदरम्यान मोबाईल क्रमांक विचारला जाईल, त्यानंतर आपल्या मोबाईलवर आलेला OTP एंटर केल्यावर मेसेजद्वारे आपल्याला त्वरित आपला नोंदणी क्रमांक मिळेल.");

        List<String> Lead_Generation = new ArrayList<String>();
        Lead_Generation.add("1)मी लीड्स तयार करण्यास कधी सुरू करू?" + "\n" + "\n" +"-> डिझायर लोन्स चा पार्टनर नोंदणी क्रमांक मिळाल्यानंतर आपण लीड्स तयार करण्यास प्रारंभ करू शकता.");
        Lead_Generation.add("2)मी लीड्स कशा तयार करू?" + "\n" + "\n" +"-> आपल्याला ज्या प्रकारच्या कर्जाची लीड तयार करायची आहे त्यामध्ये आपल्या ग्राहकाची विचारलेली माहिती प्रदान करा, SUBMIT केल्यानंतर आपली लीड तयार होईल.");
        Lead_Generation.add("3) मी लीड तयार केली आहे,आता पुढे काय?" + "\n" + "\n" +"-> आपण तयार केलेली लीड आम्हाला मिळेल,आमचे कर्मचारी ताबडतोब आपल्या ग्राहकाची संपूर्ण माहिती घेतील व कर्ज प्रक्रियेस सुरुवात करतील, त्यानंतरचे स्टेटस आमच्याकडून वेळोवेळी अपडेट केले जाईल, ते आपल्याला My Leads मध्ये दिसेल.");

        List<String> Earning_Structure = new ArrayList<String>();
        Earning_Structure.add("1)मी प्रदान केलेल्या कोणत्याही वितरणासाठी मला पे-आऊट कधी मिळेल?" + "\n" + "\n" +"-> आपण दिलेल्या ग्राहकाची संपूर्ण कर्ज प्रक्रिया पूर्ण होऊन   वितरण पूर्ण झाले की ___________");
        Earning_Structure.add("2) मला पे-आऊट गणना करताना समस्या आहे मी काय करू?" + "\n" + "\n" +"-> आपल्याला कोणतीही समस्या असल्यास आपण आमच्या ग्राहक सेवा क्रमांकावर संपर्क करू शकता,आम्ही आपली समस्या लवकरात लवकर सोडवू.");

        List<String> Customer_Application = new ArrayList<String>();
        Customer_Application.add("1");
        Customer_Application.add("2");

        listDataChild.put(listDataHeader.get(0), registration); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Lead_Generation);
        listDataChild.put(listDataHeader.get(2), Earning_Structure);
        listDataChild.put(listDataHeader.get(3), Customer_Application);
    }

}

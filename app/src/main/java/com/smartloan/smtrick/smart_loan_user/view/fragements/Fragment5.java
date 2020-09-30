package com.smartloan.smtrick.smart_loan_user.view.fragements;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.smartloan.smtrick.smart_loan_user.R;
import com.smartloan.smtrick.smart_loan_user.constants.Constants;
import com.smartloan.smtrick.smart_loan_user.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_user.models.Upload;
import com.smartloan.smtrick.smart_loan_user.view.adapters.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

public class Fragment5 extends Fragment {

    LinearLayout sliderDotspanel;
    private ImageView[] dots;
    private DatabaseReference mDatabase;

    // NOTE: Removed Some unwanted Boiler Plate Codes
    private OnFragmentInteractionListener mListener;
    private List<Upload> uploads;
    private List<Upload> uploads1;
    ViewPager viewPager;

    public Fragment5() {
    }

    Context context;
    ImageView imgPL, imgHL, imgML, imgTUL, imgBTL, imgDL;
    ProgressBar progressBar;
    Animation animBounce;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment5, container, false);

        sliderDotspanel = (LinearLayout) view.findViewById(R.id.SliderDots);

        uploads = new ArrayList<>();
        uploads1 = new ArrayList<>();
        mDatabase = FirebaseDatabase.getInstance().getReference(Constants.DATABASE_PATH_UPLOADS);

        Query query = FirebaseDatabase.getInstance().getReference("Advertise");

        query.addValueEventListener(valueEventListener);

        viewPager = view.findViewById(R.id.viewPager);


        // NOTE : We are calling the onFragmentInteraction() declared in the MainActivity
        // ie we are sending "Fragment 1" as title parameter when fragment1 is activated
        if (mListener != null) {
            mListener.onFragmentInteraction("Select Loan Type");
        }

        imgPL = (ImageView) view.findViewById(R.id.personal_loan);
        imgHL = (ImageView) view.findViewById(R.id.Home_loan);
        imgML = (ImageView) view.findViewById(R.id.Morgage_loan);
        imgTUL = (ImageView) view.findViewById(R.id.Top_up_loan);
        imgBTL = (ImageView) view.findViewById(R.id.balance_trancefer_loan);
        imgDL = (ImageView) view.findViewById(R.id.doctor_loan);


        imgPL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mListener.changeFragement(new Fragment_GenerateLeads());


            }
        });

        imgHL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Utility.showLongMessage(getActivity(), getString(R.string.lead_generated_success_message));
                mListener.changeFragement(new Fragment_Generate_homeloan());

            }
        });
        imgML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Utility.showLongMessage(getActivity(), getString(R.string.lead_generated_success_message));
                mListener.changeFragement(new Fragment_Generate_morgageloan());

            }
        });


        imgTUL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Utility.showLongMessage(getActivity(), getString(R.string.lead_generated_success_message));
                mListener.changeFragement(new Fragment_Generate_topup());

            }
        });


        imgBTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Utility.showLongMessage(getActivity(), getString(R.string.lead_generated_success_message));
                mListener.changeFragement(new Fragment_Generate_balancetransfer());

            }
        });
        imgDL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Utility.showLongMessage(getActivity(), getString(R.string.lead_generated_success_message));
                mListener.changeFragement(new Fragment_Generate_doctorloan());

            }
        });

        return view;
    }


    ValueEventListener valueEventListener = new ValueEventListener() {

        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            uploads.clear();
            for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                Upload upload = postSnapshot.getValue(Upload.class);

                uploads.add(upload);
                int size = uploads.size()-1;
                uploads1.clear();
                for(int i=size;i>=0;i--){
                    uploads1.add(uploads.get(i));
                }

            }

            // showDots();
            ImageAdapter adapter = new ImageAdapter(getContext(), uploads1);
            viewPager.setAdapter(adapter);

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };

    public void showDots() {

        dots = new ImageView[uploads.size()];

        // dots = new ImageView[dotscount];

        for (int i = 0; i < uploads.size(); i++) {

            dots[i] = new ImageView(getContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < uploads.size(); i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void onAnimationEnd(Animation animation) {
        // Take any action after completing the animation

        // check for zoom in animation
        if (animation == animBounce) {
        }

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
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

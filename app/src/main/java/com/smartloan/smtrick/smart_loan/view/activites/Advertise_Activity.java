package com.smartloan.smtrick.smart_loan.view.activites;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.smartloan.smtrick.smart_loan.R;
import com.smartloan.smtrick.smart_loan.models.Upload;

public class Advertise_Activity extends AppCompatActivity {

    ImageView AdImage;
    TextView AdName, AdDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertise_);



        AdImage = (ImageView) findViewById(R.id.Ad_image);
        AdName = (TextView) findViewById(R.id.Ad_name);
        AdDescription = (TextView) findViewById(R.id.Ad_Description);

        Intent intent =getIntent();
        String imagename = intent.getStringExtra("imagename");

        Query query = FirebaseDatabase.getInstance().getReference("Advertise").orderByChild("name").equalTo(imagename);

        query.addValueEventListener(valueEventListener);
    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                Upload upload = postSnapshot.getValue(Upload.class);

                AdName.setText(upload.getName());
                AdDescription.setText(upload.getDesc());
                Glide.with(Advertise_Activity.this).load(upload.getUrl())
                        .apply(new RequestOptions().placeholder(R.drawable.loading))
                        .into(AdImage);

            }

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
}

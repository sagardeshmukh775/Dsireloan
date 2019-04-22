package com.smartloan.smtrick.smart_loan_user.repository;

import android.content.Context;
import android.widget.ImageView;

import com.google.firebase.storage.StorageReference;

public interface StorageRepository {
    void loadImage(final Context context, final StorageReference storageReference,int placeHolerId,final ImageView imageView);
}

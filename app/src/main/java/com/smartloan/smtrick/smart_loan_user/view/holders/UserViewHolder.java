package com.smartloan.smtrick.smart_loan_user.view.holders;

import android.support.v7.widget.RecyclerView;

import com.smartloan.smtrick.smart_loan_user.databinding.UseradapterLayoutListitemBinding;

public class UserViewHolder extends RecyclerView.ViewHolder {
    public UseradapterLayoutListitemBinding useradapterLayoutListitemBinding;

    public UserViewHolder(UseradapterLayoutListitemBinding useradapterLayoutListitemBinding) {
        super(useradapterLayoutListitemBinding.getRoot());
        this.useradapterLayoutListitemBinding = useradapterLayoutListitemBinding;
    }
}

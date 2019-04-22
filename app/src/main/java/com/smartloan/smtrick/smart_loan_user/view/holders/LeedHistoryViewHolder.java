package com.smartloan.smtrick.smart_loan_user.view.holders;

import android.support.v7.widget.RecyclerView;

import com.smartloan.smtrick.smart_loan_user.databinding.HistoryAdapterLayoutBinding;

public class LeedHistoryViewHolder extends RecyclerView.ViewHolder {
    public HistoryAdapterLayoutBinding historyAdapterLayoutBinding;

    public LeedHistoryViewHolder(HistoryAdapterLayoutBinding historyAdapterLayoutBinding) {
        super(historyAdapterLayoutBinding.getRoot());
        this.historyAdapterLayoutBinding = historyAdapterLayoutBinding;
    }
}

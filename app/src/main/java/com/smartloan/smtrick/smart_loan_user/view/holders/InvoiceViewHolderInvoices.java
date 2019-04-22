package com.smartloan.smtrick.smart_loan_user.view.holders;

import android.support.v7.widget.RecyclerView;


import com.smartloan.smtrick.smart_loan_user.databinding.InvoiceAdapterLayoutInvoicesBinding;

public class InvoiceViewHolderInvoices extends RecyclerView.ViewHolder {
    public InvoiceAdapterLayoutInvoicesBinding invoiceAdapterLayoutBinding;

    public InvoiceViewHolderInvoices(InvoiceAdapterLayoutInvoicesBinding invoiceAdapterLayoutBinding) {
        super(invoiceAdapterLayoutBinding.getRoot());
        this.invoiceAdapterLayoutBinding = invoiceAdapterLayoutBinding;
    }
}

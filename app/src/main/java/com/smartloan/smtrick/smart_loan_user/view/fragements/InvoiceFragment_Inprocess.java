package com.smartloan.smtrick.smart_loan_user.view.fragements;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartloan.smtrick.smart_loan_user.R;
import com.smartloan.smtrick.smart_loan_user.callback.CallBack;
import com.smartloan.smtrick.smart_loan_user.databinding.FragmentInvoiceBinding;
import com.smartloan.smtrick.smart_loan_user.databinding.InvoicedialogBinding;
import com.smartloan.smtrick.smart_loan_user.models.Invoice;
import com.smartloan.smtrick.smart_loan_user.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_user.recyclerListener.RecyclerTouchListener;
import com.smartloan.smtrick.smart_loan_user.repository.InvoiceRepository;
import com.smartloan.smtrick.smart_loan_user.repository.impl.InvoiceRepositoryImpl;
import com.smartloan.smtrick.smart_loan_user.singleton.AppSingleton;
import com.smartloan.smtrick.smart_loan_user.utilities.Utility;
import com.smartloan.smtrick.smart_loan_user.view.adapters.InvoiceAdapter;
import com.smartloan.smtrick.smart_loan_user.view.dialog.ProgressDialogClass;

import java.util.ArrayList;

import static com.smartloan.smtrick.smart_loan_user.constants.Constant.GLOBAL_DATE_FORMATE;
import static com.smartloan.smtrick.smart_loan_user.constants.Constant.STATUS_INPROCESS;

public class InvoiceFragment_Inprocess extends Fragment {
    InvoiceAdapter invoiceAdapter;
    AppSingleton appSingleton;
    ProgressDialogClass progressDialogClass;
    AppSharedPreference appSharedPreference;
    FragmentInvoiceBinding fragmentInvoiceBinding;
    ArrayList<Invoice> invoiceArrayList;
    InvoiceRepository invoiceRepository;
    InvoicedialogBinding invoicedialogBinding;

    public InvoiceFragment_Inprocess() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (fragmentInvoiceBinding == null) {
            fragmentInvoiceBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_invoice, container, false);
            invoiceRepository = new InvoiceRepositoryImpl();
            progressDialogClass = new ProgressDialogClass(getActivity());
            appSingleton = AppSingleton.getInstance(getActivity());
            appSharedPreference = new AppSharedPreference(getActivity());
            fragmentInvoiceBinding.recyclerView.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            fragmentInvoiceBinding.recyclerView.setLayoutManager(layoutManager);
            fragmentInvoiceBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
            fragmentInvoiceBinding.recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                    DividerItemDecoration.VERTICAL));

            getInvoices();
        }
        return fragmentInvoiceBinding.getRoot();
    }

    private Invoice getModel(int position) {
        return invoiceArrayList.get(invoiceArrayList.size() - 1 - position);
    }

    private void onClickListner() {
        fragmentInvoiceBinding.recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), fragmentInvoiceBinding.recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Invoice invoice = getModel(position);
                showInvoiceDialog(invoice);
            }

            @Override
            public void onLongClick(View view, int position) {
            }

        }));
    }

    private void getInvoices() {
        progressDialogClass.showDialog(this.getString(R.string.loading), this.getString(R.string.PLEASE_WAIT));
        invoiceRepository.readInvoicesByUserId(appSharedPreference.getAgeniId(), new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    invoiceArrayList = (ArrayList<Invoice>) object;
                    filterList(invoiceArrayList);

                }
                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();
                Utility.showLongMessage(getActivity(), getString(R.string.server_error));
            }
        });
    }

    private void filterList(ArrayList<Invoice> invoiceArrayList) {
        ArrayList<Invoice> arrayList = new ArrayList<>();
        if (invoiceArrayList != null) {
            for (Invoice invoice : invoiceArrayList) {
                if (!Utility.isEmptyOrNull(invoice.getStatus()) && invoice.getStatus().equalsIgnoreCase(STATUS_INPROCESS))
                    arrayList.add(invoice);
            }
        }
        serAdapter(arrayList);
    }

    private void serAdapter(ArrayList<Invoice> invoiceArrayList) {
        if (invoiceArrayList != null) {
            if (invoiceAdapter == null) {
                invoiceAdapter = new InvoiceAdapter(getActivity(), invoiceArrayList);
                fragmentInvoiceBinding.recyclerView.setAdapter(invoiceAdapter);
                onClickListner();
            } else {
                ArrayList<Invoice> arrayList = new ArrayList<>();
                arrayList.addAll(invoiceArrayList);
                invoiceAdapter.reload(arrayList);
            }
        }
    }

    private void showInvoiceDialog(Invoice invoice) {
        final Dialog dialog = new Dialog(getActivity());
        invoicedialogBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.invoicedialog, null, false);
        dialog.setContentView(invoicedialogBinding.getRoot());
        dialog.setTitle("Title...");
        invoicedialogBinding.txtleadidvalue.setText(invoice.getLeedNumber());
        invoicedialogBinding.txtcnamevalue.setText(invoice.getCustomerName());
        invoicedialogBinding.txtccontactvalue.setText(invoice.getMobileNumber());
        invoicedialogBinding.txtcaddressvalue.setText(invoice.getAddress());
        invoicedialogBinding.txtloantyprvalue.setText(invoice.getLoanType());
        invoicedialogBinding.txtdatevalue.setText(Utility.convertMilliSecondsToFormatedDate(invoice.getCreatedDateTimeLong(), GLOBAL_DATE_FORMATE));

        invoicedialogBinding.dialogButtonaccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });
       /* invoicedialogBinding.dialogButtonreject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });*/
        dialog.show();
    }
}

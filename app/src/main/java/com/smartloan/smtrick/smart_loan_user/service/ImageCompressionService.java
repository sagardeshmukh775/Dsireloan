package com.smartloan.smtrick.smart_loan_user.service;


import com.smartloan.smtrick.smart_loan_user.callback.CallBack;

public interface ImageCompressionService {
    void compressImage(String ImagePath, CallBack callBack);
}

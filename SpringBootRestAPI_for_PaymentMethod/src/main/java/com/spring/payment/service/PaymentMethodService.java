package com.spring.payment.service;

import java.util.List;

import com.spring.payment.model.PaymentMethod;

public interface PaymentMethodService {
	
	public List<PaymentMethod> getAllPaymentMethod() throws Exception;
	public PaymentMethod getPaymentMethod(String methodName) throws Exception;
	public void addPaymentMethod(PaymentMethod paymentmethod) throws Exception;
	public void updatePaymentMethod(String methodName, PaymentMethod method) throws Exception;
	public void deletePaymentMethod(String methodName) throws Exception;

}

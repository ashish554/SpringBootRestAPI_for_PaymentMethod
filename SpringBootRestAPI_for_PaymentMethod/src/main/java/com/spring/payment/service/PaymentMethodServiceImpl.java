package com.spring.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.payment.dao.PaymentMethodDao;
import com.spring.payment.model.PaymentMethod;

@Service(value="PaymentMethodService")
public class PaymentMethodServiceImpl implements PaymentMethodService{

	@Autowired PaymentMethodDao paymentdao;
	
	@Override
	public List<PaymentMethod> getAllPaymentMethod() throws Exception {
		List<PaymentMethod> paymentList=paymentdao.getAllPaymentMethod();
		return paymentList;
	}

	@Override
	public PaymentMethod getPaymentMethod(String methodName) throws Exception {
		if(paymentdao.getPaymentMethod(methodName)==null)
		{
			throw new Exception("Service.PaymentMethod_Not_Exists");
		}
		else
			return paymentdao.getPaymentMethod(methodName);
	}

	@Override
	public void addPaymentMethod(PaymentMethod paymentmethod) throws Exception {
		if(paymentdao.getPaymentMethod(paymentmethod.getMethodName())!=null)
		{
			throw new Exception("Service.PaymentMethod_Already_Exists");
		}
		else
			 paymentdao.addPaymentMethod(paymentmethod);
	}

	@Override
	public void updatePaymentMethod(String methodName, PaymentMethod method) throws Exception {
		if(paymentdao.getPaymentMethod(methodName)==null)
		{
			throw new Exception("Service.PaymentMethod_Not_Exists");
		}
		else
			 paymentdao.updatePaymentMethod(methodName,method);
		
	}

	@Override
	public void deletePaymentMethod(String methodName) throws Exception {
		if(paymentdao.getPaymentMethod(methodName)==null)
		{
			throw new Exception("Service.PaymentMethod_Not_Exists");
		}
		else
			 paymentdao.deletePaymentMethod(methodName);
}
}

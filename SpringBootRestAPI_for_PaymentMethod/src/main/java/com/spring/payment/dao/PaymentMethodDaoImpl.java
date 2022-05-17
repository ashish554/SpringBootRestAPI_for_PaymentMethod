package com.spring.payment.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.payment.model.PaymentMethod;

@Repository(value="/PaymentMethodDao")
public class PaymentMethodDaoImpl implements PaymentMethodDao {

	HashMap<String,PaymentMethod> paymentMethod=new HashMap<String,PaymentMethod>();
	
	public PaymentMethodDaoImpl()
	{
		try {
			ObjectMapper mapper = new ObjectMapper();
			List<PaymentMethod> paymentMethodList = Arrays.asList(mapper.readValue(new File("src/main/resources/paymentMethod.json"), PaymentMethod[].class));
			for(PaymentMethod i:paymentMethodList)
			{
				paymentMethod.put(i.getMethodName(), i);
			}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	
	@Override
	public List<PaymentMethod> getAllPaymentMethod() throws Exception {
		List<PaymentMethod> list=new ArrayList<PaymentMethod>();
		for(String i:paymentMethod.keySet())
		{
			list.add(paymentMethod.get(i));
		}
		return list;
	}

	@Override
	public PaymentMethod getPaymentMethod(String methodName) throws Exception {
		return paymentMethod.get(methodName);
	}

	@Override
	public void  addPaymentMethod(PaymentMethod paymentmethod) throws Exception {
		paymentMethod.put(paymentmethod.getMethodName(), paymentmethod);
	}

	@Override
	public void updatePaymentMethod(String methodName, PaymentMethod method) throws Exception {
		paymentMethod.put(methodName, method);
		
	}

	@Override
	public void deletePaymentMethod(String methodName) throws Exception {
		paymentMethod.remove(methodName);
		
	}

}

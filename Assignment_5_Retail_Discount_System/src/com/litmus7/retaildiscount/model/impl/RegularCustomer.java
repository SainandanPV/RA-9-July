package com.litmus7.retaildiscount.model.impl;

import com.litmus7.retaildiscount.model.Discountable;

public class RegularCustomer implements Discountable {
	@Override
	public double applyDiscount(double totalAmount) {
		return totalAmount*0.95;
	}
}

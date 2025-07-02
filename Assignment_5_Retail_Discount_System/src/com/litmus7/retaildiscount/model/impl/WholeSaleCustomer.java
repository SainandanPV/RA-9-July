package com.litmus7.retaildiscount.model.impl;

import com.litmus7.retaildiscount.model.Discountable;

public class WholeSaleCustomer implements Discountable {
	@Override
	public double applyDiscount(double totalAmount) {
        if (totalAmount > 10000) {
            return totalAmount * 0.85; 
        } else {
            return totalAmount * 0.90; 
        }
    }
}

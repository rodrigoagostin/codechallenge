package br.com.codechallenge.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.codechallenge.model.Coupon;
import br.com.codechallenge.services.CouponService;

@RestController
@RequestMapping("/api/rest/coupons")
public class CouponController {
	
	@Autowired
	private CouponService service;
	
	@RequestMapping(value = "user_coupon/{cpf}", method = RequestMethod.POST)
	public Coupon testeCoupon(@PathVariable String cpf) throws IOException {
		return service.addNewCoupon(cpf);
	}
	

}

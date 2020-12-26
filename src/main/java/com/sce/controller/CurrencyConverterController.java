package com.sce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sce.service.CurrencyConverterService;

@RestController
@RequestMapping("/currency-converter-application")
public class CurrencyConverterController {
	@Autowired
	CurrencyConverterService currencyConverterService;

	@GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
	public double convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable float quantity) {
		return currencyConverterService.convertCurrency(from, to, quantity);
	}

}

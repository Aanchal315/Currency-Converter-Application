package com.sce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sce.utils.CurrencyConverterValidator;

@Service
public class CurrencyConverterService {
	@Autowired
	CurrencyConverterValidator currencyConverterValidator;

	@Autowired
	ExchangeRatesService exchangeRatesService;

	public double convertCurrency(String from, String to, double quantity) {
		currencyConverterValidator.validateCurrency(from, to);
		double exchangeRate = exchangeRatesService.getExchangeRate(from, to);
		return (exchangeRate * quantity);
	}

}

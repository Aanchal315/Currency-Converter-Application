package com.sce.utils;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class CurrencyConverterValidator {
	String[] currencies = { "INR", "USD", "EUR", "GBP" };
	List<String> supportedCurrencies = Arrays.asList(currencies);

	public void validateCurrency(String from, String to) {
		if (from.equalsIgnoreCase(to))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Cannot convert currency because both from and to are same.");
		if (!supportedCurrencies.contains(from.toUpperCase()))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, from + " is not supported.");
		if (!supportedCurrencies.contains(to.toUpperCase()))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, to + " is not supported.");

	}

}

package com.sce.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@SuppressWarnings("unchecked")
public class ExchangeRatesService {

	public double getExchangeRate(String from, String to) {
		RestTemplate restTemplate = new RestTemplate();
		String exchangeRatesURL = null;

		switch (from.toUpperCase()) {
		case "INR":
			exchangeRatesURL = "https://api.exchangeratesapi.io/latest?base=INR";
			break;
		case "USD":
			exchangeRatesURL = "https://api.exchangeratesapi.io/latest?base=USD";
			break;
		case "EUR":
			exchangeRatesURL = "https://api.exchangeratesapi.io/latest?base=EUR";
			break;
		case "GBP":
			exchangeRatesURL = "https://api.exchangeratesapi.io/latest?base=GBP";
			break;
		}
		Map<String, Object> exchangeRatesResponse = restTemplate.getForObject(exchangeRatesURL, Map.class);
		Map<String, Object> rates = (Map<String, Object>) exchangeRatesResponse.get("rates");
		return (double) rates.get(to.toUpperCase());
	}

}

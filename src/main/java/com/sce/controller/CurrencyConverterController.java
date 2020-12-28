package com.sce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sce.service.CurrencyConverterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/currency-converter-application")
@Api(tags = "Currency Converter API", description = "API meant for Currency Conversion")
public class CurrencyConverterController {
	@Autowired
	CurrencyConverterService currencyConverterService;

	@ApiOperation(value = "Convert a Currency")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Returns the converted currency successfully."),
			@ApiResponse(code = 400, message = "Returns the error message when invalid path parameters are passed.") })
	@GetMapping(value = "/from/{from}/to/{to}/quantity/{quantity}")
	public double convertCurrency(
			@ApiParam(allowableValues = "INR, USD, EUR, GBP", defaultValue = "USD", required = true) @PathVariable String from,
			@ApiParam(allowableValues = "INR, USD, EUR, GBP", defaultValue = "INR", required = true) @PathVariable String to,
			@PathVariable double quantity) {
		return currencyConverterService.convertCurrency(from, to, quantity);
	}

}

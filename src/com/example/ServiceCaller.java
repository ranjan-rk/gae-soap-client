package com.example;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.webservicex.Currency;
import net.webservicex.CurrencyConvertor;
import net.webservicex.CurrencyConvertorSoap;

@SuppressWarnings("serial")
public class ServiceCaller extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	 String strFromCurrency = req.getParameter("fromCurrency");
	 String strToCurrency = req.getParameter("toCurrency");

	 Currency fromCurrency = Currency.valueOf(strFromCurrency);
	 Currency toCurrency = Currency.valueOf(strToCurrency);

	 CurrencyConvertorSoap convertorSOAP = new CurrencyConvertor().getCurrencyConvertorSoap();
	 double conversionRate = convertorSOAP.conversionRate(fromCurrency, toCurrency);
	 System.out.println(conversionRate);

	 resp.setContentType("text/plain");
	 resp.getWriter().println(conversionRate);	
    }
}

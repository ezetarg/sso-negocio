package ar.edu.unju.fi.soo.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.inject.Named;

import ar.edu.unju.fi.soo.services.NetClientGet;

@Named
public class NetClientGetImpl implements NetClientGet {

	@Override
	public String getCurrencyValue() {
		String output = null;
		try {

			URL url = new URL("http://currencies.apps.grandtrunk.net/getlatest/usd/ars");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String line = null;
			while ((line = br.readLine()) != null) {
				output = line;
			}
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return output;

	}

	@Override
	public Double convertToDollar(double value) {
		double currency = Double.parseDouble(getCurrencyValue());
		return value * currency;
	}
}

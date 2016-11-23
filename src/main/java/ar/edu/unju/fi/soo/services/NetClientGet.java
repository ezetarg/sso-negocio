package ar.edu.unju.fi.soo.services;

import org.springframework.transaction.annotation.Transactional;
import javax.inject.Named;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Named
@Transactional
public class NetClientGet {
	public String getCurrencyValue() {
		String output = null;
		  try {

				URL url = new URL("http://currencies.apps.grandtrunk.net/getlatest/usd/ars");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

				
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}
				conn.disconnect();
		
			  } catch (MalformedURLException e) {

				e.printStackTrace();

			  } catch (IOException e) {

				e.printStackTrace();

			  }
		  return output;
	}
}

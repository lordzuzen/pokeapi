package com.alea.springboot.app.pokeapi.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class APIConnect {
	public static String fromInternet(String targetURL) {
		String result = null;

		try {
			System.setProperty("http.agent", "Chrome");
			URL url = new URL(targetURL);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
			result = APIConnect.get(bufferedReader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private static String get(BufferedReader bufferedReader) {
		String result = "";
		try {
			StringBuilder stringBuilder = new StringBuilder();

			String inputLine;
			while ((inputLine = bufferedReader.readLine()) != null) {
				stringBuilder.append(inputLine);
				stringBuilder.append(System.lineSeparator());
			}

			bufferedReader.close();
			result = stringBuilder.toString().trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}

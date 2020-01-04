package br.com.andrew.registration.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class BodyRequest {
	
	public static String GetBody(HttpServletRequest request) 
			throws IOException {
		
		BufferedReader requestBody = request.getReader();
		String aux = null;
		String result = "";
		
		while((aux = requestBody.readLine()) != null) {
			result += aux;
		}
		return result;
		
	}
	
	public static Map<String, String> MapBody(String map, int limit){
		
		Map<String, String> result = new HashMap<>();
		
		map = map.replaceAll("\\}", "").replaceAll("\\{", "").replaceAll("\\]", "").replaceAll("\\[", "");
		map = map.trim();
		String[] arr = map.split(",", limit);

		for(String s : arr) {
			String[] t = s.split(":", 2);
			result.put(t[0].replaceAll("\"", "").trim(), t[1].replaceAll("\"", "").trim());
		}
		
		return result;
	}

}

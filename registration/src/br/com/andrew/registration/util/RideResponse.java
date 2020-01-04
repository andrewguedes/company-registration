package br.com.andrew.registration.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.andrew.registration.model.Company;

public class RideResponse {

	public static void rideResponse(List<?> content, HttpServletRequest request, HttpServletResponse response) 
			throws IOException {

		String accept = request.getHeader("Accept");

		if (accept.contains("xml")) {

			RideResponse.setContentType(response, ConstantsUtil.APPLICATION_XML);
			RideResponse.writeResponse(response, RideResponse.toXML(content));

		} else {

			RideResponse.setContentType(response, ConstantsUtil.APPLICATION_JSON);
			RideResponse.writeResponse(response, RideResponse.toJSON(content));

		}

	}
	
	public static void rideResponse(Object content, HttpServletRequest request, HttpServletResponse response) 
			throws IOException {

		String accept = request.getHeader("Accept");

		if (accept.contains("xml")) {

			RideResponse.setContentType(response, ConstantsUtil.APPLICATION_XML);
			RideResponse.writeResponse(response, RideResponse.toXML(content));

		} else {

			RideResponse.setContentType(response, ConstantsUtil.APPLICATION_JSON);
			RideResponse.writeResponse(response, RideResponse.toJSON(content));

		}

	}

	public static String toXML(List<?> content) {

		return new XStream().toXML(content);

	}

	public static String toXML(Object content) {

		return new XStream().toXML(content);

	}

	public static String toJSON(List<?> content) {

		return new Gson().toJson(content);

	}

	public static String toJSON(Object content) {

		return new Gson().toJson(content);

	}

	private static void setContentType(HttpServletResponse response, String contentType) {
		response.setContentType(contentType);
	}

	private static void writeResponse(HttpServletResponse response, String content) 
			throws IOException {
		response.getWriter().print(content);
	}

}

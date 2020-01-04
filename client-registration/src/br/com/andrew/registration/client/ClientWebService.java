package br.com.andrew.registration.client;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

public class ClientWebService {

	public static void main(String[] args) throws MalformedURLException {
		//String result= GetCompany();
		//String result = Get();
		String result = Post();
		//String result = Put();
		//String result = Delete();
		
		System.out.println(result);

	}
	
	private static String GetCompany() {
		try {
			return Request
					.Get("http://localhost:8080/registration/ws/v1/showCompany?id=3")
					.addHeader("Accept", "application/json")
					.execute()
					.returnContent()
					.asString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String Get() {
		try {
			return Request
					.Get("http://localhost:8080/registration/ws/v1/companies")
					.addHeader("Accept", "application/json")
					.execute()
					.returnContent()
					.asString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String Post() {
		String obj = "{\"id\":5,\"name\":\"TESTE\",\"openingDate\":\"2019-09-08\"}";		
		HttpEntity entity = new StringEntity(obj, ContentType.create("application/json", "UTF-8")) ;
		
		try {
			return Request
					.Post("http://localhost:8080/registration/ws/v1/addCompany")
					.addHeader("Accept", "application/json")
					.body(entity)
					.execute()
					.returnContent()
					.asString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String Put() {
		String obj = "{\"id\":4,\"name\":\"TESTE\",\"openingDate\":\"2019-11-08\"}";		
		HttpEntity entity = new StringEntity(obj, ContentType.create("application/json", "UTF-8")) ;
		
		try {
			return Request
					.Put("http://localhost:8080/registration/ws/v1/changeCompany")
					.addHeader("Accept", "application/json")
					.body(entity)
					.execute()
					.returnContent()
					.asString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String Delete() {
		try {
			return Request.Delete("http://localhost:8080/registration/ws/v1/RemoveCompany?id=1")
					.addHeader("Accept", "application/json")
					.execute()
					.returnContent()
					.asString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}

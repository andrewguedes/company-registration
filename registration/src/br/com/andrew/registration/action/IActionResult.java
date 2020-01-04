package br.com.andrew.registration.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IActionResult {
	
	public ActionResult execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

}

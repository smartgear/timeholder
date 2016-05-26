package lys.trymvc.controller;

import javax.servlet.http.HttpServletResponse;

public class ControllerBase {

	public ControllerBase() {
		super();
	}

	protected void allowAccess(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
	}

}
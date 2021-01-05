package com.project1.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultController {

	public static void landing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("landing page");
		RequestDispatcher redis = req.getRequestDispatcher("/index.html");
		redis.forward(req, resp);
	}
}

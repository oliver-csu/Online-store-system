package ren.oliver.store.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ren.oliver.store.service.UserService;

public class CheckUsernameServlet extends HttpServlet {

	private static final long serialVersionUID = 2072986908680922178L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获得要校验的用户名
		String username = request.getParameter("username");

		// 传递username到service
		UserService service = new UserService();
		boolean isExist = false;
		try {
			isExist = service.checkUsername(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.getWriter().write("{\"isExist\":" + isExist + "}");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
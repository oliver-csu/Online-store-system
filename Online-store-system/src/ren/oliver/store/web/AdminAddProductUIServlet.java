package ren.oliver.store.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ren.oliver.store.domain.Category;
import ren.oliver.store.service.AdminProductService;

public class AdminAddProductUIServlet extends HttpServlet {

	private static final long serialVersionUID = 4907932039311814303L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获得所有的商品的类别数据
		AdminProductService service = new AdminProductService();
		List<Category> categoryList = null;
		try {
			categoryList = service.findAllCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("categoryList", categoryList);

		request.getRequestDispatcher("/admin/product/add.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

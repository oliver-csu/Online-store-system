package ren.oliver.store.service;

import java.sql.SQLException;

import ren.oliver.store.dao.UserDao;
import ren.oliver.store.domain.User;

public class UserService {

	public boolean checkUsername(String username) throws SQLException {

		UserDao dao = new UserDao();
		Long isExist = dao.checkUsername(username);

		return isExist > 0 ? true : false;
	}

	public User login(String username, String password) throws SQLException {
		UserDao dao = new UserDao();
		return dao.login(username,password);
	}

}
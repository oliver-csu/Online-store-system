package ren.oliver.store.service;

import java.sql.SQLException;

import ren.oliver.store.dao.UserDao;

public class UserService {

	public boolean checkUsername(String username) throws SQLException {

		UserDao dao = new UserDao();
		Long isExist = dao.checkUsername(username);

		return isExist > 0 ? true : false;
	}

}
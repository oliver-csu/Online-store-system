package ren.oliver.store.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import ren.oliver.store.domain.User;
import ren.oliver.store.utils.DataSourceUtils;

public class UserDao {

	public Long checkUsername(String username) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from user where username=?";
		Long query = (Long) runner.query(sql, new ScalarHandler(), username);
		return query;
	}

	public User login(String username, String password) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		return runner.query(sql, new BeanHandler<User>(User.class), username, password);
	}

}

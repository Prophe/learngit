package com.neusoft.Dao;

import com.neusoft.entity.Account;

/**
 * 帐户dao
 * @author Administrator
 *
 */
public interface AccountDao {

	/**
	 * 用户登录
	 * **/
	public Account doLogin(Account acc) throws DaoException;
	/**
	 * 根据id修改登录ip和最后登录时间
	 * 
	 * **/
	public boolean updateAccount(Account acc) throws DaoException;
}

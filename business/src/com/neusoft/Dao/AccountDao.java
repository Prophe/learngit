package com.neusoft.Dao;

import com.neusoft.entity.Account;

/**
 * �ʻ�dao
 * @author Administrator
 *
 */
public interface AccountDao {

	/**
	 * �û���¼
	 * **/
	public Account doLogin(Account acc) throws DaoException;
	/**
	 * ����id�޸ĵ�¼ip������¼ʱ��
	 * 
	 * **/
	public boolean updateAccount(Account acc) throws DaoException;
}

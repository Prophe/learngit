package com.neusoft.Dao.Impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.neusoft.Dao.AccountDao;
import com.neusoft.Dao.DaoException;
import com.neusoft.entity.Account;
import com.neusoft.utils.ConnectionFactory;


/**
 * 
 * 
 *
 */
public class AccountDaoImpl implements AccountDao {
	
	Connection conn = null;
	QueryRunner qr = new QueryRunner();
	
	public AccountDaoImpl() {
		conn = ConnectionFactory.getInstance().getConnection();
	}

	@Override
	public Account doLogin(Account mAcc) throws DaoException {
		Account acc = null;
		String sql = "select id,username,password,ip,logindate from accounts where username = ? and password = ?";
		try {
			acc = qr.query(conn, sql, new BeanHandler<Account>(Account.class), mAcc.getUsername(),mAcc.getPassword());
		} catch (SQLException e) {
			throw new DaoException("��ѯ�û���Ϣ����",e);
		}
		return acc;
	}

	@Override
	public boolean updateAccount(Account acc) throws DaoException {
		String sql = "update accounts set ip = ?,logindate = ? where id = ?";
		try{
			int count = qr.update(conn, sql, acc.getIp(),acc.getLogindate(),acc.getId());
			if(count>0){
				return true;
			}
		}catch (SQLException e) {
			throw new DaoException("�޸��û���Ϣ����",e);
		}
		return false;
	}
	
}
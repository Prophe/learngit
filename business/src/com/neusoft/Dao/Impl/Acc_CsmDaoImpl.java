
package com.neusoft.Dao.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.Dao.Acc_CsmDao;
import com.neusoft.Dao.DaoException;
import com.neusoft.entity.Account_Consumer;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.ConnectionFactory;

/**
 * 买家帐号实现类
 * @author Administrator
 *
 */
public class Acc_CsmDaoImpl implements Acc_CsmDao {

	Connection conn = null;
	QueryRunner qr = new QueryRunner();
	
	@Override
	public boolean insertAccCsm(Account_Consumer as ) throws DaoException {
		String sql = "insert into account_consumer(loginname,password,registertime,lastlogintime,ip) values(?,?,?,?,?)";
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			int count = qr.update(conn, sql, as.getLoginname(),as.getPassword(),System.currentTimeMillis(),System.currentTimeMillis(),as.getIp());
			if ( count > 0 ) {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException("插入买家帐号信息出错",e);
		}
		return false;
	}

	@Override
	public boolean updateAccCsm(Account_Consumer as ) throws DaoException {
		String sql = "update account_consumer set loginname = ?, password = ?, registertime = ?, lastlogintime = ?, ip = ? where id = ?";
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			int count = qr.update(conn, sql, as.getLoginname(), as.getPassword(), as.getRegistertime(), as.getLastlogintime(), as.getIp(), as.getId());
			if ( count > 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException("修改买家帐号信息出错",e);
		}
		return false;
	}

	@Override
	public boolean delAccCsm(int id) throws DaoException {
		String sql = "delete from account_consumer where id = ?";
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			int count = qr.update(conn, sql, id);
			if ( count > 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException("删除买家帐号信息出错",e);
		}
		return false;
	}

	@Override
	public Account_Consumer selectAccCsmById(int id) throws DaoException {
		String sql = "select id,loginname,password,registertime,lastlogintime,ip from account_consumer where id = ?";
		Account_Consumer as = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			as = qr.query(conn, sql, new BeanHandler<Account_Consumer>(Account_Consumer.class), id);
		} catch (SQLException e) {
			throw new DaoException("根据id获取买家帐号信息出错",e);
		}
		return as;
	}

	@Override
	public PageModel<Account_Consumer> selectAccCsmAll(int pageNo, int pageSize) throws DaoException {
		PageModel<Account_Consumer>  model=null;
		
		//获取连接
		Connection conn=ConnectionFactory.getInstance().getConnection();
				
		 //sql
		String totalcount_sql="select count(id) from account_consumer";
		//查询总的记录  ScalarHandler:第一行第一列的值
		ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
		try {
			Integer totalcount=qr.query(conn, totalcount_sql, rsh).intValue();
			
			if(totalcount>0) {
				model=new PageModel<Account_Consumer>();
				model.setTotalcount(totalcount);
				String sql="select id,loginname,password,registertime,lastlogintime,ip  from account_consumer order by cid desc limit ?,?";
			    Object[] params= {(pageNo-1)*pageSize,pageSize};
				List<Account_Consumer> msgs=qr.query(conn, sql, new BeanListHandler<Account_Consumer>(Account_Consumer.class), params);
			 
				model.setDatas(msgs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("分页查询出错。。。",e);
		}finally {
			
			DbUtils.closeQuietly(conn);
		}
		
		return model;
	}

	@Override
	public int getAccCsmTotalRecords() throws DaoException {
		String sql = "select count(id) from account_consumer ";
		int num = 0; 
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			Object obj = qr.query(conn, sql, new ScalarHandler<Object>());
			num = Integer.parseInt(obj.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public Account_Consumer selectAccCsmByUser(String user) throws DaoException {
		String sql = "select id,loginname,password,registertime,lastlogintime,ip from account_consumer where loginname = ?";
		Account_Consumer as = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			as = qr.query(conn, sql, new BeanHandler<Account_Consumer>(Account_Consumer.class), user);
		} catch (SQLException e) {
			throw new DaoException("查询买家帐号信息出错",e);
		}
		return as;
	}
	
	

}

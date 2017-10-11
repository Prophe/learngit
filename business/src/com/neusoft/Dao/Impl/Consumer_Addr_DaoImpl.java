package com.neusoft.Dao.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.Dao.Consumer_Addr_Dao;
import com.neusoft.Dao.DaoException;
import com.neusoft.entity.Consumer_Addr;
import com.neusoft.utils.ConnectionFactory;
import com.neusoft.utils.PageModel;

/**
 * 买家地址实体类
 * @author Administrator
 *
 */
public class Consumer_Addr_DaoImpl implements Consumer_Addr_Dao {

	Connection conn = null;
	QueryRunner qr = new QueryRunner();
	
	@Override
	public boolean insertCsmAddr(Consumer_Addr ca) throws DaoException {
		String sql = "insert into Consumer_Addr(name,addr,phone,provice,city,Area) values(?,?,?,?,?,?)";
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			int count = qr.update(conn, sql, ca.getName(),ca.getAddr(),ca.getPhone(),ca.getProvice(),ca.getCity(),ca.getArea());
			if ( count > 0 ) {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException("插入买家地址信息出错",e);
		}
		return false;
	}

	@Override
	public boolean updateCsmAddr(Consumer_Addr ca) throws DaoException {
		String sql = "update Consumer_Addr set name = ?,addr = ?,phone = ?,provice = ?,city = ?,Area = ? where id = ?";
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			int count = qr.update(conn, sql, ca.getName(),ca.getAddr(),ca.getPhone(),ca.getProvice(),ca.getCity(),ca.getArea(),ca.getId());
			if ( count > 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException("修改买家地址信息出错",e);
		}
		return false;
	}

	@Override
	public boolean delCsmAddr(int id) throws DaoException {
		String sql = "delete from Consumer_Addr where id = ?";
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			int count = qr.update(conn, sql, id);
			if ( count > 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException("删除买家地址信息出错",e);
		}
		return false;
	}

	@Override
	public Consumer_Addr selectCsmAddrById(int id) throws DaoException {
		String sql = "select id,name,addr,phone,provice,city,Area from Consumer_Addr where id = ?";
		Consumer_Addr as = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			as = qr.query(conn, sql, new BeanHandler<Consumer_Addr>(Consumer_Addr.class), id);
		} catch (SQLException e) {
			throw new DaoException("删除买家地址信息出错",e);
		}
		return as;
	}

	@Override
	public PageModel<Consumer_Addr> selectCsmAddrAll(int pageNo,int pageSize) throws DaoException {
		PageModel<Consumer_Addr> pageModel = new PageModel<Consumer_Addr>();
		List<Consumer_Addr> list = new ArrayList<Consumer_Addr>();
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			String sql="select id,name,addr,phone,provice,city,Area from Consumer_Addr order by cid desc limit ?,?";
		    Object[] params= {(pageNo-1)*pageSize,pageSize};
			list = qr.query(conn, sql, new BeanListHandler<Consumer_Addr>(Consumer_Addr.class),params);
			pageModel.setTotalRecords(getCsmAddrTotalRecords());
			pageModel.setList(list);
		} catch (SQLException e) {
			throw new DaoException("分页查询失败!",e);
		}
		return pageModel;
	}

	@Override
	public int getCsmAddrTotalRecords() throws DaoException { 
		String sql = "select count(id) from Consumer_Addr ";
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
}

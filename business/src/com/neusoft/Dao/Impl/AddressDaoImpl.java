package com.neusoft.Dao.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.Dao.AddressDao;
import com.neusoft.Dao.DaoException;
import com.neusoft.entity.Address;
import com.neusoft.utils.ConnectionFactory;
import com.neusoft.utils.PageModel;

/**
 * 地址实现类
 * @author Administrator
 *
 */
public class AddressDaoImpl implements AddressDao {

	Connection conn = null;
	QueryRunner qr = new QueryRunner();
	
	@Override
	public boolean insertAddress(Address ad) throws DaoException {
		String sql = "insert into address(province,city,area) values(?,?,?,);";
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			int count = qr.update(conn, sql, ad.getProvince(),ad.getCity(),ad.getArea());
			if ( count > 0 ) {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException("插入买家地址信息出错",e);
		}
		return false;
	}

	@Override
	public boolean updateAddress(Address ad) throws DaoException {
		String sql = "update address set province = ?,city = ?,area = ? where id = ?";
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			int count = qr.update(conn, sql, ad.getProvince(),ad.getCity(),ad.getArea(),ad.getId());
			if ( count > 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException("修改买家地址信息出错",e);
		}
		return false;
	}

	@Override
	public boolean delAddress(int id) throws DaoException {
		String sql = "delete from address where id = ?";
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			int count = qr.update(conn, sql, id);
			if ( count > 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException("根据id删除地址信息出错",e);
		}
		return false;
	}

	@Override
	public Address selectAddress(int id) throws DaoException {
		String sql = "select id,province,city,area from address where id = ?";
		Address as = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			as = qr.query(conn, sql, new BeanHandler<Address>(Address.class), id);
		} catch (SQLException e) {
			throw new DaoException("根据id查询买家地址信息出错",e);
		}
		return as;
	}

	@Override
	public PageModel<Address> selectAddress(int pageNo,int pageSize) throws DaoException {
		PageModel<Address> pageModel = new PageModel<Address>();
		List<Address> list = new ArrayList<Address>();
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			String sql="select id,province,city,area from address order by cid desc limit ?,?";
		    Object[] params= {(pageNo-1)*pageSize,pageSize};
			list = qr.query(conn, sql, new BeanListHandler<Address>(Address.class),params);
			pageModel.setTotalRecords(getAccPrototalcount());
			pageModel.setList(list);
		} catch (SQLException e) {
			throw new DaoException("分页查询失败!",e);
		}
		return pageModel;
	}

	@Override
	public int getAccPrototalcount() throws DaoException {
		String sql = "select count(id) from address ";
		int num = 0; 
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			Object obj = qr.query(conn, sql, new ScalarHandler<Object>());
			num = Integer.parseInt(obj.toString());
		} catch (SQLException e) {
			throw new DaoException("获取买家地址总数",e);
		}
		return num;
	}


	
}

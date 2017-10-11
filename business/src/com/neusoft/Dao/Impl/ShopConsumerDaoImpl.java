package com.neusoft.Dao.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.Dao.DaoException;
import com.neusoft.Dao.ShopConsumerDao;
import com.neusoft.entity.Shoppinginfo_Consumer;
import com.neusoft.utils.ConnectionFactory;
import com.neusoft.utils.PageModel;

/**
 * 买家个人信息实现类
 * @author Administrator
 *
 */
public class ShopConsumerDaoImpl implements ShopConsumerDao {

	Connection conn = null;
	QueryRunner qr = new QueryRunner();
	
	@Override
	public boolean insertShopCsm(Shoppinginfo_Consumer sc ) throws DaoException {
		String sql = "insert into Shoppinginfo_Consumer(aid,nickname,money,lasttime) values(?,?,?,?)";
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			int count = qr.update(conn, sql, sc.getAid(), sc.getNickname(), sc.getMoney(), sc.getLasttime());
			if ( count > 0 ) {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException("插入买家购物信息出错",e);
		}
		return false;
	}

	@Override
	public boolean updateShopCsm(Shoppinginfo_Consumer sc ) throws DaoException {
		String sql = "update Shoppinginfo_Consumer set aid = ?, nickname = ?, money = ?, lasttime = ? where id = ?";
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			int count = qr.update(conn, sql, sc.getAid(), sc.getNickname(), sc.getMoney(), sc.getLasttime(), sc.getId());
			if ( count > 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException("修改买家购物信息出错",e);
		}
		return false;
	}

	@Override
	public boolean delShopCsm(int id) throws DaoException {
		String sql = "delete from Shoppinginfo_Consumer where id = ?";
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			int count = qr.update(conn, sql, id);
			if ( count > 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException("删除买家购物信息出错",e);
		}
		return false;
	}

	@Override
	public Shoppinginfo_Consumer selectShopCsmById(int id) throws DaoException {
		String sql = "select id,aid,nickname,money,lasttime from Shoppinginfo_Consumer where id = ?";
		Shoppinginfo_Consumer sc = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			sc = qr.query(conn, sql, new BeanHandler<Shoppinginfo_Consumer>(Shoppinginfo_Consumer.class), id);
		} catch (SQLException e) {
			throw new DaoException("根据id查询买家购物信息出错",e);
		}
		return sc;
	}

	@Override
	public PageModel<Shoppinginfo_Consumer> selectShopCsmAll(int pageNo, int pageSize) throws DaoException {
		PageModel<Shoppinginfo_Consumer> pageModel = new PageModel<Shoppinginfo_Consumer>();
		List<Shoppinginfo_Consumer> list = new ArrayList<Shoppinginfo_Consumer>();
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			String sql="select id,aid,nickname,money,lasttime from Shoppinginfo_Consumer order by cid desc limit ?,?";
		    Object[] params= {(pageNo-1)*pageSize,pageSize};
			list = qr.query(conn, sql, new BeanListHandler<Shoppinginfo_Consumer>(Shoppinginfo_Consumer.class),params);
			pageModel.setTotalRecords(getAccPrototalcount());
			pageModel.setList(list);
		} catch (SQLException e) {
			throw new DaoException("分页查询失败!",e);
		}
		return pageModel;
	}

	@Override
	public int getAccPrototalcount() throws DaoException {
		String sql = "select count(id) from Shoppinginfo_Consumer ";
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

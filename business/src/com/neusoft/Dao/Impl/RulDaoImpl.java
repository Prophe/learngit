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
import com.neusoft.Dao.RulDao;
import com.neusoft.entity.Rule;
import com.neusoft.utils.ConnectionFactory;
import com.neusoft.utils.PageModel;

public class RulDaoImpl implements RulDao {
	
	Connection conn = null;
	QueryRunner qr = new QueryRunner();
	
	@Override
	public boolean insertRul(Rule r) throws DaoException {
		String sql = "insert into rule(pid,size) values(?,?)";
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			int count = qr.update(conn, sql, r.getPid(),r.getSize());
			if ( count > 0 ) {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException("插入规格信息出错",e);
		}
		return false;
	}

	@Override
	public boolean updateRul(Rule r) throws DaoException {
		String sql = "update rule set pid = ?, size = ? where id = ?";
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			int count = qr.update(conn, sql, r.getPid(),r.getSize(),r.getId());
			if ( count > 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException("修改规格信息出错",e);
		}
		return false;
	}

	@Override
	public boolean delRul(int id) throws DaoException {
		String sql = "delete from rule where id = ?";
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			int count = qr.update(conn, sql, id);
			if ( count > 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException("删除规格信息出错",e);
		}
		return false;
	}

	@Override
	public Rule selectRulById(int id) throws DaoException {
		String sql = "select id, pid, size from rule where id = ?";
		Rule r = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			r = qr.query(conn, sql, new BeanHandler<Rule>(Rule.class), id);
		} catch (SQLException e) {
			throw new DaoException("根据id查询规格信息出错",e);
		}
		return r;
	}

	@Override
	public PageModel<Rule> selectRuleAll(int pageNo, int pageSize) throws DaoException {
		PageModel<Rule> pageModel = new PageModel<Rule>();
		List<Rule> list = new ArrayList<Rule>();
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			String sql="select id, pid, size from rule order by cid desc limit ?,?";
		    Object[] params= {(pageNo-1)*pageSize,pageSize};
			list = qr.query(conn, sql, new BeanListHandler<Rule>(Rule.class),params);
			pageModel.setTotalRecords(getAccPrototalcount());
			pageModel.setList(list);
		} catch (SQLException e) {
			throw new DaoException("分页查询失败!",e);
		}
		return pageModel;
	}

	@Override
	public int getAccPrototalcount() throws DaoException {
		String sql = "select count(id) from rule";
		int num = 0; 
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			Object obj = qr.query(conn, sql, new ScalarHandler<Object>());
			num = Integer.parseInt(obj.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

}

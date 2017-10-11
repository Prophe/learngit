package com.neusoft.Dao.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.Dao.DaoException;
import com.neusoft.Dao.ProductDao;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.utils.ConnectionFactory;

public class ProductDaoImpl implements ProductDao {
	QueryRunner qr=new QueryRunner();
	@Override
	public boolean insert(Product product) throws DaoException {
		// TODO Auto-generated method stub
		//  id,pname,cid,pno,pic,price,online,pdetail,isis
		
		//获取连接
		Connection conn=ConnectionFactory.getInstance().getConnection();
		//sql语句  cid,cname,pid
		String sql="insert into Product(pname,cid,pno,pic,price,online,pdetail,isis) values(?,?,?,?,?,?,?,0)";
		Object[] params= {product.getPname(),product.getCid(),product.getPno(),product.getPic(),product.getPrice(),product.getOnline(),product.getPdetail()};
		try {
			System.out.println("sql");
			int count=qr.update(conn, sql, params);
			System.out.println("++++++++");
			if(count>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 throw new DaoException("添加商品出错", e);
		}finally {
			DbUtils.closeQuietly(conn);
		}
		
		
		
		
		
		
		return false;
	}

	@Override
	public Product getPro(int id) throws DaoException {
		// TODO Auto-generated method stub
		Product product=null;
		//获取连接
				Connection conn=ConnectionFactory.getInstance().getConnection();
				//sql语句 id,pname,cid,pno,pic,price,online,pdetail,isis
				String sql="select id,pname,cid,pno,pic,price,online,pdetail,isis from Product where id=?";
				System.out.println(sql);
				try {
					product=new Product();
					product=qr.query(conn, sql, new BeanHandler<Product>(Product.class), id);
					 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					 throw new DaoException("根据cid获取类别出错", e);
				}finally {
					DbUtils.closeQuietly(conn);
				}
	
		return product;
		
		
		
	}

	@Override
	public List<Product> getProList() throws DaoException {
		// TODO Auto-generated method stub
		List<Product> list=null;
		//获取连接
		Connection conn=ConnectionFactory.getInstance().getConnection();
		//sql语句  cid,cname,pid
		String sql="select id,pname,cid,pno,pic,price,online,pdetail,isis from Product ";
		System.out.println(sql);
		try {
			list=new ArrayList<Product>();
			 list=qr.query(conn, sql, new BeanListHandler<Product>(Product.class));
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 throw new DaoException("查询所有类别出错", e);
		}finally {
			DbUtils.closeQuietly(conn);
		}

		
		return list;
	}

	@Override
	public List<Product> getProList(String pname) throws DaoException {
		// TODO Auto-generated method stub
		List<Product> list=null;
		//获取连接
		Connection conn=ConnectionFactory.getInstance().getConnection();
		//sql语句  cid,cname,pid
		String sql="select  id,pname,cid,pno,pic,price,online,pdetail,isis from Product where cname like ?";
		System.out.println(sql);
		try {
			list=new ArrayList<Product>();
			 list=qr.query(conn, sql, new BeanListHandler<Product>(Product.class),"%"+pname+"%");
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 throw new DaoException("根据关键字类别出错", e);
		}finally {
			DbUtils.closeQuietly(conn);
		}

		
		return list;
	}

	@Override
	public PageModel<Product> getPageModel(int pageNo, int pageSize) throws DaoException {
		// TODO Auto-generated method stub
		PageModel<Product>  model=null;
		
		//获取连接
		Connection conn=ConnectionFactory.getInstance().getConnection();
				
		 //sql
		String totalcount_sql="select count(cid) from Product";
		//查询总的记录  ScalarHandler:第一行第一列的值
		ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
		try {
			Integer totalcount=qr.query(conn, totalcount_sql, rsh).intValue();
			
			if(totalcount>0) {
				model=new PageModel<Product>();
				model.setTotalcount(totalcount);
				String sql="select id,pname,cid,pno,pic,price,online,pdetail,isis from Product order by cid desc limit ?,?";
			    Object[] params= {(pageNo-1)*pageSize,pageSize};
				List<Product> msgs=qr.query(conn, sql, new BeanListHandler<Product>(Product.class), params);
			 
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
	public boolean updatePro(Product product) throws DaoException {
		// TODO Auto-generated method stub
		Connection conn=ConnectionFactory.getInstance().getConnection();
		//sql语句  cid,cname,pid ,UPDATE persondata SET ageage=age+1; 
		String sql="update Product set id=?,pname=?,cid=?,pno=?,pic=?,price=?,online=?,pdetail=?,isis=? where id=?";
		Object[] params= {product.getId(),product.getPname(),product.getCid(),product.getPno(),product.getPic(),product.getPrice(),product.getOnline(),product.getPdetail(),product.getIsis(),product.getId()};
		try {
			//int count=qr.update(conn, sql, params);
			int count=qr.update(conn, sql, params);
			if(count>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 throw new DaoException("修改类别出错", e);
		}finally {
			DbUtils.closeQuietly(conn);
		}
		
		
		
		return false;
	}

	@Override
	public boolean deletePro(int id) throws DaoException {
		// TODO Auto-generated method stub
		
		Connection conn=ConnectionFactory.getInstance().getConnection();
		//sql语句  cid,cname,pid ,UPDATE persondata SET ageage=age+1; 
		String sql="delete from Product where id=? ";
		Object[] params= {id};
		try {
			//int count=qr.update(conn, sql, params);
			int count=qr.update(conn, sql, params);
			if(count>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 throw new DaoException("删除类别出错", e);
		}finally {
			DbUtils.closeQuietly(conn);
		}
		
		
		return false;
	}

	

}

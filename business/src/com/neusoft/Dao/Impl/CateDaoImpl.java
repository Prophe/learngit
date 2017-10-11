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

import com.neusoft.Dao.CateDao;
import com.neusoft.Dao.DaoException;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.ConnectionFactory;

public class CateDaoImpl implements CateDao {
	QueryRunner qr=new QueryRunner();
	@Override
	public boolean insert(Cate cate) throws DaoException {
		// TODO Auto-generated method stub
		//获取连接
		Connection conn=ConnectionFactory.getInstance().getConnection();
		//sql语句  cid,cname,pid
		String sql="insert into Cate(cname,pid) values(?,?)";
		Object[] params= {cate.getCname(),cate.getPid()};
		try {
			int count=qr.update(conn, sql, params);
			if(count>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 throw new DaoException("添加类别出错", e);
		}finally {
			DbUtils.closeQuietly(conn);
		}
		
		return false;
	}

	@Override
	public Cate getCat(int cid) throws DaoException {
		// TODO Auto-generated method stub
		Cate cate=null;
		//获取连接
				Connection conn=ConnectionFactory.getInstance().getConnection();
				//sql语句  cid,cname,pid
				String sql="select cid,cname,pid from Cate where cid=?";
				System.out.println(sql);
				try {
				     cate=new Cate();
					 cate=qr.query(conn, sql, new BeanHandler<Cate>(Cate.class), cid);
					 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					 throw new DaoException("根据cid获取类别出错", e);
				}finally {
					DbUtils.closeQuietly(conn);
				}
	
		return cate;
	}

	
	@Override
	public List<Cate> getCatList() throws DaoException {
		// TODO Auto-generated method stub
		List<Cate> list=null;
		//获取连接
		Connection conn=ConnectionFactory.getInstance().getConnection();
		//sql语句  cid,cname,pid
		String sql="select cid,cname,pid from Cate where pid=0 ";
		System.out.println(sql);
		try {
			list=new ArrayList<Cate>();
			 list=qr.query(conn, sql, new BeanListHandler<Cate>(Cate.class));
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 throw new DaoException("查询所有类别出错", e);
		}finally {
			DbUtils.closeQuietly(conn);
		}

		
		return list;
	}

	@Override
	public List<Cate> getCatList(String cname) throws DaoException {
		// TODO Auto-generated method stub
		
		List<Cate> list=null;
		//获取连接
		Connection conn=ConnectionFactory.getInstance().getConnection();
		//sql语句  cid,cname,pid
		String sql="select cid,cname,pid from Cate where cname like ?";
		System.out.println(sql);
		try {
			list=new ArrayList<Cate>();
			 list=qr.query(conn, sql, new BeanListHandler<Cate>(Cate.class),"%"+cname+"%");
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 throw new DaoException("根据关键字类别出错", e);
		}finally {
			DbUtils.closeQuietly(conn);
		}

		
		return list;
	}

	@Override
	public PageModel<Cate> getPageModel(int pageNo, int pageSize) throws DaoException {
		// TODO Auto-generated method stub
		
			PageModel<Cate>  model=null;
			
			//获取连接
			Connection conn=ConnectionFactory.getInstance().getConnection();
					
			 //sql
			String totalcount_sql="select count(cid) from Cate";
			//查询总的记录  ScalarHandler:第一行第一列的值
			ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
			try {
				Integer totalcount=qr.query(conn, totalcount_sql, rsh).intValue();
				
				if(totalcount>0) {
					model=new PageModel<Cate>();
					model.setTotalcount(totalcount);
					String sql="select cid,cname,pid  from Cate order by cid desc limit ?,?";
				    Object[] params= {(pageNo-1)*pageSize,pageSize};
					List<Cate> msgs=qr.query(conn, sql, new BeanListHandler<Cate>(Cate.class), params);
				 
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
	public boolean updateCat(Cate cate) throws DaoException {
		// TODO Auto-generated method stub
		//获取连接
				Connection conn=ConnectionFactory.getInstance().getConnection();
				//sql语句  cid,cname,pid ,UPDATE persondata SET ageage=age+1; 
				String sql="update Cate set cname=?,pid=? where cid=?";
				Object[] params= {cate.getCname(),cate.getPid(),cate.getCid()};
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
	public boolean deleteCat(int id) throws DaoException {
		// TODO Auto-generated method stub
		Connection conn=ConnectionFactory.getInstance().getConnection();
		//sql语句  cid,cname,pid ,UPDATE persondata SET ageage=age+1; 
		String sql="delete from Cate where cid=? ";
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

	@Override
	public Cate getCatByPid() throws DaoException {
		// TODO Auto-generated method stub
		
		Cate cate=null;
		//获取连接
				Connection conn=ConnectionFactory.getInstance().getConnection();
				//sql语句  cid,cname,pid
				String sql="select cid,cname,pid from Cate where pid=0";
				System.out.println(sql);
				try {
				     cate=new Cate();
					 cate=qr.query(conn, sql, new BeanHandler<Cate>(Cate.class));
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					 throw new DaoException("根据pid获取类别出错", e);
				}finally {
					DbUtils.closeQuietly(conn);
				}
	
		return cate;
	}
	
	@Override
	public List<Cate> getAllCatList() throws DaoException {
		// TODO Auto-generated method stub
		List<Cate> list=null;
		//获取连接
		Connection conn=ConnectionFactory.getInstance().getConnection();
		//sql语句  cid,cname,pid
		String sql="select cid,cname,pid from Cate ";
		System.out.println(sql);
		try {
			list=new ArrayList<Cate>();
			 list=qr.query(conn, sql, new BeanListHandler<Cate>(Cate.class));
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 throw new DaoException("根据关键字类别出错", e);
		}finally {
			DbUtils.closeQuietly(conn);
		}

		
		return list;
	}
	@Override
	public List<Cate> getCatByPid(int pid) throws DaoException {
		// TODO Auto-generated method stub
		List<Cate> list=null;
		//获取连接
		Connection conn=ConnectionFactory.getInstance().getConnection();
		//sql语句  cid,cname,pid
		String sql="select cid,cname,pid from Cate where pid=?";
		System.out.println(sql);
		try {
			list=new ArrayList<Cate>();
			 list=qr.query(conn, sql, new BeanListHandler<Cate>(Cate.class),pid);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 throw new DaoException("根据关键字类别出错", e);
		}finally {
			DbUtils.closeQuietly(conn);
		}

		
		return list;
	}

	@Override
	public Cate getCatByName(String name) throws DaoException {
		// TODO Auto-generated method stub
		Cate cate=null;
		//获取连接
				Connection conn=ConnectionFactory.getInstance().getConnection();
				//sql语句  cid,cname,pid
				String sql="select cid,cname,pid from Cate where cname=?";
				System.out.println(sql);
				try {
				     cate=new Cate();
					 cate=qr.query(conn, sql, new BeanHandler<Cate>(Cate.class),name);
					 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					 throw new DaoException("根据类别名称获取类别出错", e);
				}finally {
					DbUtils.closeQuietly(conn);
				}
	
		return cate;
	}




	
//	/**
//	 * 删除分类
//	 * =======================================================================================================
//	 */
//	@Override
//	public Cate rearchId(Integer cid) {
//		Connection conn = ConnectionFactory.getInstance().getConnection();
//		String sql = "select * from cate where cid =?";
//		ResultSetHandler<Cate> rs = new BeanHandler<>(Cate.class);
//		Cate tb = null;
//		try {
//			tb = qr.query(conn, sql, rs, cid);
//			if(tb!=null)
//			{
//				return tb;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally
//		{
//			DbUtils.closeQuietly(conn);
//		}
//		return null;
//	}
//
//	
//	public void delRegion(Integer cid)
//	{
//		Connection conn = null;
//		try
//		{
//			conn = ConnectionFactory.getInstance().getConnection();
//			ConnectionFactory.beginTransaction(conn);
//			ConnectionFactory.
//			Cate currentNode = rearchId(cid);
//			recursionDelNode(conn,cid);
//			//如果父节点下没有子节点
//			if(currentNode.getPid()==0)
//			{
//				currentNode.setPid(0);
//			}
//			//提交事务
//			ConnectionFactory.commitTransaction(conn);
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//			ConnectionFactory.rollbackTransaction(conn);
//		}finally
//		{
//			ConnectionFactory.resetConnection(conn);
//			DbUtils.closeQuietly(conn);
//		}
//	}
//	
//	/**
//	 * 递归删除
//	 * @param conn
//	 * @param cid
//	 * 
//	 * 
//	 */
//	public void  recursionDelNode(Connection conn, Integer cid)throws  SQLException{
//		String sql ="select cid,cname,pid from cate where pid = ?";
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try
//		{
//			conn = ConnectionFactory.getInstance().getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, cid);
//			rs = pstmt.executeQuery();
//			while(rs.next())
//			{
//				if(0==rs.getInt("pid"))
//				{
//					recursionDelNode(conn, rs.getInt("cid"));
//				}
//				delNode(conn,rs.getInt("cid"));
//			}
//			//删除自身
//			delNode(conn,cid);
//		
//		}finally
//		{
//			DbUtils.closeQuietly(rs);
//			DbUtils.closeQuietly(pstmt);
//		}
//		
//	}
//	/**
//	 * 删除节点
//	 * @param conn
//	 * @param int1
//	 */
//	private void delNode(Connection conn, int cid)throws SQLException {
//		String sql ="delete from cate where cid=?";
//		PreparedStatement pstmt  = null;
//		try
//		{
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, cid);
//			pstmt.executeUpdate();
//		}finally
//		{
//			DbUtils.closeQuietly(pstmt);
//		}
//		
//	}
//	
	
}

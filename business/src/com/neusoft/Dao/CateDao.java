package com.neusoft.Dao;

import java.util.List;

import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;

/**
 * 类别表
 * */
public interface CateDao {
    
	/**
	 * 添加类别
	 * */
	public boolean insert(Cate cate) throws DaoException;
	
	/**
	 * 根据id获取类别
	 * */
	public Cate getCat(int cid) throws DaoException;
	
	/**
	 * 获取pid=0
	 * 
	 * */
	public Cate getCatByPid()throws DaoException;
	/**
	 * 获取拥有pid的cid
	 * **/
	public List<Cate> getCatByPid(int pid)throws DaoException;
	/**
	 * 所有类别
	 * */
	public List<Cate> getAllCatList()throws DaoException;
	/**
	 * 获取所有父类类别类别
	 * 
	 * */
	public List<Cate> getCatList() throws DaoException;
	/**
	 * 根据类别名称获取类别(模糊查询）
	 * 
	 * */
	public List<Cate> getCatList(String cname) throws DaoException;
	
	/**
	 * 根据类别名称获取类别数据
	 * */
	public Cate getCatByName(String name) throws DaoException;
	
	/**
	 * 分页
	 * */
	public PageModel<Cate> getPageModel(int pageNo,int pageSize)throws DaoException;
	/**
	 * 修改类别
	 * */
	public boolean updateCat(Cate cate) throws DaoException;
	/**
	 * 删除类别
	 * */
	public boolean deleteCat(int id) throws DaoException;
//	/**
//	 * 删除分类
//	 * =======================================================================================================
//	 */
//	public Cate rearchId(Integer cid) throws DaoException;
//	
//	
//	
//	public void delRegion(Integer cid) throws DaoException;
//	
	
	
	
}

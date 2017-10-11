package com.neusoft.Dao;

import java.util.List;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;

public interface ProductDao {

	/**
	 * 添加商品
	 * */
	public boolean insert(Product product) throws DaoException;
	
	/**
	 * 根据id获取商品
	 * */
	public Product getPro(int id) throws DaoException;
	
	public List<Product> getProList() throws DaoException;
	
	public List<Product> getProList(String pname) throws DaoException;
	
	public PageModel<Product> getPageModel(int pageNo,int pageSize)throws DaoException;
	
	public boolean updatePro(Product product) throws DaoException;
	
	public boolean deletePro(int id) throws DaoException;
	
}

package com.neusoft.Dao;

import com.neusoft.entity.Shoppinginfo_Consumer;
import com.neusoft.utils.PageModel;

/**
 * 买家购物信息dao
 * @author Administrator
 *
 */
public interface ShopConsumerDao {

	/**
	 * 插入买家购物信息
	 */
	public boolean insertShopCsm(Shoppinginfo_Consumer sc) throws DaoException;
	
	/**
	 * 修改买家购物信息
	 * @param r
	 * @return
	 * @throws DaoException
	 */
	public boolean updateShopCsm(Shoppinginfo_Consumer sc) throws DaoException;
	
	/**
	 * 根据id删除买家购物信息
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delShopCsm(int id) throws DaoException;
	
	/**
	 * 根据id查询买家购物信息
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public Shoppinginfo_Consumer selectShopCsmById(int id) throws DaoException;
	
	/**
	 * 分页查询所有买家购物信息
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws DaoException
	 */
	public PageModel<Shoppinginfo_Consumer> selectShopCsmAll(int pageNo,int pageSize) throws DaoException;
	
	/**
	 * 获取买家购物总数
	 * @return
	 * @throws DaoException
	 */
	public int getAccPrototalcount() throws DaoException;
}

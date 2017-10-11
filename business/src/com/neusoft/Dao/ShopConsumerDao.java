package com.neusoft.Dao;

import com.neusoft.entity.Shoppinginfo_Consumer;
import com.neusoft.utils.PageModel;

/**
 * ��ҹ�����Ϣdao
 * @author Administrator
 *
 */
public interface ShopConsumerDao {

	/**
	 * ������ҹ�����Ϣ
	 */
	public boolean insertShopCsm(Shoppinginfo_Consumer sc) throws DaoException;
	
	/**
	 * �޸���ҹ�����Ϣ
	 * @param r
	 * @return
	 * @throws DaoException
	 */
	public boolean updateShopCsm(Shoppinginfo_Consumer sc) throws DaoException;
	
	/**
	 * ����idɾ����ҹ�����Ϣ
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delShopCsm(int id) throws DaoException;
	
	/**
	 * ����id��ѯ��ҹ�����Ϣ
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public Shoppinginfo_Consumer selectShopCsmById(int id) throws DaoException;
	
	/**
	 * ��ҳ��ѯ������ҹ�����Ϣ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws DaoException
	 */
	public PageModel<Shoppinginfo_Consumer> selectShopCsmAll(int pageNo,int pageSize) throws DaoException;
	
	/**
	 * ��ȡ��ҹ�������
	 * @return
	 * @throws DaoException
	 */
	public int getAccPrototalcount() throws DaoException;
}

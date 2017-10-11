package com.neusoft.Dao;

import com.neusoft.entity.Account_Consumer;
import com.neusoft.entity.PageModel;

/**
 * ����ʺ���Ϣdao
 * @author Administrator
 *
 */
public interface Acc_CsmDao {

	/**
	 * ��������ʻ���Ϣ
	 */
	public boolean insertAccCsm(Account_Consumer as) throws DaoException;
	
	/**
	 * �޸�����ʻ���Ϣ
	 * @param r
	 * @return
	 * @throws DaoException
	 */
	public boolean updateAccCsm(Account_Consumer as) throws DaoException;
	
	/**
	 * ����idɾ������ʻ���Ϣ
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delAccCsm(int id) throws DaoException;
	
	/**
	 * ����id��ѯ����ʻ���Ϣ
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public Account_Consumer selectAccCsmById(int id) throws DaoException;
	
	/**
	 * �����û�����ѯ����
	 * @param user
	 * @return
	 * @throws DaoException
	 */
	public Account_Consumer selectAccCsmByUser(String user) throws DaoException;
	
	/**
	 * ��ҳ��ѯ��������ʻ���Ϣ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws DaoException
	 */
	public PageModel<Account_Consumer> selectAccCsmAll(int pageNo,int pageSize) throws DaoException;
	
	/**
	 * ��ȡ����ʻ�����
	 * @return
	 * @throws DaoException
	 */
	public int getAccCsmTotalRecords() throws DaoException;
}
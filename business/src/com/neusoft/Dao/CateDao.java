package com.neusoft.Dao;

import java.util.List;

import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;

/**
 * ����
 * */
public interface CateDao {
    
	/**
	 * ������
	 * */
	public boolean insert(Cate cate) throws DaoException;
	
	/**
	 * ����id��ȡ���
	 * */
	public Cate getCat(int cid) throws DaoException;
	
	/**
	 * ��ȡpid=0
	 * 
	 * */
	public Cate getCatByPid()throws DaoException;
	/**
	 * ��ȡӵ��pid��cid
	 * **/
	public List<Cate> getCatByPid(int pid)throws DaoException;
	/**
	 * �������
	 * */
	public List<Cate> getAllCatList()throws DaoException;
	/**
	 * ��ȡ���и���������
	 * 
	 * */
	public List<Cate> getCatList() throws DaoException;
	/**
	 * ����������ƻ�ȡ���(ģ����ѯ��
	 * 
	 * */
	public List<Cate> getCatList(String cname) throws DaoException;
	
	/**
	 * ����������ƻ�ȡ�������
	 * */
	public Cate getCatByName(String name) throws DaoException;
	
	/**
	 * ��ҳ
	 * */
	public PageModel<Cate> getPageModel(int pageNo,int pageSize)throws DaoException;
	/**
	 * �޸����
	 * */
	public boolean updateCat(Cate cate) throws DaoException;
	/**
	 * ɾ�����
	 * */
	public boolean deleteCat(int id) throws DaoException;
//	/**
//	 * ɾ������
//	 * =======================================================================================================
//	 */
//	public Cate rearchId(Integer cid) throws DaoException;
//	
//	
//	
//	public void delRegion(Integer cid) throws DaoException;
//	
	
	
	
}

package test;

import com.neusoft.Dao.DaoFactory;
import com.neusoft.Dao.ProductDao;
import com.neusoft.entity.Product;
import com.neusoft.utils.UUid;

public class ProductTest {
  
	public static void main(String[] args) {
		insertTest();
	}
	
	public static void insertTest(){
		//pname,cid,pno,pic,price,online,pdetail,isis
		/**
		 * id ,pno,pname,price,online
		 * insert into Product(pname,cid,pno,pic,price,online,pdetail,isis) values=('�����ﶬ��ͷ�������޳����������� ', 2, UUid.createpno(),'fdfdsf' , 109, 1, '��������ʽ�Ŀ���',0)
		 * */
		ProductDao pro= DaoFactory.getInstance("productDao");
		Product product=new Product("�����ﶬ��ͷ�������޳����������� ", 2, UUid.createpno(),"fdfdsf" , 109, 1, "��������ʽ�Ŀ���");
		pro.insert(product);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

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
		 * insert into Product(pname,cid,pno,pic,price,online,pdetail,isis) values=('潮流秋冬街头开衫纯棉长袖青年外套 ', 2, UUid.createpno(),'fdfdsf' , 109, 1, '的生产方式的考点',0)
		 * */
		ProductDao pro= DaoFactory.getInstance("productDao");
		Product product=new Product("潮流秋冬街头开衫纯棉长袖青年外套 ", 2, UUid.createpno(),"fdfdsf" , 109, 1, "的生产方式的考点");
		pro.insert(product);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

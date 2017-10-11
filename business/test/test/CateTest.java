package test;

import java.util.List;

import com.neusoft.Dao.CateDao;
import com.neusoft.Dao.DaoFactory;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;

public class CateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		insertTest();
		updateProTest();
//		deleteProTest();
		//getProTest();
//		getProListTest();
		//getProListByTest();
		//getPageModelTest();
//		getCatByNameTest();
	}

	public static void insertTest(){
		
		CateDao ca= DaoFactory.getInstance("cateDao");
		Cate cate = new Cate("男装",0);
		ca.insert(cate);
//		for(int i=0;i<10;i++){
//			if(ca.insert(cate)){
//				System.out.println("添加成功");
//				}else{
//					System.out.println("faile");
//				}
//		}
		
		
	}
	
	public static void updateProTest(){
		CateDao ca= DaoFactory.getInstance("cateDao");
		Cate cate = new Cate(1083,"女鞋",0);
		
		if(ca.updateCat(cate)){
		System.out.println("修改成功");
		}else{
			System.out.println("faile");
		}
	
	
	}
	

	public static void deleteProTest(){
		
		CateDao ca= DaoFactory.getInstance("cateDao");
		
		
		if(ca.deleteCat(3)){
		System.out.println("su");
		}else{
			System.out.println("faile");
		}
	}
		
	
	public static void getProTest(){
			
			CateDao ca= DaoFactory.getInstance("cateDao");
			System.out.println(ca.getCat(1));
			
	
	}
	public static void getProListTest(){
		
		CateDao ca= DaoFactory.getInstance("cateDao");
			
		
		List<Cate> s= ca.getCatList();
		for (Cate cate : s) {
			System.out.println(cate);
		}
		
		

}
public static void getProListByTest(){
		
		CateDao ca= DaoFactory.getInstance("cateDao");
		List<Cate> s= ca.getCatList("装");
		for (Cate cate : s) {
			System.out.println(cate);
		}
}
public static void getPageModelTest(){
	CateDao ca= DaoFactory.getInstance("cateDao");
	PageModel<Cate> s=ca.getPageModel(1, 5);
	
		System.out.println(s);
	
}
public static void getCatByNameTest(){
	CateDao ca=DaoFactory.getInstance("cateDao");
	Cate a= ca.getCatByName("男装");
	System.out.println(a);
}



}

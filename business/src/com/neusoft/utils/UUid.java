package com.neusoft.utils;

import java.util.UUID;

public class UUid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		 System.out.println(createpno());
	}

	
	public static String createpno(){
//		UUID createpno=new UUID();
		String uuid = UUID.randomUUID().toString(); 
		//È¥µô¡°-¡±·ûºÅ 
		return uuid.replaceAll("-", "");
	}
}

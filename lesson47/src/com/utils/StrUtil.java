package com.utils;

public class StrUtil {
	//��һ���ַ����ǲ���null �� "" ,����Ƿ���true
	public static boolean isNullOrEmpty(String str){
		
		if(str==null || "".equals(str)){
			return true;
		}
		
		else{
			return false;
		}
	}
}

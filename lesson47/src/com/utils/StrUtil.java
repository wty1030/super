package com.utils;

public class StrUtil {
	//判一个字符串是不是null 或 "" ,如果是返回true
	public static boolean isNullOrEmpty(String str){
		
		if(str==null || "".equals(str)){
			return true;
		}
		
		else{
			return false;
		}
	}
}

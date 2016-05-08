package com.quicksand.problem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CalculateNameValue {

	public static void main(String[] args) {	
		System.out.println(getNamesCount(readFile()));
	}
	public static long getNamesCount(String names){
		String nametemp = names.replace("\"", "");
		System.out.println(nametemp);
		String[] name = names.split(",");
		List<String> nameArray = new ArrayList<String>();
		for(int i = 0;i<name.length;i++){
			nameArray.add(name[i]);
		}
		//按字符串进行排序
		Collections.sort(nameArray);
		long count = 0;
		for(int i = 0;i<nameArray.size();i++){
			
			long nameValue = getNameValue(nameArray.get(i));
			count += (i+1)*nameValue;
		}
		return count;
		
		
	}
	/**
	 * 获得一个名字所有字母的值
	 * @param name
	 * @return
	 */
	public static int getNameValue(String name){
		int count = 0;
		for(int i = 0;i<name.length();i++){
			char ch = name.charAt(i);
			int temp = getCharValue(ch);
			if(temp > 0){
				count += temp;
			}
		}
		return count;
	}
	/**
	 * 获得一个字符的位置
	 * @param ch
	 * @return
	 */
	public static int getCharValue(char ch){
		if(ch > 'Z' || ch < 'A')
			return -1;
		return ch - 64;
	}
	/**
	 * 读取文本文件
	 * @return
	 */
	public static String readFile(){
		StringBuffer sb = new StringBuffer();
		File file = new File("/Users/xiqun/names.txt");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String length = null;
			while((length = br.readLine())!=null){
				sb.append(length);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
}

package com.quicksand.problem;

import java.util.ArrayList;
import java.util.List;
/**
 * problem 24
 * 求0~9的全排列，第一百万个的排列
 * @author quicksand
 *
 */
public class Lexicographic {
	public static List<Integer> ranke = new ArrayList<Integer>();
	public static List<Integer> rank = new ArrayList<Integer>();
	public static List<Integer> def = new ArrayList<Integer>();
	public static void main(String[] args) {		
		//从第0个开始算起，所以应该减1
		int ranked = 1000000-1;
		try {
			getRanked(ranked, 9);
		} catch (Exception e) {
			System.out.println("没有这么多的排列");
		}
	}
	/**
	 * 获取第ranked位，0~num的全排列的数
	 * @param ranked 
	 * @param num
	 */
	public static void getRanked(int ranked,int num) throws IndexOutOfBoundsException{
		saveRankeOfNum(num);
		//添加默认的排列组合
		for(int i = 0;i <= num;i++){
			def.add(i);
		}
		//生成排列的每一位
		for(int i = 0;i<ranke.size();i++){
			int shang = ranked / ranke.get(i);
			int yu = ranked % ranke.get(i);
			if(rank!=null){
				rank.add(def.get(shang));
				def.remove(shang);
			}else{
				rank.add(shang);
				def.remove(shang);
			}
			ranked = yu;	
		}
		rank.add(def.get(0));
		for(int i = 0;i<rank.size();i++){
			System.out.print(rank.get(i));
		}
	}
	public static void saveRankeOfNum(int num){
		for(int i = 0;i<num;i++){
			ranke.add(getNumOfRanke(num-i));
		}
	}
	public static int getNumOfRanke(int num){
		if(num == 1){
			return 1;
		}
		return num*getNumOfRanke(num-1);
	}
}

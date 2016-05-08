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
	public static int[] ranke = new int[9];
	public static List<Integer> rank = new ArrayList<Integer>();
	public static List<Integer> def = new ArrayList<Integer>();
	public static final int NUM_OFFSET = 10;
	public static void main(String[] args) {
		for(int i = 0;i < ranke.length;i++){
			ranke[i] = getNumOfRanke(9-i);
		}
		//从第0个开始算起，所以应该减1
		int ranked = 1000000-1;
		System.out.println(ranked);
		for(int i = 0;i < 10;i++){
			def.add(i);
		}
		for(int i = 0;i<ranke.length;i++){
			int shang = ranked / ranke[i];
			int yu = ranked % ranke[i];
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
	
	public static int getNumOfRanke(int num){
		if(num == 1){
			return 1;
		}
		return num*getNumOfRanke(num-1);
	}
}

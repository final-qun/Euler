package com.quicksand.problem;

import java.util.ArrayList;
import java.util.List;
/**
 * problem 25
 * @author Administrator
 *
 */
public class DigitFibonacciNumberOf1000 {
	private static List<Integer> currentList = new ArrayList<Integer>();
	private static List<Integer> foreList = new ArrayList<Integer>();
	public static void main(String[] args) {
		currentList.add(1);
		foreList.add(1);
		int index = 3;

		while(true){
			getDigitAddNum();
//			for (int i = currentList.size()-1; i >= 0; i--) {
//				System.out.print(currentList.get(i));
//			}
//			System.out.println();
			if(currentList.size() == 1000){
				System.out.println(index);
				break;
			}
			index++;
		}
	}
	
	public static void getDigitAddNum(){
		List<Integer> list = new ArrayList<Integer>();
		int add = 0;
		int length = foreList.size();
		for(int i = 0;i < length;i++){
			int fore = foreList.get(i);
			int current = currentList.get(i);
			int he = fore + current + add;
			list.add(he%10);
			add = he / 10;
		}
		for(int i = length;i < currentList.size();i++){
			int current = currentList.get(i)+add;
			list.add(current % 10);
			add = current / 10;
		}
		if(add > 0){
			list.add(add);
		}
		foreList.clear();
		foreList.addAll(currentList);
		currentList.clear();
		currentList.addAll(list);
	}
}

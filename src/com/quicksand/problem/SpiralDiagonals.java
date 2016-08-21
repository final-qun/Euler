package com.quicksand.problem;

import java.util.ArrayList;
import java.util.List;

public class SpiralDiagonals {
	private static List<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) {
		list.add(1);
		for(int i = 3;i<=1001;i=i+2){
			getSpiralDiagonals(i);
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void getSpiralDiagonals(int num){
		int temp = num*num;
		int index = (num-1)/2 - 1;
		int diagonals = temp*4 - (num-1)*6 + list.get(index);
		list.add(diagonals);
		
	}
}

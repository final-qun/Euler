package com.quicksand.problem;
/**
 * problem 23
 * 求所有不是两个abundant数之和的数之和
 * @author quicksand
 *
 */
public class AbundantNum {
	public static int[] abundantNum = new int[28123];
	public static void main(String[] args) {
		for(int i = 12;i<28123;i++){
			if(isAbundantNum(i)){
				abundantNum[i] = 1;
			}
		}
		int count = 0;
		for(int i = 1;i<28123;i++){
			if(isTwoAbundatNum(i)){
				continue;
			}
			count += i;
		}
		System.out.println(count);
	}
	public static boolean isTwoAbundatNum(int num){
		int halfOfNum = num / 2;
		for(int i = 12;i<=halfOfNum ;i++){
			if(abundantNum[i] == 1){
				int another = num - i;
				if(abundantNum[another] == 1){
					return true;
				}
			}
		}
		return false;
	}
	public static boolean isAbundantNum(int num){
		int count = 0;
		for(int i = 2;i <= Math.sqrt(num);i++){
			if(num % i == 0){
				int temp = num/i;
				if(temp != i)
					count += i + num /i;
				else
					count += i;
			}
		}
		count++;
		if(num < count){
			return true;
		}
		return false;
	}
}

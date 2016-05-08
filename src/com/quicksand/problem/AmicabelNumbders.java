package com.quicksand.problem;
/**
 * problem 21
 * 求10000以下所有Amicabel数之和
 * @author quicksand
 *
 */
public class AmicabelNumbders {
	public static void main(String[] args) {
		int count = 0;
		for(int i = 2;i<10000;i++){
			if(isAmicabel(i)){
				
				count+=i+getNumSum(i);
			}
		}
		System.out.println(count);
	}
	
	public static boolean isAmicabel(int num){
		int count = getNumSum(num);
		if(count < num){
			if(num == getNumSum(count)){
					return true;
			}
		}
		return false;
	}
	public static int getNumSum(int num){
		int count = 0;
		for(int i = 2;i <= Math.sqrt(num);i++){
			if(num % i == 0){
				count += i + num /i;
			}
		}
		count++;
		return count;
	}
}

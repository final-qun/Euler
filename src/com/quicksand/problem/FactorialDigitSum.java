package com.quicksand.problem;

import java.util.ArrayList;
import java.util.List;
/**
 * problem 20
 * 求100的阶乘各个位数之和
 * @author quicksand
 *
 */
public class FactorialDigitSum {
	public static List<Integer> digit = new ArrayList<Integer>();
	public static void main(String[] args) {
		digit.add(1);
		List<Integer> result = new ArrayList<Integer>();
		for(int i = 1;i<=100;i++){
			result.clear();
			result.addAll(multArrayAndTrueNum(digit, i));
			digit.clear();
			digit.addAll(result);
		}
		System.out.println(arrayToString(result));
		System.out.println(arrayToCount(result));
	}
	public static String arrayToString(List<Integer> array){
		String result="";
		for (int i = array.size()-1; i >=0; i--) {
			result += array.get(i);
		}
		return result;
	}
	public static long arrayToCount(List<Integer> array){
		long num = 0;
		for (int i = 0; i<array.size(); i++) {
			num += array.get(i);
		}
		return num;
	}
	public static List<Integer> multArrayAndTrueNum(List<Integer> array,int num){
		int shi = num;
		int count = 0;
		List<Integer> result = new ArrayList<Integer>();
		while(shi != 0){
			
			int ge = shi % 10;
			shi = shi / 10;
			List<Integer> temp = new ArrayList<Integer>();
			temp = multArrayAndNum(array,ge);
			for(int i = 0;i<count;i++){
				temp.add(0,0);
			}
			if(count == 0){
				result.addAll(temp);
			}else{
				List<Integer> temp1 = new ArrayList<Integer>();
				temp1 = addArray(result, temp);
				result.clear();
				result.addAll(temp1);
			}
			count++;
		}
		return result;
	}
	public static List<Integer> addArray(List<Integer> array1,List<Integer> array2){
		List<Integer> result = new ArrayList<Integer>();
		int length1 = array1.size();
		int length2 = array2.size();
		int length = length1 > length2 ? length2 : length1;
		int carry = 0;
		for(int i = 0;i < length;i++){
			int he = array1.get(i) + array2.get(i) + carry;
			carry = he / 10;
			result.add(he % 10);
			
		}
		if(length1 > length2){
			for(int i = length;i<length1;i++){
				int he = array1.get(i) + carry;
				carry = he / 10;
				result.add(he % 10);
			}
		}else{
			for(int i = length;i<length2;i++){
				int he = array2.get(i) + carry;
				carry = he / 10;
				result.add(he % 10);
			}
		}
		if(carry!=0){
			result.add(carry);
		}
		return result;
	}
	public static List<Integer> multArrayAndNum(List<Integer> array,int num){
		List<Integer> result = new ArrayList<Integer>();
		int carry = 0;
		for(int i = 0;i<array.size();i++){
			int temp = array.get(i);
			int temp1 = temp*num + carry;
			carry = temp1 /10;
			result.add(temp1%10);
		}
		if(carry != 0){
			result.add(carry);
		}
		return result;
	}
}

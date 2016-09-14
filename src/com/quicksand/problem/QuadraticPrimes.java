package com.quicksand.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * problem 27
 * n^2 + an + b 求其能代表素数最多的公式的ab的乘积
 * @author Administrator
 *
 */
public class QuadraticPrimes {
	public static void main(String[] args) {
		List<Integer> primes = new ArrayList<Integer>();
		for (int i = 2;i<= 1000;i++){
			if(isPrimes(i)) {
				primes.add(i);
			}
		}
		int maxPrimes = 0;
		int a = 0;
		int b = 0;
		for (Integer i:primes) {
			for(int j = -1000;j <= 1000; j++){
				int k = 0;
				while(true){
					int key = k*k + j*k +i;
					if(key < 0){
						break;
					}
					if(isPrimes(key)) {
						k++;
					}else {
						if(k > maxPrimes){
							maxPrimes = k;
							a = j;
							b = i;
						}
						break;
					}
				}
			}
			
		}
		System.out.println(maxPrimes+"  a:"+a+"  b:"+b);
		if(a < 0) {
			a = -a;
		}
		System.out.println(a*b);
	}
	public static boolean isPrimes(int primes) {
		if (primes == 2) {
			return true;
		}
		if (primes == 3) {
			return true;
		}
		for (int i = 2;i*i <= primes;i++) {
			if (primes % i == 0) {
				return false;
			}
		}
		return true;
	}
}

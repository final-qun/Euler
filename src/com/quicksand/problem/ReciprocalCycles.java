package com.quicksand.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * problem 26
 * 求1/n的最大循环位数
 * @author Administrator
 *
 */
public class ReciprocalCycles {
	
	public static final int dimen = 10;
	public static void main(String[] args) {
		int max = 0;
		int index = 0;
		for (int i = 1;i < 1000;i++) {
			int count = count(i);
			if (count > max) {
				index = i;
				max = count;
			}
		}
		System.out.println(index);
	}
	
	public static int count(int des) {
		Set<Integer> set = new HashSet<Integer>();
		int mode = 1 * dimen % des;
		while (mode != 0) {
			if (!set.contains(mode)) {
				set.add(mode);
			} else {
				return set.size();
			}
			mode = mode * dimen % des;
		}
		return 0;
	}
}

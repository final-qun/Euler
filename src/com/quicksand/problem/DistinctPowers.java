package com.quicksand.problem;

import java.util.HashSet;
import java.util.Set;

public class DistinctPowers {
	public static void main(String[] args) {
		Set<Double> powers = new HashSet<Double>();
		for (int i = 2;i <= 100;i++) {
			for (int j = 2;j <= 100;j++) {
				double pow = Math.pow(i, j);
				powers.add(pow);
			}
		}
		System.out.println(powers.size());
	}
}

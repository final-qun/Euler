package com.quicksand.problem;
/**
 * problem 18
 * 求数字三角形和最大的路径的数
 * @author quicksand
 *
 */
public class MaximumPathSumI {
	public static int[][] num = { { 75 }, { 95, 64 }, { 17, 47, 82 }, { 18, 35, 87, 10 }, { 20, 04, 82, 47, 65 },
			{ 19, 01, 23, 75, 03, 34 }, { 88, 02, 77, 73, 07, 63, 67 }, { 99, 65, 04, 28, 06, 16, 70, 92 },
			{ 41, 41, 26, 56, 83, 40, 80, 70, 33 }, { 41, 48, 72, 33, 47, 32, 37, 16, 94, 29 },
			{ 53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14 }, { 70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57 },
			{ 91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48 },
			{ 63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31 },
			{ 04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 04, 23 } };
	public static int tempNum = 0;

	public static void main(String[] args) {
		System.out.println("------------------");
		for (int i = 0; i < num.length - 1; i++) {
			System.out.println(i + "-------");
			for (int j = 0; j <= i; j++) {
				System.out.println(j + "-");
				int temp1 = num[i][j] + num[i + 1][j];

				if (temp1 > num[i + 1][j]) {
					if (tempNum != 0 && tempNum > temp1) {
						num[i + 1][j] = tempNum;
					} else {
						num[i + 1][j] = temp1;
					}
				}
				int temp2 = num[i][j] + num[i + 1][j + 1];
				if (temp2 > num[i + 1][j + 1]) {
					if (j == i) {
						num[i + 1][j + 1] = temp2;
					} else {
						tempNum = temp2;
					}
				}
			}
			tempNum = 0;
		}
		int index = num.length - 1;
		int tempMax = num[index][0];
		for (int i = 0; i < num[index].length; i++) {
			if (tempMax < num[index][i]) {
				tempMax = num[index][i];
			}

		}
		System.out.println(tempMax);
	}
}

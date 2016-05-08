package com.quicksand.problem;
/**
 * problem 15
 * 求lattice路径20x20有多少条路径
 * @author quicksand
 *
 */
public class LatticePath {
	//0,0 - 2,2
	public static int count = 0;
	public static int cloumn = 2;
	public static long[][] num = new long[21][21];
	public static void main(String[] args) {
		int k = 2;
		for(int i = 0;i <= 20;i++){
			num[i][0] = 1;
			num[0][i] = 1;
		}
		System.out.println(lattice(20,20));
	}
	
	public static long lattice(int x,int y){
		if(num[x][y] == 0){
			num[x][y] = lattice(x-1,y) + lattice(x,y-1);
		}
		return num[x][y];
	}
}

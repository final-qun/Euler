package com.quicksand.problem;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class FifthPower {
	public static int[] nums = new int[10];
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			nums[i] = getFifthOfPowerNum(i);
			//System.out.println(nums[i]+":"+i);
		}
		int count = 0;
		//isFifthPower(54748);
		for(int i = 2;i<999999;i++){
			if(isFifthPower(i)){
				count += i;
				System.out.println(i+":::fifth");
			}
		}
		System.out.println(count);
	}
	public static int getFifthOfPowerNum(int num){
		return (int) Math.pow(num, 5);
	}
	public static boolean isFifthPower(int num){
		int temp = num;
		//System.out.println(temp);
		int count = 0;
		while(temp != 0){
			//System.out.println(temp+"::"+count);
			int ge = temp % 10;
			temp = temp / 10;
			count += nums[ge];
			//System.out.println(temp+"::"+count+"::"+nums[ge]);
		}
		if(num == count)
			return true;
		return false;
	}
}

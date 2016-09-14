package com.quicksand.problem;
/**
 * problem 19
 * 求1991年1月1日到2000年12月1日有多少个星期天落在当月的第一天
 * @author quicksand
 *
 */
public class CountingSundays {
	public static int calculateDayOfYear(int year,int month,int day){
		int distanceYear = year - 1900;
		int distanceDay = day -1;
		
		int calculateLeapYear = (distanceYear-1) / 4;
		int hasGoneDayInThisYear = distanceDay;
		switch(month){
		case 12:
			hasGoneDayInThisYear += 30;
		case 11:
			hasGoneDayInThisYear += 31;
		case 10:
			hasGoneDayInThisYear += 30;
		case 9:
			hasGoneDayInThisYear += 31;
		case 8:
			hasGoneDayInThisYear += 31;
		case 7:
			hasGoneDayInThisYear += 30;
		case 6:
			hasGoneDayInThisYear += 31;
		case 5:
			hasGoneDayInThisYear += 30;
		case 4:
			hasGoneDayInThisYear += 31;
		case 3:
			if((year % 400 == 0) ||((year % 4 == 0) &&(year % 100 != 0))){
				hasGoneDayInThisYear += 29;
			}else{
				hasGoneDayInThisYear += 28;
			}
		case 2:
			hasGoneDayInThisYear += 31;
		case 1:
			break;
		}
		return hasGoneDayInThisYear + (distanceYear - calculateLeapYear)*365 + calculateLeapYear * 366;
	}
	public static int getDayOfWeek(int year,int month,int day,int currentWeekOfDay){
		int distanceDay = calculateDayOfYear(year,month,day);
		int dayOfWeek = distanceDay % 7 + currentWeekOfDay;
		return dayOfWeek <= 7 ? dayOfWeek : (dayOfWeek % 7 + 1);
	}
	public static int getDayOfWeek(int year,int mount,int day){
		return getDayOfWeek(year,mount,day,1);
	}
	public static int getFirstDayOfWeek(int year){	
		return getDayOfWeek(year, 1, 1);
	}
	public static void main(String[] args) {
		int countSunday = 0;
		for(int i = 1901;i<2001;i++){
			for(int j= 1;j<=12;j++){
				int firstDayOfWeek = getDayOfWeek(i,j,1);
				if(firstDayOfWeek == 7){
					countSunday++;
				}
			}
		}
		System.out.println(countSunday);
	}	
}

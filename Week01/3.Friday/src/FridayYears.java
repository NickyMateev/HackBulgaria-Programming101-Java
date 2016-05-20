import java.util.GregorianCalendar;

public class FridayYears {

	public static int friday_years(int start, int end){
		
		int count = 0;
		GregorianCalendar calendar = new GregorianCalendar();
		for (; start <= end; start++) {
			
			calendar.set(start, GregorianCalendar.JANUARY, 01);
			if((calendar.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.FRIDAY) || (calendar.isLeapYear(start) && calendar.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.THURSDAY))
				count++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {

		System.out.println(friday_years(1000, 2000)); // 178
		System.out.println(friday_years(1753, 2000)); // 44
		System.out.println(friday_years(1990, 2015)); // 4
		
	}
}

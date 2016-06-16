package TheTimeLord;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

	private Date userDate;
	
	public Time(Date date){
		this.userDate = date;
	}

	@Override
	public String toString() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss dd.MM.YY");
		return sdf.format(userDate);
	}
	
	public static Time Now(){
		return new Time(new Date());
	}
	
	public static void main(String[] args) {
	
		System.out.println(Time.Now());
	}

}

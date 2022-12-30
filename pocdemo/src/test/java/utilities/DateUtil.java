package utilities;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;





public class DateUtil {
	public static String formatDateTime;
	
	
	public static String Datetime()
	{
		try
		{
		LocalDateTime now = LocalDateTime.now();  
	       DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy-hhmmss");  
	      return formatDateTime = now.format(format);  
		}
		catch(Exception e)
		{
			return "";
		}
	        
	}
	
	
	
	

}

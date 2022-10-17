package ocp.chapter5.date;

import java.text.MessageFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		System.out.println(ZonedDateTime.now());
		
		LocalDate date = LocalDate.of(2015, Month.MAY, 02);
		LocalTime time = LocalTime.of(11, 55, 00);
		ZoneId zone = ZoneId.of("US/Eastern");
		
		ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zone);
		Instant instant = zonedDateTime.toInstant();
		System.out.println(instant);
		System.out.println(zonedDateTime);		
		
		//LOCALE
		Locale localeDefault = Locale.getDefault();
		System.out.println(localeDefault);
		
		//FILE RESOURCEBOUNDLE
		Locale localeEngland = Locale.ENGLISH;
		ResourceBundle rb = ResourceBundle.getBundle("Zoo",localeEngland);
		System.out.println(rb.getString("saluto"));
		Set<String> chiavi = rb.keySet();
		chiavi.stream()
			.map(k -> k + " " + rb.getString(k))
			.forEach(System.out::println);
		
		//JAVA RESOURCE BUNDLE
		ResourceBundle rb2 = ResourceBundle.getBundle("ocp.chapter5.date.Zoo2",Locale.ENGLISH);
		System.out.println(rb2.getString("saluto"));
		String format = rb2.getString("saluto");
		System.out.println(MessageFormat.format(format, "Marco"));
		System.out.println(rb2.getObject("oggetto")); //qui gli ho passato un oggetto!!

	}

}

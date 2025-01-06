<<<<<<< HEAD
package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(5000);
		return randomNumber;
	}

	public String getSystemDateInSpecifiedFormat(String format) {
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String date = sdf.format(dateObj);
		return date;
	}
	
	public String getRequiredDateInSpecifiedFormat(String format, int days) {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Calendar calendar = dateFormat.getCalendar();
		calendar.setTime(currentDate);

		// Increase the date by the specified number of days
		calendar.add(Calendar.DAY_OF_MONTH, days);

		String requiredDate = dateFormat.format(calendar.getTime());
		return requiredDate;
	}
}
=======
package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(5000);
		return randomNumber;
	}

	public String getSystemDateInSpecifiedFormat(String format) {
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String date = sdf.format(dateObj);
		return date;
	}
	
	public String getRequiredDateInSpecifiedFormat(String format, int days) {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Calendar calendar = dateFormat.getCalendar();
		calendar.setTime(currentDate);

		// Increase the date by the specified number of days
		calendar.add(Calendar.DAY_OF_MONTH, days);

		String requiredDate = dateFormat.format(calendar.getTime());
		return requiredDate;
	}
}
>>>>>>> branch 'master' of https://github.com/Basavaraj-A-Patil/ComcastFrameworkRepository

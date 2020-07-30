package com.employee.util;

import java.sql.Timestamp;
import java.util.Calendar;

public class CommonUtil {
	public static Timestamp getCurrentDateTime() {
        Calendar calendar = Calendar.getInstance();
        return new Timestamp(calendar.getTimeInMillis());
    }
}

package br.ufrn.dimap.pubshare.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormat {
	
	public static String format( Date format ){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
		return sdf.format(format);
	}

}

package br.com.cadastro.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	public static String Date2String(Date data) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(data);
	}
}

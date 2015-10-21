package com.globalroam.iaas.hoverv.coverters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date>{
	private static final Logger logger = Logger.getLogger(StringToDateConverter.class);

	@Override
	public Date convert(String src) {
		Date date = null;
		
		try {
			logger.info("Formate as: yyyy-MM-dd HH:mm:ss.");
			date = parseDateWithException(src,"yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			logger.warn("Try parse date with another formate: yyyy-MM-dd.");
			
			try {
				date = parseDateWithException(src,"yyyy-MM-dd");
			} catch (ParseException e1) {
				e1.printStackTrace();
				logger.error("Wrong date formate : " + e1.getMessage(), e1);
			}
		}
		
		return date;
	}


	private Date parseDateWithException(String time,String formate) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(formate);
		Date date = null;
		date = format.parse(time);
		return date;
	}

}
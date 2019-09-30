package com.smood.parentcontext.beans;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;


@Component
public class ParentBean
{
	private static final Logger LOGGER = Logger.getLogger(ParentBean.class.getName());



	@PostConstruct
	public void logStartup()
	{
		if (LOGGER.isLoggable(Level.INFO)) {
			LOGGER.info(String.format("%n%nKlar med uppstart: %s%nhashCode: %s%n%n",
					LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
					hashCode()));
		}
	}



	public String getName()
	{
		return String.format("ParentBean - hashCode: %s, date/time: %s",
				hashCode(),
				LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
	}
}

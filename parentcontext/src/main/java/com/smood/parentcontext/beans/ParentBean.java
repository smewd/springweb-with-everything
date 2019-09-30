package com.smood.parentcontext.beans;



import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;



@Component
public class ParentBean
{
	public static final String PARENT_CONTEXT_ID = "ear.context";
	private static final Logger LOGGER = Logger.getLogger(ParentBean.class.getName());

	private final int randomValue;



	public ParentBean()
	{
		this.randomValue = new Random(System.currentTimeMillis()).nextInt();
	}



	@PostConstruct
	public void logStartup()
	{
		Level level = LOGGER.getLevel();
		LOGGER.setLevel(Level.ALL);
		if (LOGGER.isLoggable(Level.INFO))
		{
			LOGGER.info(String.format("%n%n%nKlar med uppstart: %s%nhashCode: %s%n%n",
					LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
					hashCode()));
		}
		LOGGER.setLevel(level);
	}



	public Map<String, Object> getValues()
	{
		Map<String, Object> result = new HashMap<>();
		result.put("hashCode", hashCode());
		result.put("randomValue", randomValue);
		return result;
	}
}

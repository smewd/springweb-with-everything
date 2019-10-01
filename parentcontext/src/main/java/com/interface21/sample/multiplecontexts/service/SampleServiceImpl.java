package com.interface21.sample.multiplecontexts.service;



import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class SampleServiceImpl implements SampleService
{
	public SampleServiceImpl()
	{
		System.out.println(String.format("%n%n%n%s: Uppstart av %s klar.%n%n%n",
				LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
				getClass().getName()));
	}



	public String sayHello(String from)
	{
		return "Hello from " + from;
	}
}

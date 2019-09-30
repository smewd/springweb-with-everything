package com.smood.parentcontext.config;



import com.smood.parentcontext.controllers.PackageMarker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = PackageMarker.class)
public class MvcConfig extends WebMvcConfigurerAdapter
{
}

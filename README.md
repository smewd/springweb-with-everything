# Spring Web with "everything"

## What is it?
A Spring Web project with several included technologies; in fact, as many as possible.

## Why is it?
This is a project used as proof of concept, mainly for work. The idead is to 
integrate Spring Java config with technologies that are used in production. 
This is a faster way to experiment with transitions from technology A to 
technology B, instead of implementing them into the tech stack right at the 
start. A reference of sorts.

## What does it include?
* Spring Boot 2.3.3
* Spring WebMVC
    * A controller with a requestmapping
    * Thymeleaf for view handling
    * An interceptor for logging
* A servlet
* A couple of custom web filters
    * A filter that logs for every request
    * A "decorating" filter applied for URLs matching *.do and *.action
* TBD: Stripes 
    * Servlet
    * Filter
    * An ActionBean with corresponding JSP file
* TBD: Struts
    * Servlet
    * An Action with corresponding ActionForm and JSP file
* A service bean in another Maven module for wiring into the web project
* Maven as build tool
* A Dockerfile with Tomcat for easy, portable testing

## What does it not include?
Lots of things, naturally. Obviously the name "everything" is a *slight* exaggeration. 
And some things will never make it into the project. For instance, no unit tests or 
integration tests are included. Having integration tests with some kind of mock 
service would be nice in the future, but may very well be an entire project in its 
own right.

## How to use it
Clone it/fork it. Experiment. Add new things to it. If something could be interesting 
to add, feel free to make a pull request.

## How to try it out
Run the following commands with the supplied Docker definition:
```shell script
$ docker build -t <tagname> .
$ docker run -it --rm -p 8080:8080 <tagname>
```

Then access any of these URLs:
* http://localhost:8080/webmvc/helloworld
    * JSON output
    * Access to this request mapping is logged with LoggingFilter
* http://localhost:8080/webmvc/thymeleaf
    * Regular HTML output
    * Access to this Thymeleaf view is logged with LoggingFilter
* http://localhost:8080/servlet/dummy
    * Regular HTML output
    * Access to this view is logged with LoggingFilter
* TBD: http://localhost:8080/struts/dummy.do
    * Access to this view is logged with LoggingFilter
    * Contents of this view are rewritten with DecoratingFilter 
* TBD: http://localhost:8080/stripes/dummy.action
    * Access to this view is logged with LoggingFilter
    * Contents of this view are rewritten with DecoratingFilter 

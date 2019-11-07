# Spring Web with "everything"

## What is it?
A Spring Web project with several included technologies; in fact, as many as possible.

## Why is it?
This is a project used as proof of concept, mainly for work. The idead is to 
integrate Spring Java config with technologies that are used in production. 
This is a faster way to experiment with transitions from technology A to 
technology B, instead of implementing them into the tech stack right at the 
start.

## What does it include?
* Spring Web
* A Spring WebMVC Controller
* A servlet
* A couple of custom web filters
* Stripes 
    * Servlet
    * Filter
    * An action bean with corresponding JSP file
* A Dockerfile with Tomcat

## What does it not include?
Lots of things, naturally. Obviously the name "everything" is a slight exaggeration. 
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
* http://localhost:8080/servlet/dummy
* http://localhost:8080/struts/dummy.do
* http://localhost:8080/stripes/dummy.action
* http://localhost:8080/webmvc/dummy
# SPRING NOTES
-------------------------------------------------
### *Spring (framework) focuses on creating enterprise applications with Java.  It utilizes lots of boilerplate (text/code that can be reused in many contexts) to reduce redundancy and entensive code for applications.* 
### *A spring boot application is built on top of the Spring framework. It is autoconfigured, and implements custom configurations using @Annotations.*

## What is a Spring Bean?
- A Spring Bean is an object (*instance of a class*) whose life cycle is created, configured, and managed by the Spring IoC container. They are instatiated upon start of application, and destroyed upon shutting it down.
- Beans are configured using annotations and XML configuration.
- Can be singletons(*one instance per application*) or prototypes(*new instance with each request*).
## What is Dependency Injection?
- Dependency Injection is a design pattern instantiates specific objects used by other objects (*achieves coupling*) for your applications.
## What is the IOC container?
- An Inversion of Control (IoC) container is responsible for managing all beans and performs the dependency injection(s).
## What is the Application context?
- Application context is a version of the IoC container that provides additional features for managing beans in Spring Application.
- Provides advanced features like bean validation and event handling.
## What does @SpringBootApplication do?
- This annotation is used to create, configure and run the Spring Boot Application, using Beans configured.
- @SpringBootApplication signifies the main entry point for the application and is done in the class using the main() method.
- It combines 3 annotations: @ComponentScan, @SpringBootConfiguration, & @EnableAutoConfiguration
## What is the Dispatch Servlet?
- The DispatchServlet is responsible for handling HTTP requests and dispatching them to their appropriate controllers.
- It is essentially the front controller in Spring MVC.
- It is automatically configured in Spring Boot.
## What is a Logger?
- A logger is an object that uses a system  to log specific messages and details in an application to communication information such as errors, events, activities, warnings, etc.
- Used for monitoring, debugging, and troubleshooting purposes.
------------------------------------------------------------------------------------------------
# Spring Boot Exception Handling
### *Using Spring Boot server properties in Spring Appliation, we can alter error response by adding exception messages, exception classes, or stack traces as part of the response payload.*

## @ResponseStatus
- Allows us to modify to HTTP status of our response.
- In combination with server.error configuration properties, allows us to manipulate almost all the fields in our Spring-defined error response payload.
- Can be applied to the following:
  - On exception class itself.
  - Along with @ExceptionHandler on methods.
  - Along with @ControllerAdvice on classes.
 
## @ExceptionHandler
- To begin, create a method either in a controller itself or in @ControllerAdvice class.
- Apply @ExceptionHandler annotation to method. Use exception or list of exceptions:
  - Option 1: For argument on annotation itself [@ExceptionHandler(ThisException.class)]
  - Option 2: Defined in parameters of method:
    [@ExceptionHandler
    publice ResponseEntity<?> handleThisException(ThisException exception)
    You can also have HttpServletRequest, WebRequest, or HttpSession types in parameters.

## @ControllerAdvice
- Allow us to apply exception handlers to multiple or all controllers in application.
- It is best to have only one @ControllerAdvice class per application.
- Apply to class & use above 2 annotations on methods in class.
- @ControllerAdvice(annotations = Advised.class): only controllers marked with the @Advised annotation will be handled by the @ControllerAdvice.







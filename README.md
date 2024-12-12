#Spring Notes
-------------------------------------------------
### *Spring (framework) focuses on creating enterprise applications with Java.  It utilizes lots of boilerplate (text/code that can be reused in many contexts) to reduce redundancy and entensive code for applications.* 
### *A spring boot application is built on top of the Spring framework. It is autoconfigured, and implements custom configurations using @Annotations.*

## What is a spring bean?
- A Spring Bean is an object (*instance of a class*) whose life cycle is created, configured, and managed by the Spring IoC container. They are instatiated upon start of application, and destroyed upon shutting it down.
- Beans are configured using annotations and XML configuration.
- Can be singletons(*one instance per application*) or prototypes(*new instance with each request*).
## What is Dependency injection?
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

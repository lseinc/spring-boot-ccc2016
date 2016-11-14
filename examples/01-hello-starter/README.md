## Spring Boot Examples

#01-hello-starter

- <http://start.spring.io>
- Select the following dependencies
 - Web
 - JPA
 - Actuator
 - JMS (Artimus)
 - Apache Derby
- Download ZIP into 01-hello-starter directory
- unzip demo zip file
- cd demo
- mvn clean install
- fix any errors with setup
- BUILD SUCCESS !!!

--
 
- Add a simple Web Service
- Edit src/main/java/com/example/DemoApplication.java
- Add @RestController to class
- Add hello method    
    @RequestMapping(path="/hello")    
    public String hello() {    
          return "Hello World";    
    }    

--

- use IDE to run DemoApplication 
  (or mvn spring-boot:run)
- Observe console
- mappings, initialization
- port (8080)
- actuator
- open http://localhost:8080/hello

--
### Actuator Links

- http://localhost:8080/mappings  
- http://localhost:8080/env
- http://localhost:8080/configprops 
- http://localhost:8080/beans
- http://localhost:8080/autoconfig
- http://localhost:8080/dump
- http://localhost:8080/trace  
- http://localhost:8080/health  
- http://localhost:8080/heapdump  
- http://localhost:8080/metrics
- http://localhost:8080/info

- stop / kill application (or ctl-c)

--
- Adding More Information
 - edit src/main/resources/application.properties
 - add the following:  
  info.service.name=hello-world  
  info.service.version=1.0  
  server.port=8080   
  copy banner.txt from 01-hello-starter directory to src/main/resources

- Run DemoApplication (or mvn spring-boot:run)
-  Observe new banner text in console
         http://localhost:8080/info
- stop application (or ctl-c)

--

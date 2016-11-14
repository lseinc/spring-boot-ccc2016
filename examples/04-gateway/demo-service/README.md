Once everything is running under the peer cloud-services directory (demo-eureka, demo-hystrix, demo-zuul), do the same thing here.

mvn clean install
mvn spring-boot:run

observe console started

open http://localhost:8080/demoeureka

open http://localhost:8080/demoservice/api/hello

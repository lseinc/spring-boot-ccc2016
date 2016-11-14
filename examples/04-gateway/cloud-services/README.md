Spring Cloud consists of different tools to make cloud usage easier.
Netflix OSS provides some very useful tools to help with API gateway requests, load-balancing, and failover.

The directories under this one provides stand alone boot servers that will help in registering "microservices"
with the Zuul API Gateway.  The services will be visable via Eureka so if one or more are visible, then balancing and failover can be achieved.
We need to run demo-eureka, demo-zuul, and demo-hystrix at the same time.
Once can do this by opening three separate terminals and doing a mvn spring-boot:run in each directory appropirately.

Here is an example of what to do on a Bash command line shell:

cd demo-eureka
nohup mvn spring-boot:run &
cd demo-hystrix
nohup mvn spring-boot:run &
cd demo-zuul
nohup mvn spring-boot:run &

#
# Eureka ready for work on http://localhost:8181
# Hystrix ready for work on http://localhost:8282
# Zuul ready for work on http://localhost:8080
#

# to kill the servers run
ps auxww|grep "spring-boot:run" |grep -v grep| while read line ; do kill -9 `echo $line|awk '{print $2}'`  ; done

#
# Windows users can run each service by using their IDE and running the appropriate DemoXXXServer in each sub directory.
#



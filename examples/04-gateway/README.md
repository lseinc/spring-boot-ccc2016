First switch to cloud-service directory and follow the README.md file contents.
Once the servers are running, you can start the demo-service under the demo-service directory.

The demo service will start a rest service that will register with zuul and be visable directly and via the 
API Gateway by its spring application name.

To hit the service directly use http://localhost:9191/api/hello
To hit the service via API Gateway use http://localhost:8080/zuul/demoservice/api/hello



# fallback-Tracing
We cannot add a custom Zipkin server i.e. cannot inject zipkin into another spring boot project. So need to run it separately (default port 9411)

### Start Zipkin
curl -sSL https://zipkin.io/quickstart.sh | bash -s
<br/>java -jar zipkin.jar

### Run this project 
./gradlew bootRun

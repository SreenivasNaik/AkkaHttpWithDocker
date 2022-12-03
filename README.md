# AkkaHttpWithDocker
Step:1 Add plugins.sbt under project folder 
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.6")

Step2: Add these lines in build.sbt 

enablePlugins(JavaAppPackaging,AshScriptPlugin)
packageName in Docker := "dockerised-akka-http-sreenu"
dockerBaseImage := "openjdk:8-jre-alpine"

Step 3: Run sbt docker:publishLocal 
it will generate the image in local docker 

Step 4: run the image 
docker run -it -p 8090:9090 dockerised-akka-http-sreenu:0.1

Now Access the api's through docker port [ 8090] 
curl --location --request GET 'http://localhost:8090/v1/taskdetails/d7cac46e-b163-4d5f-9f03-87eba64e71c0'

Make sure you are lisiting to the host 0.0.0.0 


Reference Links 
https://www.freecodecamp.org/news/how-to-dockerise-a-scala-and-akka-http-application-the-easy-way-23310fc880fa/
https://sbt-native-packager.readthedocs.io/en/stable/formats/docker.html#busybox-ash-support
https://bobcares.com/blog/error-socket-hang-up-docker/
https://www.reddit.com/r/docker/comments/oa84r8/comment/h3fuj94/

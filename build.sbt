//import com.typesafe.sbt.packager.docker._
//
//dockerCommands ++= Seq(  Cmd("USER", "root"),
//  ExecCmd("RUN", "apk", "add", "--no-cache", "bash"))

enablePlugins(JavaAppPackaging,AshScriptPlugin)

name := "AkkaHttpWithDocker"

version := "0.1"

scalaVersion := "2.12.8"

val akkaVersion = "2.5.20"
val akkaHttpVersion = "10.1.7"
val scalaTestVersion = "3.0.5"

packageName in Docker := "dockerised-akka-http-sreenu"

dockerBaseImage := "openjdk:8-jre-alpine"

//dockerExposedPorts := Seq(9090)


val akka25Version       = "2.5.32"
val akkaStream                = "com.typesafe.akka"             %% "akka-stream"                       % akka25Version
val akkaStreamTestKit         = "com.typesafe.akka"             %% "akka-stream-testkit"               % akka25Version
val akka25TestKit             = "com.typesafe.akka"             %% "akka-testkit"                      % akka25Version
val akkaHttp                  = "com.typesafe.akka"             %% "akka-http"                         % akkaHttpVersion
val akkaHttpJson              = "com.typesafe.akka"             %% "akka-http-spray-json"              % akkaHttpVersion
val akkaHttpTestKit           = "com.typesafe.akka"             %% "akka-http-testkit"                 % akkaHttpVersion
libraryDependencies ++= Seq(
  akkaStream,
  akkaStreamTestKit,
  akka25TestKit,
  akkaHttp,
  akkaHttpJson,
  akkaHttpTestKit,
  "org.scalactic" %% "scalactic" % "3.2.10",
  "org.scalatest" %% "scalatest" % "3.2.10",
  // JWT
  "com.pauldijou" %% "jwt-spray-json" % "2.1.0"
)
resolvers += "Artima Maven Repository" at "https://repo.artima.com/releases"

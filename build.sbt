lazy val akkaHttpVersion = "10.0.9"
lazy val akkaVersion    = "2.5.3"
lazy val akkaKafkaVersion = "0.16"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization    := "sync3k",
      scalaVersion    := "2.12.2"
    )),
    name := "sync3k-server",
    version := "0.0.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http"         % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-xml"     % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-stream"       % akkaVersion,
      "com.typesafe.akka" %% "akka-stream-kafka" % akkaKafkaVersion,
      "com.github.scopt"  %% "scopt"             % "3.6.0",
      "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test,
      "org.scalatest"     %% "scalatest"         % "3.0.1"         % Test,
      "net.manub"         %% "scalatest-embedded-kafka" % "0.15.0" % Test exclude("log4j", "log4j"),
      "org.slf4j" % "slf4j-simple" % "1.7.21" % Test,
      "org.slf4j" % "log4j-over-slf4j" % "1.7.21" % Test
    ),
    parallelExecution in Test := false,
    logBuffered in Test := false,
    fork in Test := true
  )

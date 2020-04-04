name := "light_tomatoes"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "org.json4s" %% "json4s-jackson" % "3.7.0-M2",
  "org.apache.httpcomponents" % "httpclient" % "4.5.12",
  "junit" % "junit" % "4.13" % "test->default"
)

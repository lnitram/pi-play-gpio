name := """pi-play-gpio"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs
)

libraryDependencies += "org.webjars" % "bootstrap" % "3.0.0"

libraryDependencies += "com.pi4j" % "pi4j-core" % "0.0.5"



name := """CatShelter"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .dependsOn(imgur)

lazy val imgur = RootProject(uri("git://github.com/Cowa/Imgur-Scala.git#master"))

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)

fork in run := true

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "scala-oop"
  )
libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.14"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.14" % "test"
libraryDependencies += "com.softwaremill.quicklens" %% "quicklens" % "1.9.0"
libraryDependencies += "org.typelevel" %% "cats-core" % "2.8.0"

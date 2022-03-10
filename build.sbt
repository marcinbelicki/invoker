
name := "invoker"

version := "0.1"


lazy val akkaVersion = "2.6.15"
val scalaV = "2.12.2"
val scalaCheckV = "1.13.5"
val scalaTestV = "3.0.0"
val mockitoV = "1.10.19"
lazy val invoker = project
  .in(file("."))
  .settings(
    scalaVersion := scalaV,
    name := "invoker",
    organization := "pl.klawoj",
    libraryDependencies ++= {
      Seq(
        "org.scalacheck" %% "scalacheck" % scalaCheckV % Test,
        "org.scalatest" %% "scalatest" % scalaTestV % Test,
        "org.mockito" % "mockito-core" % mockitoV % Test,
        "com.typesafe.akka" %% "akka-stream" % akkaVersion,
        "org.scala-lang" % "scala-reflect" % scalaV
      )
    })
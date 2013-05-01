organization := "fmpwizard"

name         := "Lift Named Comet"

organization := "com.fmpwizard"

version      := "0.3"

crossScalaVersions := Seq("2.10.1", "2.9.2", "2.9.1-1", "2.9.1")

scalaVersion <<= crossScalaVersions(_.head)

scalacOptions <<= scalaVersion map { sV => Seq(
    "-unchecked", "-deprecation", "-encoding", "UTF-8",
    "-optimise", "-Xcheckinit", "-Yclosure-elim", "-Ydead-code",
    "-Yinline", "-Yrepl-sync", "-Xlint", "-Xverify", "-Ywarn-all"
  ) ++ (if (sV startsWith "2.1") Seq(
    "-feature", "-language:postfixOps"
  ) else Nil)
}

libraryDependencies := Seq(
  "net.liftweb" %% "lift-webkit" % "2.5-RC5" % "provided"
)

publishMavenStyle := true

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim endsWith "SNAPSHOT")
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomIncludeRepository := { _ => false }

licenses := Seq("Apache License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))

homepage := Some(url("https://github.com/fmpwizard/LiftNamedComet"))

pomExtra :=
  <scm>
    <url>git@github.com:fmpwizard/LiftNamedComet.git</url>
    <connection>scm:git:git@github.com:fmpwizard/LiftNamedComet.git</connection>
  </scm>
  <developers>
    <developer>
      <id>fmpwizard</id>
      <name>Diego Medina</name>
      <url>http://www.fmpwizard.com</url>
    </developer>
  </developers>

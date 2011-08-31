import sbt._

class Project(info: ProjectInfo) extends DefaultProject(info) {
  val liftVersion = "2.4-M3"
  
  lazy val JavaNet = "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"
  val scalaToolsSnapshots = "Scala-Tools Maven2 Snapshots Repository" at "http://scala-tools.org/repo-snapshots" 

  override def compileOptions = super.compileOptions ++ Seq(Unchecked)
  override def testClasspath  = super.testClasspath +++ ("src" / "main" / "webapp")

  override def libraryDependencies = Set(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile",
    "ch.qos.logback" % "logback-classic" % "0.9.26" % "compile->default",
    "org.slf4j" % "jcl-over-slf4j" % "1.6.1" % "compile->default"
  ) ++ super.libraryDependencies


}

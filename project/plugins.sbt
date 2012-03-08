// +-------------------------------------------------------------------------------------+
// | SBT Eclipse (https://github.com/typesafehub/sbteclipse)                             |
// | Creates .project and .classpath files for easy Eclipse project imports              |
// |                                                                                     |
// | See also: Eclipse downloads (http://www.eclipse.org/downloads/)                     |
// | See also: Scala IDE downloads (http://download.scala-ide.org/)                      |
// +-------------------------------------------------------------------------------------+

resolvers += Classpaths.typesafeResolver

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.0.0-RC1")

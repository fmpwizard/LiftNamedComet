This project is a library that aims at making the use of
named comet actors in Lift a little easier.

Usage:
=====

On your lift project you can add the dependency as:

    resolvers ++= Seq("snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
                    "releases"  at "http://oss.sonatype.org/content/repositories/releases")

    libraryDependencies ++= Seq("com.fmpwizard" %% "lift-named-comet" % "0.3")

For a sample project using this library visit:
[Lift Auction](https://github.com/fmpwizard/lift_auction)

Documentation:
=============

You can read this blog post to which describes how to use it::
[fmpwizard's blog](http://blog.fmpwizard.com/lift-comet-actor-per-tab-library)

Features:
=========

* You can have a CometActor of the same class, but different instances of it on different tabs.
* Only the CometActor that is going to update the Ui is going to get a message.
* You can send messages to a CometActor from other sessions (including stateless RESTful end points.
* When a CometActor has not been present on a page after a defined lifespan, it is removed from the central registry.
* Hides the whole implementation so the user can focus on the CometActor functionality. 


Enjoy

  Diego

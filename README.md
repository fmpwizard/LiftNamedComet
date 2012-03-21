This project is a library that aims at making the use of
named comet actors in Lift a little easier.

You will need to clone this project and using the included sbt 0.11.2 you will do:

    ./sbt +update +publish-local

That command will compile the library and publish it to
your local computer.

Then on your lift project you can add the dependency as:

    "fmpwizard" %% "lift-named-comet" % "0.2-SNAPSHOT"

For a sample project using this library visit:
[Lift Auction](https://github.com/fmpwizard/lift_auction)

Blog post describing how to use it is at:
[fmpwizard's blog](http://blog.fmpwizard.com/lift-comet-actor-per-tab-library)


Enjoy

  Diego

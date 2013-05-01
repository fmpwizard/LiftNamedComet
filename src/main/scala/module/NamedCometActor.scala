package com.fmpwizard.cometactor.pertab
package namedactor

import net.liftweb._
import common.{Full,Logger}
import http.CometActor
import util.Helpers._



trait NamedCometActor extends CometActor with Logger{

  /**
   * First thing we do is registering this comet actor
   * for the "name" key
   */
  override  def localSetup = {
    CometListerner.listenerFor(name) ! registerCometActor(this, name)
    super.localSetup()
  }

  /**
   * We remove the comet from the map of registers actors
   */
  override  def localShutdown = {
    CometListerner.listenerFor(name) ! unregisterCometActor(this)
    super.localShutdown()
  }

  // time out the comet actor if it hasn't been on a page for 2 minutes
  override def lifespan = Full(120 seconds)

}

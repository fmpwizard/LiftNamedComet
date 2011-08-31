package com.fmpwizard.cometactor.pertab
package namedactor

import net.liftweb.common.Logger
import net.liftweb.http.CometActor
import net.liftweb.common.Full

/**
 * Created by IntelliJ IDEA.
 * User: Diego Medina
 * Date: 7/26/11
 * Time: 2:27 PM
 */


trait NamedCometActor extends CometActor with Logger{

  /**
   * First thing we do is registering this comet actor
   * for the "name" key
   */
  override  def localSetup = {
    CometListerner.listenerFor(name) ! registerCometActor(this, name)
    info("====>>>>>>>>>> %s".format(name))
    super.localSetup()
  }

	/**
	 * We remove the comet from the map of registers actors
	 */
  override  def localShutdown = {
    CometListerner.listenerFor(name) ! unregisterCometActor(this)
    super.localShutdown()
  }
}
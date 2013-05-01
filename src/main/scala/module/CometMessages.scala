package com.fmpwizard.cometactor.pertab
package namedactor

import net.liftweb.http.CometActor
import net.liftweb.common.Box

/**
 * These are the message we pass around to
 * register each named comet actor with a dispatcher that
 * only updates the specific version it monitors
 */
case class registerCometActor(actor: CometActor, name: Box[String])
case class unregisterCometActor(actor: CometActor)
case class CometName(name: String)

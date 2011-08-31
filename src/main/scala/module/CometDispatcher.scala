package com.fmpwizard.cometactor.pertab
package namedactor

import net.liftweb.actor.LiftActor
import net.liftweb.http.CometActor
import net.liftweb.common.{Full, Box, Logger}

/**
 * Created by IntelliJ IDEA.
 * User: Diego Medina
 * Date: 7/25/11
 * Time: 4:33 AM
 */



/**
 * This class keeps a list of comet actors that need to update the UI
 * if we get new data through the rest api
 */
class CometDispatcher(version: Box[String]) extends LiftActor  with Logger{

  info("DispatcherActor got version: %s".format(version))
  private var cometActorsToUpdate: List[CometActor]= List()

  override def messageHandler  = {
    /**
     * if we do not have this actor in the list, add it (register it)
     */
    case registerCometActor(actor, Full(name)) => {
      if(cometActorsToUpdate.contains(actor) == false){
        info("We are adding actor: %s to the list".format(actor))
        cometActorsToUpdate= actor :: cometActorsToUpdate
      } else {
        info("The list so far is %s".format(cometActorsToUpdate))
      }
    }
    case unregisterCometActor(actor) => {
      info("before %s".format(cometActorsToUpdate))
      cometActorsToUpdate= cometActorsToUpdate.filterNot(_ == actor)
      info("after %s".format(cometActorsToUpdate))
    }

    /**
     * Go through the the list of actors and send them a cellToUpdate message
     */
    case msg => {
    	/**
    	 * BUG: We traverse the list twice, once for the log, and a second time to 
    	 * send the actual message.
    	 */
      cometActorsToUpdate.foreach( actr =>
      info("We will update this comet actor: %s showing version: %s".format(
        actr, version))
      )

      cometActorsToUpdate.foreach(_ ! msg)
    }
  }

}



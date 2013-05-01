package com.fmpwizard.cometactor.pertab
package namedactor

import net.liftweb.actor.LiftActor
import net.liftweb.http.CometActor
import net.liftweb.common.{Full, Box, Logger}


/**
 * This class keeps a list of comet actors that need to update the UI
 */
class CometDispatcher(name: Box[String]) extends LiftActor  with Logger{

  info("DispatcherActor got name: %s".format(name))
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

    //Catch the dummy message we send on comet creation
    case CometName(name) =>

    /**
     * Go through the list of actors and send them a message
     */
    case msg => {
      cometActorsToUpdate.foreach{ x => {
        x ! msg
        info("We will update this comet actor: %s showing name: %s".format(x, name))
        }
      }
    }
  }

}

package com.fmpwizard.cometactor.pertab
package namedactor

import net.liftweb.actor.LiftActor
import net.liftweb.common.{Box, Logger}

/**
 * Created by IntelliJ IDEA.
 * User: Diego Medina
 * Date: 7/25/11
 * Time: 12:01 AM
 */

/**
 * Maintain a Map[Value the actor monitors -> Ref to the Actor Dispatcher]
 *
 * For a url like: http://hostnbame/index/?p=icecream
 * If you name your actor based on the value of p
 * For each flavor that people have on their urls,
 * the map would be like:
 * chocolate -> code.comet.CometClassNames@ea5e9e7 ,
 * vanilla   -> code.comet.CometClassNames@wv9i7o3, etc
 *
 * If we have the actor already on the Map, just return it,
 * because it has to update the UI.
 * If wee do not have this actor on our Map. create a new
 * Dispatcher that will monitor this value, add it to our Map
 * and return the Ref to this new dispatcher so it updates the UI
 *
 *
 */
object CometListerner extends Logger{

  private var listeners: Map[String, LiftActor] = Map()

  def listenerFor(str: Box[String]): LiftActor = synchronized {
    val name= str.getOrElse("")
    listeners.get(name ) match {
      case Some(a) => info("Our map is %s".format(listeners));  a
      case None => {
        val ret = new CometDispatcher(str)
        listeners += name -> ret
        info("Our map is %s".format(listeners))
        ret
      }
    }
  }
}

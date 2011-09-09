package com.fmpwizard.cometactor.pertab
package namedactor

/**
 * User: Diego Medina
 * Date: 7/24/11
 * Time: 11:46 PM
 */

import scala.xml.NodeSeq
import net.liftweb.http.S
import net.liftweb.common.Full


/**
 * This trait adds a named comet actor on the page.
 * You should at least override cometClass to match the
 * class of your comet actor
 *
 * If all you want is different comet actors per tab, do not override
 * lazy val name.
 * If you want the same actor on some of the tabs, and you have a
 * specific value to group them, override lazy val name
 *
 *
 */
trait InsertNamedComet {
  /**
   * These are the two val(s) you would have to
   * override after extending this trait.
   * No need to touch the render method (I hope)
   */
  lazy val cometClass= "MyCometClass"
  lazy val name= net.liftweb.util.Helpers.nextFuncName


  final def render(xhtml: NodeSeq): NodeSeq = {
    for (sess <- S.session) sess.sendCometActorMessage(
      cometClass, Full(name), CometName(name)
    )
    <lift:comet type={cometClass} name={name}>{xhtml}</lift:comet>
  }
}
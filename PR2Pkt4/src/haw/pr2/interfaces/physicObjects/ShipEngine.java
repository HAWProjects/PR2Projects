/**
 * 
 */
package haw.pr2.interfaces.physicObjects;

import haw.pr2.interfaces.WithPower;
import haw.pr2.interfaces.WithUniqueId;
import haw.pr2.interfaces.adminValue.Mutable;

/**
 * @author Robert
 *
 */
public interface ShipEngine<E extends ShipEngine> extends Mutable, Body, WithUniqueId, WithPower, Comparable<E>
{
	
}

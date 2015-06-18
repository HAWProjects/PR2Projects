/**
 * 
 */
package haw.pr2.interfaces.physicObjects;

import haw.pr2.interfaces.WithUniqueId;
import haw.pr2.interfaces.adminValue.Immutable;

/**
 * @author Robert
 *
 */
public interface ShipHull<E extends ShipHull> extends Immutable, Body, WithUniqueId, Comparable<E>
{
	
}

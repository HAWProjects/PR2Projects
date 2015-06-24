/**
 * 
 */
package haw.pr2.interfaces.physicObjects;

import haw.pr2.interfaces.Immutable;
import haw.pr2.interfaces.marker.WithUniqueId;

/**
 * @author Robert
 *
 */
public interface ShipHull<E extends ShipHull> extends Immutable, Body, WithUniqueId
{
	
}

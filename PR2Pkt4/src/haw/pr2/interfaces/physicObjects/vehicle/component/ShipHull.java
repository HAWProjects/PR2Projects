/**
 * 
 */
package haw.pr2.interfaces.physicObjects.vehicle.component;

import haw.pr2.interfaces.Immutable;
import haw.pr2.interfaces.aspects.WithUniqueId;
import haw.pr2.interfaces.physicObjects.Body;

/**
 * @author Robert
 *
 */
public interface ShipHull<E extends ShipHull<?>> extends Immutable, Body, WithUniqueId
{
	
}

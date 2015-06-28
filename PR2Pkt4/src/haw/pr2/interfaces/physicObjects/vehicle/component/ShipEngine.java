/**
 * 
 */
package haw.pr2.interfaces.physicObjects.vehicle.component;

import haw.pr2.interfaces.Mutable;
import haw.pr2.interfaces.aspects.WithPower;
import haw.pr2.interfaces.aspects.WithUniqueId;
import haw.pr2.interfaces.physicObjects.Body;

/**
 * @author Robert
 *
 */
public interface ShipEngine<E extends ShipEngine> extends Mutable, Body, WithUniqueId, WithPower
{
	
}

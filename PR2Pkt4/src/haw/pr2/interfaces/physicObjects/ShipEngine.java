/**
 * 
 */
package haw.pr2.interfaces.physicObjects;

import haw.pr2.interfaces.adminValue.Mutable;
import haw.pr2.interfaces.marker.WithPower;
import haw.pr2.interfaces.marker.WithUniqueId;

/**
 * @author Robert
 *
 */
public interface ShipEngine<E extends ShipEngine> extends Mutable, Body, WithUniqueId, WithPower
{
	
}

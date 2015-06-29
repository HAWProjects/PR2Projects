/**
 * 
 */
package haw.pr2.interfaces.physicObjects.vehicle;

import haw.pr2.interfaces.Mutable;
import haw.pr2.interfaces.aspects.WithPosition;
import haw.pr2.interfaces.aspects.WithPower;
import haw.pr2.interfaces.aspects.WithPropulsion;
import haw.pr2.interfaces.aspects.WithUniqueId;
import haw.pr2.interfaces.physicObjects.Body;

/**
 * @author Robert
 *
 */
public interface Vehicle <E extends Vehicle<E>> extends Mutable, Body, WithUniqueId, WithPosition, WithPower, WithPropulsion
{
	
}

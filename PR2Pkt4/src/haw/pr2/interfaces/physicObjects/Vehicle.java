/**
 * 
 */
package haw.pr2.interfaces.physicObjects;

import haw.pr2.interfaces.adminValue.Mutable;
import haw.pr2.interfaces.marker.WithPosition;
import haw.pr2.interfaces.marker.WithPower;
import haw.pr2.interfaces.marker.WithPropulsion;
import haw.pr2.interfaces.marker.WithUniqueId;

/**
 * @author Robert
 *
 */
public interface Vehicle <E extends Vehicle> extends Mutable, Body, WithUniqueId, WithPosition, WithPower, WithPropulsion
{
	
}

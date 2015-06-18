/**
 * 
 */
package haw.pr2.interfaces.physicObjects;

import haw.pr2.interfaces.WithPosition;
import haw.pr2.interfaces.WithPower;
import haw.pr2.interfaces.WithPropulsion;
import haw.pr2.interfaces.WithUniqueId;
import haw.pr2.interfaces.adminValue.Mutable;

/**
 * @author Robert
 *
 */
public interface Vehicle <E extends Vehicle> extends Mutable, Body, WithUniqueId, WithPosition, WithPower, WithPropulsion, Comparable<E>
{
	
}

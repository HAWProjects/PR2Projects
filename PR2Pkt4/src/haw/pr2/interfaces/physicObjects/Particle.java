/**
 * 
 */
package haw.pr2.interfaces.physicObjects;

import haw.pr2.interfaces.Mutable;
import haw.pr2.interfaces.marker.WithMass;
import haw.pr2.interfaces.marker.WithPosition;
import haw.pr2.interfaces.marker.WithSpeed;

/**
 * @author Robert
 *
 */
public interface Particle extends Mutable, PhysObject, WithMass, WithPosition, WithSpeed
{
	
}

/**
 * 
 */
package haw.pr2.interfaces.physicObjects;

import haw.pr2.interfaces.WithMass;
import haw.pr2.interfaces.WithPosition;
import haw.pr2.interfaces.WithSpeed;
import haw.pr2.interfaces.adminValue.Mutable;

/**
 * @author Robert
 *
 */
public interface Particle extends Mutable, PhysObject, WithMass, WithPosition, WithSpeed
{
	
}

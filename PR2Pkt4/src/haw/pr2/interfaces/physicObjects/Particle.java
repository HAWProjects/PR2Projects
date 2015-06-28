/**
 * 
 */
package haw.pr2.interfaces.physicObjects;

import haw.pr2.interfaces.Mutable;
import haw.pr2.interfaces.aspects.WithMass;
import haw.pr2.interfaces.aspects.WithPosition;
import haw.pr2.interfaces.aspects.WithSpeed;

/**
 * @author Robert
 *
 */
public interface Particle extends Mutable, PhysObject, WithMass, WithPosition, WithSpeed
{
	
}

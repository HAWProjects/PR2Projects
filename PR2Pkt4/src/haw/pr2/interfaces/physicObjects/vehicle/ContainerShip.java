/**
 * 
 */
package haw.pr2.interfaces.physicObjects.vehicle;

import haw.pr2.interfaces.aspects.WithCargo;
import haw.pr2.interfaces.physicObjects.cargo.ContainerStowage;
import haw.pr2.interfaces.physicObjects.vehicle.component.Ship;

/**
 * @author Robert
 *
 */
public interface ContainerShip extends Ship<ContainerShip>, WithCargo, ContainerStowage
{
	
}

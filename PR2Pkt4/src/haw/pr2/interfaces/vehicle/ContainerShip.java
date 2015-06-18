/**
 * 
 */
package haw.pr2.interfaces.vehicle;

import haw.pr2.interfaces.WithCargo;
import haw.pr2.interfaces.cargo.ContainerStowage;
import haw.pr2.interfaces.physicObjects.Ship;

/**
 * @author Robert
 *
 */
public interface ContainerShip extends Ship<ContainerShip>, WithCargo, ContainerStowage
{
	
}

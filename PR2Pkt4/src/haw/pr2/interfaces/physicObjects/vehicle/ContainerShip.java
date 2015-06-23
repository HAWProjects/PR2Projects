/**
 * 
 */
package haw.pr2.interfaces.physicObjects.vehicle;

import haw.pr2.interfaces.marker.WithCargo;
import haw.pr2.interfaces.physicObjects.Ship;
import haw.pr2.interfaces.physicObjects.cargo.ContainerStowage;

/**
 * @author Robert
 *
 */
public interface ContainerShip extends Ship<ContainerShip>, WithCargo, ContainerStowage
{
	
}

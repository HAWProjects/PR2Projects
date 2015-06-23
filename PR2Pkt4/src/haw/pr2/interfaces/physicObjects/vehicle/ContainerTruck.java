package haw.pr2.interfaces.physicObjects.vehicle;

import haw.pr2.interfaces.marker.WithCargo;
import haw.pr2.interfaces.physicObjects.Vehicle;
import haw.pr2.interfaces.physicObjects.cargo.ContainerStowage;

public interface ContainerTruck extends Vehicle<ContainerTruck>, WithCargo, ContainerStowage
{
	
}

package haw.pr2.interfaces.vehicle;

import haw.pr2.interfaces.WithCargo;
import haw.pr2.interfaces.cargo.ContainerStowage;
import haw.pr2.interfaces.physicObjects.Vehicle;

public interface ContainerTruck extends Vehicle<ContainerTruck>, WithCargo, ContainerStowage
{
	
}

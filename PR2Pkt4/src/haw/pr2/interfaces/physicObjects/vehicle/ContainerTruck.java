package haw.pr2.interfaces.physicObjects.vehicle;

import haw.pr2.interfaces.aspects.WithCargo;
import haw.pr2.interfaces.physicObjects.cargo.ContainerStowage;

public interface ContainerTruck extends Vehicle<ContainerTruck>, WithCargo, ContainerStowage
{
	
}

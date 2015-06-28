package haw.pr2.interfaces.physicObjects.cargo;

import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.adminValue.UniqueId;
import haw.pr2.interfaces.aspects.WithForm;
import haw.pr2.interfaces.aspects.WithStowLoc;
import haw.pr2.interfaces.aspects.WithUniqueId;
import haw.pr2.interfaces.physicObjects.vehicle.Vehicle;

public interface Container extends Stowage<Pallet>,WithUniqueId,WithStowLoc<Stowage<Container>>,WithForm,Comparable<Container>
{
	
}

package haw.pr2.interfaces.physicObjects.cargo;

import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.adminValue.UniqueId;
import haw.pr2.interfaces.marker.WithForm;
import haw.pr2.interfaces.marker.WithStowLoc;
import haw.pr2.interfaces.marker.WithUniqueId;
import haw.pr2.interfaces.physicObjects.Vehicle;

public interface Container extends Stowage<Pallet>,WithUniqueId,WithStowLoc<Stowage<Container>>,WithForm,Comparable<Container>
{
	
}

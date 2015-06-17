package haw.pr2.interfaces.cargo;

import haw.pr2.interfaces.WithForm;
import haw.pr2.interfaces.WithStowLoc;
import haw.pr2.interfaces.WithUniqueId;
import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.adminValue.UniqueId;

public interface Container extends Stowage<Pallet>,WithUniqueId,WithStowLoc,WithForm,Comparable<Container>
{
	
}

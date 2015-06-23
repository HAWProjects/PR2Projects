package haw.pr2.interfaces.physicObjects.cargo;

import java.util.Comparator;

import haw.pr2.interfaces.adminValue.Immutable;
import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.adminValue.UniqueId;
import haw.pr2.interfaces.marker.WithForm;
import haw.pr2.interfaces.marker.WithStowLoc;
import haw.pr2.interfaces.marker.WithUniqueId;
import haw.pr2.interfaces.physicObjects.Body;
import haw.pr2.interfaces.physicObjects.Vehicle;

public interface Pallet extends Immutable, Body,WithUniqueId,WithStowLoc<Stowage<Pallet>>,WithForm,Comparable<Pallet>
{
	
}

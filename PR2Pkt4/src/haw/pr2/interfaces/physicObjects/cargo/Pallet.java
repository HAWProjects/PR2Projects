package haw.pr2.interfaces.physicObjects.cargo;

import java.util.Comparator;

import haw.pr2.interfaces.Immutable;
import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.adminValue.UniqueId;
import haw.pr2.interfaces.aspects.WithForm;
import haw.pr2.interfaces.aspects.WithStowLoc;
import haw.pr2.interfaces.aspects.WithUniqueId;
import haw.pr2.interfaces.physicObjects.Body;
import haw.pr2.interfaces.physicObjects.vehicle.Vehicle;

public interface Pallet extends Immutable, Body,WithUniqueId,WithStowLoc<Stowage<Pallet>>,WithForm,Comparable<Pallet>
{
	
}

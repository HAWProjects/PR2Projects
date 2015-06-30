package haw.pr2.interfaces;

import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.physicObjects.cargo.Stowage;

public interface NullObjFactory<T> {
	
	public T createNullObj(StowageLocation loc);
}

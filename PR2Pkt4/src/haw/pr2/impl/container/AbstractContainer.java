package haw.pr2.impl.container;

import java.util.Collection;
import java.util.Set;

import haw.pr2.impl.Bounded3DimStackImpl;
import haw.pr2.impl.UniqueIdImpl;
import haw.pr2.impl.values.Factory;
import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.adminValue.UniqueId;
import haw.pr2.interfaces.physicObjects.cargo.Container;
import haw.pr2.interfaces.physicObjects.cargo.Pallet;
import haw.pr2.interfaces.physicValues.BoundingBox;
import haw.pr2.interfaces.physicValues.Mass;

/**
 * @author Robert
 *
 */
public abstract class AbstractContainer<E extends AbstractContainer> implements Container
{	
	
	
	protected AbstractContainer(){
		
	}

	@Override
	public BoundingBox boundingBox() {
		// TODO Auto-generated method stub
		return null;
	}


	
}

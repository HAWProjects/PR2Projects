package haw.pr2.impl.container;

import haw.pr2.interfaces.physicObjects.cargo.Container;
import haw.pr2.interfaces.physicValues.BoundingBox;

/**
 * @author Robert
 *
 */
public abstract class AbstractContainer<E> implements Container
{	
	
	protected AbstractContainer(){
		
	}

	@Override
	public BoundingBox boundingBox() {
		return null;
	}


	
}

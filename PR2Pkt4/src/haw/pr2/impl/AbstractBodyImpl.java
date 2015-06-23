/**
 * 
 */
package haw.pr2.impl;

import haw.pr2.interfaces.physicObjects.Body;
import haw.pr2.interfaces.physicValues.BoundingBox;
import haw.pr2.interfaces.physicValues.Mass;

/**
 * @author abt434
 *
 */

public class AbstractBodyImpl implements Body {
	BoundingBox boundingBox;
	
	public static AbstractBodyImpl valueOf(BoundingBox boundingBox){
		return new AbstractBodyImpl(boundingBox);
	}
	
	private AbstractBodyImpl(BoundingBox boundingBox){
		this.boundingBox = boundingBox;
	}

	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.marker.WithMass#mass()
	 */
	@Override
	public Mass mass() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.marker.WithBoundingBox#boundingBox()
	 */
	@Override
	public BoundingBox boundingBox() {
		return boundingBox;
	}

}

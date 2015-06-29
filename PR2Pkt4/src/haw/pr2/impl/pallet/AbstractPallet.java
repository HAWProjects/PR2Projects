/**
 * 
 */
package haw.pr2.impl.pallet;

import haw.pr2.interfaces.physicObjects.cargo.Pallet;
import haw.pr2.interfaces.physicValues.BoundingBox;

/**
 * @author Robert
 *
 */
public abstract class AbstractPallet<E> implements Pallet
{
	@Override
	public BoundingBox boundingBox()
	{
		return null;
	}
}

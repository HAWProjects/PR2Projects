/**
 * 
 */
package haw.pr2.impl.pallet;

import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.adminValue.UniqueId;
import haw.pr2.interfaces.physicObjects.cargo.Pallet;
import haw.pr2.interfaces.physicObjects.cargo.Stowage;
import haw.pr2.interfaces.physicValues.BoundingBox;
import haw.pr2.interfaces.physicValues.Mass;

/**
 * @author Robert
 *
 */
public abstract class AbstractPallet implements Pallet
{
	@Override
	public BoundingBox boundingBox()
	{
		// TODO Auto-generated method stub
		return null;
	}
}

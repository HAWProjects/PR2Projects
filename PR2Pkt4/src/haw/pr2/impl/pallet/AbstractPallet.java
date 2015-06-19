/**
 * 
 */
package haw.pr2.impl.pallet;

import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.adminValue.UniqueId;
import haw.pr2.interfaces.physicObjects.cargo.Pallet;
import haw.pr2.interfaces.physicValues.BoundingBox;
import haw.pr2.interfaces.physicValues.Mass;

/**
 * @author Robert
 *
 */
public class AbstractPallet implements Pallet
{
	
	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.WithUniqueId#id()
	 */
	@Override
	public UniqueId id()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.WithStowLoc#loc()
	 */
	@Override
	public StowageLocation loc()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.WithStowLoc#setLocNull()
	 */
	@Override
	public void setLocNull()
	{
		// TODO Auto-generated method stub
		
	}
	
	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.WithStowLoc#setLoc(java.lang.Object, haw.pr2.interfaces.adminValue.StowageLocation)
	 */
	@Override
	public void setLoc(Object stowage, StowageLocation loc)
	{
		// TODO Auto-generated method stub
		
	}
	
	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.WithForm#isFree()
	 */
	@Override
	public boolean isFree()
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.WithForm#isBlocked()
	 */
	@Override
	public boolean isBlocked()
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.WithForm#isOcupied()
	 */
	@Override
	public boolean isOcupied()
	{
		// TODO Auto-generated method stub
		return false;
	}
	


	@Override
	public Mass mass()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoundingBox boundingBox()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}



	
}

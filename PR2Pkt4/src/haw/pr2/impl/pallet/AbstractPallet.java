/**
 * 
 */
package haw.pr2.impl.pallet;

import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.adminValue.UniqueId;
import haw.pr2.interfaces.cargo.Pallet;

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
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Pallet o)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
}

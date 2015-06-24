/**
 * 
 */
package haw.pr2.impl;

import haw.pr2.interfaces.adminValue.StowageLocation;

/**
 * @author Robert
 *
 */
public class NULLStowageLocationImpl implements StowageLocation
{
	private static StowageLocation instance = null;
	
	private NULLStowageLocationImpl(){
		
	}
	
    public static StowageLocation valueOf() {
        if (instance == null)
            instance = new NULLStowageLocationImpl();
        return instance;
    }
	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.adminValue.StowageLocation#bay()
	 */
	@Override
	public int bay()
	{
		throw new UnsupportedOperationException("Operation nicht unterstützt!");
	}
	
	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.adminValue.StowageLocation#row()
	 */
	@Override
	public int row()
	{
		throw new UnsupportedOperationException("Operation nicht unterstützt!");
	}
	
	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.adminValue.StowageLocation#tier()
	 */
	@Override
	public int tier()
	{
		throw new UnsupportedOperationException("Operation nicht unterstützt!");
	}
	
	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.adminValue.StowageLocation#isNull()
	 */
	@Override
	public boolean isNull()
	{
		return true;
	}
	
}

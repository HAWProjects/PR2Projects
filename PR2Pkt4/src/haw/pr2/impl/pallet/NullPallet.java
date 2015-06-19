/**
 * 
 */
package haw.pr2.impl.pallet;

/**
 * @author Robert
 *
 */
public class NullPallet extends AbstractPallet
{
	public static NullPallet valueOf(){
		return new NullPallet();
	}
	
	private NullPallet(){
	}
}

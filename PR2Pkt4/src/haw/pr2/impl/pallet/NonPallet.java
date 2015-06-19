/**
 * 
 */
package haw.pr2.impl.pallet;

import haw.pr2.impl.container.NonContainer;

/**
 * @author Robert
 *
 */
public class NonPallet extends AbstractPallet
{
	public static NonPallet valueOf(){
		return new NonPallet();
	}
	
	private NonPallet(){
	}
}

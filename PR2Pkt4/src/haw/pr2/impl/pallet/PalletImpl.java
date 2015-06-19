/**
 * 
 */
package haw.pr2.impl.pallet;

import haw.pr2.interfaces.physicValues.Mass;

/**
 * @author Robert
 */

public class PalletImpl extends AbstractPallet
{
	Mass mass;
	
	public static PalletImpl valueOf(Mass mass){
		return new PalletImpl(mass);
	}
	
	private PalletImpl(Mass mass){
		this.mass = mass;
	}
}

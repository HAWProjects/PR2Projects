/**
 * 
 */
package haw.pr2.impl.pallet;


import haw.pr2.impl.UniqueIdImpl;
import haw.pr2.impl.values.Factory;
import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.adminValue.UniqueId;
import haw.pr2.interfaces.physicObjects.cargo.Pallet;
import haw.pr2.interfaces.physicObjects.cargo.Stowage;
import haw.pr2.interfaces.physicValues.Mass;

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

	@Override
	public Mass mass() {
		return Factory.mass(0.0);
	}

	@Override
	public UniqueId id() {
		return UniqueIdImpl.valueOf();
	}

	@Override
	public StowageLocation loc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLocNull() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoc(Stowage stowage, StowageLocation loc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isFree() {
		return false;
	}

	@Override
	public boolean isBlocked() {
		return true;
	}

	@Override
	public boolean isOcupied() {
		return false;
	}

	@Override
	public int compareTo(Pallet o) {
		return 0;
	}
}

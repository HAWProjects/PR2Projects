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
public class NullPalletImpl extends AbstractPallet<Pallet>
{
	private final UniqueId id;
	
	public static NullPalletImpl valueOf(){
		return new NullPalletImpl();
	}
	
	private NullPalletImpl(){
		this.id = UniqueIdImpl.valueOf();
	}

	@Override
	public Mass mass() {
		return Factory.mass(0.0);
	}

	@Override
	public UniqueId id() {
		return id;
	}

	@Override
	public StowageLocation loc() {
		return null;
	}

	@Override
	public void setLocNull() {
	}

	@Override
	public void setLoc(Stowage<Pallet> stowage, StowageLocation loc) {
	}

	@Override
	public boolean isFree() {
		return true;
	}

	@Override
	public boolean isBlocked() {
		return false;
	}

	@Override
	public boolean isOcupied() {
		return true;
	}

	@Override
	public int compareTo(Pallet o) {
		return 0;
	}

}

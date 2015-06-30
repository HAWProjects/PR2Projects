/**
 * 
 */
package haw.pr2.impl.pallet;

import haw.pr2.impl.UniqueIdImpl;
import haw.pr2.impl.values.NullStowageLocation;
import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.adminValue.UniqueId;
import haw.pr2.interfaces.physicObjects.cargo.Pallet;
import haw.pr2.interfaces.physicObjects.cargo.Stowage;
import haw.pr2.interfaces.physicValues.Mass;

/**
 * @author Robert
 */

public class PalletImpl extends AbstractPallet<Pallet>
{
	Mass mass;
    private final UniqueId id;
    private StowageLocation loc;
	private Stowage<Pallet> stowage;
	
	public static PalletImpl valueOf(Mass mass){
		return new PalletImpl(mass);
	}
	
	private PalletImpl(Mass mass){
		this.mass = mass;
		this.id = UniqueIdImpl.valueOf();
		this.loc = NullStowageLocation.valueOf();
	}

	@Override
	public Mass mass() {
		return mass;
	}

	@Override
	public UniqueId id() {
		return id;
	}

	@Override
	public StowageLocation loc() {
		return loc;
	}

	@Override
	public void setLocNull() {
		this.loc = NullStowageLocation.valueOf();
	}

	@Override
	public void setLoc(Stowage<Pallet> stowage, StowageLocation loc) {
		this.stowage = stowage;
		this.loc = loc;
	}

	@Override
	public boolean isFree() {
		return false;
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
		return (int)(this.mass.sub(o.mass()).value());
	}
	public Stowage<Pallet> getStowage(){
		return stowage;
	}
}

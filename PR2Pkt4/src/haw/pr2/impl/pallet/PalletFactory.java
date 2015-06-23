/**
 * 
 */
package haw.pr2.impl.pallet;

import haw.pr2.impl.values.Factory;
import haw.pr2.interfaces.physicObjects.cargo.Pallet;
import haw.pr2.interfaces.physicValues.Mass;
import haw.pr2.interfaces.units.MassUnit;
import haw.pr2.interfaces.units.Multiplier;

/**
 * @author Robert
 */
public class PalletFactory {
	private PalletFactory() {
	}

	public static Pallet pallet(Mass mass) {
		return PalletImpl.valueOf(mass);
	}

	public static Pallet pallet100KG() {
		return pallet(100, MassUnit.KILOGRAMM, Multiplier.NONE);
	}

	private static Pallet pallet(int mass, MassUnit kilogramm, Multiplier none) {
		return pallet(Factory.mass(mass * kilogramm.getFactor() * none.getMultiplier()));
	}

}

package haw.pr2.impl.pallet;

import haw.pr2.interfaces.NullObjFactory;
import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.physicObjects.cargo.Pallet;
import haw.pr2.interfaces.physicObjects.cargo.Stowage;

public class NullPalletFactory implements NullObjFactory<Pallet> {

	@Override
	public Pallet createNullObj(StowageLocation loc) {
		return PalletFactory.NullPallet();
	}

}

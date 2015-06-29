package haw.pr2.impl.pallet;

import haw.pr2.interfaces.NullObjFactory;
import haw.pr2.interfaces.physicObjects.cargo.Pallet;

public class NullPalletFactory implements NullObjFactory<Pallet> {

	@Override
	public Pallet createNullObj() {
		return PalletFactory.NullPallet();
	}

}

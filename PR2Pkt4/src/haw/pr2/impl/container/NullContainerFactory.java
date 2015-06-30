package haw.pr2.impl.container;

import haw.pr2.interfaces.NullObjFactory;
import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.physicObjects.cargo.Container;
import haw.pr2.interfaces.physicObjects.cargo.Pallet;
import haw.pr2.interfaces.physicObjects.cargo.Stowage;

public class NullContainerFactory implements NullObjFactory<Container> {

	@Override
	public Container createNullObj(StowageLocation loc) {
		return ContainerFactory.NULLContainer();
	}

}

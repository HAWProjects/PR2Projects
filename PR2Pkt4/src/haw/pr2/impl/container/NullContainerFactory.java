package haw.pr2.impl.container;

import haw.pr2.interfaces.NullObjFactory;
import haw.pr2.interfaces.physicObjects.cargo.Container;

public class NullContainerFactory implements NullObjFactory<Container> {

	@Override
	public Container createNullObj() {
		return ContainerFactory.NULLContainer();
	}

}

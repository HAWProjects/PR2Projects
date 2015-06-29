package haw.pr2.impl.container;

import haw.pr2.interfaces.physicObjects.cargo.Container;
import haw.pr2.interfaces.physicObjects.cargo.Stowage;

/**
 * @author Robert
 */
public class ContainerFactory {
	private ContainerFactory() {
	}

	public static <E extends Container> Container container(Stowage<Container> stowage) {
		return ContainerImpl.valueOf(stowage);
	}

	public static Container container20ftDryLoad(Stowage<Container> stowage) {
		return container(stowage);
	}

	public static Container NULLContainer() {
		return NullContainerImpl.valueOf();
	}

	public static Container NONContainer() {
		return NonContainerImpl.valueOf();
	}
}

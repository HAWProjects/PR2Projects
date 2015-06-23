package haw.pr2.impl.container;

import haw.pr2.interfaces.physicObjects.cargo.Container;
import haw.pr2.interfaces.physicObjects.cargo.Stowage;

/**
 * @author Robert
 *
 */
public class ContainerFactory
{
	private ContainerFactory() {
	}

	public static <E extends Container> Container container(Stowage<Container> stowage) {
		return ContainerImpl.valueOf(stowage);
	}

	public static Container container20ftDryLoad(Stowage<Container> stowage) {
		return container(stowage, 8, 20, 8);
	}

	private static Container container(Stowage<Container> stowage, int breite, int laenge, int hoehe) {
		return ContainerImpl.valueOf(stowage, breite, laenge, hoehe);
	}
}

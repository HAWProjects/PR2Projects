package haw.pr2.impl.container;

import haw.pr2.interfaces.physicObjects.cargo.Container;
import haw.pr2.interfaces.physicObjects.cargo.Stowage;
import haw.pr2.interfaces.units.MassUnit;
import haw.pr2.interfaces.units.Multiplier;

/**
 * @author Robert
 *
 */
public class ContainerFactory
{
	private ContainerFactory() {
	}

	public static <E> Container container(Stowage<E> stowage) {
		return ContainerImpl.valueOf(stowage);
	}

	public static Container container20ftDryLoad() {
		//TODO: stowage erstellen
		return null;
	}

	private static Container container(int mass, MassUnit kilogramm, Multiplier none) {

		//TODO: ja fertig machen
		return null;
	}
}

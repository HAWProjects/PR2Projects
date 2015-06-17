package haw.pr2.interfaces;
/**
 * @author Robert
 *
 */
import haw.pr2.interfaces.physicValues.Mass;

public interface WithCargo
{
	Mass emptyMass();
	Mass maxMass();
	boolean isEmpty();
	boolean isFull();
}

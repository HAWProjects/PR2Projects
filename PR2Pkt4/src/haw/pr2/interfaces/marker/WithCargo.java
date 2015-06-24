package haw.pr2.interfaces.marker;
/**
 * @author Robert
 *
 */
import haw.pr2.interfaces.physicValues.Mass;

public interface WithCargo
{
	public Mass emptyMass();
	public Mass maxMass();
	public boolean isEmpty();
	public boolean isFull();
}

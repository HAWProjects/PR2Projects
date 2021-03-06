package haw.pr2.interfaces.aspects;
/**
 * @author Robert
 *
 */
import haw.pr2.interfaces.Mutable;
import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.physicObjects.cargo.Stowage;

public interface WithStowLoc<S extends Stowage<?>> extends Mutable
{
	StowageLocation loc();
	void setLocNull();
	void setLoc(S stowage, StowageLocation loc);
}

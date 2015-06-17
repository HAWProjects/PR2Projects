package haw.pr2.interfaces;
/**
 * @author Robert
 *
 */
import haw.pr2.interfaces.adminValue.Mutable;
import haw.pr2.interfaces.adminValue.StowageLocation;

public interface WithStowLoc<S> extends Mutable
{
	StowageLocation loc();
	void setLocNull();
	void setLoc(S stowage, StowageLocation loc);
}

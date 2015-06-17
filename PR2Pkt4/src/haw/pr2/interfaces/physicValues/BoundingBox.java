package haw.pr2.interfaces.physicValues;
/**
 * @author Robert
 *
 */

public interface BoundingBox
{
	Length length();
	Length width();
	Length height();
	boolean fitsInto(BoundingBox boundingBox);
}

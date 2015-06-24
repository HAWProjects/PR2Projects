package haw.pr2.interfaces.adminValue;
/**
 * @author Robert
 *
 */
public interface Name
{
	String nameString();
	int compareTo(Name other);
	@Override
	int hashCode();
	@Override
	boolean equals(Object obj);
}

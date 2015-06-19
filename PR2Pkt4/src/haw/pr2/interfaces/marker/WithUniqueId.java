package haw.pr2.interfaces.marker;
/**
 * @author Robert
 *
 */
import haw.pr2.interfaces.adminValue.UniqueId;

public interface WithUniqueId<E extends WithUniqueId<E>> extends Comparable<E>
{
	UniqueId id();
}

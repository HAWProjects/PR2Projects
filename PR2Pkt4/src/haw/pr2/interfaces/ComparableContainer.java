/**
 * 
 */
package haw.pr2.interfaces;

import haw.pr2.interfaces.aspects.WithUniqueId;

/**
 * @author Robert
 *
 */
public interface ComparableContainer<E extends WithUniqueId> extends Comparable<E>
{
    public default int compareTo(E other) {
        long x = ((E)this).id().idNumber();         //(E) cast zu E
        long y = other.id().idNumber();
        return Long.compare(x, y); //x.compareTo(y)
    }
}

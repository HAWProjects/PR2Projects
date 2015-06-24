package haw.pr2.interfaces.physicObjects.cargo;
/**
 * @author Robert
 *
 */
import java.util.Collection;
import java.util.Set;

import haw.pr2.interfaces.Mutable;
import haw.pr2.interfaces.adminValue.StowageLocation;

public interface Bounded3DimStack<E> extends Mutable
{
	void load(int bayNo, int rowNo, E elem);
	void load(E elem);
	void loadAll(Collection<? extends E> coll);
	
	boolean isEmpty();
	boolean isFull();
	boolean tierIsEmpty(int bay, int row);
	boolean tierIsFull(int bay, int row);
	boolean contains(Object elem);
	boolean containsAll(Collection<?> coll);
	
	//gibt das an der Position vorhandene Element zurück
	E get(StowageLocation loc);
	//liefert alle im Stack enthaltene Elemente
	Set<E> getAll();
	//sucht ein Element und gibt dessen Position zurück
	StowageLocation locationOf(E elem);
}

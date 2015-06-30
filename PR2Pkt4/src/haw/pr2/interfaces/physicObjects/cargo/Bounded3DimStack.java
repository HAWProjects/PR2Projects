package haw.pr2.interfaces.physicObjects.cargo;
/**
 * @author Robert
 *
 */
import java.util.Collection;
import java.util.Set;

import haw.pr2.interfaces.Mutable;
import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.aspects.WithStowLoc;

public interface Bounded3DimStack<E> extends Mutable
{
	// leadt eine element auf einen speziellen Platz
	void load(int bayNo, int rowNo, E elem);
	// leadt ein Element in den Stack auf einen freien Platz
	void load(E elem);
	//leadt eine Collection in den Stack
	void loadAll(Collection<? extends E> coll);
	
	//prueft ob der Stack leer ist
	boolean isEmpty();
	// prueft ob der Stack voll ist
	boolean isFull();
	// prueft ob das tier leer ist
	boolean tierIsEmpty(int bay, int row);
	// prueft ob das tier voll ist
	boolean tierIsFull(int bay, int row);
	// prueft ob der Stack das Object enthaelt
	boolean contains(Object elem);
	// prueft ob der Stack die Collection enthaelt
	boolean containsAll(Collection<?> coll);
	
	//gibt das an der Position vorhandene Element zurück
	E get(StowageLocation loc);
	//liefert alle im Stack enthaltene Elemente
	Set<E> getAll();
	//sucht ein Element und gibt dessen Position zurück
	StowageLocation locationOf(E elem);
	
}

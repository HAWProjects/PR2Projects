/**
 * 
 */
package haw.pr2.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.physicObjects.cargo.Bounded3DimStack;

/**
 * @author abt434
 *
 */

	
public class Bounded3DimStackImpl<E> implements Bounded3DimStack<E> {

	List rowList;
	List bayList;
	List tierList;
	
	public Bounded3DimStackImpl() {
		rowList = new ArrayList<>();
		bayList = new ArrayList<>();
		tierList = new ArrayList<>();
	}
	
	@Override
	public void load(int bayNo, int rowNo, E elem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load(E elem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadAll(Collection<? extends E> coll) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tierIsEmpty(int bay, int row) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tierIsFull(int bay, int row) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> coll) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(StowageLocation loc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<E> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StowageLocation locationOf(E elem) {
		// TODO Auto-generated method stub
		return null;
	}

}

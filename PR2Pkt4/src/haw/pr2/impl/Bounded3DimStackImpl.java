/**
 * 
 */
package haw.pr2.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import haw.pr2.impl.container.ContainerFactory;
import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.marker.WithForm;
import haw.pr2.interfaces.physicObjects.cargo.Bounded3DimStack;

/**
 * @author abt434
 *
 */

	
public class Bounded3DimStackImpl<E extends WithForm> implements Bounded3DimStack<E> {

    private final int bays;
    private final int rows;
    private final int tiers;
    private final List<List<List<E>>> stowage;
	
	private Bounded3DimStackImpl(int bays, int rows, int tiers)  {
		this.bays = bays;
		this.rows = rows;
		this.tiers = tiers;
		this.stowage = new ArrayList<>();
		
		try {
			initStowage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    public static Bounded3DimStackImpl valueOf(int bays, int rows, int tiers) {
        return new Bounded3DimStackImpl(bays, rows, tiers);
    }
    
    private void initStowage() throws Exception {
    	stowage.clear();
    	for(int bay = 0; bay < bays; bay++){
    		List<List<E>> rowL = new ArrayList<>();
    		for(int row = 0; row < rows; row++ ){
    			List<E> tierL = new ArrayList<>();
    			for(int tier = 0; tier< tiers; tier++){
    				tierL.add(getNullObject());
    			}
    			rowL.add(tierL);
    		}
    		stowage.add(rowL);
    	}
    }
    
	private E getNullObject() throws Exception{
    	return (E)NullObj.valueOf();
    }
	
	@Override
	public void load(int bayNo, int rowNo, E elem) {
		List<E> tierlist = stowage.get(bayNo).get(rowNo);
		for(int i = 0; i < tierlist.size(); i++){
			if(tierlist.get(i).isFree()){
				tierlist.set(i, elem);
				return;
			}
		}
		throw new IllegalArgumentException("Platz kann nicht beladen werden!");
	}

	@Override
	public void load(E elem) {
		for(List<List<E>> rowl :stowage){
			for(List<E> tierl : rowl){
				for(int i= 0; i< tierl.size(); i++){
					if(tierl.get(i).isFree()){
						tierl.set(i, elem);
						return;
					}
				}
			}
		}
		throw new IllegalArgumentException("Es gibt keinen freien Platz!");
	}

	@Override
	public void loadAll(Collection<? extends E> coll) {
		for(E elem : coll){
			load(elem);
		}
	}

	@Override
	public boolean isEmpty() {
		for(int bay=0; bay<stowage.size(); bay++){
			List<List<E>> rowL = stowage.get(bay);
			for(int row = 0;row < rowL.size();row++ ){
				if(!tierIsEmpty(bay, row)){
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean isFull() {
		for(int bay=0; bay<stowage.size(); bay++){
			List<List<E>> rowL = stowage.get(bay);
			for(int row = 0;row < rowL.size(); row++){
				if(!tierIsFull(bay, row)){
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean tierIsEmpty(int bay, int row) {
		List<E> tierL = stowage.get(bay).get(row);
		for(E elem : tierL){
			if(elem.isFree()){
				return true;
			}else if(elem.isOcupied()){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean tierIsFull(int bay, int row) {
		List<E> tierL = stowage.get(bay).get(row);
		//Collections.reverse(tierL);
		for(E elem: tierL){
			if(elem.isFree()){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean contains(Object elem) {
		for(List<List<E>> rowL : stowage){
			for(List<E> tierL: rowL){
				if(tierL.contains(elem)){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> coll) {
	       for (Object elem : coll) {
	            if (!contains(elem))
	                return false;
	        }
	        return true;
	}

	@Override
	public E get(StowageLocation loc) {
		return stowage.get(loc.bay()).get(loc.row()).get(loc.tier());
	}

	@Override
	public Set<E> getAll() {
		Set<E> resultSet = new HashSet<>();
		for(List<List<E>> rowL: stowage){
			for(List<E> tierL:rowL){
				for(E elem: tierL){
					resultSet.add(elem);
				}
			}
		}
		return resultSet;
	}

	@Override
	public StowageLocation locationOf(E elem) {
		for(int bay=0; bay<stowage.size();bay++){
			List<List<E>> rowL = stowage.get(bay);
			for(int row=0; row<rowL.size(); row++){
				List<E> tierL = rowL.get(row);
				if(tierL.contains(elem)){
					return  StowageLocationImpl.valueOf(bay, row, tierL.indexOf(elem)); 
				}
			}
		}
		return null;
	}
}

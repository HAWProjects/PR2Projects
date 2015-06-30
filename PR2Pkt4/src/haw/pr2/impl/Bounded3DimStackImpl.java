/**
 * Die Klasse Bounded3DimStackImpl repräsentiert einen 3Dimensionalen Stapel um beliebige Objekte vom Typ T zu stapeln.
 */
package haw.pr2.impl;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import haw.pr2.interfaces.NullObjFactory;
import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.aspects.WithForm;
import haw.pr2.interfaces.physicObjects.cargo.Bounded3DimStack;
import haw.pr2.interfaces.physicObjects.cargo.Stowage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Robert, Jenny
 * @param <T>
 */
public class Bounded3DimStackImpl<T extends WithForm,E extends WithForm> implements Bounded3DimStack<T> {

    private final int bays;
    private final int rows;
    private final int tiers;
    private final Stowage<E> stow;
    private final List<List<List<T>>> stowage;
	private NullObjFactory<T> nullObjFactory;

	/**
	 * @param bays
	 * @param rows
	 * @param tiers
	 */
	private Bounded3DimStackImpl(NullObjFactory<T> nullObjFactory,Stowage<E> stowage,int bays, int rows, int tiers)  {
		this.bays = bays;
		this.rows = rows;
		this.tiers = tiers;
		this.stowage = new ArrayList<>();
		this.nullObjFactory = nullObjFactory;
		this.stow = stowage;
		
		try {
			initStowage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    public static <T extends WithForm,E extends WithForm> Bounded3DimStackImpl<T,E> valueOf(NullObjFactory<T> nullObjFactory,Stowage<E> stowage,int bays, int rows, int tiers) {
        return new Bounded3DimStackImpl<T,E>(nullObjFactory,stowage, bays, rows, tiers);
    }
    
    //Initialisierung des 3DimStacks
    private void initStowage() throws Exception {
    	stowage.clear();
    	for(int bay = 0; bay < bays; bay++){
    		List<List<T>> rowL = new ArrayList<>();
    		for(int row = 0; row < rows; row++ ){
    			List<T> tierL = new ArrayList<>();
    			for(int tier = 0; tier< tiers; tier++){
    				StowageLocation loc = StowageLocationImpl.valueOf(bay, row, tier);    				
    				tierL.add(nullObjFactory.createNullObj(loc)); // stow zusätzlich
    			}
    			rowL.add(tierL);
    		}
    		stowage.add(rowL);
    	}
    }

	@Override
	public void load(int bayNo, int rowNo, T elem) {
		checkArgument(bayNo > 0 && rowNo > 0);
		checkNotNull(elem);
		List<T> tierlist = stowage.get(bayNo).get(rowNo);
		for(T obj: tierlist){
			if(obj.isOcupied() || obj.isFree()){
				int tierNumber = locationOf(obj).tier();
				
				tierlist.set(tierNumber, elem);
				return;
			}
		}

//		for(int i = 0; i < tierlist.size(); i++){
//			if(tierlist.get(i).isFree()){
//				tierlist.set(i, elem);
//				return;
//			}
//		}
		throw new IllegalArgumentException("Platz kann nicht beladen werden!");
	}

	@Override
	public void load(T elem) {
		checkNotNull(elem);
		for(List<List<T>> rowl :stowage){
			for(List<T> tierl : rowl){
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
	public void loadAll(Collection<? extends T> coll) {
		checkNotNull(coll);
		for(T elem : coll){
			checkNotNull(elem);
			load(elem);
		}
	}

	@Override
	public boolean isEmpty() {
		for(int bay=0; bay<stowage.size(); bay++){
			List<List<T>> rowL = stowage.get(bay);
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
			List<List<T>> rowL = stowage.get(bay);
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
		List<T> tierL = stowage.get(bay).get(row);
		for(T elem : tierL){
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
		List<T> tierL = stowage.get(bay).get(row);
		for(T elem: tierL){
			if(elem.isFree()){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean contains(Object elem) {
		checkNotNull(elem);
		for(List<List<T>> rowL : stowage){
			for(List<T> tierL: rowL){
				if(tierL.contains(elem)){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> coll) {
		checkNotNull(coll);
	       for (Object elem : coll) {
	            if (!contains(elem))
	                return false;
	        }
	        return true;
	}

	@Override
	public T get(StowageLocation loc) {
		checkNotNull(loc);
		return stowage.get(loc.bay()).get(loc.row()).get(loc.tier());
	}

	@Override
	public Set<T> getAll() {
		Set<T> resultSet = new HashSet<>();
		for(List<List<T>> rowL: stowage){
			for(List<T> tierL:rowL){
				for(T elem: tierL){
					resultSet.add(elem);
				}
			}
		}
		return resultSet;
	}

	@Override
	public StowageLocation locationOf(T elem) {
		checkNotNull(elem);
		for(int bay=0; bay<stowage.size();bay++){ // for each
			List<List<T>> rowL = stowage.get(bay); 
			for(int row=0; row<rowL.size(); row++){
				List<T> tierL = rowL.get(row);
				if(tierL.contains(elem)){
					return  StowageLocationImpl.valueOf(bay, row, tierL.indexOf(elem)); 
				}
			}
		}
		return null; //nulllocation
	}


}

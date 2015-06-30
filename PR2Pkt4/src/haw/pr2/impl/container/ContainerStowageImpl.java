/**
 * 
 */
package haw.pr2.impl.container;

import java.util.Collection;
import java.util.Set;

import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.physicObjects.cargo.Container;
import haw.pr2.interfaces.physicObjects.cargo.ContainerStowage;
import haw.pr2.interfaces.physicObjects.cargo.Stowage;
import haw.pr2.interfaces.physicValues.BoundingBox;
import haw.pr2.interfaces.physicValues.Mass;

/**
 * @author abt434
 */
public class ContainerStowageImpl implements ContainerStowage {

	
    @SuppressWarnings("unused")
	private final int bays;
    @SuppressWarnings("unused")
    private final int rows;
    @SuppressWarnings("unused")
    private final int tiers;
    
	
	private ContainerStowageImpl (int bay, int row ,int tier){
		this.bays = bay;
		this.rows = row;
		this.tiers = tier;
	}
	
	public static ContainerStowageImpl valueOf(int bay, int row ,int tier){
		return new ContainerStowageImpl(bay, row, tier);
	}
	
	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.physicObjects.cargo.Bounded3DimStack#load(int, int, java.lang.Object)
	 */
	@Override
	public void load(int bayNo, int rowNo, Container elem) {
	}

	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.physicObjects.cargo.Bounded3DimStack#load(java.lang.Object)
	 */
	@Override
	public void load(Container elem) {
	}

	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.physicObjects.cargo.Bounded3DimStack#loadAll(java.util.Collection)
	 */
	@Override
	public void loadAll(Collection<? extends Container> coll) {
	}

	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.physicObjects.cargo.Bounded3DimStack#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return false;
	}

	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.physicObjects.cargo.Bounded3DimStack#isFull()
	 */
	@Override
	public boolean isFull() {
		return false;
	}

	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.physicObjects.cargo.Bounded3DimStack#tierIsEmpty(int, int)
	 */
	@Override
	public boolean tierIsEmpty(int bay, int row) {
		return false;
	}

	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.physicObjects.cargo.Bounded3DimStack#tierIsFull(int, int)
	 */
	@Override
	public boolean tierIsFull(int bay, int row) {
		return false;
	}

	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.physicObjects.cargo.Bounded3DimStack#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(Object elem) {
		return false;
	}

	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.physicObjects.cargo.Bounded3DimStack#containsAll(java.util.Collection)
	 */
	@Override
	public boolean containsAll(Collection<?> coll) {
		return false;
	}

	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.physicObjects.cargo.Bounded3DimStack#get(haw.pr2.interfaces.adminValue.StowageLocation)
	 */
	@Override
	public Container get(StowageLocation loc) {
		return null;
	}

	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.physicObjects.cargo.Bounded3DimStack#getAll()
	 */
	@Override
	public Set<Container> getAll() {
		return null;
	}

	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.physicObjects.cargo.Bounded3DimStack#locationOf(java.lang.Object)
	 */
	@Override
	public StowageLocation locationOf(Container elem) {
		return null;
	}

	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.marker.WithCargo#emptyMass()
	 */
	@Override
	public Mass emptyMass() {
		return null;
	}

	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.marker.WithCargo#maxMass()
	 */
	@Override
	public Mass maxMass() {
		return null;
	}

	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.marker.WithMass#mass()
	 */
	@Override
	public Mass mass() {
		return null;
	}

	/* (non-Javadoc)
	 * @see haw.pr2.interfaces.marker.WithBoundingBox#boundingBox()
	 */
	@Override
	public BoundingBox boundingBox() {
		return null;
	}


}
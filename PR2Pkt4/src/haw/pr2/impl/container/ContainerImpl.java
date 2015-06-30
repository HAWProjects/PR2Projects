package haw.pr2.impl.container;

import static com.google.common.base.Preconditions.*;

import java.util.Collection;
import java.util.Set;

import haw.pr2.impl.Bounded3DimStackImpl;
import haw.pr2.impl.UniqueIdImpl;
import haw.pr2.impl.pallet.NullPalletFactory;
import haw.pr2.impl.values.Factory;
import haw.pr2.impl.values.NullStowageLocation;
import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.adminValue.UniqueId;
import haw.pr2.interfaces.physicObjects.cargo.Container;
import haw.pr2.interfaces.physicObjects.cargo.Pallet;
import haw.pr2.interfaces.physicObjects.cargo.Stowage;
import haw.pr2.interfaces.physicValues.Mass;

public class ContainerImpl extends AbstractContainer<ContainerImpl> {

	private final UniqueId id;
	private StowageLocation loc;
	private Stowage<Container> stowage; // Container weiß zu welchem Lager er gehört
	private final Bounded3DimStackImpl<Pallet,Container> palletStowage;

	public static ContainerImpl valueOf(Stowage<Container> stowage) {
		checkNotNull(stowage);
		return new ContainerImpl(stowage);
	}

	private ContainerImpl(Stowage<Container> stowage) {
		this.stowage = stowage;
		this.id = UniqueIdImpl.valueOf();
		this.loc = NullStowageLocation.valueOf();
		this.palletStowage = Bounded3DimStackImpl.valueOf(new NullPalletFactory(), stowage, 5, 10, 5);
	}

	@Override
	public Mass emptyMass() {
		return Factory.massInKilogramm(2280);
	}

	@Override
	public void load(int bayNo, int rowNo, Pallet elem) {
		palletStowage.load(bayNo, rowNo, elem);
	}

	@Override
	public void load(Pallet elem) {
		palletStowage.load(elem);
	}

	@Override
	public void loadAll(Collection<? extends Pallet> coll) {
		palletStowage.loadAll(coll);
	}

	@Override
	public boolean isEmpty() {
		return palletStowage.isEmpty();
	}

	@Override
	public boolean isFull() {
		return palletStowage.isFull();
	}

	@Override
	public boolean tierIsEmpty(int bay, int row) {
		return palletStowage.tierIsEmpty(bay, row);
	}

	@Override
	public boolean tierIsFull(int bay, int row) {
		return palletStowage.tierIsFull(bay, row);
	}

	@Override
	public boolean contains(Object elem) {
		return palletStowage.contains(elem);
	}

	@Override
	public boolean containsAll(Collection<?> coll) {
		return palletStowage.containsAll(coll);
	}

	@Override
	public Pallet get(StowageLocation loc) {
		return palletStowage.get(loc);
	}

	@Override
	public Set<Pallet> getAll() {
		return palletStowage.getAll();
	}

	@Override
	public StowageLocation locationOf(Pallet elem) {
		return palletStowage.locationOf(elem);
	}

	@Override
	public Mass maxMass() {
		return Factory.massInKilogramm(24000).add(this.emptyMass());
	}

	@Override
	public Mass mass() {
		Mass result = emptyMass();

		for (Pallet e : palletStowage.getAll()) {
			result = result.add(e.mass());
		}
		return result;
	}

	@Override
	public UniqueId id() {
		return id;
	}

	@Override
	public StowageLocation loc() {
		return loc;
	}

	@Override
	public void setLocNull() {
		this.stowage = null;
		this.loc = NullStowageLocation.valueOf();
	}

	@Override
	public void setLoc(Stowage<Container> stowage, StowageLocation loc) {
		this.stowage = stowage;
        this.loc = loc;
	}

	@Override
	public boolean isFree() {
		return false;
	}

	@Override
	public boolean isBlocked() {
		return false;
	}

	@Override
	public boolean isOcupied() {
		return false;
	}

	@Override
	public int compareTo(Container o) {
		return (int)((this.mass().sub(o.mass())).value()) ;
	}
	
	public Stowage getStowage(){
		return stowage;
	}


}

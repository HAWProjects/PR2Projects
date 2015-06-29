/**
 * 
 */
package haw.pr2.impl.container;

import java.util.Collection;
import java.util.Set;

import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.adminValue.UniqueId;
import haw.pr2.interfaces.physicObjects.cargo.Container;
import haw.pr2.interfaces.physicObjects.cargo.Pallet;
import haw.pr2.interfaces.physicObjects.cargo.Stowage;
import haw.pr2.interfaces.physicValues.Mass;

/**
 * @author Robert
 */
public class NullContainerImpl extends AbstractContainer<Container>
{
	public static NullContainerImpl valueOf(){
		return new NullContainerImpl();
	}
	
	private NullContainerImpl(){
	}

	@Override
	public void load(int bayNo, int rowNo, Pallet elem) {
	}

	@Override
	public void load(Pallet elem) {
	}

	@Override
	public void loadAll(Collection<? extends Pallet> coll) {
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public boolean tierIsEmpty(int bay, int row) {
		return false;
	}

	@Override
	public boolean tierIsFull(int bay, int row) {
		return false;
	}

	@Override
	public boolean contains(Object elem) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> coll) {
		return false;
	}

	@Override
	public Pallet get(StowageLocation loc) {
		return null;
	}

	@Override
	public Set<Pallet> getAll() {
		return null;
	}

	@Override
	public StowageLocation locationOf(Pallet elem) {
		return null;
	}

	@Override
	public Mass emptyMass() {
		return null;
	}

	@Override
	public Mass maxMass() {
		return null;
	}

	@Override
	public Mass mass() {
		return null;
	}

	@Override
	public UniqueId id() {
		return null;
	}

	@Override
	public StowageLocation loc() {
		return null;
	}

	@Override
	public void setLocNull() {
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
		return 0;
	}

	@Override
	public void setLoc(Stowage<Container> stowage, StowageLocation loc) {
	}
}

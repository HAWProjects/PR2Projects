package haw.pr2.impl.container;

import java.util.Collection;
import java.util.Set;

import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.adminValue.UniqueId;
import haw.pr2.interfaces.cargo.Container;
import haw.pr2.interfaces.cargo.Pallet;
import haw.pr2.interfaces.physicValues.Mass;

/**
 * @author Robert
 *
 */
public class AbstractContainer implements Container
{

	@Override
	public void load(int bayNo, int rowNo, Pallet elem)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load(Pallet elem)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadAll(Collection<? extends Pallet> coll)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFull()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tierIsEmpty(int bay, int row)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tierIsFull(int bay, int row)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object elem)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> coll)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pallet get(StowageLocation loc)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Pallet> getAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StowageLocation locationOf(Pallet elem)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mass emptyMass()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mass maxMass()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UniqueId id()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StowageLocation loc()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLocNull()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoc(Object stowage, StowageLocation loc)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isFree()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBlocked()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOcupied()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int compareTo(Container arg0)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
}
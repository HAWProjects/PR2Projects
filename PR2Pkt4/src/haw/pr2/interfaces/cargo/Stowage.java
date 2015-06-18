package haw.pr2.interfaces.cargo;

import haw.pr2.interfaces.WithCargo;
import haw.pr2.interfaces.physicObjects.Body;

public interface Stowage<E> extends Bounded3DimStack<E>, WithCargo,Body 
{
	
}

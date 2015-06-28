package haw.pr2.interfaces.physicObjects.cargo;

import haw.pr2.interfaces.aspects.WithCargo;
import haw.pr2.interfaces.physicObjects.Body;

public interface Stowage<E> extends Bounded3DimStack<E>, WithCargo,Body 
{
	
}

package haw.pr2.impl.container;

import haw.pr2.interfaces.physicObjects.cargo.Stowage;

public class ContainerImpl extends AbstractContainer
{
	Stowage stowage;
	
	public static ContainerImpl valueOf(Stowage stowage){
		return new ContainerImpl(stowage);
	}
	
	private ContainerImpl(Stowage stowage){
		this.stowage = stowage;
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}


}

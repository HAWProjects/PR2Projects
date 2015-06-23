package haw.pr2.tests;

import static org.junit.Assert.*;
import haw.pr2.impl.StowageLocationImpl;
import haw.pr2.impl.container.ContainerImpl;
import haw.pr2.impl.pallet.PalletFactory;
import haw.pr2.interfaces.physicObjects.cargo.Container;
import haw.pr2.interfaces.physicObjects.cargo.Stowage;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test3DimStack {
	
	private Container container;
	
	@Before
	public void setUp() throws Exception {
		container = ContainerImpl.valueOf((Stowage<Container>) StowageLocationImpl.valueOf(5, 8, 5));
		
	}

	@Test
	public void test3DimStackFull() {
		for(int i = 0; i < 200; i++){
			container.load(PalletFactory.pallet100KG());
		}
		assertTrue(container.isFull());
	}

}

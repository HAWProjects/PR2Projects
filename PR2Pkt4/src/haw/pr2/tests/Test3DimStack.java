package haw.pr2.tests;

import static org.junit.Assert.*;
import haw.pr2.impl.Bounded3DimStackImpl;
import haw.pr2.impl.StowageLocationImpl;
import haw.pr2.impl.container.ContainerFactory;
import haw.pr2.impl.pallet.PalletFactory;
import haw.pr2.impl.values.Factory;
import haw.pr2.impl.container.*;
import haw.pr2.interfaces.physicObjects.cargo.Container;
import haw.pr2.interfaces.physicObjects.cargo.ContainerStowage;
import haw.pr2.interfaces.physicObjects.cargo.Pallet;
import haw.pr2.interfaces.physicObjects.cargo.Stowage;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test3DimStack {
	
	private static Bounded3DimStackImpl<Container> instance;
	private static ContainerImpl container;
	private static Stowage<Container> stowage;
	
	@Before
	public void setUp() throws Exception {
		instance = Bounded3DimStackImpl.valueOf(2, 4, 2);
//		stowage = neuen Stowage erstellen-> ContainerStowageImpl;
		container = ContainerImpl.valueOf(stowage);
	}
	
    @Test
    public void testValueOf() {
        assertNotNull(instance);
    }
    
    @Test
    public void testIsEmpty() {
        assertTrue(stowage.isEmpty());
        container.load(PalletFactory.pallet100KG());
        assertFalse(stowage.isEmpty());
    }
    
//	@Test
//	public void test3DimStackFull() {
//		for(int i = 0; i < 200; i++){
////			instance.load(PalletFactory.pallet100KG());
//		}
//		assertTrue(instance.isFull());
//	}
}

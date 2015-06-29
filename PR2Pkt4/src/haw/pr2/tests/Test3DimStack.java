package haw.pr2.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import haw.pr2.impl.StowageLocationImpl;
import haw.pr2.impl.container.ContainerImpl;
import haw.pr2.impl.container.ContainerStowageImpl;
import haw.pr2.impl.pallet.PalletFactory;
import haw.pr2.interfaces.adminValue.StowageLocation;
import haw.pr2.interfaces.physicObjects.cargo.Container;
import haw.pr2.interfaces.physicObjects.cargo.Pallet;
import haw.pr2.interfaces.physicObjects.cargo.Stowage;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Test3DimStack {
	
	private static ContainerImpl container;
	private static Stowage<Container> stowageContainer;
	
	private static int bay = 5;
	private static int row = 10;
	private static int tier = 5;
	
	@Before
	public void setUp() throws Exception {
		stowageContainer = ContainerStowageImpl.valueOf(15, 15, 15);
		container = ContainerImpl.valueOf(stowageContainer);
	}
	
    @Test
    public void testValueOf() {
        assertNotNull(container);
    }
    
	 /**
     * Test Stack ist leer.
     */
    @Test
    public void testIsEmptyContainer() {
        assertTrue(container.isEmpty());
        container.load(PalletFactory.pallet100KG());
        assertFalse(container.isEmpty());
    }
    
	 /**
     * Test Stack ist voll bef�llt.
     */
	@Test
	public void test3DimStackFull() {
		for(int i = 0; i < (bay*row*tier); i++){
			assertFalse(container.isFull());
			container.load(PalletFactory.pallet100KG());
		}
		assertTrue(container.isFull());
	}
	
	 /**
     * Test Stack enthaelt Pallet.
     */
    @Test
    public void testContains() {
        Pallet elem = PalletFactory.pallet100KG();
        assertFalse(container.contains(elem));
        container.load(elem);
        assertTrue(container.contains(elem));
    }
    
    /**
     * Test Container load element
     */
    @Test
    public void testLoad(){
    	Pallet nullelem = PalletFactory.NullPallet();
    	Pallet elem = PalletFactory.pallet100KG();
    	container.load(nullelem);
    	assertTrue(container.isEmpty());
    	container.load(elem);
    	assertFalse(container.isEmpty());
    	assertTrue(container.contains(elem));
    }
    
	/**
	 * Test load position
	 */
    @Test
    public void testLoadPos() {
    	Pallet elem = PalletFactory.pallet100KG();
    	container.load(1, 3, elem);
    	StowageLocation loc = container.locationOf(elem);
    	StowageLocation expectedLoc = StowageLocationImpl.valueOf(1, 3, 0);
    	assertEquals(expectedLoc, loc);
    }
    
    /**
     * Test getAll 
     */
    @Test
    public void testGetAll() {
        for (int i=0; i<(bay*row*tier); i++) {
            container.load(PalletFactory.pallet100KG());
        }
        assertEquals(bay*row*tier, container.getAll().size());
    }
    
    /**
     * Test load Collection
     */
    @Test
    public void testLoad_Collection() {
        List<Pallet> palletList = new ArrayList<>();
        for (int i=0; i<5; i++) {
            palletList.add(PalletFactory.pallet100KG());
        }
        assertFalse(container.containsAll(palletList));
        container.loadAll(palletList);
        assertTrue(container.containsAll(palletList));
    }
}

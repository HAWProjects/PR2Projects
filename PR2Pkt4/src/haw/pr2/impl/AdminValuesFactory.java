/**
 * 
 */
package haw.pr2.impl;

import haw.pr2.interfaces.adminValue.Name;
import haw.pr2.interfaces.adminValue.StowageLocation;

/**
 * @author Robert
 *
 */
public final class AdminValuesFactory
{
	public static Name name(String name){
		return NameImpl.valueOf(name);
	}
	
	/**
	 * @param bay
	 * @param row
	 * @param tier
	 * @return StowageLocation
	 */
	public static StowageLocation stowageLocation(int bay, int row, int tier){
		return StowageLocationImpl.valueOf(bay, row, tier);
	}
	
	/**
	 * @return NULLStowageLocation
	 */
	public static StowageLocation nullStowageLocation(){
		return NULLStowageLocationImpl.valueOf(); 
	}
}

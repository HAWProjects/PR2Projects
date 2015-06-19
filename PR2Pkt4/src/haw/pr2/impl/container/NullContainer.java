/**
 * 
 */
package haw.pr2.impl.container;

import haw.pr2.interfaces.physicObjects.cargo.Stowage;

/**
 * @author Robert
 */
public class NullContainer extends AbstractContainer
{
	public static NullContainer valueOf(){
		return new NullContainer();
	}
	
	private NullContainer(){
	}
}

/**
 * 
 */
package haw.pr2.impl.container;

/**
 * @author Robert
 */
public class NonContainer extends AbstractContainer
{
	public static NonContainer valueOf(){
		return new NonContainer();
	}
	
	private NonContainer(){
	}

}

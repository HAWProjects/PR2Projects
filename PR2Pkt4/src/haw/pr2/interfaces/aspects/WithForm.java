package haw.pr2.interfaces.aspects;

import haw.pr2.interfaces.physicObjects.cargo.Stowage;

/**
 * Zum modellieren der unregelmäßge Form von Stauräumen
 * @author Robert
 *
 */
public interface WithForm
{
	boolean isFree(); // leer und ersetzbar
	boolean isBlocked(); // nicht ersetzbar
	boolean isOcupied(); // belegt und ersetzbar
	
}

package haw.pr2.impl;

import haw.pr2.interfaces.marker.WithForm;

public class NullObj<E extends WithForm> implements WithForm {
	
	private NullObj(){
		
	}
	
	public static NullObj valueOf(){
		return new NullObj();
	}

	@Override
	public boolean isFree() {
		return true;
	}

	@Override
	public boolean isBlocked() {
		return false;
	}

	@Override
	public boolean isOcupied() {
		return true;
	}

}

package haw.pr2.impl;

import haw.pr2.interfaces.adminValue.StowageLocation;

public class StowageLocationImpl implements StowageLocation {
	private final int bay;
	private final int row;
	private final int tier;
	
    private StowageLocationImpl(int bay, int row, int tier) {
        this.bay = bay;
        this.row = row;
        this.tier = tier;
    }
    
    public static StowageLocation valueOf(int bay, int row, int tier) {
        return new StowageLocationImpl(bay, row, tier);
    }

	@Override
	public int bay() {
		return bay;
	}

	@Override
	public int row() {
		return row;
	}

	@Override
	public int tier() {
		return tier;
	}

	@Override
	public boolean isNull() {
		return false;
	}
	@Override
	public int hashCode(){
		int hash = 7;
		hash = 17 * hash + this.bay;
		hash = 17 * hash + this.row;
		hash = 17 * hash + this.tier;
		return hash;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		
		if(!(obj instanceof StowageLocation)) {
			return false;
		}
		
		if(this.bay != ((StowageLocation)obj).bay()){
			return false;
		}
		if(this.row != ((StowageLocation)obj).row()){
			return false;
		}	
		if(this.tier != ((StowageLocation)obj).tier()){
			return false;
		}
		return true;
	}

}

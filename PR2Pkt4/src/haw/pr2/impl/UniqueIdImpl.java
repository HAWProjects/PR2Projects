package haw.pr2.impl;

import haw.pr2.interfaces.adminValue.UniqueId;

public class UniqueIdImpl implements UniqueId
{
	private final long idNumber;
	private static long currentIdNumber = 0;

    public static synchronized UniqueId valueOf() {
        UniqueId instance = new UniqueIdImpl(currentIdNumber);
        currentIdNumber++;
        return instance;
    }
	
    private UniqueIdImpl(long idNumber) {
        this.idNumber = idNumber;  
    }
	
	@Override
	public long idNumber()
	{
		return this.idNumber;
	}

	@Override
	public int compareTo(UniqueId o) {
		return (int)(this.idNumber - o.idNumber());
	}
}

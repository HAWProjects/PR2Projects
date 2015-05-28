package haw.pr2.jgame.impl;

import haw.pr2.jgame.interfaces.AbstractValue;

public abstract class AbstractValuesImpl<E extends AbstractValue> implements AbstractValue<E> {

	   double value;
	    protected AbstractValuesImpl(double value){
	        this.value = value;
	    }
	    @Override
	    public E add(E other) {
	        return fromPrototype(value() + other.value());
	    }

	    @Override
	    public double value() {
	        return value;
	    }
	    
	    @Override
	    public int compareTo(E t) {
	        return Double.compare(this.value(), t.value());
	    }
	    
	    @Override
	    public int hashCode() {
	        int hash = 3;
	        hash = 97 * hash + (int) (Double.doubleToLongBits(this.value) ^ (Double.doubleToLongBits(this.value) >>> 32));
	        return hash;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        // Referenzgleichheit
	        if (this == obj) {
	            return true;
	        }
	        
	        // Typgleichheit
	        if (!this.checkInstance(obj)) {
	            return false;
	        }
	        
	        // Wertegleichheit
	        E other = (E)(obj);
	        return (this.compareTo(other) == 0);
	    }
}

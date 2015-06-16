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
	    public E sub(E other) {
	        return fromPrototype(value() - other.value());
	    }
	    @Override
	    public E add(double other) {
	        return fromPrototype(value() + other);
	    }
	    
	    @Override
	    public E sub(double other) {
	        return fromPrototype(value() - other);
	    }
	    
	    @Override
	    public E abs() {
	        return fromPrototype(Math.abs(this.value()));
	    }
	    
	    @Override
	    public E signum() {
	        return fromPrototype(Math.signum(this.value()));
	    }
	    
	    @Override
	    public E min(E e) {
	    	return fromPrototype(Math.min(this.value, e.value()));
	    }

	    @Override
	    public double value() {
	        return value;
	    }
	    
	    @Override
	    public boolean checkInstance(Object obj){
	    	return false;
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

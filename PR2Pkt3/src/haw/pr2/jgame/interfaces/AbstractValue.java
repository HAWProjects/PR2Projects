package haw.pr2.jgame.interfaces;
import haw.pr2.jgame.units.*;


public interface AbstractValue <E extends AbstractValue> extends Comparable<E> {
    public E add(E other);
    public E sub(E other);
    public E div(double other);
    public E mul(double other);
    
    public E abs();
    public E signum();
    
    public E fromPrototype(double value);
    
    public double value();
    public boolean checkInstance(Object obj);
    
    @Override
    public String toString();
}

package haw.pr2.jgame.interfaces;


public interface AbstractValue <E extends AbstractValue> extends Comparable<E> {
    public E add(E other);
    public E sub(E other);
    public E div(double other);
    public E mul(double other);
    
    public E abs(E other);
    public E signum(E other);
    
    public E fromPrototype(double value);
    
    public double value();
    public boolean checkInstance(Object obj);
    
    @Override
    public String toString();
}

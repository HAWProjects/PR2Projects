package haw.pr2.jgame.interfaces;


public interface AbstractValue <E extends AbstractValue> extends Comparable<E> {
    public E add(E other);
    public E fromPrototype(double value);
    public double value();
    public boolean checkInstance(Object obj);
}

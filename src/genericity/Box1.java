package genericity;

import oop.ValueAdressTest;

public class Box1<T,V> {
    private T t;
    private V v;

    public void add(T t,V v){  //泛型方法
        this.t=t;
        this.v=v;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }
}

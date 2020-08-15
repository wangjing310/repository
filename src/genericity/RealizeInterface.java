package genericity;

//未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中
public class RealizeInterface<T> implements InterfaceTest<T> {
    @Override
    public T next() {
        return null;
    }
}

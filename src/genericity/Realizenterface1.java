package genericity;

//在实现类实现泛型接口时，如已将泛型类型传入实参类型，则所有使用泛型的地方都要替换成传入的实参类型
public class Realizenterface1 implements InterfaceTest<String> {
    @Override
    public String next() {
        return null;
    }
}

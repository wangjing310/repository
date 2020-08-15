package genericity;

//泛型即类型参数化
public class Box<T> {
    //此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
    //在实例化泛型类时，必须指定T的具体类型
    //key这个成员变量的类型为T,T的类型由外部指定
    private T t;

    public Box(){}
    public Box(T t) {
        this.t = t;   ////泛型构造方法形参key的类型也为T，T的类型由外部指定
    }

    public T getT() {
        return t;
    }   //泛型方法getT的返回值类型为T，T的类型由外部指定

    public void setT(T t) {
        this.t = t;
    }
}

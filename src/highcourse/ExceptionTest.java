package highcourse;

public class ExceptionTest {
    //处理异常的两种方式
    //1.try{}catch（）{}
    public static void main(String[] args){
        try{    //发现异常
            foo();
        }
        catch (ArithmeticException e){    //声明了一个参数，参数类型是捕获的异常类的名称 ，当抛出异常时，异常对象的引用将复制到e
            System.out.println("处理异常");
            String msg=e.getMessage();
            e.printStackTrace();  //在命令行打印错误信息在程序中错误的原因和位置
            System.out.println(msg);
        }


    }
    public static void foo(){
        int a=5/0;
        System.out.println("阳春四月");  // 不执行，Java是让执行流恢复到处理了异常的catch块后接着执行
    }

    //2.throws




}

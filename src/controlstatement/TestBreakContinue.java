package controlstatement;

public class TestBreakContinue {

    public void breaktest(){
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                if (i==2&&j==2)
                    break;
                System.out.println(i+" ~~~ "+j);
            }
        }
    }

    public static void main(String[] args) {
        TestBreakContinue t=new TestBreakContinue();
        t.breaktest();
    }
}

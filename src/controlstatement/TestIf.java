package controlstatement;

public class TestIf {
   //if-else-if
    public void grade(){
        int grade =65;
        if (grade<60)
        { System.out.println("没及格");}
        else if (grade>70){
            System.out.println("良好");}
        else if (grade>90){
            System.out.println("优秀");
        }
        else {System.out.println("及格");}

    }

    //switch
    public void testSwitch(){
        int month=6;
        switch (month){
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;

        }
    }
}

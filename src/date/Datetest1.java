package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Datetest1 {

    public static void main(String[] args){
        Date date=new Date();
        SimpleDateFormat spt=new SimpleDateFormat("YYYY-MM-dd");
        System.out.println(spt.format(date));

    }
}

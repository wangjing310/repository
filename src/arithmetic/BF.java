package arithmetic;

public class BF {
    /**
     * 模式匹配
     * P称为模式，T称为目标。
     * 如果T中存在一个或多个模式为P的子串，就给出该子串在T中的位置，称为匹配成功；否则匹配失败。
     */

    //BF算法思想：t第一个字符与P第一个字符比较，若相等则继续后续比较，否则p的第一个字符与t第二个比较，以此类推

    public static void bfMath(String t,String p){
        int pos=-1;
        int i=0,j=0,k=0;

        while (i<t.length()){

            while(j<p.length()&&i<t.length()&&t.charAt(i)==p.charAt(j)){
                i++;
                j++;
            }
            if (j>=p.length()){
                pos=k;
                j=0;
                System.out.println(pos);
            }
            else{
                j=0;
                k++;
                i=k;
            }

        }
        System.out.println(pos);
    }


    public static void bf(String t,String p){
        int pos=-1;
        int i=0,j=0,k=0;
        for (;i<t.length()+1;){
            if (j<p.length()&&i<t.length()&&t.charAt(i)==p.charAt(j)){
                i++;
                j++;

            }
            else{
                if (j>=p.length()){
                    pos=k;
                    k=k+p.length();
                    j=0;
                    i=k;
                    System.out.println(pos);

                }
                else{
                    k++;
                    j=0;
                    i=k;
                }
            }
        }
    }

    public static void main(String[] args){
        String t="hellowordowor";
        String p="owor";
        bfMath(t,p);
        //bf(t,p);

    }
}

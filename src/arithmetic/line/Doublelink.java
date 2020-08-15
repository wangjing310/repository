package arithmetic.line;

public class Doublelink<T> {

    //表头
    private DNode<T> mHead;
    //节点个数
    private int num;

    //双向列表对应的结构体
    private class DNode<T>{
        public DNode pre;
        public DNode next;
        public T value;
        DNode(T vpre,DNode pre,DNode next){
            this.value=value;
            this.pre=pre;
            this.next=next;
        }
    }


    //构造函数
    Doublelink(){
        //创建头节点
        mHead=new DNode<T>(null,null,null);
        mHead.pre=mHead.next=mHead;
        //初始化节点个数
        num=0;
    }

    //返回节点数目
    public int size(){
        return num;
    }
    //返回链表是否为空
    public boolean isEmpty(){
        return num==0;
    }

    //获取第index位置节点
    public DNode<T> getNode(int index){
        if (index<0||index>num)
            throw new IndexOutOfBoundsException("下标越界");

        if (index<=num/2) {
            DNode<T> node = mHead.next;
            for (int i = 0; i < index; i++)
                node = node.next;
            return node;

        }

            //反向查找
            DNode<T> rnode = mHead.pre;
                int rindex = num - index -1;
               for (int j=0; j<rindex; j++)
                    rnode = rnode.pre;

            return rnode;
        }



    //获取index节点的值
    public T getvalue(int index){
        return getNode(index).value;
    }

    //将节点插入index节点之前
    public void insert(int index, T t) {
        if (index == 0) {
            DNode<T> node = new DNode<T>(t, mHead, mHead.next);
            mHead.next.pre = node;
            mHead.next = node;
            num++;
            return;
        }

        DNode<T> inode = getNode(index);
        DNode<T> tnode = new DNode<T>(t, inode.pre, inode);
        inode.pre.next = tnode;
        inode.next = tnode;
        num++;
        return;
    }

    //删除节点
    public void del(int index){
        DNode dNode=getNode(index);
        dNode.pre.next=dNode.next;
        dNode.next.pre=dNode.pre;
        dNode=null;
        num--;
    }


    /**
     * 测试
     */
    public static void main(String[] args){
         int[] iarr = {10, 20, 30, 40};
         Doublelink<Integer> link=new Doublelink<>();
         link.insert(0,10);


         System.out.println(link.isEmpty());
         System.out.println(link.size());
         for (int i=0;i<link.size();i++){
             System.out.println(link.getvalue(i));
         }

    }

}

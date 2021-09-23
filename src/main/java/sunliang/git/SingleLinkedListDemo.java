package sunliang.git;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        //先创建节点
        HeroNode hero1=new HeroNode(1,"宋江","及时雨");
        HeroNode hero2=new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3=new HeroNode(3,"吴用","智多星");
        HeroNode hero4=new HeroNode(4,"林冲","豹子头");
        //创建要给链表
        SingleLinkedlist singleLinkedlist=new SingleLinkedlist();
        //加入
        singleLinkedlist.add(hero1);
        singleLinkedlist.add(hero2);
        singleLinkedlist.add(hero3);
        singleLinkedlist.add(hero4);
        singleLinkedlist.list();
    }
}
//定义SingleLinkedList 管理英雄
class SingleLinkedlist{
    //先初始化一个头结点，该头结点不动，不存放具体的数据
    private HeroNode head=new HeroNode(0,"","");
    //添加节点到单向链表
    /*思路：当不考虑编号顺序时；1.找到当前链表的最后节点；2.将最后这个节点的next指向新的节点*/
    public void add(HeroNode heroNode){
        //因为head节点不能动，所以需要一个辅助遍历 temp
        HeroNode temp=head;
        //遍历链表，找到最后
        while(true){
            if(temp.next==null){
                break;
            }
            //如果没有找到最后，将temp后移
            temp=temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next指向新的节点
        temp.next=heroNode;
    }
    //显示链表【遍历】
    public void list(){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，所以需要一个辅助变量进行遍历
        HeroNode temp=head;
        while (true) {
            //判断是否到达链表尾部
            if(temp==null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //一定要将temp后移，重点
            temp=temp.next;
        }
    }
}
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点
    //构造器
    public HeroNode(int no,String name,String nickname){
        this.no=no;
        this.name=name;
        this.nickname=nickname;
    }
    //为了显示方法，重写toString方法

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' + '}';
    }

}

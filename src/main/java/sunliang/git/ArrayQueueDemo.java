package sunliang.git;

import java.util.Scanner;
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue=new ArrayQueue(3);
        Scanner in=new Scanner(System.in);
        boolean p=true;
        while(p){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据");
            System.out.println("g(get):取出数据");
            System.out.println("h(head):显示队列头数据");
            char key=in.next().charAt(0);
            switch(key){
                case 's': queue.showQueue();
                    break;
                case 'a': int value=in.nextInt(); queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res=queue.getQueue();
                        System.out.println(res);
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res_1=queue.headQueue();
                        System.out.println("队列头数据是"+res_1);
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': in.close(); p=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
//编写一个ArrayDemo类
class ArrayQueue{
    int maxSize;//表示数组的最大容量
    int front;//队列头
    int rear;//队列尾
    int arr[];//该数组用于存放数据，模拟队列
    //创建队列的构造器
    public ArrayQueue(int arrmaxSize) {
        maxSize = arrmaxSize;
        arr = new int[maxSize];
        front = -1;//
        rear = -1;//
    }
    //判断队列是否为满
    public boolean isFull(){
        return rear==maxSize-1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return front==rear;
    }
    //向队列添加数据
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满，不可添加数据");
        }
        rear++;
        arr[rear]=n;
    }
    //获取队列数据，出队列
    public int  getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能获取数据");
        }
        // front++;
        return arr[front++];
    }
    //显示队列的所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    //显示队列的头数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能获取数据");
        }
        return arr[front+1];
    }
}

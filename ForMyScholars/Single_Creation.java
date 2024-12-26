package ForMyScholars;

import java.util.Scanner;

public class Single_Creation {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    public void creation(){

        int data,n,m,p;
        Scanner sc = new Scanner(System.in);
        do{
        System.out.println("Enter Data");
        data = sc.nextInt();
        Node new_node = new Node(data);

        if (head == null) {
            head = new_node;
        }else{
            System.out.println("Enter 1 to insert data at beginning , 2 to insert the item at the end , 3 to insert in specific location");
        m = sc.nextInt();
        switch (m) {
            case 1:
                new_node.next = head;
                head = new_node;
                break;
        
            case 2:
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = new_node;
                break;
            
            case 3:
                System.out.println("Where you want to enter");
                p = sc.nextInt();;
                Node temp1 = head;
                for(int i = 0; i < (p-1); i++){
                    temp1 = temp1.next;
                }

                new_node.next = temp1.next;
                temp1.next = new_node;

                break;
        }
        }
        
        System.out.println("Do you want to add more data : If yes press : 1");
        n = sc.nextInt();
       }
       while(n == 1);
    }

    public void traverse(){
        Node temp = head;
        if (head == null) {
            System.out.println("LL Doesn't Exist");
        }else{
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }

    }

    public static void main(String[] args) {

        Single_Creation ll = new Single_Creation();
        ll.creation();
        ll.traverse();
        
    }

}

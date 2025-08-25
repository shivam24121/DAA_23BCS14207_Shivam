public class Stack{
    private int[] stack;
    private int n;
    private int top;
    
    Stack(int size){
        stack=new int[size];
        n=size;
        top=-1;
    }
    public void push(int data){
        if(isFull()){
            System.out.println("Stack overflow");
            return;
        }
        stack[++top]=data;
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack underflow");
            return -1;
        }
        return stack[top--];
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return -1;
        }
        return stack[top];
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top==n-1;
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        for(int i=top; i>=0; i--){
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        Stack s=new Stack(5);
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.display();
        s.pop();
        s.display();
    }
}

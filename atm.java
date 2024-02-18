//package OOPS;           // atm working model using abstract classes and interfaces
import java.util.*;
public class atm{
    static Scanner sc=new Scanner(System.in);
    static int b=sc.nextInt();
    
    public static void main(String[] args) {
        System.out.println("the balance in ur account is:"+b);
        System.out.println();
        while(true){
            System.out.println("***ATM COMMAND LINE INTERFACE***");
            System.out.println("enter 1 to withdraw");
            System.out.println("enter 2 to deposit");
            System.out.println("enter 3 to checkbalance");
            System.out.println("enter 4 to exit");

            int n=sc.nextInt();
            switch (n) {
                case 1: bank ba=new bank();
                ba.withdraw();  
                    break;
                case 2: abst ab=new abst();
                ab.deposit();
                    break;
                case 3: ert er=new ert();
                er.checkbalance();
                break;
                case 4: System.exit(0);
                    break;
                default:
                System.out.println("invalid option");
                    break;
            }
        }
    }
    
}

interface op{
    public void withdraw();
    public void deposit();
    public void checkbalance();
}
abstract class withdrawing extends atm implements op{
    public int c=0;
    public void withdraw(){
        System.out.println("enter the amount to withdraw");
        Scanner sc=new Scanner(System.in);
        int w=sc.nextInt();
        if((atm.b-w)>0){
             c=(atm.b-w);
            System.out.println("after the withdraw current balance is "+c);
            }else{
                 throw new ArithmeticException("insufficient funds");
    }
    this.b=c;       //this keyword is used to update the balance value after selecting the withdrawing process
}

}
abstract class depositing extends withdrawing implements op{
   public int e=0;

    public void deposit(){
        System.out.println("enter the deposit money");
        Scanner sc = new Scanner(System.in);
        int d=sc.nextInt();
        e=(atm.b+d);
        System.out.println("current balance is "+ e);
        this.b=e;       //this keyword is used to update the balance value after selecting the depositing process
}
}
abstract class checkbalanceing extends depositing implements op{
    public void checkbalance(){
        System.out.println("current balance is "+b);
    }
}
class bank extends withdrawing{
    public void deposit(){
        System.out.println("d");
    }
    public void checkbalance(){
        System.out.println("check");
    }
}
 class abst extends depositing{
     public void checkbalance(){
        System.out.println("check");
    }
    public void withdraw(){
        System.out.println("within");
    }
}
class ert extends checkbalanceing{
     public void withdraw(){
        System.out.println("within");
    }
     public void deposit(){
        System.out.println("d");
    }

}








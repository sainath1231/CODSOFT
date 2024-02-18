import java.util.*;
class gussnum{
public static void main(String[] args){
Random r=new Random();
Scanner sc=new Scanner(System.in);
int maxlimit=10;
System.out.println("highest number of attemps are "+maxlimit);
int rand=r.nextInt(100)+1;
//System.out.println(rand);
System.out.println("");
int j=1;
System.out.println("guss the num");
int n;


while(j<=maxlimit)
{
n=sc.nextInt();
if(n<rand){
System.out.println("the gussed num is lower than the random num");
} else if(n>rand){
System.out.println("the gussed num is higher than the random numr");

} else {
System.out.println("the gussed num is correct"+n);
if(j<=1){
System.out.println("That was quick you scored: 100 marks");
} else if(j<=4){
System.out.println("That is good you scored: 75 marks");
} else if(j<=6){
System.out.println("Not bad u scored: 50 marks");
}else {
System.out.println("Better luck next time");
}
System.exit(0);
}
System.out.println("The number of chances completed are "+j);
j++;
}
System.out.println(j);

}
}



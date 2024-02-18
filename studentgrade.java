import java.util.*;
public class studentgrade{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
System.out.println("enter number of subjects");
int n=sc.nextInt();
int m,sum=0;
for(int i=1;i<=n;i++){
System.out.println("enter the marks of subject "+i);
m=sc.nextInt();
if(m<=100){

    sum=sum+m;
} else{
    System.out.println("marks are not valid enter again");
    i--;
}
}
System.out.println("total is "+sum);
double av=0.0;
av=sum/n;
System.out.println("average is "+av);
if(av>=90){
System.out.println("u secured grade O which is outstanding");
} else if(av>=80){
System.out.println("u secured grade A which is good");
} else if(av>=60){
System.out.println("u secured grade B which is satisfying");
} else if(av>=50){
System.out.println("u secured grade C which is Sufficient");
}else if(av>=40){
System.out.println("u secured grade D which is Pass");
} else{
System.out.println("u secured grade F which says u have failed");
}

}
}

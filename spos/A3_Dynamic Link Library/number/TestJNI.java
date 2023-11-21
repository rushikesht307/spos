import java.io.*;
import java.util.Scanner;
public class TestJNI 
{

public native int add(int n1,int n2);
public native int sub(int n1,int n2);
public native int mul(int n1,int n2);
public native int div(int n1,int n2);
public static void main(String []args)throws Exception
{
TestJNI ob=new TestJNI();
System.out.println("1.Add\n2.Subtraction\n3.Multiplication\n4.Division\nENter your choice:");
Scanner sc=new Scanner(System.in);
int ch=sc.nextInt();

	switch(ch)
	{
	case 1:
		System.out.println("Enter 2 numbers");
		int a=sc.nextInt();
		int b=sc.nextInt();
		System.out.println("\nADD="+ob.add(a,b));
		break;
	case 2:
		System.out.println("Enter 2 numbers");
		a=sc.nextInt();
		b=sc.nextInt();
		System.out.println("\nSUB="+ob.sub(a,b));
		break;
	case 3:
		System.out.println("Enter 2 numbers");
		 a=sc.nextInt();
		 b=sc.nextInt();
		System.out.println("\nMUL="+ob.mul(a,b));
		break;
	case 4:
		System.out.println("Enter 2 numbers");
		 a=sc.nextInt();
		 b=sc.nextInt();
		System.out.println("\nDIV="+ob.div(a,b));
	}
}
	static 
	{
	System.loadLibrary("TestJNI");
	}
}
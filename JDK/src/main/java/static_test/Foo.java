package static_test;

//静态引用
import static static_test.Bar.*;

public class Foo {
	//static变量
	private static int c;
	
	//static静态块
	static{
		c=0;
	}
	
	//static静态方法
	public final static void inc(){
		c++;
	}
	
	//内部类
	public class Inner{
		private int i=0;
		Inner(){
			System.out.println("Inner invoked");
		}
	}
	
	//static静态内部类
	public static class StaticInner{
		private int i=1;
		private static int j=2;
		StaticInner(){
			System.out.println("static Inner invoked");
		}
	}
	
	public static void main(String[] args) {
		//static 用法
		Foo f1 = new Foo();
		Foo f2 = new Foo();
		System.out.printf("f1.c=%s,f2.c=%s%n",f1.c,f2.c);
		Foo.inc();
		System.out.printf("f1.c=%s,f2.c=%s%n",f1.c,f2.c);
		
		//静态内部类实例化
		Foo.StaticInner inner = new Foo.StaticInner();
		Foo.StaticInner inner2 = new Foo.StaticInner();
		System.out.printf("inner1.i=%d,inner1.j=%d%n", inner.i,inner.j);
		System.out.printf("inner2.i=%d,inner2.j=%d%n", inner2.i,inner2.j);
		inner.i=0;
		inner2.i=4;
		inner.j=5;
		inner2.j=6;
		System.out.printf("inner.i=%d,inner.j=%d%n", inner.i,inner.j);
		System.out.printf("inner2.i=%d,inner2.j=%d%n", inner2.i,inner2.j);
		
		//内部类实例化
		Foo.Inner inn =  f1.new Inner();
		System.out.printf("Foo.Inner.i=%d%n",inn.i);
		
		//静态方法引用
		add(1,2);
		
	}
	
}

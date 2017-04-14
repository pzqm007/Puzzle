package transient_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.Data;

@Data
public class Foo implements Serializable{
	private int w=0;
	private final int x=1;
	private static int y=2;
	private transient int z=3;
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Foo f = new Foo();
		System.out.printf("Foo.w=%d%n", f.w);
		System.out.printf("Foo.x=%d%n", f.x);
		System.out.printf("Foo.y=%d%n", f.y);
		System.out.printf("Foo.z=%d%n", f.z);
		
		FileOutputStream fos = new FileOutputStream(new File("Foo.foo"));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(f);
		
		f=null;
		oos.close();
		
		FileInputStream fis = new FileInputStream(new File("Foo.foo"));
		ObjectInputStream ois = new ObjectInputStream(fis);
		f=(Foo)ois.readObject();
		
		System.out.printf("%nFoo.w=%d%n", f.w);
		System.out.printf("Foo.x=%d%n", f.x);
		System.out.printf("Foo.y=%d%n", f.y);
		System.out.printf("Foo.z=%d%n", f.z);
		
		ois.close();
		
		
	}
}

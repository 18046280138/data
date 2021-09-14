package ylz.com.java1;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * 方法重写的规则之一：
 * 子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型
 * 原因：
 *    方法的重写，异常捕获处理的是父类，在传入子类时，调用的是子类的方法，如果子类抛出异常比父类大，则异常捕获不住（罩不住）
 * 
 * 
 */
public class OverrideTest {
	
	public static void main(String[] args) {
		OverrideTest test = new OverrideTest();
		test.display(new SubClass());
	}

	
	public void display(SuperClass s){
		try {
			s.method();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class SuperClass{
	
	public void method() throws IOException{
		
	}
	
	
}

class SubClass extends SuperClass{
	@Override
	public void method()throws FileNotFoundException{
		
	}
}

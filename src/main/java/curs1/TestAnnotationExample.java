package curs1;

import org.testng.annotations.Test;

@Test
public class TestAnnotationExample {
	
	//@Test
	public void test1() {
		System.out.println("test 1");
	}
	//@Test
	public void test2() {
		System.out.println("test 2");
	}	
	//@Test
	public void test3() {
		System.out.println("test 3");
	}	
	//@Test
	public void test4() {
		System.out.println("test 4");
	}	
	//@Test dc e private si nu are anotarea test la nivel de metoda atunci nu va fi rulata desi exista anotare la nivel de clasa
	private void test5() {
		System.out.println("test 5");
	}
	

}

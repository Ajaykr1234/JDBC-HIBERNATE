package classLoadingProcess;

public class Demo1 {
	
	public static void test() {
		System.out.println("test method started in class demo1");
		System.out.println("test method ended in class demo1");
		
		
	}
	static {
		System.out.println("Demo1 class is loaded");
	}

}

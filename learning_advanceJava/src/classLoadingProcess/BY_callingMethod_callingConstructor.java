package classLoadingProcess;

public class BY_callingMethod_callingConstructor {
	
	public static void main(String[] args) {
		System.out.println("main method started..........");
		Demo1.test();
		System.out.println("main method ended.............");
	}
	static {
		System.out.println("");
	}

}

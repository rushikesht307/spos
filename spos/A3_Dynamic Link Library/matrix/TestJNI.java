public class TestJNI{

	static{
	   System.loadLibrary("TestJNI");
	}
	// declare native method
	public native void addMatrices();
	
	public static void main(String[] args){
		
		TestJNI obj = new TestJNI();
		
		obj.addMatrices();
		
	}
	
}

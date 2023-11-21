public class TestJNI{
	static{
	   System.loadLibrary("TestJNI");
	}
	
	// Declare Native Method
	public native void reverseString();
	
	public static void main(String[] args){
		TestJNI obj = new TestJNI();
		obj.reverseString();
	}
}

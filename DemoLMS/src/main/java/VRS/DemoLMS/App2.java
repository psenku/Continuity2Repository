package VRS.DemoLMS;

public class App2 extends MyAbstract implements SampleInterface {

	
	/*
	public App2 () {
		System.out.println("App2 class constructor..");
	}
	*/
	public void iamAnInterfaceMethod() 
	{
		System.out.println("Interface method..");
		
	}
	/*
	void displayName() {
		
		System.out.println("Inside App2 class..");
	}
*/
	
	void findOnlyNonDigit(String paramStr) {
		System.out.println("Inside app2..findonlynumbers() method");
		
		String str2 = paramStr.replaceAll("\\D+","");
		System.out.println(str2);
		
	}
	
	void findOnlyDigit(String paramStr) {
		System.out.println("Inside app2..findOnlyDigit() method");
		
		String str2 = paramStr.replaceAll("\\d+","");
		System.out.println(str2);
		
	}
	
	String extractDigits(String paramStr) {
		System.out.println("Inside app2..extractDigits() method");
		StringBuilder sbr = new StringBuilder();
		
		for (int i=0;i<paramStr.length();i++) {
			
			char c = paramStr.charAt(i);
			if (Character.isDigit(c)) {
				sbr.append(c);
			}
		}
		return sbr.toString();
	}
}

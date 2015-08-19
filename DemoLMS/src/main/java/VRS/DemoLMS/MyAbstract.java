package VRS.DemoLMS;

public abstract class MyAbstract {

		MyAbstract() {
			System.out.println("Inside abstract constructor..");
		}
		void displayName() {
			
			System.out.println("Inside abstract class..");
		}
		void findOnlyNonDigit(String paramStr) {
			System.out.println("Inside abstract class..findonlynondigit() method");
			
		}
		
		void findOnlyDigit(String paramStr) {
			System.out.println("Inside app2..findonlydigit() method");
			
		}
		
		String extractDigits(String paramStr) {
			System.out.println("Inside app2..findonlydigit() method");
			return paramStr;
		}
		
		
}

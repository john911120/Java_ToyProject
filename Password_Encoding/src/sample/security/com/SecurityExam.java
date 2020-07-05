package sample.security.com;

public class SecurityExam {

	public static void main(String[] args) throws Exception {
		
		SecurityUtil securityUtil = new SecurityUtil();
		
		String rtn1 = securityUtil.encryptSHA256("hg741111#!");
		/*test*/System.out.println(">" + rtn1);
		
		String rtn2 = securityUtil.encryptSHA256("hg741111#!");
		/*test*/System.out.println(">" + rtn2);
		
		String rtn3 = securityUtil.encryptSHA256("dog13!@");
		/*test*/System.out.println(">" + rtn3);
		
		if(rtn1.equals(rtn2)) {
			/*test*/System.out.println(">>> Equals!");
		}
	}
}	

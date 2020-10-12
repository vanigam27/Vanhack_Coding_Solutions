import com.google.common.net.InternetDomainName;
import com.google.common.net.InetAddresses;
public class TestConcepts {

	public static void main (String[] args) {
		String ip = "trello.com";
		String ipv4 = "2001:0db8:85a3:0000:0000:8a2e:0370:";
		
		boolean result = InternetDomainName.isValid(ip);
		boolean resultIPaddrValidation = InetAddresses.isInetAddress(ipv4);
		System.out.println(result);
		System.out.println(resultIPaddrValidation);
	}
}

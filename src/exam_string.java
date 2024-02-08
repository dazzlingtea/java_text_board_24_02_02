import java.util.Arrays;

//query string 요청에 맞게 데이터를 처리하는 방법
public class exam_string {
	public static void main(String[] args) {
		String queryString = "a=1&b=2&c=3";
		String[] queryStringBits = queryString.split("&");
		
		// 향상된 for문
		for(String bit : queryStringBits) {
		System.out.println(bit);
		}
		
		// stream 
		Arrays.stream(queryStringBits)
			.forEach(System.out::println);
		
		// 파라미터 이름/ 파라미터 값
		int a=0, b=0, c=0;
		Integer d = null; // 객체 타입 변수는 null 가능
		
		for(String bit : queryStringBits) {
			String[] bitBits = bit.split("=");
			String paraName = bitBits[0];
			String paraValue = bitBits[1];
			
			System.out.printf("%s : %s\n", paraName, paraValue);
			
			if(paraName.equals("a")) {
				a = Integer.parseInt(paraValue);
			}
			else if(paraName.equals("b")) {
				b = Integer.parseInt(paraValue);
			}
			else if(paraName.equals("c")) {
				c = Integer.parseInt(paraValue);
			}
		}
		System.out.printf("a : %s\n", a);
		System.out.printf("b : %s\n", b);
		System.out.printf("c : %s\n", c);
	}
}

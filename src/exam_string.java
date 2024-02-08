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
	}
}

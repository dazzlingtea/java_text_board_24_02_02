import java.util.Arrays;

//query string ��û�� �°� �����͸� ó���ϴ� ���
public class exam_string {
	public static void main(String[] args) {
		String queryString = "a=1&b=2&c=3";
		String[] queryStringBits = queryString.split("&");
		
		// ���� for��
		for(String bit : queryStringBits) {
			System.out.println(bit);
		}
		
		// stream 
		Arrays.stream(queryStringBits)
			.forEach(System.out::println);
	}
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		
		// �Ķ���� �̸�/ �Ķ���� ��
		int a=0, b=0, c=0;
		Integer d = null; // ��ü Ÿ�� ������ null ����
		
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
		
		System.out.println("===============");
		
		// a=100&b....&d=10 -> d�� ��� �Ұ�, �� �߰��� ������ ������ ����
		// "c=30&a=100&b=20&d=40&e=-50"
		// a,b,c ... ����Ʈ1, 100,20,30,... �� ����Ʈ2 -> ��� ��ȿ�� -> Map �ʿ�
		List<String> paramNames = new ArrayList<>();
		List<Integer> paramValues = new ArrayList<>();
		
		// �������� ����
		for(String bit : queryStringBits) {
			String[] bitBits = bit.split("=");
			String paraName = bitBits[0];
			String paraValue = bitBits[1];
			
			paramNames.add(paraName);
			paramValues.add(Integer.parseInt(paraValue));
		}
		// ���� ���� ��
		
		for(int i=0; i < paramNames.size(); i++) {
			String paramName = paramNames.get(i);
			int paramValue = paramValues.get(i);
			
			System.out.printf("%s : %d\n", paramName, paramValue);
		}
		
		System.out.println("===============");
		// �����͸� �Ľ�, id�� �ٸ� �ε����� �־ ��µǵ��� ¥�� ��
		String queryString2 = "id=5&regDate=20230915&updateDate=20230916";
		String[] queryStringBits2 = queryString2.split("&");
		List<String> paraNames = new ArrayList<>();
		List<Integer> paraValues = new ArrayList<>();
		for(String bit : queryStringBits2) {
			String[] bitBits = bit.split("=");
			String paraName = bitBits[0];
			String paraValue = bitBits[1];
			
			paraNames.add(paraName);
			paraValues.add(Integer.parseInt(paraValue));
		}
		
		// ->id ��ġ ã�� �� value ��������(���ŷ�)
		int idIndex = paraNames.indexOf("id");
		System.out.println("id : " + paraValues.get(idIndex));
		int regDateIndex = paraNames.indexOf("regDate");
		System.out.println("regDate : " + paraValues.get(regDateIndex));
	}
}

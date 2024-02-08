import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		System.out.println("===============");
		
		// a=100&b....&d=10 -> d는 출력 불가, 즉 추가할 때마다 문제가 생김
		// "c=30&a=100&b=20&d=40&e=-50"
		// a,b,c ... 리스트1, 100,20,30,... 값 리스트2 -> 사실 비효율 -> Map 필요
		List<String> paramNames = new ArrayList<>();
		List<Integer> paramValues = new ArrayList<>();
		
		// 압축해제 시작
		for(String bit : queryStringBits) {
			String[] bitBits = bit.split("=");
			String paraName = bitBits[0];
			String paraValue = bitBits[1];
			
			paramNames.add(paraName);
			paramValues.add(Integer.parseInt(paraValue));
		}
		// 압축 해제 끝
		
		for(int i=0; i < paramNames.size(); i++) {
			String paramName = paramNames.get(i);
			int paramValue = paramValues.get(i);
			
			System.out.printf("%s : %d\n", paramName, paramValue);
		}
		
		System.out.println("===============");
		// 데이터를 파싱, id가 다른 인덱스에 있어도 출력되도록 짜야 함
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
		
		// ->id 위치 찾은 후 value 가져오기(번거롭)
		int idIndex = paraNames.indexOf("id");
		System.out.println("id : " + paraValues.get(idIndex));
		int regDateIndex = paraNames.indexOf("regDate");
		System.out.println("regDate : " + paraValues.get(regDateIndex));
		
		
		System.out.println("===============");
		/* https:// --> 프로토콜
		 * https://www.naver.com/usr/article/list
		 * ?
		 * id=5&title=aaaa&content=bbbb&writerName=홍길동 --> 쿼리 스트링
		 * /usr/article/list -> path 경로
		 */
		String queryString3 = "id=5&title=aaaa&content=bbbb&writerName=홍길동";
		String[] queryStringBits3 = queryString3.split("&");
		Map<String, String> params = new HashMap<>();
		
		for(String bit : queryStringBits3) {
			String[] bitBits = bit.split("=");
			params.put(bitBits[0], bitBits[1]); // key, value
		}
		System.out.println(params);
		System.out.printf("id : %d\n", Integer.parseInt(params.get("id")));
		System.out.printf("title : %s\n", params.get("title"));
		System.out.printf("content : %s\n", params.get("content"));
		System.out.printf("writerName : %s\n", params.get("writerName"));
		
		System.out.println("==반복문으로 전체 출력==");
		for(String paramName : params.keySet()) {
			String paramValue = params.get(paramName);
			System.out.printf("%s : %s\n", paramName, paramValue);
		}
	}
}

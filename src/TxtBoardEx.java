
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

class Article {
	int id;
	String title, content;
	
	Article(int id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
	public String toString() {
		return String.format("{id: %d, title: \"%s\", content: \"%s\"}"
				, id, title, content);
	}
}

public class TxtBoardEx {
	static void makeTestData(List<Article> articles) {
		articles.add(new Article(1, "����1", "����1"));
		articles.add(new Article(2, "����2", "����2"));
		articles.add(new Article(3, "����3", "����3"));
		
	}
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int articleLastId = 0;
    Article lastArticle = null;
    List<Article> articles = new ArrayList<>();
    
    makeTestData(articles);
    
    if(articles.size() > 0) {
    	articleLastId = articles.get(articles.size() - 1).id;
    }
    
    System.out.println("== �ڹ� �ؽ�Ʈ �Խ��� ==");
    System.out.println("== ���α׷� ���� ==");

    while (true) {
      System.out.printf("���) ");
      String cmd = sc.nextLine();
      
      if(cmd.equals("/usr/article/write")) {
    	  System.out.println("== �Խù� ��� ==");
    	  System.out.printf("���� : ");
    	  String title = sc.nextLine();
    	  
    	  System.out.printf("���� : "); 
    	  String content = sc.nextLine();
    	  
    	  int id = articleLastId + 1;
    	  articleLastId++;
    	  
    	  Article article = new Article(id, title, content);
    	  lastArticle = article;
    	  
    	  articles.add(article); // list�� �Խù� �߰�
    	  
    	  System.out.printf("%d�� �Խù��� ��ϵǾ����ϴ�.\n", id);
    	  continue;
      }
      else if(cmd.equals("/usr/article/list")) {
    	  System.out.println("==�Խù� ����Ʈ==");
    	  // �ֱ� �Խù��� ����Ʈ ���� �־�� �� 3->2->1����
    	  for(int i = articles.size() - 1; i >= 0; i--) {
    		  Article article = articles.get(i);
    		  System.out.println(article.id+" / "+article.title);
    	  }
    	  /* ���� for�� ������ ����
    	  for(Article article : articles) {
    		  System.out.printf("%d / %s", article.id, article.title);
    	  }*/
    	  
      }
      else if(cmd.equals("/usr/article/detail")) {
    	  if(lastArticle == null) {
    		  System.out.println("�Խù��� �������� �ʽ��ϴ�."); 
    		  continue;
    	  }
    	  
    	  Article article = lastArticle;
    	  
    	  System.out.println("==�Խù� �󼼺���==");
    	  System.out.printf("��ȣ:%d\n����:%s\n����:%s\n",
    			  article.id, article.title, article.content);
    	  continue;
      }
      else if(cmd.equals("exit")) {
        System.out.println("���α׷��� �����մϴ�.");
        break;
      }
      
      
      System.out.printf("�Է� �� ��ɾ� : %s\n", cmd);
    }

    sc.close();
  }
}
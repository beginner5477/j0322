package practice;

public class Prac3Run {
	public static void main(String[] args) {
		Prac3DAO dao = new Prac3DAO();
		
		System.out.println("데이터베이스 연동 작업중...");
		
		Prac3Service service = new Prac3Service();
		
		service.something();
		
		dao.connClose();
	}
}

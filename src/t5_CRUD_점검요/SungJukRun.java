package t5_CRUD_점검요;

import java.util.Scanner;

public class SungJukRun {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SungjukService service = new SungjukService();
		
		int choice = 0;
		boolean run = true;
		
		while(run)
		{
			System.out.println("** 성 적 표 **");
			System.out.print("처리할 작업 선택? 1.입력 2.전체조회 3.개별조회 4.수정 5.삭제 0.종료 =>");
			choice = sc.nextInt();
			
			switch (choice) 
			{
				//자료입력
				case 1:
					service.setSungjukInput();
					break;
				//성적 조회
				case 2:
					service.getSungjukList();
					break;
				//개별 성적 조회	
				case 3:
//					service.getSearch();
					break;
				//수정하기
				case 4:
//					service.setInput();
					break;
				//삭제하기
				case 5:
//					service.setInput();
					break;
				default:
					run = false;
					break;
			}
		}
		
		System.out.println("작업끝.");
		sc.close();
	}
}

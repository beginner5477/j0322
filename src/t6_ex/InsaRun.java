package t6_ex;

import java.util.Scanner;

public class InsaRun {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		InsaService service = new InsaService();
		boolean run = true;
		while(run)
		{
			System.out.print("원하는 메뉴를 선택하세요(1.조회 2.등록 3.수정 4.삭제 5.종료): ");
			int ans = sc.nextInt();
			switch(ans)
			{
				//사원 전체 조회
				case 1:
					service.getList();
					break;
				case 2:
					service.setSalary();
					break;
				case 3:
//					service.setEdit();
					break;
				case 4:
//					service.setDelete();
					break;
				case 5:
					run = false;
					break;
				default :
					System.out.println("입력이 잘못되었습니다. 다시입력해주세요.");
					break;
			}
			
		}
		System.out.println("프로그램 종료.");
		sc.close();
	}
}

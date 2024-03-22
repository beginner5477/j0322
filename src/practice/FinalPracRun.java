package practice;

import java.util.Scanner;

public class FinalPracRun {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FinalPracService service = new FinalPracService();
		
		exit:while(true)
		{
			System.out.print("어떤 작업을 하시겠습니까? 1.데이터등록 2.전체조회 3.개별조회 4.수정 5.삭제 6.종료: ");
			int ans = sc.nextInt();
			
			switch(ans)
			{
				case 1:
					service.setInsert();
					break;
				case 2:
					service.getList();
					break;
				case 3:
					service.getSearch();
					break;
				default:
					break exit;
			}
			
			
			
		}
		sc.close();
	}
}

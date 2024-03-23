package t6_ex;

import java.util.ArrayList;
import java.util.Scanner;

public class SalaryService {
	Scanner sc = new Scanner(System.in);
	SalaryDAO dao = new SalaryDAO();
	SalaryVO vo = new SalaryVO();
	
	String ans = "";
	String ans3 = "";
	int ans2 = 0, res = 0;
	//자료 전체 조회
	public void getList() {
		ArrayList<SalaryVO> vos = new ArrayList<>();
		vos = dao.getList();
		System.out.println("직급\t본봉");
		System.out.println("=======================================");
		for(int i = 0; i < vos.size(); i++)
		{
			System.out.println(vos.get(i).getJikkub()+"\t"+vos.get(i).getBonbong());
		}
	}
	
	//자료 등록
	public void setSalary() {
		while(true)
		{
			System.out.print("직급 입력하세요(-1입력은 메뉴로 돌아가기):");
			ans = sc.next();
			if(ans.equals("-1")) break;
			vo = dao.salarySearch(ans);
			if(vo.getBonbong() == -1) break;
			else System.out.println("이미 존재하는 직급입니다, 다른 직급을 입력해주세요.");
		}
		if(!ans.equals("-1"))
		{
			System.out.print("본봉을 입력하세요:");
			ans2 = sc.nextInt();
			res = dao.setSalary(ans, ans2);
			if(res == 0) System.out.println("자료 등록 실패하였습니다.");
			else System.out.println("자료 등록 성공~");
		}
	}

	//자료 수정
	public void setEdit() {
		while(true)
		{
			System.out.print("직급 입력하세요(-1입력은 메뉴로 돌아가기):");
			ans = sc.next();
			if(ans.equals("-1")) break;
			vo = dao.salarySearch(ans);
			if(vo.getBonbong() != -1) break;
		}
		if(!ans.equals("-1"))
		{
			System.out.print("수정할 항목을 입력하세요(1.직급 2.본봉):");
			ans2 = sc.nextInt();
			switch(ans2)
			{
				case 1:
					System.out.print(ans+"를 무엇으로 수정할지 입력하세요: ");
					vo.setJikkub(sc.next());
					break;
				case 2:
					System.out.print(ans+"의 본봉을 얼마로 수정할지 입력하세요: ");
					vo.setBonbong(sc.nextInt());
			}
			res = dao.setSalaryEdit(vo,ans);
			if(res != 0) System.out.println("수정이 완료되었습니다.");
			else System.out.println("수정 실패 되었습니다.");
		}
		
	}
	
	//자료 삭제하기
	public void setDelete() {
		while(true)
		{
			System.out.print("직급 입력하세요(-1입력은 메뉴로 돌아가기):");
			ans = sc.next();
			if(ans.equals("-1")) break;
			vo = dao.salarySearch(ans);
			if(vo.getBonbong() != -1) break;
		}
		if(!ans.equals("-1"))
		{
			System.out.println("직급\t본봉");
			System.out.println("=======================================");
			System.out.println(vo.getJikkub()+"\t"+vo.getBonbong());
			System.out.println("삭제하시겠습니까?(Y/N)");
			ans3 = sc.next();
			if(ans3.toUpperCase().equals("Y")) 
			{
				res = dao.setDelete(vo);
				if(res != 0) System.out.println("삭제 성공.");
				else System.out.println("삭제 실패");
			}
			else if(ans3.toUpperCase().equals("N")) System.out.println("삭제 취소 처리 되었습니다.");
			else System.out.println("입력이 잘못되었습니다. 다시 시작해주세요.");
		}
		
	}
}

package t6_ex;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class InsaService {
	Scanner sc = new Scanner(System.in);
	InsaDAO dao = new InsaDAO();
	InsaVO vo = new InsaVO();
	int res = 0;
	
	//전체 조회
	public void getList() {
		ArrayList<InsaVO> vos = new ArrayList<InsaVO>();
		vos = dao.getList();
		System.out.println("인덱스\t사번\t\t부서\t성명\t직급\t나이\t입사일\t\t성별\t주소");
		for(int i = 0; i < vos.size(); i++)
		{
			System.out.println(vos.get(i).getIdx()+"\t"+vos.get(i).getSabun()+"\t"+vos.get(i).getBuseo()+
					"\t"+vos.get(i).getName()+"\t"+vos.get(i).getJikkub()+"\t"+vos.get(i).getAge()+"\t"+
					vos.get(i).getIpsail()+"\t"+vos.get(i).getGender()+"\t"+vos.get(i).getAddress());
		}
	}

	//자료 등록
	public void setSalary() {
		System.out.println("**자료등록하기**");
		System.out.print("부서: "); vo.setBuseo(sc.next());
		System.out.print("성명: "); vo.setName(sc.next());
		System.out.print("직급: "); vo.setJikkub(sc.next());
		System.out.print("나이: "); vo.setAge(sc.nextInt());
		System.out.print("입사일: "); vo.setIpsail(sc.next());
		System.out.print("성별: "); vo.setGender(sc.next());
		System.out.print("주소: "); vo.setAddress(sc.next());
		int cnt = dao.DateSearch(vo.getIpsail());
		String cnt1 = "";
		if(cnt<10) cnt1 = "0"+(cnt+1);
		else cnt1 = (cnt+1)+"";
		vo.setSabun(vo.getIpsail().substring(2,4)+vo.getIpsail().substring(5,7)+vo.getIpsail().substring(8,10)+cnt1);
		res = dao.setSalary(vo);
		if(res != 0) System.out.println("자료 등록 성공~");
		else System.out.println("자료 등록 실패..");
	}

}

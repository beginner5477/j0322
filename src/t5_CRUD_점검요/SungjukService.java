package t5_CRUD_점검요;

import java.util.ArrayList;
import java.util.Scanner;

public class SungjukService {
	Scanner sc = new Scanner(System.in);
	SungjukDAO dao = new SungjukDAO();
	SungjukVO vo = null;
	int res = 0;
	String ans = "N", name = "";
	//성적 입력
	public void setSungjukInput() {
		vo = new SungjukVO();
		String name;
		int kor = 0, eng = 0, mat = 0;
		while(true) 
		{
			while(true)
			{
				System.out.print("이름을 입력해주세요:");
				name = sc.next();
				vo.setName(name);
				vo = dao.getSungjukSearch(vo.getName());
				if(vo == null) break;
				else System.out.println("동명2인이 존재합니다. 다시입력하세요.");
			}
				System.out.print("국어 점수를 입력해주세요:");
				kor = sc.nextInt();
				System.out.print("영어 점수 입력해주세요:");
				eng = sc.nextInt();
				System.out.print("수학 점수 입력해주세요:");
				mat = sc.nextInt();
				
				vo = new SungjukVO();
				
				vo.setName(name);
				vo.setKor(kor);
				vo.setEng(eng);
				vo.setMat(mat);
				res = dao.setSungjukInput(vo);
				if(res != 0) System.out.println("등록 완료되었습니다.");
				else System.out.println("등록 실패하였습니다.");
				
			System.out.print("계속하시겠습니까?(Y/N)");
			ans = sc.next();
			if(ans.toUpperCase().equals("N")) break;
			else if(ans.toUpperCase().equals("Y")) continue;
			else System.out.println("입력이 잘못되었습니다. ReStart");
		}
		
	}
	public void getSungjukList() {
		 ArrayList<SungjukVO> vos = dao.getSungjukList();
		 for(int i = 0; i < vos.size(); i++)
		 {
			 System.out.print("번호: "+vos.get(i).getIdx()+"\t");
			 System.out.print("name: "+vos.get(i).getName()+"\t");
			 System.out.print("kor: "+vos.get(i).getKor()+"\t");
			 System.out.print("eng: "+vos.get(i).getEng()+"\t");
			 System.out.print("mat: "+vos.get(i).getMat()+"\t");
			 System.out.print("총점: "+(vos.get(i).getMat()+vos.get(i).getEng()+vos.get(i).getKor())+"\t");
			 System.out.print("평균: "+ String.format("%.1f",((vos.get(i).getMat()+vos.get(i).getEng()+vos.get(i).getKor()) / 3.0))+"\t");
			 System.out.println();
		 }
	}

}

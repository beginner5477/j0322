package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class FinalPracService {
	Scanner sc = new Scanner(System.in);
	public void setInsert() {
		FinalPracDAO dao = new FinalPracDAO();
		FinalPracVO vo = new FinalPracVO();
		System.out.print("성명을 입력해주세요:");
		vo.setName(sc.next());
		System.out.print("나이를 입력해주세요:");
		vo.setAge(sc.nextInt());
		System.out.print("성별을 입력해주세요:");
		vo.setGender(sc.next());
		System.out.print("주소를 입력해주세요:");
		vo.setAddress(sc.next());
		dao.setInsert(vo);
		
		dao.connClose();
	}
	public void getList() {
		FinalPracDAO dao = new FinalPracDAO();
		ArrayList<FinalPracVO> vos = dao.getList();
		for(int i = 0; i < vos.size(); i++)
		{
			System.out.print(vos.get(i).getIdx()+"\t"); 
			System.out.print(vos.get(i).getName()+"\t"); 
			System.out.print(vos.get(i).getAge()+"\t"); 
			System.out.print(vos.get(i).getGender()+"\t"); 
			System.out.print(vos.get(i).getAddress()+"\t"); 
			System.out.println();
		}
		
	}
	public void getSearch() {
		FinalPracDAO dao = new FinalPracDAO();
		System.out.print("성명을 입력해주세요:");
		String name = sc.next();
		FinalPracVO vo = dao.getSearch(name);
		if(vo.getName() == null) System.out.println(name+"으로 검색된 자료가 없습니다.");
		else 
		{
			System.out.println("성명: "+vo.getName());
			System.out.println("나이: "+vo.getAge());
			System.out.println("성별: "+vo.getGender());
			System.out.println("주소: "+vo.getAddress());
		}
	}


}

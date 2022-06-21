package blood.transfusion.view;

import java.util.Scanner;

import blood.transfusion.contoller.BTController;
import blood.transfusion.dto.BTProjectDTO;
import blood.transfusion.dto.DonorDTO;
import blood.transfusion.dto.RecipientDTO;

public class RunningStartView {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num =0;
		BTController controller = BTController.getInstance();
		// 헌혈자
		DonorDTO donor4 = new DonorDTO("donor4", "헌혈4", 52, "M", "AB-", "실험");
		// 수혈자
		RecipientDTO recipient4 = new RecipientDTO("recipient4", "수혈4", 83, "M", "AB-", "수술");
		// 새로운 헌혈 프로젝트
		BTProjectDTO newProject= new BTProjectDTO("AB-", "bt4", donor4.getId(), recipient4.getId(), "응급 처치 프로젝트");
		
//		System.out.println("=====모든 프로젝트 검색=====");
		controller.allBTProjects();
//		System.out.println("=====특정 프로젝트 검색=====");
//		controller.projectView("bt1");
//		System.out.println("=====특정 프로젝트 추가=====");
//		controller.addProject(donor4,recipient4,newProject);
//		System.out.println("=====특정 프로젝트 수정=====");
//		controller.updateProject("bt4","수정됨!!!!!");
//		controller.projectView("bt4");
//		System.out.println("=====특정 프로젝트 삭제=====");
////		controller.deleteProject("bt4");
//		controller.projectView("bt4");
		
		System.out.println("1.고객 메뉴");
		System.out.println("2.룸 메뉴");
		System.out.println("3.예약 메뉴");
		num = scan.nextInt();
		System.out.flush();
		System.out.println(num);
		
		
	}
}

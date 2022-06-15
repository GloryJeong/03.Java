package blood.transfusion.view;

import blood.transfusion.contoller.BTController;
import blood.transfusion.dto.BTProjectDTO;
import blood.transfusion.dto.DonorDTO;
import blood.transfusion.dto.RecipientDTO;

public class RunningStartView {

	public static void main(String[] args) {
		BTController controller = BTController.getInstance();
		// 헌혈자
		DonorDTO donor4 = new DonorDTO("donor4", "헌혈4", 52, "M", "AB-", "실험");
		// 수혈자
		RecipientDTO recipient4 = new RecipientDTO("recipient4", "수혈4", 83, "M", "AB-", "수술");
		// 새로운 헌혈 프로젝트
		BTProjectDTO newProject= new BTProjectDTO("AB-", "bt4", donor4.getId(), recipient4.getId(), "응급 처치 프로젝트");
		
		System.out.println("=====모든 프로젝트 검색=====");
		controller.allBTProjects();
		
		System.out.println("=====특정 프로젝트 검색=====");
		controller.projectView("B-!");
		System.out.println("=====특정 프로젝트 추가=====");
		controller.addProject(donor4,recipient4,newProject);
		System.out.println("=====특정 프로젝트 수정=====");
		controller.updateProject("AB-!","수정됨!!!!!");
		controller.projectView("AB-");
		System.out.println("=====특정 프로젝트 삭제=====");
		controller.deleteProject("AB-");
		controller.projectView("AB-");
		
	}
}

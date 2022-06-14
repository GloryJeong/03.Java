package blood.transfusion.controller;

import java.util.ArrayList;

import blood.transfusion.dto.BloodTransfusionProject;
import blood.transfusion.dto.People;
import blood.transfusion.dto.Recipient;
import blood.transfusion.exception.NotExistException;
import blood.transfusion.model.BloodTransfusionVirtualDB;
import blood.transfusion.service.BloodTransFusionProjectService;
import blood.transfusion.view.EndView;
import blood.transfusion.view.FailView;

public class BloodTransfusionController {
	private static BloodTransfusionController instance = new BloodTransfusionController();
	private BloodTransFusionProjectService service = BloodTransFusionProjectService.getInstance();
	private ArrayList<BloodTransfusionProject> projectList = BloodTransfusionVirtualDB.getInstance().getProjectList();
	private BloodTransfusionController() {}

	public static BloodTransfusionController getInstance() {
		return instance;
	}

	// 모든 프로젝트 검색
	public void projectListView() {
		ArrayList<BloodTransfusionProject> projectList = this.projectList;
		EndView.projectListView(projectList);
	}
	
	// 특정 프로젝트 검색_
	public void projectView(String projectName) {
		try {
			EndView.projectListView(service.getProject(projectName));
		} catch (NotExistException e) {
			FailView.failMessageView("Project가 존재하지 않습니다");
		}
		
	}

	// 새로운 프로젝트 저장
	public void insertProject(BloodTransfusionProject newProject) {
		service.projectInsert(newProject);
	}
	
	// 존재하는 프로젝트 수정_
	public void updateProject(String projectName, People people)  {
		try {
			service.projectUpdate(projectName,people);
		} catch (NotExistException e) {
			FailView.failMessageView("수정하고자 하는 Project가 존재하지 않습니다");
		}
	}

	// 이름으로 검색한 프로젝트 삭제_
	public void deleteProject(String projectName) {
		try {
			service.projectDelete(projectName);
		} catch (NotExistException e) {
			FailView.failMessageView("Project가 존재하지 않습니다");
		}
	}
}





























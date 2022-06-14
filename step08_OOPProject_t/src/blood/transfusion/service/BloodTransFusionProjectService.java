package blood.transfusion.service;

import java.util.ArrayList;

import blood.transfusion.dto.BloodTransfusionProject;
import blood.transfusion.dto.Donor;
import blood.transfusion.dto.People;
import blood.transfusion.dto.Recipient;
import blood.transfusion.exception.NotExistException;
import blood.transfusion.model.BloodTransfusionVirtualDB;

public class BloodTransFusionProjectService {
	private static BloodTransFusionProjectService instance = new BloodTransFusionProjectService();
	private BloodTransfusionVirtualDB projectVirtualData = BloodTransfusionVirtualDB.getInstance();

	private BloodTransFusionProjectService(){}
	public static BloodTransFusionProjectService getInstance(){
		return instance;
	}
	
	// 모든 프로젝트 반환
	public ArrayList<BloodTransfusionProject> getAllProjects(){
		return projectVirtualData.getProjectList();
	}
	
	// 프로젝트 검색_
	public ArrayList<BloodTransfusionProject> getProject(String projectName) throws NotExistException {
//		BloodTransfusionProject project = null;
		ArrayList<BloodTransfusionProject> selectProjectList =new ArrayList<BloodTransfusionProject>();
		if(!this.projectVirtualData.getProjectList().isEmpty()) {
			this.projectVirtualData.getProjectList().stream().filter(v->projectName.equals(v.getBtProjectName())).forEach(v->{
				selectProjectList.add(v);});
			if(selectProjectList.isEmpty()) {
				throw new NotExistException(projectName+" 프로젝트는 없음");
			}
		}else {
			// 프로젝트가 하나도 없을경우
			System.out.println("프로젝트 없음");
		}
		return selectProjectList;
	}

	// 새로운 프로젝트 추가
	public void projectInsert(BloodTransfusionProject newProject) {
		projectVirtualData.insertProject(newProject);
	}
	
	// 프로젝트 수정 - 프로젝트 명으로 현혈자 혹은 수혈자 수정_
	public void projectUpdate(String projectName, People people) throws NotExistException{
		ArrayList<BloodTransfusionProject> updateProject=getProject(projectName);
		if(!updateProject.isEmpty()) {
			if(people instanceof Recipient) {
				updateProject.stream().forEach(v->
						v.setRecipient((Recipient)people)
					);
			}else if(people instanceof Donor) {
				updateProject.stream().forEach(v->
						v.setDonor((Donor)people)
					);
			}
		}else {
			throw new NotExistException();
		}
	}
	
	// 프로젝트 삭제_
	public void projectDelete(String projectName) throws NotExistException{
		getProject(projectName).stream().forEach(v->{
			getAllProjects().remove(v);
			System.out.println("해당 Project가 삭제되었습니다");
			});
	}	
}

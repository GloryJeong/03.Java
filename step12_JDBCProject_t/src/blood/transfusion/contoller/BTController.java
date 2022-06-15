package blood.transfusion.contoller;


import java.sql.SQLException;
import java.util.ArrayList;

import blood.transfusion.dto.BTProjectDTO;
import blood.transfusion.dto.DonorDTO;
import blood.transfusion.dto.PeopleDTO;
import blood.transfusion.dto.RecipientDTO;
import blood.transfusion.exception.ExistException;
import blood.transfusion.exception.NotExistException;
import blood.transfusion.model.BTProjectDAO;
import blood.transfusion.model.BTService;
import blood.transfusion.model.DonorDAO;
import blood.transfusion.view.RunningEndView;
//import blood.transfusion.view.RunningSuccessView;
import blood.transfusion.view.RunningSuccessView;

public class BTController {
	private static BTController instance = new BTController();
	private BTService service = BTService.getInstance();
	
	private BTController() {}
	
	public static BTController getInstance() {
		return instance;
	}
	
	// 모든 프로젝트 검색
	public void allBTProjects(){
		try{
			RunningEndView.projectListView(service.getAllBTProjects());
			RunningSuccessView.showSuccess("모든 프로젝트 검색 성공");
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("모든 프로젝트 검색시 에러 발생");
		}
	
	}
	
	// 특정 프로젝트 검색
	public void projectView(String BtProjectId) {
		try {
			RunningEndView.projectView(service.getBTProject(BtProjectId));
			RunningSuccessView.showSuccess("검색 성공!!!!");
		}catch(SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("검색한 프로젝트가 없음");
		}catch(NotExistException e) {
			RunningEndView.showError(e.getMessage());
		}
	}
	
	// 새로운 프로젝트 저장 로직
	public void addProject(DonorDTO donor,RecipientDTO recipient,BTProjectDTO newProject) {
		try {
			service.addDonor(donor);
			service.addRecipient(recipient);
			service.addBTProject(newProject);
			RunningSuccessView.showSuccess("저장 성공!!!!");
		} catch (SQLException e) {
//			e.printStackTrace();
			RunningEndView.showError("추가실패");
		} catch(ExistException e) {
			RunningEndView.showError(e.getMessage());
		} catch(NotExistException e) {
			RunningEndView.showError("추가실패");
		}
	}
	
	// 특정 프로젝트 업데이트
	public void updateProject(String BTProjectName,String btContent) {
		try {
			service.updateBTProject(BTProjectName, btContent);
			RunningSuccessView.showSuccess("업데이트 성공!!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NotExistException e) {
			RunningEndView.showError("존재하지 않는 프로젝트");
		}
	}
	
	// 특정 프로젝트 삭제
	public void deleteProject(String BTProjectName)  {
		BTProjectDTO project = null;
		String donorId = null;
		String recipientId = null;
		try {
			project= service.getBTProject(BTProjectName);
			if(project != null) {
				donorId = project.getDonorId();
				recipientId = project.getRecipientId();
			}
			service.deleteBTProject(BTProjectName);
			service.deleteDonor(donorId);
			service.deleteRecipient(recipientId);
			RunningSuccessView.showSuccess("삭제 성공!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotExistException e) {
			e.printStackTrace();
			RunningEndView.showError("존재하지 않는 프로젝트");
		}
	}
	
	// 모든 헌혈자 검색 로직
	public ArrayList<DonorDTO> getAllDonors(){
		ArrayList<DonorDTO> allProject = null;
		try{
			RunningEndView.projectListView(DonorDAO.getAllDonors());
			RunningSuccessView.showSuccess("모든  헌혈자 검색 성공");
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("모든  헌혈자 검색시 에러 발생");
		}
		return allProject;
	}
	
}

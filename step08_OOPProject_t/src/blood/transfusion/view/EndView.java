package blood.transfusion.view;

import java.util.ArrayList;

import blood.transfusion.dto.BloodTransfusionProject;

public class EndView {
	
	//특정 프로젝트 출력_
//	public static void projectView(ArrayList<BloodTransfusionProject> project) {
//		project.stream().forEach(System.out::println);
//	}
	
	//모든 프로젝트 출력_
	public static void projectListView(ArrayList<BloodTransfusionProject> allBTPrjoects) {
		allBTPrjoects.stream().forEach(v->System.out.println(v));
	}
	
	//예외가 아닌 단순 메세지 출력
	public static void messageView(String message) {
		System.out.println(message);
	}
}












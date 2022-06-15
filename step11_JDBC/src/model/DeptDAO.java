package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import model.domain.DeptDTO;
import util.DBUtil;

public class DeptDAO {
   // step01*
   // Driver 로딩
   // 표준 (형식정해져있음) - Class.forName("com.mysql.cj.jdbc.Driver");
//   static {
//      try {
//         Class.forName("com.mysql.cj.jdbc.Driver");
//      } catch (ClassNotFoundException e) {
//         e.printStackTrace();
//      }
//   }
   // 정보를 얻을때는 void타입은 X
   // 하나만 반환할때는 DeptDTO라고 정의해도 되지만 여러개를 할땐 ArrayList사용
   // 모든 부서 모든 정보 검색 메소드
   // Query : "select * from dept"
   public static ArrayList<DeptDTO> getAllDept() throws SQLException {
      ArrayList<DeptDTO> allData =  null;
      Connection conn = null; //conn이 없을때는 생성되지 않도록 하려고 미리 선언
      Statement stmt = null;
      ResultSet rset = null;
      
   try {
      // step02*
      // DB연결
      // ip주소, DB 이름, 계정 이름/비밀번호, ....
   
//      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott","scott","tiger");
	   conn = DBUtil.getConnection();
      
      // step03
      // SQL 문장 객체
      // Statement - java.sql패키지
      stmt = conn.createStatement();
      
      // step04
      // SQL 문장 객체 실행
      rset = stmt.executeQuery("select * from dept");
      
      // step05
      // Data 활용
      allData = new ArrayList<DeptDTO>();
      while(rset.next()) {
         allData.add(new DeptDTO(rset.getInt("DEPTNO"), rset.getString("DNAME"),rset.getString("LOC")));
      }
      
//      conn.commit();
      
      // step06*
      // DB 종료
   }finally {
	   // 자원을 가져다가 썼으니깐 close해줘야 함
      DBUtil.close(rset,stmt,conn);
   }
      return allData;
}
   
   
   
   // 실습! 부서이름으로 특정 부서 검색
   public static DeptDTO getDept(String DNAME) throws SQLException {
//      DeptDTO dto = null;
//      ArrayList<DeptDTO> allDTO = getAllDept();
//      for(int i = 0; i < allDTO.size(); i++) {
//         if(allDTO.get(i).getDNAME() != null && allDTO.get(i).getDNAME().equals(DNAME)) {
//            dto = allDTO.get(i);
//            return dto;
//         }
//      }
//      
//      return null;
      
      //강사님 코드
      Connection conn = null; 
      // ver1
//      Statement stmt = null;
      
      // ver2
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      DeptDTO data = null;
      
      try {
    	  conn = DBUtil.getConnection();
         // ver1
//         stmt = conn.createStatement();
//         rset = stmt.executeQuery("select * from dept where dname = '" + DNAME + "'");
         
         // ver2
         // 1 -> ?가 들어가는 위치  x -> DNAME
         pstmt = conn.prepareStatement("select * from dept where dname = ?");
         pstmt.setString(1, DNAME);
         
         rset = pstmt.executeQuery();
         
         data = new DeptDTO();
         while(rset.next()) {
            data = new DeptDTO(rset.getInt("DEPTNO"), rset.getString("DNAME"),rset.getString("LOC"));
         }
      }finally {
         DBUtil.close(rset, pstmt, conn);
         
      }
      return data;
      
   }
   
   // 부서 생성 메소드
   // Query : insert into dept values(deptno,dname,loc);
   
   public static boolean insertDept(DeptDTO dept) throws SQLException {
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   try {
		   conn = DBUtil.getConnection();
		   pstmt = conn.prepareStatement("insert into dept values(?,?,?)");
		   
		   pstmt.setInt(1, dept.getDeptno());
		   pstmt.setString(2, dept.getDname());
		   pstmt.setString(3, dept.getLoc());
		   
		   int r =pstmt.executeUpdate();		   
		   if(r != 0) {
			   return true;
		   }
	   }finally {
		   DBUtil.close(pstmt, conn);
	   }
	   
	   return false;
   }
   
   // 부서 수정 메소드
   // Query : update dept set 변경컬럼 = "내용" where deptno = ?;
   public static boolean updateDept(int deptno, String loc) throws SQLException {
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   try {
		   conn = DBUtil.getConnection();
		   pstmt = conn.prepareStatement("update dept set loc =?  where deptno = ?");
		   
		   pstmt.setString(1, loc);
		   pstmt.setInt(2, deptno);
		   
		   int r =pstmt.executeUpdate();
		   
		   if(r != 0) {
			   return true;
		   }
		   
	   }finally {
		   DBUtil.close(pstmt, conn);
	}
	   return false;
   }
   
   
   // 부서 삭제 메소드
   // Query : delete from dept where deptno = ?
   public static boolean deleteDept(int deptno) throws SQLException {
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   try {
		   conn = DBUtil.getConnection();
		   pstmt = conn.prepareStatement("delete from dept where deptno = ?");
		   
		   pstmt.setInt(1, deptno);
		   
		   int r = pstmt.executeUpdate();
		   if(r != 0) {
			   return true;
		   }
		   
	   }finally {
		   DBUtil.close(pstmt, conn);
	}
	   
	   return false;
   }
   
  public static ArrayList<HashMap<String, String>> selectSal(int sal) throws SQLException{
	  Connection conn = null;
	  PreparedStatement pstmt = null;
	  ResultSet rset = null;
	  ArrayList<HashMap<String, String>> resultList = new ArrayList<HashMap<String,String>>();
	  HashMap<String, String> result = new HashMap<String, String>();
	  
	  try {
		  conn = DBUtil.getConnection();
		  pstmt = conn.prepareStatement("select e.deptno,ename,SAL from emp as e join dept as d on e.deptno=d.deptno"
		  		+ " where sal>?");
		  
		 pstmt.setInt(1, sal);
		 
		 rset=pstmt.executeQuery();
		 ResultSetMetaData rsmd = rset.getMetaData();
		 int columnCnt = rsmd.getColumnCount();
		 String columnName;
		 while(rset.next()) {
			 System.out.println(rset);
			 result.clear();
			 for(int i = 1;i<=columnCnt;i++) {
				 columnName = rsmd.getColumnName(i);
				 result.put(columnName,rset.getString(columnName == "DEPTNO"?"e.DEPTNO":columnName));
			 }
			 resultList.add(result);
		 }
		 return resultList;
	  }finally {
		DBUtil.close(rset, pstmt, conn);
		
	}
  }
   
   
   public static void main(String[] args) {
      try {
         //모든 부서 검색
         for(DeptDTO dept : getAllDept()) {
//            System.out.println(dept);      
         } 
         
         // (부서 이름으로) 특정 부서를 검색
         // getDept(String dname)
//         System.out.println(getDept("SALES"));
         
         // 부서 생성
         // insertDept(Dept dept);
//         System.out.println(insertDept(new DeptDTO(50,"PROGRAMMING","BUSAN")));
         
      // (부서 번호로) 검색한 해당 부서의 위치 수정
//          updateDept(50, "SEOUL") : BUSAN -> SEOUL
//         System.out.println(updateDept(50, "SEOUL"));
         
         // (부서 번호로) 검색한 해당 부서 삭제
//          deleteDept(50);
         
         // join으로 
         System.out.println(selectSal(1500));
      }catch(SQLException e){
         e.printStackTrace();
      }
   }
}
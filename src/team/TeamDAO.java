package team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class TeamDAO {
	
	Vector<UserDTO> vetList = new Vector<UserDTO>();
 //adasd
	
	
	
	
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##java";
		String password = "12345";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}//

	// userTBL 데이터 모두 가져오기
	public Vector<UserDTO> select1(String username,String password) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

		try {

			con = getConnection();

			String sql = "select * from userTable";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserDTO userdto = new UserDTO();
				userdto.setUserID(rs.getString("UserID"));
				userdto.setUserNm(rs.getInt("UserNm"));
				userdto.setUserPw(rs.getString("UserPw"));
				userdto.setUserName(rs.getString("UserName"));
				userdto.setUserEm(rs.getString("UserEm"));
				vetList.add(userdto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return vetList;
	}//select1
	
	
	///board테이블 가져오기
	public Vector<BoardDTO> select2() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<BoardDTO> boardList = new Vector<BoardDTO>();

		try {

			con = getConnection();

			String sql = "select * from BoardTable";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO boarddto = new BoardDTO();
				boarddto.setBoardNm(rs.getInt("BoardNm"));
				boarddto.setBoardTitle(rs.getString("BoardTitle"));
				boarddto.setBoardSub(rs.getString("BoardSub"));
				boarddto.setUserNm(rs.getInt("UserNm"));
				boarddto.setBoardDate(rs.getDate("BoardDate"));
				boarddto.setBoardCount(rs.getInt("BoardCount"));
				boardList.add(boarddto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return boardList;
	}//select 2
	//로그인함수
	public boolean loginUser(String username,String password) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean loginFlag = false;
		try {
			con =getConnection();
			String sql="select UserPw from userTable where UserID = ?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,username);
			
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("UserPw").equals(password)) {
					loginFlag =true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return loginFlag;
	}//insertuser
	
	//신입 회원입력
		public boolean insertUser(UserDTO userinsert) {
			Connection con = null;
			PreparedStatement pstmt = null;
			boolean insertFlag = false;
			try {
				con =getConnection();
				String sql="insert into userTable(userID,userNm,userPw,userName,userEm)";
				sql+="values(?,userNm_SEQ.nextval,?,?,?)";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,userinsert.getUserID());
				pstmt.setString(2,userinsert.getUserPw());
				pstmt.setString(3, userinsert.getUserName());
				pstmt.setString(4, userinsert.getUserEm());
				int result=pstmt.executeUpdate();
				if (result>0) {
					insertFlag=true;
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					pstmt.close();
					con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			return insertFlag;
		}//insertuser
		
		
		
		public boolean idCheck(String id ) {
			Connection con = null;
	PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean idflag = true;
				
			
			try {
				con=getConnection();
			pstmt=con.prepareStatement("Select * from UserTable where Userid = ?");
			pstmt.setString(1, id);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getString("UserPw").equals(id)) {
						idflag =true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {try {
				
				pstmt.close();
				con.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
				
			}
			return idflag;
			}
		
		
		
		
	
}//teamdao

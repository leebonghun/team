package team;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;

public class TeamDAO {

	Vector<UserDTO> vetList = new Vector<UserDTO>();
	// adasd

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
	public Vector<UserDTO> select1(String username, String password) {
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
	}// select1

	/// board테이블 가져오기
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
	}// select 2

	public BoardDTO select3(int no, int userNm) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<BoardDTO> boardList = new Vector<BoardDTO>();
		BoardDTO boarddto = new BoardDTO();
		try {

			con = getConnection();

			String sql = "select * from BoardTable where boardNm = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				boarddto.setBoardTitle(rs.getString("BoardTitle"));
				boarddto.setUserNm(rs.getInt("userNm"));
				boarddto.setBoardSub(rs.getString("BoardSub"));

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
		return boarddto;
	}// select 3

	public boolean update1(BoardDTO updateuser) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;

		try {
			String sql = "update BoardTable set boardTitle=? , boardSub=? where boardNm=?";
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(3, updateuser.getBoardNm());
			pstmt.setString(1, updateuser.getBoardTitle());
			pstmt.setString(2, updateuser.getBoardSub());

			int result = pstmt.executeUpdate();
			if (result > 0) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();// TODO: handle exception
			}
		}
		return flag;
	}// update1

	public boolean update2(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;

		try {
			String sql = "update BoardTable set boardCount=boardCount+1 where boardNm=?";
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);

			int result = pstmt.executeUpdate();
			if (result > 0) {
				flag = true;

			}

		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();// TODO: handle exception
			}
		}
		return flag;
	}// update1

	// 로그인함수
	public int loginUser(String userId, String password) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean loginFlag = false;
		try {
			con = getConnection();
			String sql = "select userNm from userTable where UserID = ? and userpw=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return 0;
	}// insertuser

	// 신입 회원입력
	public boolean insertUser(UserDTO userinsert) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean insertFlag = false;
		try {
			con = getConnection();
			String sql = "insert into userTable(userID,userNm,userPw,userName,userEm)";
			sql += "values(?,userNm_SEQ.nextval,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userinsert.getUserID());
			pstmt.setString(2, userinsert.getUserPw());
			pstmt.setString(3, userinsert.getUserName());
			pstmt.setString(4, userinsert.getUserEm());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				insertFlag = true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return insertFlag;
	}// insertuser

	public boolean idCheck(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean idflag = true;

		try {
			con = getConnection();
			pstmt = con.prepareStatement("Select count(*) cnt from UserTable where Userid = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int cnt = rs.getInt("cnt");
				if (cnt > 0) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				pstmt.close();
				con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		return false;
	}

	public boolean insertBoard(BoardDTO boardinsert) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean insertFlag = false;
		try {
			con = getConnection();
			String sql = "insert into boardTable(boardnm,boardtitle,boardSUB,usernm,boarddate,boardcount)";
			sql += "values(boardnm_seq.nextval,?,?,?,sysdate,0)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardinsert.getBoardTitle());
			pstmt.setString(2, boardinsert.getBoardSub());
			pstmt.setInt(3, boardinsert.getUserNm());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				insertFlag = true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return insertFlag;
	}// insertboard

	// 게시글 삭제
	public boolean deleteUser(BoardDTO userdelete) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean deleteFlag = false;

		try {
			con = getConnection();
			String sql = "delete BoardTable where boardTitle =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userdelete.getBoardTitle());

			int result = pstmt.executeUpdate();
			if (result > 0) {
				deleteFlag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return deleteFlag;
	}// deleteuserid

//		public boolean uopdateboard(String title,String sub) {
//
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			boolean updateFlag = false;
//
//			try {
//
//				con = getConnection();
//
//				String sql = "update boardtable set title=?,sub=? where title=?";
//				pstmt = con.prepareStatement(sql);
//				pstmt.setString(1,title);
//				pstmt.setString(2, sub);
//
//				int result = pstmt.executeUpdate();
//				if (result > 0) {// update 성공
//					updateFlag = true;
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				try {
//					pstmt.close();
//					con.close();
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
//			return updateFlag;
//		}//
//		

}// teamdao

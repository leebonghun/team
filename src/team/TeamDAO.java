package team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class TeamDAO {
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
	public Vector<UserDTO> select1() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<UserDTO> vetList = new Vector<UserDTO>();

		try {

			con = getConnection();

			String sql = "select * from userTable";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setUserID(rs.getString("UserID"));
				dto.setUserNm(rs.getInt("UserNm"));
				dto.setUserPw(rs.getString("UserPw"));
				dto.setUserName(rs.getString("UserName"));
				dto.setUserEm(rs.getString("UserEm"));
				vetList.add(dto);
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
	}
	
	
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
				BoardDTO dto2 = new BoardDTO();
				dto2.setBoardNm(rs.getInt("BoardNm"));
				dto2.setBoardTitle(rs.getString("BoardTitle"));
				dto2.setBoardSub(rs.getString("BoardSub"));
				dto2.setUserNm(rs.getInt("UserNm"));
				dto2.setBoardDate(rs.getDate("BoardDate"));
				dto2.setBoardCount(rs.getInt("BoardCount"));
				boardList.add(dto2);
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
	}
	
}

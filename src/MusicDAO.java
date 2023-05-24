import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicDAO {
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@192.168.18.4:1521:xe";
	private static final String USER = "MUSIC";
	private static final String PASSWORD = "a1234";

	Scanner scan = new Scanner(System.in);

	private Connection conn;
	private PreparedStatement pstmt;
	
	private ResultSet rs;
	private Statement stmt;

	String id = null;
	String pw = null;
	String name = null;

	String phNum = null;
	String singer = null;
	
	//static 초기화 구문
	static {
		try {
			Class.forName(DRIVER);
			System.out.println(">> JDBC 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("[예외발생] JDBC 드라이버 로딩 실패!!!");
			e.printStackTrace();
		}
	}
	public int join(MusicVO vo) { // 회원가입
		int result = 0; //

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// System.out.println(">>연결 성공"); // 나중에 삭제

			StringBuilder sql = new StringBuilder();

			sql.append("INSERT INTO MEMBER");
			sql.append("	(NAME, ID, PASSWORD, PHONE, EMAIL) ");
			sql.append(" VALUES (?, ?, ?, ?, ?)");

			pstmt = conn.prepareStatement(sql.toString());

			int i = 1;
			pstmt.setString(i++, vo.getName());
			pstmt.setString(i++, vo.getId());
			pstmt.setString(i++, vo.getPw());
			pstmt.setString(i++, vo.getPhNum());
			pstmt.setString(i++, vo.getEmail());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// e.printStackTrace();
			result = -1; // 중복아이디 존재
		} finally {
			close(conn, pstmt);
		}

		return result; // 성공하면 1
	}

	public int update(MusicVO vo) { // 회원정보 수정
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE MEMBER ");
			sql.append("	SET PASSWORD = ? ");
			sql.append("	  , PHONE = ? ");
			sql.append("	  , EMAIL = ? ");
			sql.append("WHERE id = ? ");
			pstmt = conn.prepareStatement(sql.toString());

			
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getPhNum());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getId());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			//e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}

		return result;
	}

	// 로그인
	String login(String id, String pw) {
		String userid = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			StringBuilder sql = new StringBuilder();

			sql.append("SELECT ID FROM MEMBER WHERE ID = ? and PASSWORD = ?");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				userid = rs.getString("ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return userid;
	}

	// 로그인 로그남기기
	int loginLog(String id) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sql = new StringBuilder();

			sql.append("insert into loginlog(ID, INDATE) ");
			sql.append("VALUES ((select id from member where id = ?),TO_char(sysdate, 'YYYY-MM-DD HH24:MI:SS')) ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn, pstmt);

		return result;

	}
	//로그아웃 로그남기기
	int logoutLog(String userid) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sql = new StringBuilder();

			sql.append("update loginlog set outdate = to_char(sysdate,'YYYY-MM-DD HH24:MI:SS') ");
			sql.append(" where id = ? ");


			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userid);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn, pstmt);

		return result; 

	}

	// 동시접속 확인
	String loginCh(String userid) {
		String str = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sql = new StringBuilder();

			sql.append("select indate from loginlog where id = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, userid);

			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				str = rs.getString("indate");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn, pstmt, rs);
		return str;
	}

	// 아이디 찾기
	public String idCheck(String name, String phNum) {
		String str = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT ID FROM MEMBER WHERE NAME = ? AND PHONE = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, name);
			pstmt.setString(2, phNum);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				str = rs.getString(1);

			}
		} catch (SQLException e) {
//			e.printStackTrace();
		return null;
		} finally {
			close(conn, pstmt, rs);
		}
		return str;

	}

	// 비밀번호 찾기

	public String pwcheck(String name, String id, String phNum) {
		String result = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT PASSWORD FROM MEMBER WHERE NAME = ? AND ID = ? AND PHONE = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, phNum);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = rs.getString("PASSWORD");
			}
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}

	// 회원정보 수정 전 비밀번호 다시 확인
	String moreCheck(String userid,String pw) {// 수정시 비밀번호 다시 확인 NULL이면 비번 다름
		String str = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			StringBuilder sql = new StringBuilder();

			sql.append("SELECT PASSWORD FROM MEMBER WHERE id = ? and PASSWORD = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, userid);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				str = rs.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return str;
	}

	// 회원정보 확인
	MusicVO mylistAll(String userid) {// 수정시 비밀번호 다시 확인 NULL이면 비번 다름
		MusicVO all = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			StringBuilder sql = new StringBuilder();

			sql.append("SELECT NAME, ID, PHONE, EMAIL, MEMBERSHIP_ON, msterm FROM MEMBER where id = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userid);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				all = new MusicVO(rs.getString("NAME"), rs.getString("ID"),rs.getString("PHONE"),
						rs.getString("EMAIL"),rs.getString("MEMBERSHIP_ON"),rs.getString("msterm"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return all;
	}
	
	// 가사로 노래정보
	List<Music_songVO> searchLy(String lyrics) {
		List<Music_songVO> list = null;
		Music_songVO vo = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT song_NUM, name, SINGER, ALBULM, GENRE, FEEL from song ");
			sql.append("where LYRICS like ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, "%" + lyrics + "%");
			rs = pstmt.executeQuery();

			list = new ArrayList<Music_songVO>();
			while (rs.next()) {
				vo = new Music_songVO(rs.getInt("song_NUM"), rs.getString("NAME"), rs.getString("SINGER"),
						rs.getString("ALBULM"), rs.getString("GENRE"), rs.getString("FEEL"));
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}

	// 가수로 찾기
	List<Music_songVO> searchSinger(String singer) {
		List<Music_songVO> list = null;
		Music_songVO vo = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sql = new StringBuilder();
			
			sql.append("SELECT SONG_NUM, name, SINGER, ALBULM, GENRE, FEEL from song ");
			sql.append("where SINGER like ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, "%" + singer + "%");
			rs = pstmt.executeQuery();

			list = new ArrayList<Music_songVO>();
			while (rs.next()) {
				vo = new Music_songVO(rs.getInt("song_NUM"), rs.getString("NAME"), rs.getString("SINGER"),
						rs.getString("ALBULM"), rs.getString("GENRE"), rs.getString("FEEL"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}

	// 제목으로 찾기
	List<Music_songVO> searchName(String name) {
		List<Music_songVO> list = null;
		Music_songVO vo = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT song_NUM, name, SINGER, ALBULM, GENRE, FEEL from song ");
			sql.append("where name like ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, "%" + name + "%");
			rs = pstmt.executeQuery();

			list = new ArrayList<Music_songVO>();
			while (rs.next()) {
				vo = new Music_songVO(rs.getInt("song_NUM"), rs.getString("NAME"), rs.getString("SINGER"),
						rs.getString("ALBULM"), rs.getString("GENRE"), rs.getString("FEEL"));
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}

	// 노래제목검색해서플리에 저장---
	int Nanmesave(String name, String userid) {
		int result = 0;
		try {

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sql = new StringBuilder();
			

			sql.append("INSERT INTO playlist ");
			sql.append(" SELECT s.song_NUM, s.NAME, s.SINGER, s.ALBULM, s.GENRE, m.id  from song s, member m, loginlog l ");
			sql.append(" WHERE m.id = l.id and s.name LIKE ? and l.id = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, "%" + name + "%");
			pstmt.setString(2, userid );

			rs = pstmt.executeQuery();
			result = pstmt.executeUpdate();
			if (rs.next()) {
				rs.getString("NAME");
			}
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		close(conn, pstmt, rs);
		return result;
	}

	// 가사로 검색했을때 저장
	int lyricssave(String lyrics, String userid) {
		int result = 0;
		try {

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sql = new StringBuilder();

			sql.append("INSERT INTO playlist ");
			sql.append(" SELECT s.song_NUM, s.NAME, s.SINGER, s.ALBULM, s.GENRE, m.id  from song s, member m, loginlog l ");
			sql.append(" WHERE m.id = l.id and s.lyrics LIKE ? and l.id = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, "%" + lyrics + "%");
			pstmt.setString(2, userid );
			result = pstmt.executeUpdate();

			rs = pstmt.executeQuery();
			if (rs.next()) {
				rs.getString("NAME");
			}
		} catch (SQLException e) {
		}
		close(conn, pstmt, rs);
		return result;
	}

	// 가수로 찾았을때 저장
	int singersave(String singer, String userid) {
		int result = 0;
		try {

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sql = new StringBuilder();

			sql.append("INSERT INTO playlist ");
			sql.append(" SELECT s.song_NUM, s.NAME, s.SINGER, s.ALBULM, s.GENRE, m.id  from song s, member m, loginlog l ");
			sql.append(" WHERE m.id = l.id and s.SINGER LIKE ? and l.id = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, "%" + singer + "%");
			pstmt.setString(2, userid );
			
			result = pstmt.executeUpdate();
			rs = pstmt.executeQuery();
			

			if (rs.next()) {
				rs.getString("s.song_NUM");
				rs.getString("s.NAME");
				rs.getString("s.SINGER");
				rs.getString("s.ALBULM");
				rs.getString("s.GENRE");
				rs.getString("m.id");
				
				
			}
		} catch (SQLException e) {
		}
		close(conn, pstmt, rs);
		return result;
	}

	// 플레이 리스트 전체 조회
	List<Music_songVO> seletListAll(String userid) {
		List<Music_songVO> list = new ArrayList<Music_songVO>();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT pl_NUM,NAME,SINGER,ALBULM,GENRE FROM PLAYLIST where id = ?  ");
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, userid);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Music_songVO vo  = new Music_songVO(rs.getInt("pl_num"),
													rs.getString("name"),
													rs.getString("singer"),
													rs.getString("albulm"),
													rs.getString("genre"));
			list.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("오류?");
			e.printStackTrace();
			
		} close(conn, pstmt, rs);
		return list;
	}

	// 플레이어 실행
	String Player(String name) {
		String str = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sql = new StringBuilder();

			System.out.println("▲   ◆  ■   ▼  " + " 재생중~~~♬~♪");

			sql.append(" SELECT NAME, SINGER FROM SONG WHERE NAME LIKE  = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, name);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				str = rs.getString(1);
			}
			System.out.println(str);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return str; //

	}

	// 멤버십 가격 출력
	List<membershipVO> membership() {
		List<membershipVO> list = new ArrayList<membershipVO>();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT NUM, type, PRICE, TERM FROM MEMBERSHIP ");

			pstmt = conn.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				membershipVO vo = new membershipVO(rs.getInt("NUM"), rs.getString("type"), rs.getString("PRICE"),
						rs.getString("TERM"));

				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn, pstmt, rs);
		return list;

	}

	int msjoin(int num, String userid) { // 멤버십 가입
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sql = new StringBuilder();
			
			sql.append("update member ");
			sql.append("set membership_on = (select type from membership where num = ?), ");
			sql.append("		  msterm = TO_char(add_months(sysdate,1), 'yyyy-mm-dd hh24:mi:ss') ");
			sql.append("  where id = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, num);
			pstmt.setString(2, userid);
			
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} close(conn, pstmt, rs);
		return result;
	}

	// 멤버십가입여부
	String msYN(String id) {
		String str = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT MEMBERSHIP_ON FROM MEMBER WHERE ID = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				str = rs.getString("MEMBERSHIP_ON");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn, pstmt, rs);
		return str; // null이면 가입 x >membership전체출력
	}

	// 특정특정노래삭제
	int playlistDelete(int num) {
		int str = 0;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sql = new StringBuilder();

			sql.append(" Delete from playlist where num = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, num);

			str = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return str;
	}

	
	
	// 번호 지정 플레이리스트 재생
	MusicCO playlistplay(int num) {
		MusicCO co = null;
		int str = 0;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sql = new StringBuilder();

			sql.append(" SELECT pl_NUM,NAME,SINGER,ALBULM,GENRE FROM PLAYLIST WHERE pl_NUM = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				str = rs.getInt(1);
				co = new MusicCO(rs.getInt("pl_NUM"), rs.getString("NAME"), rs.getString("SINGER"), rs.getString("ALBULM"),
						rs.getString("GENRE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} close(conn, pstmt, rs);
		return co;
	}
	
	//재생목록 전체 재생
	List<Music_songVO> playlistAllplay(String userid) {
		Music_songVO co = null;
		List<Music_songVO> list = new ArrayList<Music_songVO>();
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sql = new StringBuilder();

			sql.append(" SELECT pl_NUM,NAME,SINGER,ALBULM,GENRE FROM PLAYLIST where id = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				co = new Music_songVO(rs.getInt("pl_NUM"), rs.getString("NAME"), rs.getString("SINGER"), rs.getString("ALBULM"),
						rs.getString("GENRE"));
				list.add(co);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} close(conn, pstmt, rs);
		return list;
	}
	// 회원탈퇴
	int memberDelete(String id) {
		int result = 0;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sql = new StringBuilder();

			sql.append(" Delete from member where id = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, id);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} close(conn, pstmt);
		return result;
	} 

	private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {

		try {
			// 5. 클로징 처리에 의한 자원 반납
			if (rs != null)
				rs.close();
		} catch (SQLException e1) {
		}
		try {
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
		}
	}

	private void close(Connection conn, PreparedStatement pstmt) {

		// 5. 클로징 처리에 의한 자원 반납
		try {
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
		}

	}

}

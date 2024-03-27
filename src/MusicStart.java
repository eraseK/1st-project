import java.util.Scanner;

public class MusicStart {

	static String id = null;
	static String pw = null;
	static String name = null;
	static String songname = null;
	static String phNum = null;
	static String email = null;
	static Scanner scan = new Scanner(System.in);
	static String lyrics = null;
	static String play = null;
	static String cs = null;
	static MusicDAO dao = new MusicDAO();
	static int df = 0;
	static MusicVO vo = null;

	public static void main(String[] args) {

		while (true) {
			System.out.println("1. 회원가입  2. 로그인  3. 아이디 찾기  4. 비밀번호찾기 ");
			System.out.print("1~4 사이의 숫자를 입력해주세요 : ");
			String co = scan.nextLine();
			System.out.println();

			if ("1".equals(co)) {
				while (true) {
					df = rejoin(); //로그인 스캐너 함수
					if (df == 1) {
						System.out.println("회원가입이 완료되었습니다. 초기화면으로 로그인하세요.");
						break;
					} else if (df == 0) {
						rejoin(); //로그인 스캐너 함수
					}
				} 
			} else if ("2".equals(co)) {
				System.out.println("ID : ");
				id = scan.nextLine();
				System.out.println("PW : ");
				pw = scan.nextLine();
				
				dao.login(id, pw);
				if (dao.login(id, pw) != null) {
					String logch = dao.loginCh(id);
					if (dao.loginCh(id) == null) {
						System.out.println("로그인이 되었습니다.");
						dao.loginLog(id);
						System.out.println(); break;
						
					}else {
						System.out.println("이미 접속중인 아이디입니다. 확인하고 다시 로그인해주세요.");
					} 
				}else {
					System.out.println("해당 ID와 일치하는 값이 없습니다. 초기화면으로 돌아가 ID 찾기또는 회원가입을 해주세요.");
					continue;
					 
				} 
				
				
				
				
				
				
//				lyrics = scan.nextLine();
//
//				dao.searchName(lyrics);
//				dao.searchSinger(lyrics);
//				dao.searchLy(lyrics);
//
//				System.out.println();
//
//				System.out.println("재생할거면 yes  안할거면 no");
//				cs = scan.nextLine();
//
//				if ("yes".equals(cs)) {
//					String str = dao.Player(lyrics);
//					break;
//				} else if ("no".equals(cs)) {
//					System.out.println("1.종료하시겠습니까?  2.다시시작하겠습니까?");
//					cs = scan.nextLine();
//
//					if ("1".equals(cs)) {
//						System.out.println("종료되었습니다");
//					} else if ("2".equals(cs)) {
//						System.out.println("-로그인창-");
//						continue;
//					}
//				}
//				break;

			} else if ("3".equals(co)) {
				System.out.println("이름 : ");
				name = scan.nextLine();
				System.out.println("phNum : ");
				phNum = scan.nextLine();
				dao.idCheck(name, phNum);
				break;

			} else if ("4".equals(co)) {
				System.out.println("이름 : ");
				name = scan.nextLine();
				System.out.println("ID : ");
				id = scan.nextLine();
				System.out.println("phNum : ");
				phNum = scan.nextLine();
				dao.pwcheck(name, id, phNum);
				break;
			}
		}

		//로그인 후
		while(true) {
			int num = selectMenu();
			if(num == 1) {
				dao.searchSinger(cs);
			}
		}
		
		
		
		
		
		
	}

	static int rejoin() {

		System.out.print("이름 : ");
		name = scan.nextLine();
		System.out.print("ID : ");
		id = scan.nextLine();
		System.out.print("PW : ");
		pw = scan.nextLine();
		System.out.print("phNum : ");
		phNum = scan.nextLine();
		System.out.print("email : ");
		email = scan.nextLine();
		vo = new MusicVO(name, id, pw, phNum, email);
		int result = dao.join(vo);
		return result;
	}
	static int selectMenu() {
		int select = 0;
		while (true) {
			try {
			System.out.println("1. 검색   2. 재생목록   3. 회원수정    4. 회원탈퇴 ");
			System.out.println("원하시는 번호를 선택해주세요");
			select = Integer.parseInt(scan.nextLine());
			if (select < 1 || select > 4) {
				System.out.println("1 ~ 4 중의 번호를 선택해주세요.");
				continue;
			} 
			break;
			} catch(Exception e) {
				System.out.println("숫자가 아닙니다. 숫자를 입력해 주세요");
			}
		}
		return select;
	}
	
}

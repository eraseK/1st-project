import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mumu1 {

	private Scanner scan = new Scanner(System.in);
	private MusicDAO dao = new MusicDAO();
	private MusicVO vo = new MusicVO();
	
	private mumu2 mu2 = new mumu2();
	private LoginLogVO loCh = new LoginLogVO();
	public String str;
	private String name;
	public String id;
	private String pw;
	private String phNum;
	private String email;
	private String search;
	private int num;

	// private String id;

	public void maindisplay() {
		
		System.out.println("                ♬  Music  ♬     ");
		int getjoin = 0;
		String userid = null;
		loop: while (true) {
			int fp = firstdisplay();
			if( fp == 0) { // 종료
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			if (fp == 1) { //회원가입
				getjoin = getjoin();
				if (getjoin == 1) {
					System.out.println("회원가입이 완료되었습니다. 로그인 해주시길 바랍니다.");
					continue;
				} else if (getjoin == -1) {
					System.out.println("중복된 ID입니다. 확인하고 다시 입력해주세요");
				}
			}

			if (fp == 2) { // 로그인
//				loop2 :
				while (true) {

					userid = getlogin();
					if (userid == null) {
						System.out.println("\n일치하는 ID가 없습니다. 확인하고 다시 로그인 해주세요.");
						break;
					} else if (userid != null){
						String str = dao.loginCh(userid);
						if (str == null) {
							System.out.println("\n로그인 되었습니다. 사용하실 메뉴를 선택해주세요.");
							dao.loginLog(userid);
							mu2.logindisplay(userid);
							break;
						} else if(str != null) {
							System.out.println("이미 접속중인 아이디입니다. 확인하고 다시 로그인 해주세요");
						}

					}
				}

			}
			if (fp == 3) { // 아이디 찾기
				System.out.println("                     ▒▒ ID 찾기 ▒▒");
				System.out.println("\n가입하신 이름과 연락처를 입력해주세요. (연락처는 '-'를 포함하여 입력해주세요)\n");
				System.out.print("이름 :");
				name = scan.nextLine();
				System.out.print("연락처☏ :");
				phNum = scan.nextLine();

				String idCh = dao.idCheck(name, phNum);

				if (idCh != null) {
					System.out.println("⊙ 아이디를 찾았습니다 ⊙");
					System.out.println("ID : " + idCh + "\n");
				} else if (idCh == null) {
					System.out.println("가입된 회원 정보가 없습니다. 회원가입을 진행해주세요\n");
				}

			}
			if (fp == 4) { // 비밀번호 찾기
				System.out.println("                   ▒▒ Password 찾기 ▒▒");
				System.out.println("가입하신 이름, 아이디, 연락처를 입력해주세요. (연락처는 '-'를 포함하여 입력해주세요) ");
				System.out.print("이름 :");
				name = scan.nextLine();
				System.out.print("아이디 :");
				id = scan.nextLine();
				System.out.print("연락처 :");
				phNum = scan.nextLine();

				String pwch = dao.pwcheck(name, id, phNum);

				if (pwch != null) {
					System.out.println("⊙ 비밀번호를 찾았습니다 ⊙");
					System.out.println("비밀번호 : " + pwch + "\n");
				} else if (pwch == null) {
					System.out.println("가입된 회원 정보가 없습니다. 회원가입을 진행해주세요\n");
				}

			}
		}
	}

	private int firstdisplay() {
		int select = 0;
		while (true) {
			try {
				System.out.println("1. 회원가입  2. 로그인  3. 아이디 찾기  4. 비밀번호찾기  0. 종료");
				System.out.print("▶ \n");
				select = Integer.parseInt(scan.nextLine());
				System.out.println();
				if (select < 0 || select > 4) {
					System.out.println("\n※※※ 1 ~ 4번 중의 번호를 입력해주세요 ※※※");
					continue;
				}
				break;

			} catch (Exception e) {
				System.out.println("\n※※※ 숫자가 아닙니다. 숫자를 입력해주세요 ※※※");
			}
		}
		return select;

	}



	private int getjoin() {
		int result = 0;
		System.out.println("------ 회원가입 -------");
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
		result = dao.join(vo);
		return result;
	}

	private String getlogin() {

		System.out.print("ID : ");
		id = scan.nextLine();
		System.out.print("PW : ");
		pw = scan.nextLine();
		String userid = dao.login(id, pw);
		return userid;
	}

}

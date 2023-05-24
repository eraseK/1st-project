import java.util.Scanner;

public class Music_main {

	public static void main(String[] args) {
		String id = null;
		String pw = null;
		String name = null;
		String phNum = null;
		String email = null;
		Scanner scan = new Scanner(System.in);
//		MusicDAO dao = null;
		String lyrics = null;
		
		MusicDAO dao = new MusicDAO();
		MusicVO vo = null;
		System.out.println("1. 회원가입  2. 로그인  3. 아이디 찾기  4. 비밀번호찾기 ");
		System.out.print("1~4 사이의 숫자를 입력해주세요 : ");
		String co = scan.nextLine();
		System.out.println();
		
		while(true) {
			if("1".equals(co)) {
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
				dao.join(vo); break;
			} else if("2".equals(co)) {
//				for()
				System.out.println("ID : ");
				
				id = scan.nextLine();
				System.out.println("PW : ");
				pw = scan.nextLine();
				dao.login(id, pw);
				
				System.out.println("검색할 가사를 입력해쥬생ㅅ");
				lyrics = scan.nextLine();
				dao.searchLy(lyrics);
				
				break;
			} else if("3".equals(co)) {
				System.out.println("이름 : ");
				name = scan.nextLine();
				System.out.println("phNum : ");
				phNum = scan.nextLine();
				dao.idCheck(name, phNum);break;
			} else if("4".equals(co)) {
				System.out.println("이름 : ");
				name = scan.nextLine();
				System.out.println("ID : ");
				id = scan.nextLine();
				System.out.println("phNum : ");
				phNum = scan.nextLine();
				dao.pwcheck(name, id, phNum);break;
			}
		}
		
		
		
		
		
		}

	

	}



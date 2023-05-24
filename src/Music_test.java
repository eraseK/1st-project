import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Music_test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MusicDAO mvo = new MusicDAO();
		membershipVO ms = new membershipVO();
		
		
//		List<membershipVO> vo =  mvo.membership();
//		System.out.println(vo);
		//mvo.start();
//		String id = null;
//		String pw = null;
//		String name = null;
//		String phNum = null;
//		MusicVO vo = new MusicVO("김지우2","abc2","a1234","010-2370-9711","ee@naver.com");
//		
//		mvo.join(vo);
		
//		int result = mvo.join(vo);
//		System.out.println(result);
//		String str = mvo.pwcheck("김지우", "abc", "010-2370-9711");
//		System.out.println(str);
//		String idCh = null;
//		for (int i = 1; i <= 5; i++) {
//			System.out.println("ID를 입력해주세요 :");
//			id = scan.nextLine();
//			System.out.println("pw를 입력해주세요 :");
//			pw = scan.nextLine();

//			System.out.println(aa);
//			if (aa != null) {
//				idCh = mvo.loginCh(id);
//				System.out.println(idCh);
//				if(idCh != null) {
//					System.out.println("로그인에 성공했습니다.");
//					mvo.loginLog(id); break;
//				} else {
//					System.out.println("이미 접속된 아이디입니다. 확인하고 다시 로그인 해주세요 ");
//					continue;
//				}
//				
//			} else if (aa == null) {
//				System.out.println("id 또는 pw를 확인하고 다시 입력해주세요");
//				continue;
//			}
//			System.out.println("로그인 횟수 초과하여 초기화면으로 돌아가 아이디 또는 비밀번호 찾기를 해주세요.");
//		}
//		while(true) {
//			System.out.println("이름을 입력해주세요 :");
//			name = scan.nextLine();	
//			System.out.println("ID를 입력해주세요 :");
//			id = scan.nextLine();	
//			System.out.println("전화번호를 입력해주세요 :");
//			pw = scan.nextLine();	
//			
//			mvo.pwcheck(name, id, pw);
//			
//		
		
//		}
	//	mvo.update(vo);
//		System.out.println("아이디");
//		id = scan.nextLine();
//		System.out.println("아이디");
//		pw = scan.nextLine();
//		int re = mvo.login(id, pw);
//		System.out.println(re);
//		 
		
//		mvo.searchAll();
//		System.out.println(list);
//		mvo.join(vo);
//		System.out.println(vo1);
//		while(true) {
//			System.out.println("검색어 입력"
//					+ "");
//			name = scan.nextLine();
//			
//		mvo.searchName(name);
//		System.out.println("플레이리스트에 저장?");
//		String save = scan.nextLine();
//		if(save.equals("1")) {
//			mvo.plistsave();
//		} else {
//			continue;
//		}
//		}
		
		
		//검색해서 저장
//		List<Music_songVO> list = new ArrayList<Music_songVO>();
//		while(true) {
//			System.out.println("dfdsfs : ");
//			name= scan.nextLine();
//			list = mvo.searchName(name);
//			if(list.isEmpty()) {
//				System.out.println("검색결과가 없습니다. 다시 입력해주세요");
//				continue;
//			}
//		
//			System.out.println("저장하시겠습니까?");
//			String num = scan.nextLine();
//
//			if (num.equals("1")) {
//				int rs = mvo.Nanmesave(name);
//
//				if (rs == 0) {
//					System.out.println();
//				} else {
//					System.out.println("저장완료");
//					System.out.println("다시 검색하시겠습니까?");
//					System.out.println("1. 예  2. 아니오");
//					String ste = scan.nextLisne();
//					if (ste.equals("1")) {
//						continue;
//					} else {
//						break;
//					}
//				}
//
//			} else {
//				System.out.println("다시 검색");
//			}rs.getString("MEMBERSHIP")
	
//		}

		
	}

}

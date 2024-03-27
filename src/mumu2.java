import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mumu2 {

	private Scanner scan = new Scanner(System.in);
	private MusicDAO dao = new MusicDAO();
	private MusicVO vo = new MusicVO();
//	List<Music_songVO> list = new ArrayList<Music_songVO>();
	private String name;
	private String id;
	private String pw;

	private String phNum;
	private String search;
	private String email;
	private int num;

	public void logindisplay(String userid) {
		end: while (true) {
			int fd = firstdisplay();

			if (fd == 1) {
				System.out.println("1. 가수명으로 검색   2. 가사로 검색   3. 노래제목으로 검색 ");
				num = Integer.parseInt(scan.nextLine());
				System.out.println("검색어 :");
				search = scan.nextLine();

				if (num == 1) {
					out: while (true) {
						List<Music_songVO> listSg = new ArrayList<Music_songVO>();
						listSg = dao.searchSinger(search); // 가수로 검색

						if (listSg.isEmpty()) {
							System.out.println("' " + search + " '" + "에 대한 검색 결과가 없습니다.");
							break out;
						}
						for (Music_songVO vo : listSg) {
							System.out.println(vo.getsNum() + "   " + vo.getSinger() + "   " + vo.getAlbulm()
									+ vo.getGenre() + "   ");

							System.out.println("1. 재생   2. 재생목록에 추가");
							System.out.println("▷");
							num = Integer.parseInt(scan.nextLine());

							List<Music_songVO> playlist = new ArrayList();
							if (num == 1) {
								String membership = dao.msYN(userid); // 멤버십 가입 여부확인
								if (membership == null) {
									List<membershipVO> memPrice = new ArrayList<membershipVO>();
									memPrice = dao.membership(); // 가입x > 멤버십 리스트 출력
									System.out.println("멤버십에 가입되어 있지 않습니다. 가입을 진행해주세요\n");
									for (int i = 0; i < memPrice.size(); i++) {
										System.out.println(memPrice.get(i).getNum() + "\t" + memPrice.get(i).gettype()
												+ "\t" + memPrice.get(i).getPrice() + "\t" + memPrice.get(i).getTerm());
									}
									System.out.println("구매할 멤버십의 번호를 입력해주세요");
									System.out.println("▷");
									num = Integer.parseInt(scan.nextLine());
									System.out.println("입금할 금액을 입력해주세요");
									System.out.println("▷");
									int inprice = Integer.parseInt(scan.nextLine());
									int result = dao.msjoin(num, userid);

									if (result == 1) {
										System.out.println("멤버십 가입이 완료되었습니다.\n");
										break out;
									}
								} else { // 가입했으면 진행
									int result = dao.singersave(search, userid);
									playlist = dao.playlistAllplay(userid);

									System.out.println("♬ 재생목록 ♬");
									for (Music_songVO pl : playlist) {
										System.out.println(
												pl.getsNum() + "   " + vo.getSinger() + "   " + vo.getAlbulm());
									}
									System.out.println("재생목록에 " + result + " 곡을 담고 재생합니다.");
									break out;
								}
							} else if (num == 2) {
								int result = dao.singersave(search, userid);
								System.out.println("재생목록에 " + result + " 곡이 추가 되었습니다.");
								continue end;
								
							}
						}
					}
				}
				if (num == 2) {
					out: while (true) {
						List<Music_songVO> listLy = dao.searchLy(search);
						if (listLy.isEmpty()) {
							System.out.println("' " + search + " '" + "에 대한 검색 결과가 없습니다.");
							break out;
						}
						for (Music_songVO vo : listLy) {
							System.out.println(
									vo.getsNum() + "   " + vo.getSinger() + "   " + vo.getAlbulm() + vo.getGenre());

							System.out.println("1. 재생   2. 재생목록에 추가");
							System.out.println("▷");
							num = Integer.parseInt(scan.nextLine());

							List<Music_songVO> playlist = new ArrayList();
							if (num == 1) {
								String membership = dao.msYN(userid); // 멤버십 가입 여부확인
								if (membership == null) {
									List<membershipVO> memPrice = new ArrayList<membershipVO>();
									memPrice = dao.membership(); // 가입x > 멤버십 리스트 출력
									for (int i = 0; i < memPrice.size(); i++) {
										System.out.println(memPrice.get(i).getNum() + "\t" + memPrice.get(i).gettype()
												+ "\t" + memPrice.get(i).getPrice() + "\t" + memPrice.get(i).getTerm());
									}
									System.out.println("멤버십에 가입되어 있지 않습니다. 가입을 진행해주세요");
									System.out.println("구매할 멤버십의 번호를 입력해주세요");
									System.out.println("▷");
									num = Integer.parseInt(scan.nextLine());
									System.out.println("입금할 금액을 입력해주세요");
									System.out.println("▷");
									int inprice = Integer.parseInt(scan.nextLine());
									int result = dao.msjoin(num, userid);

									if (result == 1) {
										System.out.println("멤버십 가입이 완료되었습니다.\n");
										break out;
									}
								}
								int result = dao.lyricssave(search, userid);
								playlist = dao.playlistAllplay(userid);

								System.out.println("♬ 재생목록 ♬");
								for (Music_songVO pl : playlist) {
									System.out.println(pl.getsNum() + "   " + vo.getSinger() + "   " + vo.getAlbulm());
								}
								System.out.println("재생목록에 " + result + " 곡을 담고 재생합니다.");
								break out;
							} else if (num == 2) {
								int result = dao.lyricssave(search, userid);
								System.out.println("재생목록에 " + result + " 곡이 추가 되었습니다.");
								break out;
							}
						}
					}
				}
				if (num == 3) {
					out: while (true) {
						List<Music_songVO> listNm = new ArrayList<Music_songVO>();
						listNm = dao.searchName(search);
						if (listNm.isEmpty()) {
							System.out.println("' " + search + " '" + "에 대한 검색 결과가 없습니다.");
							break out;
						}
						for (Music_songVO vo : listNm) {
							System.out.println(
									vo.getsNum() + "   " + vo.getSinger() + "   " + vo.getAlbulm() + vo.getGenre());

							System.out.println("1. 재생   2. 재생목록에 추가");
							System.out.println("▷");
							num = Integer.parseInt(scan.nextLine());

							List<Music_songVO> playlist = new ArrayList();
							if (num == 1) {
								String membership = dao.msYN(userid); // 멤버십 가입 여부확인
								if (membership == null) {
									List<membershipVO> memPrice = new ArrayList<membershipVO>();
									memPrice = dao.membership(); // 가입x > 멤버십 리스트 출력
									for (int i = 0; i < memPrice.size(); i++) {
										System.out.println(memPrice.get(i).getNum() + "\t" + memPrice.get(i).gettype()
												+ "\t" + memPrice.get(i).getPrice() + "\t" + memPrice.get(i).getTerm());
									}
									System.out.println("멤버십에 가입되어 있지 않습니다. 가입을 진행해주세요");
									System.out.println("구매할 멤버십의 번호를 입력해주세요");
									System.out.println("▷");
									num = Integer.parseInt(scan.nextLine());
									System.out.println("입금할 금액을 입력해주세요");
									System.out.println("▷");
									int inprice = Integer.parseInt(scan.nextLine());
									int result = dao.msjoin(num, userid);

									if (result == 1) {
										System.out.println("멤버십 가입이 완료되었습니다.\n");
										break out;
									}
								}
								int result = dao.Nanmesave(search, userid);
								playlist = dao.playlistAllplay(userid);

								System.out.println("♬ 재생목록 ♬");
								for (Music_songVO pl : playlist) {
									System.out.println(pl.getsNum() + "   " + vo.getSinger() + "   " + vo.getAlbulm());
								}
								System.out.println("재생목록에 " + result + " 곡을 담고 재생합니다.");
								break out;
							} else if (num == 2) {
								int result = dao.Nanmesave(search, userid);
								System.out.println("재생목록에 " + result + " 곡이 추가 되었습니다.");
								break out;
							}
						}
					}

				}
			}

			if (fd == 2) {
				out: while (true) {
					List<Music_songVO> listAll = new ArrayList<Music_songVO>();
					listAll = dao.seletListAll(userid);
					if (listAll.isEmpty()) {
						System.out.println("재생목록이 비어 있습니다. 메인화면으로 돌아가 노래를 추가해주세요.");
						break out;
					}
					System.out.println("------  재생목록 -------- ");
					for (int i = 0; i < listAll.size(); i++) {
						System.out.println(listAll.get(i).getsNum() + "   " + listAll.get(i).getsName() + "   "
								+ listAll.get(i).getSinger() + "   " + listAll.get(i).getAlbulm());
//						break;
					}
					System.out.println("1. 재생   2. 뒤로가기");////////////////
					System.out.println("▷");
					num = Integer.parseInt(scan.nextLine());
					if (num == 1) {
						String membership = dao.msYN(userid); // 멤버십 가입 여부확인
						if (membership == null) {
							List<membershipVO> memPrice = new ArrayList<membershipVO>();
							memPrice = dao.membership(); // 가입x > 멤버십 리스트 출력
							for (int i = 0; i < memPrice.size(); i++) {
								System.out.println(memPrice.get(i).getNum() + "\t" + memPrice.get(i).gettype() + "\t"
										+ memPrice.get(i).getPrice() + "\t" + memPrice.get(i).getTerm());
							}
							System.out.println("※※※※ 멤버십에 가입되어 있지 않습니다. 가입을 진행해주세요 ※※※※");
							System.out.println("구매할 멤버십의 번호를 입력해주세요");
							System.out.println("▷");
							num = Integer.parseInt(scan.nextLine());
							System.out.println("입금할 금액을 입력해주세요");
							System.out.println("▷");
							int inprice = Integer.parseInt(scan.nextLine());
							int result = dao.msjoin(num, userid);

							if (result == 1) {
								System.out.println("멤버십 가입이 완료되었습니다.\n");
								break out;
							}
						}
						List<Music_songVO> playlist = new ArrayList();
						playlist = dao.playlistAllplay(userid);

						System.out.println("재생중 ~♬");
						for (int i = 0; i < playlist.size(); i++) {
							System.out.println(playlist.get(i).getsNum() + "   " + playlist.get(i).getSinger() + "   "
									+ playlist.get(i).getAlbulm() + "\n");
						}
						System.out.println("재생 종료~");
						break;
					} else if (num == 2) {
						break out;
					}
				}
			}

			if (fd == 3) {
				System.out.println("회원 정보확인을 위해 비밀번호를 다시 입력해주세요");
				System.out.println("비밀번호 :");
				pw = scan.nextLine();

				String mc = dao.moreCheck(userid, pw);
				if (mc == null) {
					System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요");
				} else {
					MusicVO mylist = dao.mylistAll(userid);

					if (mylist != null) {
						System.out.println("\n -------  회원 정보 ----------");
						System.out.println("이름 :" + mylist.getName());
						System.out.println("아이디 :" + mylist.getId());
						System.out.println("연락처 :" + mylist.getPhNum());
						System.out.println("이메일 :" + mylist.getEmail());
						System.out.println("멤버십가입여부 :" + mylist.getMemsYN());
						System.out.println("멤버십유효기간 :" + mylist.getMsterm());
				
					}
					System.out.println("회원정보 수정을 원하시면 1번, 처음화면으로 돌아가려면 2번을 입력해주세요");
					System.out.println("▷ ");
					num = Integer.parseInt(scan.nextLine());
					if (num == 1) {
						System.out.println("---- 회원정보 수정 -----");
						System.out.println("새로운 비밀번호 :");
						pw = scan.nextLine();
						System.out.println("비밀번호 확인 :");
						String pw1 = scan.nextLine();
						System.out.println("전화번호 :");
						phNum = scan.nextLine();
						System.out.println("E-maile :");
						email = scan.nextLine();

						vo = new MusicVO(userid, pw, phNum, email);
						if (pw.equals(pw1)) {
							dao.update(vo);
							System.out.println("수정이 완료되었습니다. 처음화면으로 돌아갑니다.\n");
							continue;
						} else {
							System.out.println("비밀번호와 비밀번호확인 값이 다릅니다. 확인하고 다시 입력해주세요");
						}

					}

				}
			}
			if (fd == 4) {
				System.out.println("회원 정보확인을 위해 비밀번호를 다시 입력해주세요");
				System.out.println("비밀번호 :");
				pw = scan.nextLine();
				dao.moreCheck(userid, pw);

				System.out.println("회원탈퇴를 진행하시겠습니까? (1.예   2. 아니오)");
				num = Integer.parseInt(scan.nextLine());

				if (num == 1) {
					System.out.println(userid);
					dao.memberDelete(userid);
					System.out.println("탈퇴가 완료되었습니다.");
					break;
				} else {
					System.out.println("회원탈퇴를 철회하고 처음화면으로 돌아갑니다.");
					break;
				}

			}
			if (fd == 5) {
				int out = dao.logoutLog(userid);
				System.out.println(out);
				if (out == 1) {
					System.out.println("로그아웃 되었습니다.\n");
				} else {
					System.out.println("로그아웃 처리 안됨!!!!!!!!!!!!!!");
				}
				break end;
			}
		}
	}

	int firstdisplay() {
		int select = 0;
		while (true) {
			try {
				System.out.println("\n1.검색   2. 재생목록   3. 회원정보조회   4. 회원탈퇴   5. 로그아웃");
				System.out.print("▷ ");
				select = Integer.parseInt(scan.nextLine());
				System.out.println();
				if (select < 1 || select > 5) {
					System.out.println("\n※※※ 1 ~ 5번 중의 번호를 입력해주세요 ※※※");
					continue;
				}
				break;

			} catch (Exception e) {
				System.out.println("\n※※※ 숫자가 아닙니다. 숫자를 입력해주세요 ※※※");
			}
		}
		return select;
	}

}

package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class GameManager {

	BufferedReader br = null;
	BufferedWriter bw = null;

	StringBuffer buffer = new StringBuffer();
	
	String key ;

	Map<String, Stage> stage = new HashMap<>();
	Map<String, User> user = new HashMap<>();

	private GameManager() {
		stage.put("title", new StageTitle());
		stage.put("battle", new StageBattle());
		stage.put("lobby", new StageLobby());
	}

	private static GameManager instance = new GameManager();

	public static GameManager getinstance() {
		return instance;
	}
	public void run() {
		while(true) {
			print();
			String select = scan();
			if(select.equals("1")) {
				signUp();
			}
			else if(select.equals("2")) {
				withdraw();
			}else if(select.equals("3")) {
				login();
			}else if(select.equals("4")) {
				logout();
			}
				
		}
	}
	private void withdraw() {
		if(user.containsKey(key)) {
			System.out.print("비밀번호 : ");
			String pw = scan();
			if(user.get(key).pw.equals(pw)) {
				System.out.println("탈퇴 성공");
				user.remove(key);
				this.key = "";
			}
			else {
				System.out.println("비밀번호를 확인해주세요");
			}
		}else {
			System.out.println("로그인 후 이용해주세요");
		}
		
	}

	public void signUp() {
		System.out.println("이름 : ");
		String name = scan();
		System.out.print("아이디 : ");
		String id = scan();
		System.out.print("비밀번호 : ");
		String pw = scan();
		boolean isRun = overlap(id);
		if(isRun) {
			user.put(id, new User(id,pw,name));			
			System.out.println("회원가입 성공");
		}else {
			System.out.println("중복된 아이디 입니다.");
		}
	}
	public void login() {		
		if(user.containsKey(key)) {
			System.out.println("로그인 상태입니다");		
		}else {
			System.out.print("아이디 : ");
			String id = scan();
			System.out.print("비밀번호 : ");
			String pw = scan();
			if(user.containsKey(id)) {
				if(user.get(id).pw.equals(pw)) {
					System.out.println("로그인 성공");
					this.key = id;
				}
				else {
					System.out.println("아이디 또는 비밀번호가 틀립니다.");
				}
			}
			else {
				System.out.println("아이디 또는 비밀번호가 틀립니다.");
			}
		}
	}
	private void logout() {
		if(user.containsKey(key)) {
			System.out.println("로그아웃 성공");
			this.key = "";
		}else {
			System.out.println("로그아웃 상태입니다/");
		}
	}
	private boolean overlap(String id) {
		boolean isRun = true;
		if(user.containsKey(id)) {
			isRun = false;
		}
		return isRun;
	}
	private void print() {
		System.out.println("[1. 회원가입]");
		System.out.println("[2. 회원탈퇴]");
		System.out.println("[3. 로그인]");
		System.out.println("[4. 로그아웃]");
		
	}
	

	public String scan() {

		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			buffer.delete(0, buffer.length());
			buffer.append(br.readLine());
//			bw.write(buffer.toString());
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
	}
		return buffer.toString();
	}

//	유저관리
//	회원가입
//	스테이지 (+맵추가)
//	파티 기능

//			. 전투 기능 (+몬스터추가)
//			. 상점 추가
//			. 창고 관리
//			. 데이터 처리 (파일 또는 DB)
//			
//			1. 본인 깃 저장소에
//		    1. 프로젝트명 : “poly-rpg-console-game” 로 커밋하고 시작
//			2. 접근제어자 유의
//			3. Singletone Pattern 적용
//			4. 상속/추상화/인터페이스 적용
//			6. 완성 후 → UML ClassDiagram 작성해보기
//			7. StringBuffer 사용
//			8. BufferedReader & BufferedWriter 사용

}

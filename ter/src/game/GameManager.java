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
			System.out.print("��й�ȣ : ");
			String pw = scan();
			if(user.get(key).pw.equals(pw)) {
				System.out.println("Ż�� ����");
				user.remove(key);
				this.key = "";
			}
			else {
				System.out.println("��й�ȣ�� Ȯ�����ּ���");
			}
		}else {
			System.out.println("�α��� �� �̿����ּ���");
		}
		
	}

	public void signUp() {
		System.out.println("�̸� : ");
		String name = scan();
		System.out.print("���̵� : ");
		String id = scan();
		System.out.print("��й�ȣ : ");
		String pw = scan();
		boolean isRun = overlap(id);
		if(isRun) {
			user.put(id, new User(id,pw,name));			
			System.out.println("ȸ������ ����");
		}else {
			System.out.println("�ߺ��� ���̵� �Դϴ�.");
		}
	}
	public void login() {		
		if(user.containsKey(key)) {
			System.out.println("�α��� �����Դϴ�");		
		}else {
			System.out.print("���̵� : ");
			String id = scan();
			System.out.print("��й�ȣ : ");
			String pw = scan();
			if(user.containsKey(id)) {
				if(user.get(id).pw.equals(pw)) {
					System.out.println("�α��� ����");
					this.key = id;
				}
				else {
					System.out.println("���̵� �Ǵ� ��й�ȣ�� Ʋ���ϴ�.");
				}
			}
			else {
				System.out.println("���̵� �Ǵ� ��й�ȣ�� Ʋ���ϴ�.");
			}
		}
	}
	private void logout() {
		if(user.containsKey(key)) {
			System.out.println("�α׾ƿ� ����");
			this.key = "";
		}else {
			System.out.println("�α׾ƿ� �����Դϴ�/");
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
		System.out.println("[1. ȸ������]");
		System.out.println("[2. ȸ��Ż��]");
		System.out.println("[3. �α���]");
		System.out.println("[4. �α׾ƿ�]");
		
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

//	��������
//	ȸ������
//	�������� (+���߰�)
//	��Ƽ ���

//			. ���� ��� (+�����߰�)
//			. ���� �߰�
//			. â�� ����
//			. ������ ó�� (���� �Ǵ� DB)
//			
//			1. ���� �� ����ҿ�
//		    1. ������Ʈ�� : ��poly-rpg-console-game�� �� Ŀ���ϰ� ����
//			2. ���������� ����
//			3. Singletone Pattern ����
//			4. ���/�߻�ȭ/�������̽� ����
//			6. �ϼ� �� �� UML ClassDiagram �ۼ��غ���
//			7. StringBuffer ���
//			8. BufferedReader & BufferedWriter ���

}

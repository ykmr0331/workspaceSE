package server;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ChatServerFrame extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextField noticeTF;
	private JTextArea displayTA;
	/******접속된클라이어트객체를 보관할 서비스객체****/
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ChatServerFrame frame = new ChatServerFrame();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public ChatServerFrame() {
		setTitle("ChatServer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		displayTA = new JTextArea();
		displayTA.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		displayTA.setEditable(false);
		scrollPane.setViewportView(displayTA);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		noticeTF = new JTextField();
		noticeTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(noticeTF);
		noticeTF.setColumns(45);

		JButton noticeB = new JButton("공지");
		noticeB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(noticeB);
		
		/***** 접속된클라이어트객체를 보관할 ServerClientService객체생성 *****************/
		
		/***** 클라이언트의 소켓연결요청을 처리 ChatServerThread 객체생성 쓰레드start **/
		ChatServerThread chatServerThread = new ChatServerThread();
		chatServerThread.start();
		
	}

	private void setLog(String log) {
		displayTA.append(log + "\n");
		int maxSize = scrollPane.getVerticalScrollBar().getMaximum();
		scrollPane.getVerticalScrollBar().setValue(maxSize);
	}

	/***********************************************
	  특정포트를 열고 클라이언트의 소켓연결요청을 처리해서
	  소켓을생성하는클래스
	 ***********************************************/
	
	public class ChatServerThread extends Thread {
		@Override
		public void run() {
			try {
				 /*
				  setLog("0.ChatServerThread:8888번포트에 ServerSocket생성");
				  setLog("1.ChatServerThread:클라이어트소켓연결요청대기");
				  setLog("2.ChatServerThread:접속클라이언트:"+socket);
				  setLog("3.ChatServerThread:ClientService 객체에 ServerClientThread객체추가 쓰레드start");
				  */
				ServerSocket serverSocket = new ServerSocket(8888);
				setLog("0.ChatServerThread:8888번포트에 ServerSocket생성");		
				while(true) {
					  setLog("1.ChatServerThread:클라이어트소켓연결요청대기");
					  Socket socket =  serverSocket.accept();
					  setLog("2.ChatServerThread:접속클라이언트:"+socket);
					  

				}
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/********************************************
	  서버쪽소켓을 사용하여 클라이언트와 통신을 담당하는 클래스(VO) 
	  - 한명의 클라이언트와통신을 담당하는 클래스 
	  - 클라이언트와연결된 소켓1개를 가지고있는클래스 
	  - 클라이언트의 정보를 가지고있는 클래스
	  - 클라이언트당 1개의객체가생성
	 ********************************************/
	
	public class ServerClientThread extends Thread {
		private Socket socket; //서버쪽소켓
		
		public ServerClientThread(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			try {
				while(true) {
					/*
					 setLog("가.ServerClientThread"+ id+ "로부터 데이타를 읽기위해 쓰레드대기");
					 setLog("나.ServerClientThread:"+id+ " 로부터읽은데이타:"+readStr);
					 setLog("다.ServerClientThread:연결된모든 클라이언에 읽은데이타 전송");
					 */
				}
			}catch (Exception e) {
				
			}
		}
	}
	/************************************
	 * 서버에연결된 클라이언트객체(Service)를관리할클래스 
	 * - 클라이언트객체 추가 
	 * - 클라이언트객체 찾기 
	 * - 클라이언트객체 삭제 
	 * - 모든 클라이언트객체에 데이타전송
	 ************************************/
	public class ServerClientService {
		/*
		 * 클라이언트객체 보관리스트
		 */
		private List<ServerClientThread> clientList=
				new ArrayList<ServerClientThread>();
		/*
		 * 클라이트객체추가
		 */
		
		/*
		 * 클라이트객체삭제
		 */
		
		/*
		 *모든클라이언트에 메세지전송
		 */
	}
}
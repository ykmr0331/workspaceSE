package com.itwill.member.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.member.Member;
import com.itwill.member.MemberService;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class MemberMainFrame extends JFrame {
	/*********1.MemberService멤버필드선언*****/
	private MemberService memberService;
	/*
	ProductService productService;
	....
	*/
	/*************로그인한회원****************/
	private Member loginMember=null;
	
	private int selected_index = 0;
	
	private JPanel contentPane;
	private JTextField idTF;
	private JPasswordField passTF;
	private JTextField nameTF;
	private JTextField addressTF;
	private JComboBox ageComobBox;
	private JCheckBox marriedCheckBox;
	private JLabel idMsgLB;
	private JTextField loginIdTF;
	private JPasswordField loginPassTF;
	private JTextField infoIdTF;
	private JPasswordField infoPassTF;
	private JTextField infoNameTF;
	private JTextField infoAddressTF;
	private JTabbedPane memberTabbedPane;
	private JComboBox infoAgeComboBox;
	private JCheckBox infoMarriedCheckBox;
	private JMenuItem loginMenuItem;
	private JMenuItem joinMenuItem;
	private JMenuItem logoutMenuItem;
	private JButton updateFormBtn;
	private JButton updateBtn;
	private JTable memberListTable;
	private JButton memberDeleteBtn;
	private JList memberListList;
	private JComboBox memberComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberMainFrame frame = new MemberMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MemberMainFrame()throws Exception {
		setTitle("회원관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 574);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("D2Coding", Font.BOLD, 13));
		setJMenuBar(menuBar);
		
		JMenu memberMenu = new JMenu("회원");
		menuBar.add(memberMenu);
		
		loginMenuItem = new JMenuItem("로그인");
		loginMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberTabbedPane.setSelectedIndex(1);
			}
		});
		memberMenu.add(loginMenuItem);
		
		joinMenuItem = new JMenuItem("가입");
		joinMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberTabbedPane.setSelectedIndex(2);
			}
			
		});
		memberMenu.add(joinMenuItem);
		
		logoutMenuItem = new JMenuItem("로그아웃");
		logoutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logoutProcess();
			}
		});
		memberMenu.add(logoutMenuItem);
		
		JSeparator separator = new JSeparator();
		memberMenu.add(separator);
		
		JMenuItem exitMenuItem = new JMenuItem("종료");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		memberMenu.add(exitMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		memberTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		memberTabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int selectedTabIndex=memberTabbedPane.getSelectedIndex();
				if(selectedTabIndex==4) {
					displayMemberList();
				}
			}
		});
		
		memberTabbedPane.setFont(new Font("D2Coding", Font.BOLD, 13));
		contentPane.add(memberTabbedPane, BorderLayout.CENTER);
		
		JPanel memberMainPanel = new JPanel();
		memberTabbedPane.addTab("회원메인", null, memberMainPanel, null);
		memberMainPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel memberMainLabel = new JLabel("");
		memberMainLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(loginMember==null) {
					memberTabbedPane.setSelectedIndex(1);
				}else {
					memberTabbedPane.setSelectedIndex(3);
				}
			}
		});
		memberMainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		memberMainLabel.setIcon(new ImageIcon(MemberMainFrame.class.getResource("/images/album.jpg")));
		memberMainPanel.add(memberMainLabel, BorderLayout.CENTER);
		
		JPanel memberLoginPanel = new JPanel();
		memberLoginPanel.setBackground(new Color(192, 192, 192));
		memberTabbedPane.addTab("회원로그인", null, memberLoginPanel, null);
		memberLoginPanel.setLayout(null);
		
		JLabel loginIdLabel = new JLabel("아이디");
		loginIdLabel.setBounds(96, 71, 57, 15);
		memberLoginPanel.add(loginIdLabel);
		
		JLabel lgoinPasswordLabel = new JLabel("패쓰워드");
		lgoinPasswordLabel.setBounds(96, 133, 57, 15);
		memberLoginPanel.add(lgoinPasswordLabel);
		
		loginIdTF = new JTextField();
		loginIdTF.setBounds(196, 68, 116, 21);
		memberLoginPanel.add(loginIdTF);
		loginIdTF.setColumns(10);
		
		loginPassTF = new JPasswordField();
		loginPassTF.setBounds(196, 130, 116, 21);
		memberLoginPanel.add(loginPassTF);
		
		JButton loginBtn = new JButton("로그인");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***********회원로그인************/
				try {
					String id = loginIdTF.getText();
					String pass=new String(loginPassTF.getPassword());
					
					int result = memberService.login(id, pass);
					if(result==0) {
						//로그인성공
						loginProcess(id);
						loginIdTF.setText("");
						loginPassTF.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "아이디또는 비밀번호를 확인하세요");
						loginIdTF.setSelectionStart(0);
						loginIdTF.setSelectionEnd(id.length());
						loginIdTF.requestFocus();
					}
					
					
					
				}catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});
		loginBtn.setBounds(96, 192, 97, 23);
		memberLoginPanel.add(loginBtn);
		
		JButton joinBtn = new JButton("회원가입");
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberTabbedPane.setSelectedIndex(1);
			}
		});
		joinBtn.setBounds(215, 192, 97, 23);
		memberLoginPanel.add(joinBtn);
		
		JPanel memberJoinPanel = new JPanel();
		memberJoinPanel.setBackground(new Color(192, 192, 192));
		memberTabbedPane.addTab("회원가입", null, memberJoinPanel, null);
		memberJoinPanel.setLayout(null);
		
		JLabel joinIdLabel = new JLabel("아이디");
		joinIdLabel.setBounds(84, 61, 57, 15);
		memberJoinPanel.add(joinIdLabel);
		
		idTF = new JTextField();
		idTF.setBounds(181, 54, 116, 21);
		memberJoinPanel.add(idTF);
		idTF.setColumns(10);
		
		JLabel joinPasswordLabel = new JLabel("패쓰워드");
		joinPasswordLabel.setBounds(84, 110, 57, 15);
		memberJoinPanel.add(joinPasswordLabel);
		
		JLabel joinNameLabel = new JLabel("이름");
		joinNameLabel.setBounds(84, 163, 57, 15);
		memberJoinPanel.add(joinNameLabel);
		
		JLabel joinAddressLabel = new JLabel("주소");
		joinAddressLabel.setBounds(84, 206, 57, 15);
		memberJoinPanel.add(joinAddressLabel);
		
		JLabel joinAgeLabel = new JLabel("나이");
		joinAgeLabel.setBounds(84, 265, 57, 15);
		memberJoinPanel.add(joinAgeLabel);
		
		JLabel joinMarriedLabel = new JLabel("결혼여부");
		joinMarriedLabel.setBounds(84, 323, 57, 15);
		memberJoinPanel.add(joinMarriedLabel);
		
		passTF = new JPasswordField();
		passTF.setBounds(181, 104, 116, 18);
		memberJoinPanel.add(passTF);
		
		nameTF = new JTextField();
		nameTF.setBounds(181, 156, 116, 21);
		memberJoinPanel.add(nameTF);
		nameTF.setColumns(10);
		
		addressTF = new JTextField();
		addressTF.setBounds(181, 199, 116, 21);
		memberJoinPanel.add(addressTF);
		addressTF.setColumns(10);
		
		ageComobBox = new JComboBox();
		ageComobBox.setModel(new DefaultComboBoxModel(new String[] {"20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34"}));
		ageComobBox.setBounds(181, 257, 116, 23);
		memberJoinPanel.add(ageComobBox);
		
		marriedCheckBox = new JCheckBox("");
		marriedCheckBox.setBounds(181, 319, 27, 19);
		memberJoinPanel.add(marriedCheckBox);
		
		JButton memberJoinBtn = new JButton("가입");
		memberJoinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*********** 회원가입 ************/
				try {
					/******TextField로 부터 데이타얻기*****/
					String id = idTF.getText();
					String password=new String(passTF.getPassword());
					String name=nameTF.getText();
					String address=addressTF.getText();
					/***********유효성체크****************/
					if(id.equals("")) {
						 idMsgLB.setText("아이디를 입력하세요.");
						 idTF.requestFocus();
						return;
					}
					String ageStr=(String)ageComobBox.getSelectedItem();
					int age = Integer.parseInt(ageStr);
					String married="";
					if(marriedCheckBox.isSelected()) {
						married="T";
					}else {
						married="F";
					}
					
					
					Member newMember=new Member(id,password,name,address,age,married,null);
					boolean isAdd = memberService.addMember(newMember);
					if(isAdd) {
						//로그인화면전환
						 memberTabbedPane.setSelectedIndex(1);
					}else {
						JOptionPane.showMessageDialog(null, "이미사용하고있는 아이디입니다.");
						idTF.requestFocus();
						idTF.setSelectionStart(0);
						idTF.setSelectionEnd(id.length());
					}
				}catch (Exception e1) {
					System.out.println("회원가입-->"+e1.getMessage());
				}
			}
		});
		memberJoinBtn.setBounds(84, 375, 97, 23);
		memberJoinPanel.add(memberJoinBtn);
		
		JButton memberCancleBtn = new JButton("취소");
		memberCancleBtn.setBounds(210, 375, 97, 23);
		memberJoinPanel.add(memberCancleBtn);
		
		idMsgLB = new JLabel("");
		idMsgLB.setForeground(Color.RED);
		idMsgLB.setBounds(131, 88, 116, 15);
		memberJoinPanel.add(idMsgLB);
		
		JPanel memberInfoPanel = new JPanel();
		memberInfoPanel.setBackground(Color.LIGHT_GRAY);
		memberTabbedPane.addTab("회원정보", null, memberInfoPanel, null);
		memberInfoPanel.setLayout(null);
		
		JLabel memberInfoIdLabel = new JLabel("아이디");
		memberInfoIdLabel.setBounds(84, 50, 57, 15);
		memberInfoPanel.add(memberInfoIdLabel);
		
		infoIdTF = new JTextField();
		infoIdTF.setEnabled(false);
		infoIdTF.setColumns(10);
		infoIdTF.setBounds(162, 47, 116, 21);
		memberInfoPanel.add(infoIdTF);
		
		JLabel memberInfoPasswordLabel = new JLabel("패쓰워드");
		memberInfoPasswordLabel.setBounds(84, 99, 57, 15);
		memberInfoPanel.add(memberInfoPasswordLabel);
		
		infoPassTF = new JPasswordField();
		infoPassTF.setEditable(false);
		infoPassTF.setBounds(162, 97, 116, 18);
		memberInfoPanel.add(infoPassTF);
		
		JLabel memberInNameLabel = new JLabel("이름");
		memberInNameLabel.setBounds(84, 152, 57, 15);
		memberInfoPanel.add(memberInNameLabel);
		
		infoNameTF = new JTextField();
		infoNameTF.setEditable(false);
		infoNameTF.setColumns(10);
		infoNameTF.setBounds(162, 149, 116, 21);
		memberInfoPanel.add(infoNameTF);
		
		JLabel memberInAddressLabel = new JLabel("주소");
		memberInAddressLabel.setBounds(84, 195, 57, 15);
		memberInfoPanel.add(memberInAddressLabel);
		
		infoAddressTF = new JTextField();
		infoAddressTF.setEditable(false);
		infoAddressTF.setColumns(10);
		infoAddressTF.setBounds(162, 192, 116, 21);
		memberInfoPanel.add(infoAddressTF);
		
		JLabel memberInAgeLabel = new JLabel("나이");
		memberInAgeLabel.setBounds(84, 254, 57, 15);
		memberInfoPanel.add(memberInAgeLabel);
		
		infoAgeComboBox = new JComboBox();
		infoAgeComboBox.setEnabled(false);
		infoAgeComboBox.setModel(new DefaultComboBoxModel(new String[] {"20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34"}));
		infoAgeComboBox.setBounds(162, 250, 116, 23);
		memberInfoPanel.add(infoAgeComboBox);
		
		JLabel memberInMarriedLabel = new JLabel("결혼여부");
		memberInMarriedLabel.setBounds(84, 316, 57, 15);
		memberInfoPanel.add(memberInMarriedLabel);
		
		infoMarriedCheckBox = new JCheckBox("");
		infoMarriedCheckBox.setEnabled(false);
		infoMarriedCheckBox.setBounds(162, 312, 27, 19);
		memberInfoPanel.add(infoMarriedCheckBox);
		
		updateFormBtn = new JButton("수정폼");
		updateFormBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String btnText=updateFormBtn.getText();
				if(btnText.equals("수정폼")) {
					updateFormEnable(true);
				}else if(btnText.equals("수정취소")) {
					displayMemberInfo(loginMember);
					updateFormEnable(false);
				}
				
				
			}
		});
		updateFormBtn.setBounds(77, 379, 97, 23);
		memberInfoPanel.add(updateFormBtn);
		
		updateBtn = new JButton("수정");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**************** 회원수정 ***************/
				try {
					/******TextField로 부터 데이타얻기*****/
					String id = infoIdTF.getText();
					String password=new String(infoPassTF.getPassword());
					String name=infoNameTF.getText();
					String address=infoAddressTF.getText();
					
					String ageStr=(String)infoAgeComboBox.getSelectedItem();
					int age = Integer.parseInt(ageStr);
					String married="";
					if(infoMarriedCheckBox.isSelected()) {
						married="T";
					}else {
						married="F";
					}
					Member member=new Member(id,password,name,address,age,married,null);
					memberService.memberUpdate(member);
					loginMember = memberService.memberDetail(id);
					updateFormEnable(false);
				}catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		updateBtn.setBounds(186, 379, 97, 23);
		memberInfoPanel.add(updateBtn);
		
		JPanel memberAdminPanel = new JPanel();
		memberTabbedPane.addTab("회원관리", null, memberAdminPanel, null);
		memberAdminPanel.setLayout(null);
		
		JScrollPane memberTableScrollPane = new JScrollPane();
		memberTableScrollPane.setBounds(0, 10, 389, 110);
		memberAdminPanel.add(memberTableScrollPane);
		
		memberListTable = new JTable();
		memberListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selected_index = memberListTable.getSelectedRow();
				memberDeleteBtn.setEnabled(true);
				
			}
		});
		memberListTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"\uC544\uC774\uB514", "\uD328\uC4F0\uC6CC\uB4DC", "\uC774\uB984", "\uC8FC\uC18C", "\uB098\uC774", "\uACB0\uD63C\uC5EC\uBD80", "\uB4F1\uB85D\uC77C"
			}
		) {
			Class[] columnTypes = new Class[] {
				Long.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		memberTableScrollPane.setViewportView(memberListTable);
		
		memberComboBox = new JComboBox();
		memberComboBox.setModel(new DefaultComboBoxModel(new String[] {"김경호", "김경미", "김경양", "김경가", "김경나"}));
		memberComboBox.setBounds(201, 221, 146, 23);
		memberAdminPanel.add(memberComboBox);
		
		JScrollPane memberListScrollpane = new JScrollPane();
		memberListScrollpane.setBounds(12, 223, 127, 182);
		memberAdminPanel.add(memberListScrollpane);
		
		memberListList = new JList();
		memberListList.setModel(new AbstractListModel() {
			String[] values = new String[] {"김경호", "김경미", "김경양", "김경가", "김경나", "김경호", "김경미", "김경양", "김경가", "김경나", "김경호", "김경미", "김경양", "김경가", "김경나"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		memberListScrollpane.setViewportView(memberListList);
		
		JButton memberListBtn = new JButton("회원리스트");
		memberListBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayMemberList();
			}
		});
		memberListBtn.setBounds(65, 148, 104, 23);
		memberAdminPanel.add(memberListBtn);
		
		memberDeleteBtn = new JButton("회원삭제");
		memberDeleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int selectedRow = memberListTable.getSelectedRow();
					if(selected_index >= 0) {
						String selectedId=(String)memberListTable.getValueAt(selectedRow, 0);
						memberService.memberDelete(selectedId);
						displayMemberList();
					}else {
						memberDeleteBtn.setEnabled(false);
						
					}
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		memberDeleteBtn.setEnabled(false);
		memberDeleteBtn.setBounds(213, 148, 97, 23);
		memberAdminPanel.add(memberDeleteBtn);
		
		/******2.MemberService멤버필드객체생성*********/
		memberService=new MemberService();
		logoutProcess();
		
	}//생성자끝
	
	/*****************************************************/
	private void displayMemberList() {
		
		try {
			List<Member> memberList = memberService.memberList();
			/***************회원리스트보기[JTable]************/
			Vector  columnVector=new Vector();
			columnVector.add("아이디");
			columnVector.add("패쓰워드");
			columnVector.add("이름");
			columnVector.add("주소");
			columnVector.add("나이");
			columnVector.add("결혼");
			columnVector.add("가입일");
			
			Vector  tableVector=new Vector();
			
			for(Member member:memberList) {
				Vector rowVector=new Vector();
				rowVector.add(member.getMemberId());
				rowVector.add(member.getMemberPassword());
				rowVector.add(member.getMemberName());
				rowVector.add(member.getMemberAddress());
				rowVector.add(member.getMemberAge());
				rowVector.add(member.getMemberMarried());
				rowVector.add(member.getMemberRegdate());
				tableVector.add(rowVector);
			}
			DefaultTableModel tableModel=
					new DefaultTableModel(tableVector, columnVector);
			
			memberListTable.setModel(tableModel);
			memberDeleteBtn.setEnabled(false);	
			
			/***************회원리스트보기[JList]****************/
			DefaultListModel listModel=new DefaultListModel();
			for(Member member:memberList) {
				listModel.addElement(member.getMemberId());
			}
			memberListList.setModel(listModel);
			/***************회원리스트보기[JCombobox]************/
			DefaultComboBoxModel  comboBoxModel=new DefaultComboBoxModel();
			for (Member member : memberList) {
				comboBoxModel.addElement(member.getMemberName()+"["+member.getMemberId()+"]");
			}
			memberComboBox.setModel(comboBoxModel);
			
			
		}catch(Exception e1) {
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}
		
	}
	
	/*************회원수정폼활성화 불활성화****************/
	private void updateFormEnable(boolean b) {
		if(b) {
			//활성화
			//infoIdTF.setEnabled(true);
			//infoPassTF.setEnabled(true);
			infoNameTF.setEditable(true);
			infoAddressTF.setEditable(true);
			infoAgeComboBox.setEnabled(true);
			infoMarriedCheckBox.setEnabled(true);
			
			updateFormBtn.setText("수정취소");
			updateBtn.setEnabled(true);
		}else {
			//불활성화
			infoIdTF.setEnabled(false);
			infoPassTF.setEnabled(false);
			infoNameTF.setEditable(false);
			infoAddressTF.setEditable(false);
			infoAgeComboBox.setEnabled(false);
			infoMarriedCheckBox.setEnabled(false);
			
			updateFormBtn.setText("수정폼");
			updateBtn.setEnabled(false);
		}
		
	}
	
	
	/**************로그아웃시   호출할메쏘드***************/
	private void logoutProcess() {
		/***********로그아웃시 해야할일***********
		 1.로그인성공한 멤버객체 멤버필드에서제거
		 2.MemberMainFrame타이틀변경
		 3.로그인,회원가입탭 활성화,회원정보탭 불활성화
		   로그인,회원가입 메뉴아이템 활성화
		   로그아웃 메뉴아이템 불활성화
		 
		 4.메인 화면전환
		********************************************/
		this.loginMember=null;
		setTitle("회원관리");
		
		memberTabbedPane.setEnabledAt(1, true);
		memberTabbedPane.setEnabledAt(2, true);
		memberTabbedPane.setEnabledAt(3, false);
		loginMenuItem.setEnabled(true);
		joinMenuItem.setEnabled(true);
		logoutMenuItem.setEnabled(false);
		
		memberTabbedPane.setSelectedIndex(0);
	}
	/**************로그인성공시 호출할메쏘드***************/
	private void loginProcess(String id) throws Exception{
		/***********로그인성공시 해야할일***********
		 1.로그인성공한 멤버객체 멤버필드에저장
		 2.MemberMainFrame타이틀변경
		 3.로그인,회원가입탭 불활성화
		   로그인,회원가입 메뉴아이템 불활성화
		   로그아웃 메뉴아이템 활성화
		 4.회원정보보기 화면전환
		********************************************/
		//1.로그인성공한 멤버객체 멤버필드에저장
		this.loginMember = memberService.memberDetail(id);
		//2.MemberMainFrame타이틀변경
		setTitle(id+" 님 로그인");
		// 3.로그인,회원가입탭 불활성화
		memberTabbedPane.setEnabledAt(1, false);
		memberTabbedPane.setEnabledAt(2, false);
		memberTabbedPane.setEnabledAt(3, true);
		loginMenuItem.setEnabled(false);
		joinMenuItem.setEnabled(false);
		logoutMenuItem.setEnabled(true);
		
		
		// 4.회원정보보기 화면전환
		memberTabbedPane.setSelectedIndex(3);
		displayMemberInfo(this.loginMember);
		updateFormEnable(false);
	}
	
	private void displayMemberInfo(Member member) {
		/****회원상세데이타보여주기*****/
		infoIdTF.setText(member.getMemberId());
		infoPassTF.setText(member.getMemberPassword());
		infoNameTF.setText(member.getMemberName());
		infoAddressTF.setText(member.getMemberAddress());
		infoAgeComboBox.setSelectedItem(member.getMemberAge()+"");
		if(member.getMemberMarried().equals("T")) {
			infoMarriedCheckBox.setSelected(true);
		}else {
			infoMarriedCheckBox.setSelected(false);
		}
		
	}
}

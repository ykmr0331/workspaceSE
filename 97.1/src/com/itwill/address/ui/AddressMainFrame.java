package com.itwill.address.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

public class AddressMainFrame extends JFrame {
	/******1.AddressService 멤버필드선언******/
	private AddressService addressService;
	/****************************************/
	
	private JPanel contentPane;
	private JTextField insertNameTextField;
	private JTextField insertPhoneTextField;
	private JTextField insertAddressTextField;
	private JTextField detailNameTextField;
	private JTextField detailPhoneTextField;
	private JTextField detailAddressTextField;
	private JTextField detailNoTextField;
	private JTable addressListTable;
	private JTextField detailNoTextField2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressMainFrame frame = new AddressMainFrame();
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
	public AddressMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane addressTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(addressTabbedPane, BorderLayout.CENTER);
		
		JPanel addressInsertPanel = new JPanel();
		addressTabbedPane.addTab("주소록쓰기", null, addressInsertPanel, null);
		addressInsertPanel.setLayout(null);
		
		JLabel insertNameLabel = new JLabel("이름");
		insertNameLabel.setBounds(68, 45, 57, 15);
		addressInsertPanel.add(insertNameLabel);
		
		JLabel insertPhoneLabel = new JLabel("전화번호");
		insertPhoneLabel.setBounds(68, 98, 57, 15);
		addressInsertPanel.add(insertPhoneLabel);
		
		JLabel insertAddressLabel = new JLabel("주소");
		insertAddressLabel.setBounds(68, 147, 57, 18);
		addressInsertPanel.add(insertAddressLabel);
		
		insertNameTextField = new JTextField();
		insertNameTextField.setBounds(200, 42, 116, 21);
		addressInsertPanel.add(insertNameTextField);
		insertNameTextField.setColumns(10);
		
		insertPhoneTextField = new JTextField();
		insertPhoneTextField.setBounds(200, 95, 116, 21);
		addressInsertPanel.add(insertPhoneTextField);
		insertPhoneTextField.setColumns(10);
		
		insertAddressTextField = new JTextField();
		insertAddressTextField.setBounds(200, 146, 116, 21);
		addressInsertPanel.add(insertAddressTextField);
		insertAddressTextField.setColumns(10);
		
		JButton addressInsertButton = new JButton("주소록쓰기");
		addressInsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*******주소록쓰기*********/
				
				try {
					//1.TextField로부터데이타얻기
					String name=insertNameTextField.getText();
					String phone=insertPhoneTextField.getText();
					String address=insertAddressTextField.getText();
					
					Address newAddress=new Address(0,name,phone,address);
					//2.addressService.addressWrite()메쏘드호출
					int rowCount=
							addressService.addressWrite(newAddress);
					JOptionPane.showMessageDialog(null, "주소쓰기성공");
					addressTabbedPane.setSelectedIndex(1);
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "주소쓰기실패");
					e1.printStackTrace();
				}
				
				/**************************/
			}
		});
		addressInsertButton.setBounds(119, 219, 150, 23);
		addressInsertPanel.add(addressInsertButton);
		
		JPanel addressListPanel = new JPanel();
		addressTabbedPane.addTab("주소록리스트", null, addressListPanel, null);
		addressListPanel.setLayout(null);
		
		JButton addressListButton = new JButton("주소록리스트");
		addressListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**********주소록리스트*************/
				
				try {
					
					List<Address> addressList= addressService.addressList();
					System.out.println("----------------UI에서출력-------------------");
					System.out.println(addressList);
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
				/**********************************/
			}
		});
		addressListButton.setBounds(110, 200, 150, 23);
		addressListPanel.add(addressListButton);
		
		JScrollPane addressListScrollPane = new JScrollPane();
		addressListScrollPane.setBounds(12, 10, 359, 180);
		addressListPanel.add(addressListScrollPane);
		
		addressListTable = new JTable();
		addressListTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\uBC88\uD638", "\uC774\uB984", "\uC804\uD654\uBC88\uD638", "\uC8FC\uC18C"
			}
		));
		addressListScrollPane.setViewportView(addressListTable);
		
		JPanel addressDetailPanel = new JPanel();
		addressDetailPanel.setLayout(null);
		addressTabbedPane.addTab("주소록상세보기", null, addressDetailPanel, null);
		
		JLabel detailNameLabel = new JLabel("이름");
		detailNameLabel.setBounds(68, 130, 57, 15);
		addressDetailPanel.add(detailNameLabel);
		
		JLabel detailPhoneLabel = new JLabel("전화번호");
		detailPhoneLabel.setBounds(68, 183, 57, 15);
		addressDetailPanel.add(detailPhoneLabel);
		
		JLabel detailAddressLabel = new JLabel("주소");
		detailAddressLabel.setBounds(68, 232, 57, 18);
		addressDetailPanel.add(detailAddressLabel);
		
		detailNameTextField = new JTextField();
		detailNameTextField.setEditable(false);
		detailNameTextField.setColumns(10);
		detailNameTextField.setBounds(200, 127, 116, 21);
		addressDetailPanel.add(detailNameTextField);
		
		detailPhoneTextField = new JTextField();
		detailPhoneTextField.setEditable(false);
		detailPhoneTextField.setColumns(10);
		detailPhoneTextField.setBounds(200, 180, 116, 21);
		addressDetailPanel.add(detailPhoneTextField);
		
		detailAddressTextField = new JTextField();
		detailAddressTextField.setEditable(false);
		detailAddressTextField.setColumns(10);
		detailAddressTextField.setBounds(200, 231, 116, 21);
		addressDetailPanel.add(detailAddressTextField);
		
		JButton addressDetailButton = new JButton("번호로찾기");
		addressDetailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/**************주소록1개 상세보기*******************/
				try {
					String noStr = detailNoTextField.getText();
					/**************유효성 체크***************/
					if(noStr == null ||  noStr.equals("")) {
						JOptionPane.showMessageDialog(null, "번호를 입력하세요");
						detailNoTextField.requestFocus();
						return;						
					}
					int no = Integer.parseInt(noStr);
					/***********************addressService.addressDetail(no)호출*************************/
					Address findAddress = addressService.addressDetail(no);
					if(findAddress != null) {
						detailNoTextField2.setText(findAddress.getNo()+ "");
						detailNameTextField.setText(findAddress.getName());
						detailPhoneTextField.setText(findAddress.getPhone());
						detailAddressTextField.setText(findAddress.getAddress());
						
						System.out.println(findAddress);
					} else {
						JOptionPane.showMessageDialog(null, "존재하지 않는 주소입니다.");
					} 
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				/***********************************************/
			}
		});
		addressDetailButton.setBounds(200, 21, 116, 23);
		addressDetailPanel.add(addressDetailButton);
		
		detailNoTextField = new JTextField();
		detailNoTextField.setBounds(131, 22, 57, 21);
		addressDetailPanel.add(detailNoTextField);
		detailNoTextField.setColumns(10);
		
		JLabel detailNoLabel = new JLabel("<html><b>번호입력:</b></html>");
		detailNoLabel.setBounds(68, 25, 57, 19);
		addressDetailPanel.add(detailNoLabel);
		
		JLabel detailNoLabel2 = new JLabel("번호");
		detailNoLabel2.setBounds(68, 74, 57, 15);
		addressDetailPanel.add(detailNoLabel2);
		
		detailNoTextField2 = new JTextField();
		detailNoTextField2.setEditable(false);
		detailNoTextField2.setColumns(10);
		detailNoTextField2.setBounds(200, 71, 116, 21);
		addressDetailPanel.add(detailNoTextField2);
		/**********2.AddressService객체생성**********/
		try {
			this.addressService=new AddressService();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		/******************************************/
	}//생성자 끝
}
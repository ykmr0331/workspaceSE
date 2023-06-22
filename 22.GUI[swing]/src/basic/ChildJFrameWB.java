package basic;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ChildJFrameWB extends JFrame {

	private JPanel contentPane;
	private JButton okBtn;
	private JButton cancelBtn;

	// 프로그램 실행 진입점
	public static void main(String[] args) {
	
		ChildJFrameWB frame = new ChildJFrameWB(); // ChildJFrameWB 객체 생성
		frame.setVisible(true); // 프레임을 화면에 표시
		
	}

	
	public ChildJFrameWB() {
		setTitle("나의첫번째W프레임"); // 프레임의 제목 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼을 눌렀을 때 프로그램 종료 설정
		setBounds(100, 100, 450, 300); // 프레임의 위치와 크기 설정
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE); // 배경색을 파란색으로 설정
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // 내부 여백 설정

		setContentPane(contentPane); // 프레임의 콘텐츠 패널로 contentPane 설정
		contentPane.setLayout(null); // 레이아웃 매니저를 null로 설정하여 컴포넌트의 위치와 크기 직접 지정
		
		okBtn = new JButton("확인"); // "확인" 버튼 생성
		okBtn.setBounds(63, 122, 97, 23); // 버튼의 위치와 크기 설정
		contentPane.add(okBtn); // contentPane에 버튼 추가
		
		cancelBtn = new JButton("취소"); // "취소" 버튼 생성
		cancelBtn.setBounds(256, 122, 97, 23); // 버튼의 위치와 크기 설정
		contentPane.add(cancelBtn); // contentPane에 버튼 추가
	}
}

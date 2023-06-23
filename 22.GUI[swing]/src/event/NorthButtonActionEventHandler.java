package event;

import java.awt.Color;
import java.awt.event.ActionEvent;//ActionEvent 클래스를 가져옵니다.
import java.awt.event.ActionListener;//ActionListener 인터페이스를 가져옵니다

import javax.swing.JButton;

//  이벤트는 사용자의 입력이나 시스템의 변화와 같은 이벤트 소스에서 발생하는 사건입니다

public class NorthButtonActionEventHandler implements ActionListener{
	//ActionListener 인터페이스는 액션 이벤트(사용자 입력에 의해 발생하는 이벤트)를 처리하는 데 사용되는 인터페이스입니다.
	//ActionListener 인터페이스는 JButton, JCheckBox, JRadioButton과 같은 컴포넌트에서 구현됌(컴포넌트는 클래스임)
	private ActionEventJFrame frame;
	private int buttonClickCount=0;
	


	public NorthButtonActionEventHandler(ActionEventJFrame frame) {//생성자
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {  // 이벤트가 발생할때마다 호출된다.
		
//		System.out.println("north button click!!");
//		System.out.println("실행쓰레드이름:"
//				+Thread.currentThread().getName());
		
		//컴포넌트는 자바에서 UI를 구성하는 데 사용되는 객체입니다.
		//자바에서 가장 많이 사용되는 컴포넌트는 JButton, JLabel, JTextField, JTextArea 등이 있습니다.
		
		Object eventSource = e.getSource();//e 이벤트 객체의 getSource() 메서드를 호출하여 이벤트를 발생시킨 컴포넌트를 가져옵니다.
		System.out.println(eventSource);
		JButton eventSourceButton = (JButton)eventSource; // 이벤트를 발생시킨 컴포넌트를 JButton타입으로 바꾼다.
		eventSourceButton.setText("이벤트소스[NORTH]" + ++buttonClickCount);//자바에서 setText() 메서드는 텍스트 컴포넌트의 텍스트를 설정하는 데 사용됩니다.
																			//이 메서드는 String 인수를 취하고 텍스트 컴포넌트의 텍스트를 해당 문자열로 설정합니다.
		
		/****************************ActionEventFrame의 멤버접근***************
		*	프레임의 타이틀 변경
		*	contentPane(프레임의 멤버필드)의 배경색변경
		*	
		*/
		frame.setTitle("button Click count: " +buttonClickCount);//프레임의 제목을 설정하는 데 사용됩니다
		int r = (int)(Math.random() * 256);
		int g = (int)(Math.random() * 256);
		int b = (int)(Math.random() * 256);
		frame.contentPane.setBackground(new Color(r,g,b));// 검은색
		 
		
	}

}
package event;

import java.awt.event.ActionEvent;//ActionEvent 클래스를 가져옵니다.
import java.awt.event.ActionListener;//ActionListener 인터페이스를 가져옵니다

public class NorthButtonActionEventHandler implements ActionListener{
	//ActionListener 인터페이스는 액션 이벤트(사용자 입력에 의해 발생하는 이벤트)를 처리하는 데 사용되는 인터페이스입니다.
	//ActionListener 인터페이스는 JButton, JCheckBox, JRadioButton과 같은 컴포넌트에서 구현됌(컴포넌트는 클래스임)
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("north button click!!");
		System.out.println("실행쓰레드이름:"
				+Thread.currentThread().getName());
		Object eventSource = e.getSource();//e 이벤트 객체의 getSource() 메서드를 호출하여 이벤트를 발생시킨 컴포넌트를 가져옵니다.
		System.out.println(eventSource);
		
	}

}
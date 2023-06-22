package event;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

// 이벤트 소스(JButton)에 이벤트 핸들러(NorthButtonActionEventHandler)를 등록합니다.
public class ActionEventJFrame extends JFrame {

	/**
	JFrame은 Java Swing 프레임워크의 최상위 컨테이너 클래스입니다. 
	JFrame은 GUI를 만들기 위한 기본 프레임워크를 제공하며, 다른 컴포넌트를 포함할 수 있습니다. 
	JFrame은 크기, 위치, 타이틀, 콘텐츠 등을 설정할 수 있습니다.
	JFrame은 Java Swing 프레임워크의 가장 기본적인 컴포넌트 중 하나이며, GUI를 만들기 위해 자주 사용됩니다.**/
	
	
	//GUI(Graphical User Interface)는 그래픽 사용자 인터페이스를 의미합니다

	/*
	 * 컴포넌트는 GUI(Graphical User Interface)를 구성하는 기본 요소입니다.(GUI를 구현한거임)
	 *  컴포넌트는 텍스트, 이미지, 버튼, 라벨 등 다양한 형태로 나타날 수 있습니다.
	 *  컴포넌트는 사용자와 상호 작용하고, 이벤트를 처리할 수 있습니다. 
	 *  컴포넌트는 Java Swing, HTML, CSS, JavaScript 등 다양한 프레임워크에서 사용됩니다.
	 *	컴포넌트는 클래스임!!!!!!!!!!!!!!!!!!!!!!
	 */
	
    private JPanel contentPane;// JPanel(클래스): 컴포넌트를 포함하고 관리하는 데 사용되는 컨테이너 컴포넌트를 생성하는 데 사용됩니다.
    private JButton northButton;// JButton(클래스): 사용자가 클릭할 수 있는 버튼 컴포넌트

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    	  
    	// EventQueue.invokeLater()는 주 스레드가 아닌 별도의 스레드에서 코드를 실행합니다.
    	  // 이렇게 하면 UI 이벤트를 처리하는 데 필요한 작업이 주 스레드에서 차단되지 않습니다.
    	  EventQueue.invokeLater(new Runnable() { /* EventQueue.invokeLater(): 실행하면 새로운 쓰레드 생성, 
    		  																   이렇게 하면 UI 이벤트를 처리하는 데 필요한 작업이 주 스레드에서 차단되지 않음*/
    		  									//new Runnable(){} : Runnable인터페이스를 구현하는 익명 클래스를 생성합니다
    	   
    		  public void run() {
    	      try {
    	        // ActionEventJFrame 클래스의 인스턴스를 생성합니다.
    	        ActionEventJFrame frame = new ActionEventJFrame();

    	        // frame의 setVisible() 메서드를 호출하여 프레임을 표시합니다.
    	        frame.setVisible(true);
    	      } catch (Exception e) {
    	        // e.printStackTrace()는 예외를 로깅합니다.
    	        e.printStackTrace();
    	      }
    	    }//run메소드끝, 생성된 쓰레드 종료
    	  });//여기서 invokeLater()메서드 끝남
    	  
    	 /* 이 코드에서 invokeLater() 메서드는 Runnable 인터페이스를 구현하는 익명 클래스를 전달받아, 
    	  * 별도의 스레드에서 해당 익명 클래스의 run() 메서드를 실행합니다. 
    	  * run() 메서드는 ActionEventJFrame 클래스의 인스턴스를 생성하고 setVisible() 메서드를 호출하여 프레임을 표시합니다.
    	  *  run() 메서드는 별도의 스레드에서 실행되므로 UI 이벤트를 처리하는 데 필요한 작업이 주 스레드에서 차단되지 않습니다*/
    	}

    /**
     * Create the frame.
     */
    public ActionEventJFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 프레임을 닫을 때 프로그램을 종료합니다.
        setBounds(100, 100, 230, 287);// 프레임을 100x100px 크기로 생성합니다.
        contentPane = new JPanel();
	        /*JPanel은 Swing 프레임워크에서 제공되는 컨테이너 컴포넌트(클래스)입니다. 
	         * JPanel은 컴포넌트를 포함하고 관리하는 데 사용할 수 있습니다. 
	         * JPanel은 다양한 레이아웃 매니저를 사용하여 컴포넌트를 배치할 수 있습니다.*/
        
  
        // contentPane의 테두리를 5px로 설정합니다.
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        // contentPane(JPanel타입)을 프레임의 콘텐츠 영역으로 설정합니다.
        setContentPane(contentPane);
       
        // contentPane의 레이아웃을 BorderLayout으로 설정합니다.
        contentPane.setLayout(new BorderLayout(0, 0));
       
        /// northButton이라는 새로운 JButton을 생성하고 "이벤트쏘스[NORTH]"라는 텍스트를 설정합니다.
        northButton = new JButton("이벤트쏘스[NORTH]");
        
        // northButton을 contentPane에 BorderLayout.NORTH 위치에 추가합니다.
        contentPane.add(northButton, BorderLayout.NORTH);

        // 이벤트 소스(northButton)에 이벤트 핸들러(NorthButtonActionEventHandler)를 등록합니다.
        northButton.addActionListener(
					/*	addActionListener() 메서드는 컴포넌트에 액션 리스너를 추가하는 데 사용됩니다. 
						액션 리스너는 액션 이벤트가 발생했을 때 호출되는 리스너입니다*/
                new NorthButtonActionEventHandler());
    }

}
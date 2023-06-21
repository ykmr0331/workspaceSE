package wb;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LoginFrame extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

    /**
     * 애플리케이션을 실행합니다.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginFrame frame = new LoginFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 프레임을 생성합니다.
     */
    public LoginFrame() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/image/free-icon-user-5264565.png")));
        setTitle("로그인"); // 프레임의 제목을 설정합니다.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 564, 361); // 프레임의 위치와 크기를 설정합니다.
        contentPane = new JPanel();
        contentPane.setBackground(new Color(26, 224, 230)); // 패널의 배경색을 설정합니다.
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // 패널 주위에 빈 테두리를 설정합니다.

        setContentPane(contentPane); // 프레임의 콘텐츠 패널을 설정합니다.
        contentPane.setLayout(null); // 컴포넌트의 위치를 절대 좌표로 설정하기 위해 null 레이아웃을 사용합니다.

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/free-icon-login-295128.png")));
        lblNewLabel.setBounds(12, 10, 249, 302); // 레이블의 위치와 크기를 설정합니다.
        contentPane.add(lblNewLabel); // 패널에 레이블을 추가합니다.

        JLabel lblNewLabel_1 = new JLabel("                  userLogin");
        lblNewLabel_1.setFont(new Font("궁서체", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(285, 96, 263, 58); // 레이블의 위치와 크기를 설정합니다.
        contentPane.add(lblNewLabel_1); // 패널에 레이블을 추가합니다.

        textField = new JTextField();
        textField.setBounds(322, 164, 166, 21); // 텍스트 필드의 위치와 크기를 설정합니다.
        contentPane.add(textField); // 패널에 텍스트 필드를 추가합니다.
        textField.setColumns(10); // 텍스트 필드의 열 개수를 설정합니다.

        textField_1 = new JTextField();
        textField_1.setBounds(322, 220, 166, 21); // 텍스트 필드의 위치와 크기를 설정합니다.
        contentPane.add(textField_1); // 패널에 텍스트 필드를 추가합니다.
        textField_1.setColumns(10); // 텍스트 필드의 열 개수를 설정합니다.

        JButton btnNewButton = new JButton("LOGIN");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // "LOGIN" 버튼이 클릭되었을 때 수행되는 동작입니다.
            }
        });
        btnNewButton.setBackground(new Color(255, 0, 255)); // 버튼의 배경색을 설정합니다.
        btnNewButton.setBounds(285, 296, 203, 23); // 버튼의 위치와 크기를 설정합니다.
        contentPane.add(btnNewButton); // 패널에 버튼을 추가합니다.

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
        lblNewLabel_2.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/free-icon-user-5264565.png")));
        lblNewLabel_2.setBounds(285, 164, 26, 21); // 레이블의 위치와 크기를 설정합니다.
        contentPane.add(lblNewLabel_2); // 패널에 레이블을 추가합니다.

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/free-icon-padlock-6934782.png")));
        lblNewLabel_3.setBounds(285, 220, 20, 21); // 레이블의 위치와 크기를 설정합니다.
        contentPane.add(lblNewLabel_3); // 패널에 레이블을 추가합니다.

        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setBounds(273, 271, 44, 15); // 레이블의 위치와 크기를 설정합니다.
        contentPane.add(lblNewLabel_4); // 패널에 레이블을 추가합니다.

        JCheckBox chckbxNewCheckBox = new JCheckBox("Remember");
        chckbxNewCheckBox.setBounds(285, 267, 115, 23); // 체크 박스의 위치와 크기를 설정합니다.
        contentPane.add(chckbxNewCheckBox); // 패널에 체크 박스를 추가합니다.
    }
}

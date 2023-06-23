package layout;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ChatJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatJFrame frame = new ChatJFrame();
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
	public ChatJFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChatJFrame.class.getResource("/image/w.png")));
		setTitle("채팅");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 274, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("채팅");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 18));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel soutPanel = new JPanel();
		contentPane.add(soutPanel, BorderLayout.SOUTH);
		
		textField = new JTextField();
		soutPanel.add(textField);
		textField.setColumns(15);
		
		JButton btnNewButton = new JButton("전송");
		soutPanel.add(btnNewButton);
		
		JTextArea txtrn = new JTextArea();
		txtrn.setText("경호: 이따만나~~~~\r\n태희: 아라써~~");
		txtrn.setEditable(false);
		contentPane.add(txtrn, BorderLayout.CENTER);
	}

}
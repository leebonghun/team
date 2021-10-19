package team;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
//게시글 수정화면
public class TeamBoardUpdate extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamBoardUpdate frame = new TeamBoardUpdate();
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
	public TeamBoardUpdate() {
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TeamBoardUpdate.class.getResource("/team/v.jpg")));
		setTitle("게시글 수정하기");
		setFont(new Font("Dialog", Font.BOLD, 20));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 370);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("게시글 수정");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("글 제목");
		lblNewLabel_1.setForeground(Color.WHITE);
		panel_3.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.addActionListener(this);
		textField.setColumns(10);
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLACK);
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("작성자");
		lblNewLabel_3.setForeground(Color.WHITE);
		panel_5.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel_5.add(lblNewLabel_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("내용");
		lblNewLabel_2.setForeground(Color.WHITE);
		panel_4.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTextArea textArea = new JTextArea();
		panel_1.add(textArea);
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("수정");
		btnNewButton.setBackground(Color.WHITE);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("취소");
		btnNewButton_2.setBackground(Color.WHITE);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("삭제");
		btnNewButton_1.setBackground(Color.WHITE);
		panel_2.add(btnNewButton_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//제목
		
		
		//내용
		
	}

}

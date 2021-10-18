package team;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

//첫화면  입력값 : 아이디 ,비밀번호  버튼 :로그인,회원가입  
public class TeamMain extends JFrame implements ActionListener, ItemListener {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtpwd;
	TeamDAO dao = new TeamDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamMain frame = new TeamMain();
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
	public TeamMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("Anonynous");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 26));
		panel.add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);

		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		panel_3.add(lblNewLabel_1);

		txtid = new JTextField();
		panel_3.add(txtid);
		txtid.setColumns(10);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);

		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_2);

		txtpwd = new JTextField();
		panel_1.add(txtpwd);
		txtpwd.setColumns(10);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);

		JButton login = new JButton("로그인");
		login.addActionListener(this);
//		login.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//				dispose();
//				new TeamLogin();
//
//			}
//		});
		login.setFont(new Font("굴림", Font.PLAIN, 14));
		panel_2.add(login);

		JButton signin = new JButton("회원가입");
		signin.addActionListener(this);
		signin.setFont(new Font("굴림", Font.PLAIN, 14));
		panel_2.add(signin);

		setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String cmd = e.getActionCommand();
		Vector<UserDTO> vetList = new Vector<UserDTO>();
		if (cmd.equals("회원가입")) {
			dispose();
			new TeamSignIn();

		} else if (cmd.equals("로그인")) {//로그인 절차
//			UserDTO userdto = new UserDTO();
			dao.select1();
			for (UserDTO userdto2 : vetList) {

				if (userdto2.getUserID().equals(txtid.getText()) && userdto2.getUserPw().equals(txtpwd.getText())) {

					JOptionPane.showMessageDialog(null, " 로그인성공");

					dispose();
					new TeamLogin();
				}else if (txtid.getText().trim().length() == 0 || txtpwd.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "아이디나 비밀번호를 입력해주세요.");
				}
				
				else {

					JOptionPane.showMessageDialog(null, " 아이디나 비밀번호가 틀립니다.");
					
				}

			}

		} // else if

	}

}
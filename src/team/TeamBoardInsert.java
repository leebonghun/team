package team;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.DropMode;
import java.awt.Color;
import java.awt.Toolkit;

//게시글 입력화면

public class TeamBoardInsert extends JFrame implements ActionListener, ItemListener, MouseListener {

	private JPanel contentPane;
	private JTextField textTitle;
	private JTextField textField_2;
	private JTextArea textsub;
	TeamDAO dao = new TeamDAO();

	private int userNm;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TeamBoardInsert frame = new TeamBoardInsert();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public TeamBoardInsert(int userNm) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TeamBoardInsert.class.getResource("/team/v.jpg")));
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);
		setTitle("게시글 작성하기");
		setFont(new Font("Dialog", Font.BOLD, 20));
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel = new JLabel("게시글 작성");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("글 제목");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		panel_3.add(lblNewLabel_1);

		textTitle = new JTextField();
		textTitle.setFont(new Font("굴림", Font.PLAIN, 16));
		textTitle.setForeground(Color.BLACK);
		textTitle.setBackground(Color.WHITE);
		panel_3.add(textTitle);
		textTitle.setColumns(10);
		textTitle.addActionListener(this);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLACK);
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel_3 = new JLabel("작성자");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(Color.WHITE);
		panel_5.add(lblNewLabel_3);

		textField_2 = new JTextField(String.valueOf(userNm));
		textField_2.setFont(new Font("굴림", Font.PLAIN, 16));
		textField_2.setEditable(false);
		panel_5.add(textField_2);
		textField_2.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblNewLabel_2 = new JLabel("내용");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setForeground(Color.WHITE);
		panel_4.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		textsub = new JTextArea();
		textsub.setFont(new Font("굴림", Font.PLAIN, 16));

		textsub.setForeground(Color.black);

		textsub.setForeground(Color.BLACK);

		panel_1.add(textsub);
		textsub.addMouseListener(this);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		contentPane.add(panel_2, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("작성");
		btnNewButton.setBackground(Color.WHITE);
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(this);

		JButton btnNewButton_2 = new JButton("취소");
		btnNewButton_2.setBackground(Color.WHITE);
		panel_2.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new TeamLogin(userNm);

			}
		});
		setVisible(true);

		this.userNm = userNm;

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String cmd = e.getActionCommand();

		if (cmd.equals("작성")) {
			if (textsub.getText().trim().length() == 0) {
				String insertfail = "내용을 입력해주세요.";
				JOptionPane.showConfirmDialog(null, insertfail, "작성실패", JOptionPane.WARNING_MESSAGE);
			} else {

				BoardDTO dto = new BoardDTO();
				dto.setBoardTitle(textTitle.getText());
				dto.setUserNm(userNm);
				textField_2.setEditable(false);
				dto.setBoardSub(textsub.getText());

				if (dao.insertBoard(dto)) {
					System.out.print("success");

					dispose();
					new TeamLogin(userNm);
				}
			}

//			new TeamLogin();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}

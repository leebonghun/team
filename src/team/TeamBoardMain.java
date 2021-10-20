package team;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;

//게시글 조회
public class TeamBoardMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textArea;
	private TeamDAO dao;
	private int no;

	/**
	 * Launch the application.
	 */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    TeamBoardMain frame = new TeamBoardMain();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

	/**
	 * Create the frame.
	 */
	public TeamBoardMain(int no) {
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TeamBoardMain.class.getResource("/team/v.jpg")));

		this.no = no;

		setTitle("게시글 조회");
		setFont(new Font("Dialog", Font.BOLD, 20));

		setBounds(1100, 30, 450, 370);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel = new JLabel("게시글 조회");
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
		lblNewLabel_1.setBackground(Color.BLACK);
		panel_3.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setForeground(Color.BLACK);
		panel_3.add(textField);
		textField.addActionListener(this);
		textField.setColumns(10);

		JPanel panel_5 = new JPanel();
		panel_5.setForeground(Color.BLACK);
		panel_5.setBackground(Color.BLACK);
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel_3 = new JLabel("작성자");
		lblNewLabel_3.setForeground(Color.WHITE);
		panel_5.add(lblNewLabel_3);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBackground(Color.WHITE);
		panel_5.add(textField_1);
		textField_1.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblNewLabel_2 = new JLabel("내용");
		lblNewLabel_2.setForeground(Color.WHITE);
		panel_4.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setForeground(Color.BLACK);
		textArea.setBackground(Color.WHITE);
		panel_1.add(textArea);
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		contentPane.add(panel_2, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("목록");
		btnNewButton.setBackground(Color.WHITE);
		panel_2.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("삭제");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TeamDAO dao = new TeamDAO();
				BoardDTO dto = dao.select3(no);

				dto.setBoardTitle(textField.getText());
				dto.setBoardSub(textArea.getText());
				dao.deleteUser(dto);
				new TeamLogin(no);
				System.out.println("Success" + dao.deleteUser(dto));

			}
		});

		panel_2.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("수정");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TeamDAO dao = new TeamDAO();
				BoardDTO dto = new BoardDTO();
				dto.setBoardTitle(textField.getText());
				textField.setEditable(true);
				dto.setUserNm(Integer.parseInt(textField_1.getText()));

				dto.setBoardSub(textArea.getText());
				textArea.setEditable(true);

				

			}
		});
		btnNewButton.setBackground(Color.WHITE);
		panel_2.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("완료");
		btnNewButton_3.setBackground(Color.WHITE);
		panel_2.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cmd = e.getActionCommand();
				if (cmd.equals("완료")) {
					TeamDAO dao = new TeamDAO();
					BoardDTO dto = new BoardDTO();
					dto.setBoardNm(no);
					dto.setBoardTitle(textField.getText());
					textField.setEditable(true);
					dto.setUserNm(Integer.parseInt(textField_1.getText()));
					dto.setBoardSub(textArea.getText());
					textArea.setEditable(true);
					System.out.println("success" + dao.update1(dto));
					dao.update1(dto);
					new TeamLogin(no);
				}
			}
		});

		btnNewButton.addActionListener(this);
		getRow(no);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BoardDTO dto = new BoardDTO();
		dto.setBoardTitle(textField.getText());
		dto.setBoardSub(textArea.getText());

	}// actionperformed

	private void getRow(int no) {
		TeamDAO dao = new TeamDAO();
		
		//조회수 올리기
		dao.update2(no);
		
		
		BoardDTO dto = dao.select3(no);

		textField.setText(dto.getBoardTitle());
		textField_1.setText(Integer.toString(dto.getUserNm()));
		textArea.setText(dto.getBoardSub());

	}

}
package team;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
// 게시판 출력화면 

//만들어야될것 
//게시글 목록 만들기 =>목록 출력 기능 
//게시글 정보 출력 (번호 ,제목 작성자 조회수) => 각각 패널에 디벨로퍼와 연동하기  
// 글쓰기 기능 버튼 => 누르면 글 쓰기 페이지로 이동 )
// 로그아웃 기능 버튼 버튼 
public class TeamLogin extends JFrame implements ActionListener,ItemListener {

	private JPanel contentPane;
	private JTable table;
	private JTextField boardNm;
	private JTextField boardTitle;
	
	private JTextField boardDate;
	private JTextField boardCount;
	private DefaultTableModel model;
	private BoardDTO dao;
	private JButton btnNewButton,btnNewButton_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamLogin frame = new TeamLogin();
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
	public TeamLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 1000);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		
		// 목록 부분
//		String[] sub = { "공지사항", "모든 게시글", "가입인사" };
//
//		JList<String> list = new JList<String>(sub);
//		panel.add(list);

		
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("게시글 정보 ");
		panel_1.add(lblNewLabel);
		
		btnNewButton = new JButton("글쓰기");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TeamMain();
				setVisible(false);
				new TeamBoardMain();
				
			}
		});
		panel_1.add(btnNewButton);
		
		btnNewButton_1 = new JButton("로그아웃");
btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TeamMain();
				setVisible(false);
				new TeamMain();
				
			}
		});
		panel_1.add(btnNewButton_1);
		
		
	
		

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);

		JLabel lblNewLabel_2 = new JLabel("익명 게시판 ");
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_3.add(tabbedPane);
		
		table = new JTable();
		String list[]= {"번호","제목","작성자","작성일자","조회수"};
		
       model = new DefaultTableModel(list, 0) {
			
			// 셀의 내용을 수정할 수 없게 처리			
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(model);		
		scrollPane.setViewportView(table);		
		
		
		dao = new BoardDTO();
		showTable();
		
		setVisible(true);

	}

	private void showTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	


}



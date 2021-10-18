
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import java.awt.Color;
// 게시판 출력화면 

//만들어야될것 
//게시글 목록 만들기 =>목록 출력 기능 
//게시글 정보 출력 (번호 ,제목 작성자 조회수) => 각각 패널에 디벨로퍼와 연동하기  
// 글쓰기 기능 버튼 => 누르면 글 쓰기 페이지로 이동 )
// 로그아웃 기능 버튼 버튼 


public class TeamLogin extends JFrame implements ActionListener,ItemListener,MouseListener {

	private JPanel contentPane;
	private JTable table;
	private JTextField boardNm;
	private JTextField boardTitle;
//디벨로퍼 연걸 변수명
	private JTextField boardDate;
	private JTextField boardCount;
	private DefaultTableModel model;
	private TeamDAO dao;
	private JTable table_1;
	private int userNm;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TeamLogin frame = new TeamLogin();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	
	//기본 전체 화면 패널 
	public TeamLogin(int userNm) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 1000);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.WEST);
		
		// 왼쪽 목록 부분
		String[] sub = { "공지사항", "모든 게시글", "가입인사" };

		JList<String> list = new JList<String>(sub);
		panel.add(list);
		

		
		//중앙 스크롤 패인 (게시물 작성후 등록되서 보이는 목록들)
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
	
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		contentPane.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		//위쪽 타이틀 
		JLabel lblNewLabel_2 = new JLabel("익명 게시판 ");
		lblNewLabel_2.setForeground(Color.WHITE);
		panel_2.add(lblNewLabel_2);
		
		//"번호","제목","작성자","작성일자","조회수" 테이블 모델 패인
		JScrollPane scrollPane_1 = new JScrollPane();
		contentPane.add(scrollPane_1, BorderLayout.CENTER);
		
		table_1 = new JTable();
		table_1.setForeground(Color.PINK);
		String list1[]= {"번호","제목","작성자","작성일자","조회수"};
		  model = new DefaultTableModel(list1, 0) {
			// 셀의 내용을 수정할 수 없게 처리			
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		//맨밑 게시판목록 알림과 글쓰기 ,로그아웃 버튼 
		JLabel lblNewLabel = new JLabel("익명게시판 목록");
		panel_1.add(lblNewLabel);
		
		
		
		this.userNm=userNm;
		
		
		//글쓰기 버튼과 누를시 게시물 작성으로 이동 
		JButton btnNewButton = new JButton("글쓰기");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
				new TeamBoardInsert(userNm);
				
			}
		});


		panel_1.add(btnNewButton);
		//로그아웃 버튼과 누름시 메인화면 이동
		JButton btnNewButton_1 = new JButton("로그아웃");
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

		scrollPane_1.setViewportView(table_1);
		table_1.setModel(model);
		dao = new TeamDAO();
		showTable();
		
		setVisible(true);

	}

		private void showTable() {
		// "번호","제목","작성자","작성일자","조회수"
		Vector<BoardDTO> vecList = dao.select2();
			if(!vecList.isEmpty()) {
			for(BoardDTO dto : vecList) {
				Vector<Object> newVec = new Vector<Object>();
				newVec.add(dto.getBoardNm());
				newVec.add(dto.getBoardTitle());
				newVec.add(dto.getUserNm());
				newVec.add(dto.getBoardDate());
				newVec.add(dto.getBoardCount());
				
				model.addRow(newVec);
			}	

			}

		}


	

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

	
	
	}

	
}



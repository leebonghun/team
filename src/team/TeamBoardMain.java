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
    	
    	this.no = no;
    	
    	
    	
    	
    	
        setTitle("게시글 조회");
        setFont(new Font("Dialog", Font.BOLD, 20));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 370);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(0, 1, 0, 0));
        
        JLabel lblNewLabel = new JLabel("게시글 조회");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
        panel.add(lblNewLabel);
        
        JPanel panel_3 = new JPanel();
        panel.add(panel_3);
        panel_3.setLayout(new GridLayout(0, 2, 0, 0));
        
        JLabel lblNewLabel_1 = new JLabel("글 제목");
        panel_3.add(lblNewLabel_1);
        
        textField = new JTextField();
        panel_3.add(textField);
        textField.addActionListener(this);
        textField.setColumns(10);
        
        
        JPanel panel_5 = new JPanel();
        panel.add(panel_5);
        panel_5.setLayout(new GridLayout(0, 2, 0, 0));
        
        JLabel lblNewLabel_3 = new JLabel("작성자");
        panel_5.add(lblNewLabel_3);
        
        textField_1 = new JTextField();
        panel_5.add(textField_1);
        textField_1.setColumns(10);
        
        JPanel panel_4 = new JPanel();
        panel.add(panel_4);
        panel_4.setLayout(new GridLayout(1, 0, 0, 0));
        
        JLabel lblNewLabel_2 = new JLabel("내용");
        panel_4.add(lblNewLabel_2);
        
        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new GridLayout(0, 1, 0, 0));
        
        textArea = new JTextArea();
        panel_1.add(textArea);
        JPanel panel_2 = new JPanel();
        contentPane.add(panel_2, BorderLayout.SOUTH);
        
        JButton btnNewButton = new JButton("목록");
        panel_2.add(btnNewButton);
        getRow(no);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BoardDTO dto = new BoardDTO();
        dto.setBoardTitle(textField.getText());
        dto.setBoardSub(textArea.getText());
        }
    
    private void getRow(int no) {
    	TeamDAO dao = new TeamDAO();
    	BoardDTO dto =dao.select3(no);
    	
    	textField.setText(dto.getBoardTitle());
    	textArea.setText(dto.getBoardSub());
    	
    }
        
    }
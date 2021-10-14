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

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
//첫화면  입력값 : 아이디 ,비밀번호  버튼 :로그인,회원가입  
public class TeamMain extends JFrame
implements ActionListener,ItemListener {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    


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
        
        textField = new JTextField();
        panel_3.add(textField);
        textField.setColumns(10);
        
        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1);
        
        JLabel lblNewLabel_2 = new JLabel("비밀번호");
        lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 14));
        panel_1.add(lblNewLabel_2);
        
        textField_1 = new JTextField();
        panel_1.add(textField_1);
        textField_1.setColumns(10);
        
        JPanel panel_2 = new JPanel();
        contentPane.add(panel_2);
        
        JButton login = new JButton("로그인");
        login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TeamMain();
				setVisible(false);
				new TeamLogin();
				
			}
		});
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
        
        String cmd =e.getActionCommand();
        
        if(cmd.equals("회원가입")) {
            new TeamSignIn();
            
        }else {
        	new TeamLogin();
			UserDTO userdto = new UserDTO();
            
        }
        
    }

}
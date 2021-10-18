package team;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lombok.Cleanup;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

//회원가입화면 입력값:아이디,비번,이름,이메일 버튼:회원가입 ,뒤로가기
public class TeamSignIn extends JFrame implements ActionListener, ItemListener {

   private JPanel contentPane;
   private JTextField txtEmail;
   private JTextField txtId;
   private JTextField txtPwd;
   private JTextField txtName;
   private JButton btnNewButton, btnNewButton_1, btnNewButton_2;
   TeamDAO dao = new TeamDAO();

   /**
    * Launch the application.
    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               TeamSignIn frame = new TeamSignIn();
//               
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
//   }

   /**
    * Create the frame.
    */
   public TeamSignIn() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 450, 300);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(new GridLayout(0, 1, 0, 0));

      JPanel panel_4 = new JPanel();
      FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
      contentPane.add(panel_4);

      JLabel lblNewLabel_4 = new JLabel("회원가입");
      lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 20));
      panel_4.add(lblNewLabel_4);

      JPanel panel_3 = new JPanel();
      FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
      flowLayout_1.setAlignment(FlowLayout.LEFT);
      contentPane.add(panel_3);

      JLabel lblNewLabel_1 = new JLabel("아이디");
      lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
      panel_3.add(lblNewLabel_1);

      txtId = new JTextField();
      panel_3.add(txtId);
      txtId.addActionListener(this);
      txtId.setColumns(10);

      btnNewButton_2 = new JButton("중복체크");
      btnNewButton_2.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String id = txtId.getText();
            if (dao.idCheck(id)) {
               JOptionPane.showMessageDialog(null, "중복된 아이디");
            }else {
            	
            }
         }
      });

      panel_3.add(btnNewButton_2);

      JPanel panel_2 = new JPanel();
      FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
      flowLayout_2.setAlignment(FlowLayout.LEFT);
      contentPane.add(panel_2);

      JLabel lblNewLabel_2 = new JLabel("비밀번호");
      panel_2.add(lblNewLabel_2);

      txtPwd = new JTextField();
      panel_2.add(txtPwd);
      txtPwd.addActionListener(this);
      txtPwd.setColumns(10);

      JPanel panel_1 = new JPanel();
      FlowLayout flowLayout_3 = (FlowLayout) panel_1.getLayout();
      flowLayout_3.setAlignment(FlowLayout.LEFT);
      contentPane.add(panel_1);

      JLabel lblNewLabel_3 = new JLabel("이름");
      panel_1.add(lblNewLabel_3);

      txtName = new JTextField();
      panel_1.add(txtName);
      txtName.addActionListener(this);
      txtName.setColumns(10);

      JPanel panel = new JPanel();
      FlowLayout flowLayout_4 = (FlowLayout) panel.getLayout();
      flowLayout_4.setAlignment(FlowLayout.LEFT);
      contentPane.add(panel);

      JLabel lblNewLabel = new JLabel("이메일");
      panel.add(lblNewLabel);

      txtEmail = new JTextField();
      panel.add(txtEmail);
      txtEmail.addActionListener(this);
      txtEmail.setColumns(10);

      JPanel panel_5 = new JPanel();
      contentPane.add(panel_5);

      btnNewButton = new JButton("회원가입");
      btnNewButton.addActionListener(this);
      panel_5.add(btnNewButton);

      btnNewButton_1 = new JButton("뒤로가기");
      btnNewButton_1.addActionListener(this);
      panel_5.add(btnNewButton_1);

      setVisible(true);
   }

   @Override
   public void itemStateChanged(ItemEvent e) {
      // TODO Auto-generated method stub

   }

   @Override
   public void actionPerformed(ActionEvent e) {
      UserDTO newdto = new UserDTO();
      String cmd = e.getActionCommand();
      
   

<<<<<<< HEAD
      if (cmd.equals("회원가입")) {
         
         // 사용자 입력값 가져오기
          if (txtId.getText().trim().length() == 0 || txtPwd.getText().trim().length() == 0
               || txtName.getText().trim().length() == 0 || txtEmail.getText().trim().length() == 0) {
            String signin = "회원가입실패";
            JOptionPane.showMessageDialog(null, signin, "회원가입실패", JOptionPane.WARNING_MESSAGE);
         } 
      else {
=======
		if (cmd.equals("회원가입")) {
			
			// 사용자 입력값 가져오기
			 if (txtId.getText().trim().length() == 0 || txtPwd.getText().trim().length() == 0
					|| txtName.getText().trim().length() == 0 || txtEmail.getText().trim().length() == 0) {
				String signin = "회원가입실패";
				JOptionPane.showMessageDialog(null, signin, "회원가입실패", JOptionPane.WARNING_MESSAGE);
				
			} 
		else {
>>>>>>> branch 'master' of https://github.com/leebonghun/team.git

<<<<<<< HEAD
            String signinfail = "회원가입 성공 ";
            JOptionPane.showMessageDialog(getParent(), signinfail, "회원가입성공", JOptionPane.OK_CANCEL_OPTION);
            dispose();
            new TeamLogin();
           
         }
         newdto.setUserID(txtId.getText());
=======
				String signinfail = "회원가입 성공 ";
				
				JOptionPane.showMessageDialog(getParent(), signinfail, "회원가입성공", JOptionPane.OK_CANCEL_OPTION);
				dispose();
				new TeamMain();
				
			}
			newdto.setUserID(txtId.getText());
>>>>>>> branch 'master' of https://github.com/leebonghun/team.git

         newdto.setUserPw(txtPwd.getText());
         newdto.setUserName(txtName.getText());
         newdto.setUserEm(txtEmail.getText());

<<<<<<< HEAD
         
         dao.insertUser(newdto);
      }
      }
=======
			
			dao.insertUser(newdto);
			
			
		}
		
		dispose();
		
	     
		}
>>>>>>> branch 'master' of https://github.com/leebonghun/team.git


}
package team;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import lombok.Cleanup;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

//회원가입화면 입력값:아이디,비번,이름,이메일 버튼:회원가입 ,뒤로가기
public class TeamSignIn extends JFrame implements ActionListener, ItemListener {

   private JPanel contentPane;
   private JTextField txtId,txtName,txtEmail;
   private JButton btnNewButton, btnNewButton_1, btnNewButton_2;
   private JPasswordField txtPwd;
   private String id;
   TeamDAO dao = new TeamDAO();
   
   private JTextField textField_1;
   

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
//   }2

   /**
    * Create the frame.
    */
   public TeamSignIn() {
      setIconImage(Toolkit.getDefaultToolkit().getImage(TeamSignIn.class.getResource("/team/v.jpg")));
      setBounds(100, 100, 700, 500);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(new GridLayout(0, 1, 0, 0));

//
      JPanel panel_4 = new JPanel();
      panel_4.setBackground(Color.DARK_GRAY);
      FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
      flowLayout.setVgap(0);
      contentPane.add(panel_4);

      JLabel lblNewLabel_4 = new JLabel("회원가입");
      lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 20));
      lblNewLabel_4.setForeground(Color.white);
      panel_4.add(lblNewLabel_4);

      JPanel panel_3 = new JPanel();
      panel_3.setBackground(Color.DARK_GRAY);
      contentPane.add(panel_3);
      panel_3.setLayout(new GridLayout(0, 3, 10, 5));
      
            JLabel lblNewLabel_1 = new JLabel("아이디");
            lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 16));
            lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel_1.setForeground(Color.white);
            panel_3.add(lblNewLabel_1);

      txtId = new JTextField();
      txtId.setFont(new Font("굴림", Font.PLAIN, 16));
      panel_3.add(txtId);
      txtId.addActionListener(this);
      txtId.setColumns(10);
      
            btnNewButton_2 = new JButton("중복체크");
            btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 16));
            btnNewButton_2.setBackground(Color.WHITE);
            btnNewButton_2.addActionListener(new ActionListener() {

               @Override
               public void actionPerformed(ActionEvent e) {
                  // TODO Auto-generated method stub
                  Object obj = e.getSource();
                  id = txtId.getText();
                  if (dao.idCheck(id)) {
                     JOptionPane.showMessageDialog(null, "중복된 아이디");
                  } else {
                     JOptionPane.showMessageDialog(null, "사용가능한 아이디");
                  }

               }
            });
            
                  panel_3.add(btnNewButton_2);
      
      JLabel lblNewLabel_3 = new JLabel("비밀번호");
      lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 16));
      lblNewLabel_3.setForeground(Color.WHITE);
      lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
      panel_3.add(lblNewLabel_3);
      
      txtPwd = new JPasswordField();
      txtPwd.setFont(new Font("굴림", Font.PLAIN, 16));
      panel_3.add(txtPwd);
      txtPwd.setColumns(10);
      
      JLabel lblNewLabel = new JLabel("");
      panel_3.add(lblNewLabel);
      
      JLabel lblNewLabel_6 = new JLabel("이름");
      lblNewLabel_6.setFont(new Font("굴림", Font.PLAIN, 16));
      lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_6.setForeground(Color.WHITE);
      panel_3.add(lblNewLabel_6);
      
      txtName = new JTextField();
      txtName.setFont(new Font("굴림", Font.PLAIN, 16));
      panel_3.add(txtName);
      txtName.setColumns(10);
      
      JLabel lblNewLabel_5 = new JLabel("");
      panel_3.add(lblNewLabel_5);
      
      JLabel lblNewLabel_2 = new JLabel("이메일");
      lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 16));
      lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_2.setForeground(Color.WHITE);
      panel_3.add(lblNewLabel_2);
      
      txtEmail = new JTextField();
      txtEmail.setFont(new Font("굴림", Font.PLAIN, 16));
      panel_3.add(txtEmail);
      txtEmail.setColumns(10);

      JPanel panel_5 = new JPanel();
      panel_5.setBackground(Color.DARK_GRAY);
      contentPane.add(panel_5);
      panel_5.setLayout(new BorderLayout(0, 0));      
      
      JPanel panel_6 = new JPanel();
      panel_6.setBackground(Color.DARK_GRAY);
      panel_5.add(panel_6,BorderLayout.SOUTH);
      
      
      btnNewButton = new JButton("회원가입");
      btnNewButton.setBackground(Color.WHITE);
      btnNewButton.addActionListener(this);
      
      btnNewButton_1 = new JButton("뒤로가기");
      btnNewButton_1.setBackground(Color.WHITE);
      btnNewButton_1.addActionListener(this);
      
      panel_6.add(btnNewButton);
      panel_6.add(btnNewButton_1);
      
      
      


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
      id = txtId.getText();

      if (cmd.equals("회원가입")) {

         // 사용자 입력값 가져오기
         if (txtId.getText().trim().length() == 0 || txtPwd.getText().trim().length() == 0
               || txtName.getText().trim().length() == 0 || txtEmail.getText().trim().length() == 0
               || dao.idCheck(id)) {
            String signin = "회원가입실패";
            JOptionPane.showMessageDialog(null, signin, "회원가입실패", JOptionPane.WARNING_MESSAGE);

         } else {

            String signinfail = "회원가입 성공 ";

            JOptionPane.showMessageDialog(getParent(), signinfail, "회원가입성공", JOptionPane.OK_CANCEL_OPTION);
            dispose();
            new TeamMain();

         }
         newdto.setUserID(txtId.getText());

         newdto.setUserPw(txtPwd.getText());
         newdto.setUserName(txtName.getText());
         newdto.setUserEm(txtEmail.getText());

         dao.insertUser(newdto);

      } else {
         dispose();
         new TeamMain();
      }

   }

   

}
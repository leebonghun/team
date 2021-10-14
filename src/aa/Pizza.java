package aa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;

public class Pizza extends JFrame implements ActionListener, ItemListener {

	private JPanel contentPane;
	private JRadioButton rdoCombo, rdoPotato, rdoBul, rdoPeper, rdoCheese, rdoPepp, rdoBacon, rdoSmall, rdoMed,
			rdoLarge;
	private JButton btnOrder, btnCancel;
	private JLabel lblMoney;
	private ButtonGroup group1, group2, group3;

	// 그룹별 주문금액 변수 설정
	private int kindMoney, toppingMoney, SizeMoney;
	// 그룹별 제품선택 변수 설정
	private String kind, topping, size;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pizza frame = new Pizza();
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
	public Pizza() {
		setTitle("\uD53C\uC790\uC8FC\uBB38");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Pizza.class.getResource("/aa/pizza1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel(
				"\uC790\uBC14 \uD53C\uC790\uC5D0 \uC624\uC2E0\uAC83\uC744 \uD658\uC601\uD569\uB2C8\uB2E4");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 3, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\uC885\uB958", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		rdoCombo = new JRadioButton("\uCF64\uBCF4");
		rdoCombo.setBackground(Color.WHITE);
		rdoCombo.addItemListener(this);
		panel_2.add(rdoCombo);

		rdoPotato = new JRadioButton("\uD3EC\uD14C\uC774\uD1A0");
		rdoPotato.setBackground(Color.WHITE);
		rdoPotato.addItemListener(this);
		panel_2.add(rdoPotato);

		rdoBul = new JRadioButton("\uBD88\uACE0\uAE30");
		rdoBul.setBackground(Color.WHITE);
		rdoBul.addItemListener(this);
		panel_2.add(rdoBul);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\uCD94\uAC00\uD1A0\uD551",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));

		rdoPeper = new JRadioButton("\uD53C\uB9DD");
		rdoPeper.setBackground(Color.WHITE);
		rdoPeper.addItemListener(this);
		panel_3.add(rdoPeper);

		rdoCheese = new JRadioButton("\uCE58\uC988");
		rdoCheese.setBackground(Color.WHITE);
		rdoCheese.addItemListener(this);
		panel_3.add(rdoCheese);

		rdoPepp = new JRadioButton("\uD398\uD398\uB85C\uB2C8");
		rdoPepp.setBackground(Color.WHITE);
		rdoPepp.addItemListener(this);
		panel_3.add(rdoPepp);

		rdoBacon = new JRadioButton("\uBCA0\uC774\uCEE8");
		rdoBacon.setBackground(Color.WHITE);
		rdoBacon.addItemListener(this);
		panel_3.add(rdoBacon);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\uD06C\uAE30", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));

		rdoSmall = new JRadioButton("Small");
		rdoSmall.setBackground(Color.WHITE);
		rdoSmall.addItemListener(this);
		panel_4.add(rdoSmall);

		rdoMed = new JRadioButton("Medium");
		rdoMed.setBackground(Color.WHITE);
		rdoMed.addItemListener(this);
		panel_4.add(rdoMed);

		rdoLarge = new JRadioButton("Large");
		rdoLarge.setBackground(Color.WHITE);
		rdoLarge.addItemListener(this);
		panel_4.add(rdoLarge);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.SOUTH);

		btnOrder = new JButton("\uC8FC\uBB38");
		btnOrder.addActionListener(this);
		panel_1.add(btnOrder);

		btnCancel = new JButton("\uCDE8\uC18C");
		btnCancel.addActionListener(this);
		panel_1.add(btnCancel);

		lblMoney = new JLabel("\uAE08\uC561:");
		panel_1.add(lblMoney);

		// 라디오 그룹 설정
		group1 = new ButtonGroup();
		group1.add(rdoCombo);
		group1.add(rdoPotato);
		group1.add(rdoBul);
		group2 = new ButtonGroup();
		group2.add(rdoPeper);
		group2.add(rdoCheese);
		group2.add(rdoPepp);
		group2.add(rdoBacon);
		group3 = new ButtonGroup();
		group3.add(rdoSmall);
		group3.add(rdoMed);
		group3.add(rdoLarge);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// 라디오 버튼 이벤트 처리
		// 종류 콤보(10000) 포테이토(12000)불고기(13000)
		// 추가토핑 피망(2000)치즈(2000)페페로니(1000)베이컨(3000)
		// 크기:작은1000미둠2000라지3000
		JRadioButton radio = (JRadioButton) e.getItem();

		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (radio == rdoCombo) {
				kindMoney = 10000;
				kind = radio.getText();
			} else if (radio == rdoPotato) {
				kindMoney = 12000;
				kind = radio.getText();
			} else if (radio == rdoBul) {
				kindMoney = 13000;
				kind = radio.getText();
			} else if (radio == rdoPeper) {
				toppingMoney = 2000;
				topping = radio.getText();
			} else if (radio == rdoCheese) {
				toppingMoney = 2000;
				topping = radio.getText();
			} else if (radio == rdoPepp) {
				toppingMoney = 1000;
				topping = radio.getText();
			} else if (radio == rdoBacon) {
				toppingMoney = 3000;
				topping = radio.getText();
			} else if (radio == rdoSmall) {
				SizeMoney = 1000;
				size = radio.getText();
			} else if (radio == rdoMed) {
				SizeMoney = 2000;
				size = radio.getText();
			} else if (radio == rdoLarge) {
				SizeMoney = 3000;
				size = radio.getText();
			}
			int price = kindMoney + toppingMoney + SizeMoney;
			lblMoney.setText("금액:" + price);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼 이벤트 처리
		String cmd = e.getActionCommand();

		if (cmd.equals("주문")) {

			String orderList = "주문내역\n";
			orderList += "종류 :" + kind + "\n";
			orderList += "토핑 :" + topping + "\n";
			orderList += "크기 :" + size + "\n";
			orderList += "주문하시겠습니까?";

			int result = JOptionPane.showConfirmDialog(getParent(), orderList, "주문완료", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);

			if (result == 0) {
				JOptionPane.showMessageDialog(getParent(), "주문이완료되었습니다");
				clear();
			} else {
				clear();
			}
		} else {
			clear();
		}
	}

	private void clear() {
		// 라디오 버튼 해제
		group1.clearSelection();
		group2.clearSelection();
		group3.clearSelection();

		// 그룹별 주문금액 변수 초기화
		kindMoney = 0;
		toppingMoney = 0;
		SizeMoney = 0;

		// 그룹별 주문메시지 변수 초기화
		kind = "";
		topping = "";
		size = "";

		lblMoney.setText("금액:");
	}
}

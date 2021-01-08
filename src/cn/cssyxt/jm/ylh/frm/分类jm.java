package cn.cssyxt.jm.ylh.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.cssyxt.sjk.ylh.dbc.lj;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ����jm extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					����jm frame = new ����jm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * ������棬����Ʒ���з������
	 */
	public ����jm() {
		setTitle("\u5546\u54C1\u5206\u7C7B\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�����������Ϣ");
		lblNewLabel.setBounds(10, 27, 94, 15);
		contentPane.add(lblNewLabel);
		
		JTextPane flsr = new JTextPane();
		flsr.setBounds(114, 21, 109, 21);
		contentPane.add(flsr);
		
		JButton btnNewButton = new JButton("��ѯ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(33, 89, 350, 145);
				contentPane.add(scrollPane);
				
				String[] titles = { "����", "��Ʒ��", "����","����"};
				DefaultTableModel model=new DefaultTableModel(titles, 0);
				//DefaultTableModel model2=new DefaultTableModel(titles, 0);
				Connection conn=new lj().getConnection();//����lj()�������ݿ�
				String sql="select zl,name,sl,money from ��Ʒadd where zl='"+flsr.getText()+"'";	
				try(PreparedStatement pstmt=conn.prepareStatement(sql);) {
					ResultSet rs=pstmt.executeQuery();
					while(rs.next()) {
						String zl=rs.getString("zl");
						String name=rs.getString("name");
						int sl=rs.getInt("sl");
						float money=rs.getFloat("money");
						
						model.addRow(new Object[] {zl,name,sl,money});
					}
					
					conn.close();
				} catch (SQLException e5) {
					e5.printStackTrace();
				}
				table = new JTable(model);
				//table.setAutoCreateRowSorter(true);
				scrollPane.setViewportView(table);
				
			}
		});
		
		btnNewButton.setBounds(236, 23, 97, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("��Ʒ�����");
		lblNewLabel_1.setBounds(124, 64, 84, 15);
		contentPane.add(lblNewLabel_1);
		
		//JScrollPane scrollPane = new JScrollPane();
		///scrollPane.setBounds(33, 89, 350, 145);
		//contentPane.add(scrollPane);
		
		
	}
}

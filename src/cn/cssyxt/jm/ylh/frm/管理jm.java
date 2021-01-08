package cn.cssyxt.jm.ylh.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import cn.cssyxt.sjk.ylh.dbc.lj;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.RowFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JDesktopPane;
import java.awt.Color;

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
	 * ������棬����Ʒ���й�������ɾ��Ĳ���
	 */
	public ����jm() {
		setTitle("\u7BA1\u7406\u754C\u9762");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 503, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 64, 423, 177);
		contentPane.add(scrollPane);
		String[] titles = { "����", "��Ʒ��", "����","�۸�"};
		DefaultTableModel model=new DefaultTableModel(titles, 0);
		Connection conn=new lj().getConnection();//����lj()�������ݿ�
		String sql="select zl,name,sl,money from ��Ʒadd";
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		table = new JTable(model);
		table.setAutoCreateRowSorter(true);//�����������
		scrollPane.setViewportView(table);
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 33, 55, 21);
		contentPane.add(textPane);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u5173\u952E\u5B57\u67E5\u8BE2");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(10, 8, 102, 15);
		contentPane.add(lblNewLabel);
		
		JDesktopPane desktopPane = new JDesktopPane(){
			@Override
			public void paintComponent(Graphics g) {//�ػ���屳��
				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon=new ImageIcon("img/rr.jpg");
				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		desktopPane.setBounds(0, 0, 489, 253);
		contentPane.add(desktopPane);
		JButton btnNewButton = new JButton("�����Ʒ");
		btnNewButton.setIcon(new ImageIcon(����jm.class.getResource("/\u56FE\u7247/m12.png")));
		btnNewButton.setBounds(172, 31, 104, 23);
		desktopPane.add(btnNewButton);
		
		
		JButton btnNewButton_2 = new JButton("�޸�");
		btnNewButton_2.setIcon(new ImageIcon(����jm.class.getResource("/\u56FE\u7247/m7.png")));
		btnNewButton_2.setBounds(387, 31, 92, 23);
		desktopPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("ɾ����Ʒ");
		btnNewButton_1.setIcon(new ImageIcon(����jm.class.getResource("/\u56FE\u7247/m17.png")));
		btnNewButton_1.setBounds(359, 0, 104, 23);
		desktopPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("\u67E5\u8BE2");
		btnNewButton_3.setBounds(72, 31, 90, 23);
		desktopPane.add(btnNewButton_3);
		btnNewButton_3.setIcon(new ImageIcon(����jm.class.getResource("/\u56FE\u7247/06.png")));
		
		JButton btnNewButton_4 = new JButton("ˢ��");
		btnNewButton_4.setBounds(286, 31, 97, 23);
		desktopPane.add(btnNewButton_4);
		btnNewButton_4.setIcon(new ImageIcon(����jm.class.getResource("/\u56FE\u7247/r8.png")));
		
		JTextPane slsc = new JTextPane();
		slsc.setBounds(264, 2, 88, 21);
		desktopPane.add(slsc);
		
		JLabel lblNewLabel_1 = new JLabel("\u8F93\u5165\u8981\u5220\u9664\u7684\u540D\u79F0");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(140, 4, 114, 15);
		desktopPane.add(lblNewLabel_1);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				����jm ww=new ����jm();
				ww.show();
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u=textPane.getText();
				TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//���ñ��ģ��������
				table.setRowSorter(sorter);//���ñ��������
				sorter.setRowFilter(null);//�����ù�����������ʾȫ������
				sorter.setRowFilter(RowFilter.regexFilter(u));//��ָ����������ʽ��������  RowFilter.regexFilter(u,0)   0��ʾ���˵�һ�е�����
				//����ֵ�������д�����˵�2���ֶ�С��70������
				//sorter.setRowFilter(RowFilter.numberFilter(ComparisonType.BEFORE, 70, 2));
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					  if (JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ��������", "",    JOptionPane.YES_NO_OPTION) == 0) {// ȷ���Ի���
						  lj t=new lj();
							String a1="delete from ��Ʒadd where name=?";//ʹ��ռλ������sqlʶ��
							try{
							Connection conn=t.getConnection();//��ȡ���ݿ��
							PreparedStatement s = conn.prepareStatement(a1);
								s.setString(1,slsc.getText());
								s.executeUpdate();
								s.close();	
						        conn.close();
						        JOptionPane.showMessageDialog(null, "ɾ���ɹ�", "ɾ���ɹ�", JOptionPane.NO_OPTION);
						        dispose();
								����jm ww=new ����jm();
								ww.show();
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
					  } else {
					    JOptionPane.showMessageDialog(null, "������Ҫɾ��������");
					  }
					
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				�޸�jm t=new �޸�jm();
				t.show();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				add a=new add();
				a.show();
			}
		});
	}
}

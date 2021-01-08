package cn.cssyxt.jm.ylh.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import cn.cssyxt.sjk.ylh.dbc.lj;

import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;

public class ͳ��jm extends JFrame {
    float ss;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	public void a(float ss) {
		this.ss=ss;
	}
	public float c() {
		return ss;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ͳ��jm frame = new ͳ��jm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * ͳ�ƽ��棬�����۵���Ʒ����ͳ�ƹ���
	 */
	public ͳ��jm() {
		setTitle("\u7EDF\u8BA1\u754C\u9762");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 22, 366, 185);
		contentPane.add(scrollPane);
		
		String[] titles = { "����", "��Ʒ��", "������","����"};
		DefaultTableModel model=new DefaultTableModel(titles, 0);
		//DefaultTableModel model2=new DefaultTableModel(titles, 0);
		Connection conn=new lj().getConnection();//����lj()�������ݿ�
		String sql="select zl,name,sl,money from ͳ��table";	
		try(PreparedStatement pstmt=conn.prepareStatement(sql);) {
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				String zl=rs.getString("zl");
				String name=rs.getString("name");
				int sl=rs.getInt("sl");
				float money=rs.getFloat("money");
				ss=ss+sl*money;
				model.addRow(new Object[] {zl,name,sl,money});a(ss);
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		table = new JTable(model);
		//table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("�����ܽ�"+c());
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(10, 221, 112, 15);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("������������");
		btnNewButton.setIcon(new ImageIcon(ͳ��jm.class.getResource("/\u56FE\u7247/01.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] titles = { "����", "��Ʒ��", "������","����"};
				DefaultTableModel model=new DefaultTableModel(titles, 0);
				//DefaultTableModel model2=new DefaultTableModel(titles, 0);
				Connection conn=new lj().getConnection();//����lj()�������ݿ�
				String sql="select zl,name,sl,money from ͳ��table order by sl";	
				try(PreparedStatement pstmt=conn.prepareStatement(sql);) {
					ResultSet rs=pstmt.executeQuery();
					while(rs.next()) {
						String zl=rs.getString("zl");
						String name=rs.getString("name");
						int sl=rs.getInt("sl");
						float money=rs.getFloat("money");
						ss=ss+sl*money;
						model.addRow(new Object[] {zl,name,sl,money});a(ss);
					}
					
					conn.close();
				} catch (SQLException e3) {
					e3.printStackTrace();
				}
				table = new JTable(model);
				//table.setAutoCreateRowSorter(true);
				scrollPane.setViewportView(table);
				//table.setAutoCreateRowSorter(true);
				//TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//����������
				//table.setRowSorter(sorter);//���ñ���������
				//ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
				//���������ֶΣ�����Ϊ��1���ֶ�����
				//sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
				//sorter.setSortKeys(sortKeys);
			}
		});
		btnNewButton.setBounds(119, 217, 138, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("����������");
		btnNewButton_1.setIcon(new ImageIcon(ͳ��jm.class.getResource("/\u56FE\u7247/04.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] titles = { "����", "��Ʒ��", "������","����"};
				DefaultTableModel model=new DefaultTableModel(titles, 0);
				//DefaultTableModel model2=new DefaultTableModel(titles, 0);
				Connection conn=new lj().getConnection();//����lj()�������ݿ�
				String sql="select zl,name,sl,money from ͳ��table order by money";	
				try(PreparedStatement pstmt=conn.prepareStatement(sql);) {
					ResultSet rs=pstmt.executeQuery();
					while(rs.next()) {
						String zl=rs.getString("zl");
						String name=rs.getString("name");
						int sl=rs.getInt("sl");
						float money=rs.getFloat("money");
						model.addRow(new Object[] {zl,name,sl,money});a(ss);
					}
					
					conn.close();
				} catch (SQLException e3) {
					e3.printStackTrace();
				}
				table = new JTable(model);
				//table.setAutoCreateRowSorter(true);
				scrollPane.setViewportView(table);
			}
		});
		btnNewButton_1.setBounds(276, 217, 135, 23);
		contentPane.add(btnNewButton_1);
		
		JTextPane sc1 = new JTextPane();
		sc1.setBounds(94, 240, 102, 21);
		contentPane.add(sc1);
		
		btnNewButton_2 = new JButton("ɾ��");
		btnNewButton_2.setIcon(new ImageIcon(ͳ��jm.class.getResource("/\u56FE\u7247/qqt.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lj t=new lj();
				String a1="delete from ͳ��table where name=?";//ʹ��ռλ������sqlʶ��
				try{
				Connection conn=t.getConnection();//��ȡ���ݿ��
				PreparedStatement s = conn.prepareStatement(a1);
					s.setString(1,sc1.getText());
					s.executeUpdate();
					s.close();	
			        conn.close();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�", "ɾ���ɹ�", JOptionPane.NO_OPTION);
				dispose();
				ͳ��jm et=new ͳ��jm();
				et.show();
			}
		});
		btnNewButton_2.setBounds(206, 240, 102, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("\u8F93\u5165\u5220\u9664\u540D\u79F0");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(0, 246, 84, 15);
		contentPane.add(lblNewLabel_1);
	}
}

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

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.RowFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ʱ���jm extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ʱ���jm frame = new ʱ���jm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * ����Ʒ���۵�ʱ��ν��в�ѯ
	 */
	public ʱ���jm() {
		setTitle("\u65F6\u95F4\u6BB5\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 509, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 82, 475, 140);
		contentPane.add(scrollPane);
		
		String[] titles = { "����", "��Ʒ��", "������","����","����ʱ��"};
		DefaultTableModel model=new DefaultTableModel(titles, 0);
		//DefaultTableModel model2=new DefaultTableModel(titles, 0);
		Connection conn=new lj().getConnection();//����lj()�������ݿ�
		String sql="select zl,name,sl,money,sj from ʱ��table";	
		try(PreparedStatement pstmt=conn.prepareStatement(sql);) {
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				String zl=rs.getString("zl");
				String name=rs.getString("name");
				String sl=rs.getString("sl");
				String money=rs.getString("money");
				String sj=rs.getString("sj");
				model.addRow(new Object[] {zl,name,sl,money,sj});
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		table = new JTable(model);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(150, 29, 107, 21);
		contentPane.add(textPane);
		
		JButton btnNewButton = new JButton("��ѯ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u=textPane.getText();
				TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//���ñ��ģ��������
				table.setRowSorter(sorter);//���ñ��������
				sorter.setRowFilter(null);//�����ù�����������ʾȫ������
				sorter.setRowFilter(RowFilter.regexFilter(u,4));
			}
		});
		btnNewButton.setBounds(264, 29, 97, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("������ʱ��β�ѯ");
		lblNewLabel.setBounds(10, 33, 130, 15);
		contentPane.add(lblNewLabel);
		
		JDesktopPane desktopPane = new JDesktopPane(){
			@Override
			public void paintComponent(Graphics g) {//�ػ���屳��
				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon=new ImageIcon("img/apic29974.jpg");
				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		desktopPane.setBounds(0, 0, 489, 263);
		contentPane.add(desktopPane);
	}
}

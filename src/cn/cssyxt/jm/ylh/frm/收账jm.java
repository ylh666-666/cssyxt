package cn.cssyxt.jm.ylh.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.cssyxt.sjk.ylh.dbc.lj;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;

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
	 * ���˽��� ��������Ʒ��ѡ��
	 */
	public ����jm() {
		setTitle("\u6536\u8D26\u754C\u9762");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 10, 369, 187);
		contentPane.add(scrollPane);
		String[] titles = { "����", "��Ʒ��", "����","�۸�"};
		DefaultTableModel model=new DefaultTableModel(titles, 0);
		DefaultTableModel model2=new DefaultTableModel(titles, 0);
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
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u60A8\u6240\u9700\u5546\u54C1\u540D\u79F0");
		lblNewLabel.setBounds(10, 207, 150, 15);
		contentPane.add(lblNewLabel);
		
		JTextPane fkmc =new JTextPane();
		fkmc.setBounds(32, 232, 85, 21);
		contentPane.add(fkmc);
		
		JLabel lblNewLabel_1 = new JLabel("\u6570\u91CF");
		lblNewLabel_1.setBounds(148, 207, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		JTextPane fksl = new JTextPane();
		fksl.setBounds(148, 232, 36, 21);
		contentPane.add(fksl);
		
		JButton btnNewButton = new JButton("\u52A0\u5165\u8D2D\u7269\u8F66");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn=new lj().getConnection();//����lj()�������ݿ�
				String sql="select zl,money from ��Ʒadd where name='"+fkmc.getText()+"'";	
				try(PreparedStatement pstmt=conn.prepareStatement(sql);) {
					ResultSet rs=pstmt.executeQuery();
					//if(!rs.next()) {JOptionPane.showMessageDialog( null, "���������Ʒ������");}
					while(rs.next()) {
						String zl=rs.getString("zl");
						String name=fkmc.getText();
						String sl=fksl.getText();
						float money=rs.getFloat("money");
						model2.addRow(new Object[] {zl,name,sl,money});
						File file=new File("f:/a.txt");
						try(FileWriter fw=new FileWriter(file,true)){//�����ַ������
						    //���û��������Ϣд��ָ���ļ�
						   fw.write(zl+"\t"+name+"\t"+sl+"\t"+money+"\r\n");
						}catch(Exception e1) {e1.printStackTrace();}
					}
					conn.close();
				}
						 catch (SQLException e1) {
					e1.printStackTrace();
					//JOptionPane.showMessageDialog( null, "���������Ʒ������");
				}
				
				if(fkmc.getText().equals("")||fksl.getText().equals("")) {//fkmc.getText().equals("")||fksl.getText().equals("")
					JOptionPane.showMessageDialog( null, "���������Ʒ������");
				}else {
				JOptionPane.showMessageDialog( null, "�ɹ���ӵ����ﳵ");
				lj p=new lj();
				String a1="update ��Ʒadd set sl=sl-? where name=?";//ʹ��ռλ������sqlʶ��
				try{
				Connection conn2=p.getConnection();//��ȡ���ݿ��
				PreparedStatement s = conn2.prepareStatement(a1);
				int jj=Integer.parseInt(fksl.getText());
					s.setInt(1,jj);
					s.setString(2,fkmc.getText());
					s.executeUpdate();
					s.close();	
			        conn2.close();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				fkmc.setText("");
				fksl.setText("");
				}
			}
		});
		btnNewButton.setBounds(292, 207, 104, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("����");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				���ﳵfkjm d=new ���ﳵfkjm();
				d.show();
			}
		});
		btnNewButton_1.setBounds(322, 230, 74, 23);
		contentPane.add(btnNewButton_1);
		
		JDesktopPane desktopPane = new JDesktopPane(){
			@Override
			public void paintComponent(Graphics g) {//�ػ���屳��
				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon=new ImageIcon("img/zz.jpg");
				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		desktopPane.setBounds(0, 0, 489, 263);
		contentPane.add(desktopPane);
	
	}
}

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

public class 管理jm extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					管理jm frame = new 管理jm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 管理界面，对商品进行管理，即增删查改操作
	 */
	public 管理jm() {
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
		String[] titles = { "种类", "商品名", "数量","价格"};
		DefaultTableModel model=new DefaultTableModel(titles, 0);
		Connection conn=new lj().getConnection();//调用lj()连接数据库
		String sql="select zl,name,sl,money from 商品add";
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
		table.setAutoCreateRowSorter(true);//点击标题排序
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
			public void paintComponent(Graphics g) {//重绘面板背景
				//创建一个未初始化的图像图标，参考API
				ImageIcon icon=new ImageIcon("img/rr.jpg");
				//绘制指定图像中已缩放到适合指定矩形内部的图像，参考API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		desktopPane.setBounds(0, 0, 489, 253);
		contentPane.add(desktopPane);
		JButton btnNewButton = new JButton("添加商品");
		btnNewButton.setIcon(new ImageIcon(管理jm.class.getResource("/\u56FE\u7247/m12.png")));
		btnNewButton.setBounds(172, 31, 104, 23);
		desktopPane.add(btnNewButton);
		
		
		JButton btnNewButton_2 = new JButton("修改");
		btnNewButton_2.setIcon(new ImageIcon(管理jm.class.getResource("/\u56FE\u7247/m7.png")));
		btnNewButton_2.setBounds(387, 31, 92, 23);
		desktopPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("删除商品");
		btnNewButton_1.setIcon(new ImageIcon(管理jm.class.getResource("/\u56FE\u7247/m17.png")));
		btnNewButton_1.setBounds(359, 0, 104, 23);
		desktopPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("\u67E5\u8BE2");
		btnNewButton_3.setBounds(72, 31, 90, 23);
		desktopPane.add(btnNewButton_3);
		btnNewButton_3.setIcon(new ImageIcon(管理jm.class.getResource("/\u56FE\u7247/06.png")));
		
		JButton btnNewButton_4 = new JButton("刷新");
		btnNewButton_4.setBounds(286, 31, 97, 23);
		desktopPane.add(btnNewButton_4);
		btnNewButton_4.setIcon(new ImageIcon(管理jm.class.getResource("/\u56FE\u7247/r8.png")));
		
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
				管理jm ww=new 管理jm();
				ww.show();
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u=textPane.getText();
				TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//设置表格模型排序器
				table.setRowSorter(sorter);//设置表格排序器
				sorter.setRowFilter(null);//不设置过滤条件，显示全部数据
				sorter.setRowFilter(RowFilter.regexFilter(u));//按指定的正则表达式过滤数据  RowFilter.regexFilter(u,0)   0表示过滤第一列的数据
				//按数值排序，下列代码过滤第2个字段小于70的数据
				//sorter.setRowFilter(RowFilter.numberFilter(ComparisonType.BEFORE, 70, 2));
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					  if (JOptionPane.showConfirmDialog(null, "确定要删除数据吗？", "",    JOptionPane.YES_NO_OPTION) == 0) {// 确定对话框
						  lj t=new lj();
							String a1="delete from 商品add where name=?";//使用占位符便于sql识别
							try{
							Connection conn=t.getConnection();//获取数据库接
							PreparedStatement s = conn.prepareStatement(a1);
								s.setString(1,slsc.getText());
								s.executeUpdate();
								s.close();	
						        conn.close();
						        JOptionPane.showMessageDialog(null, "删除成功", "删除成功", JOptionPane.NO_OPTION);
						        dispose();
								管理jm ww=new 管理jm();
								ww.show();
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
					  } else {
					    JOptionPane.showMessageDialog(null, "请输入要删除的名称");
					  }
					
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				修改jm t=new 修改jm();
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

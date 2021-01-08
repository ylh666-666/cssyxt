package cn.cssyxt.jm.ylh.frm;
/**
 * 通过文件进行增删查改操作
 * 购物车以及收银活动界面
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.cssyxt.pdff.ylh.dao.时间add;
import cn.cssyxt.pdff.ylh.dao.统计add;
import cn.cssyxt.sjk.ylh.dbc.lj;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.RowFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import java.awt.Color;

public class 购物车fkjm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JButton btnNewButton_2;
	float s;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JDesktopPane desktopPane;
	private JButton btnNewButton_7;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_8;
	private JTextPane gwccx;
	private JButton btnNewButton_9;
	private JButton btnNewButton_10;
public void a(float s) {
	this.s=s;
}
public float c() {
	return s;
}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					购物车fkjm frame = new 购物车fkjm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
/**
 * 读取文件内容，将其存入model
 * @param model
 */
	public static void initTable(DefaultTableModel model) {
		  try(FileReader fr=new FileReader("f:/a.txt");//实例化字符文件流
		      BufferedReader br=new BufferedReader(fr);){//实例化缓冲流
		    String row=null;
		    while((row=br.readLine())!=null) {//按行读取数据
		      model.addRow(row.split("\t"));//将读取的行按分隔符拆分成字符串数组存入数据模型，关键代码
		    }
		  }catch(Exception e1) {e1.printStackTrace();}
		}
	/**
	 * 购物车界面
	 */
	public 购物车fkjm() {
		setTitle("\u8D2D\u7269\u8F66");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 685, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 10, 362, 175);
		contentPane.add(scrollPane);
		String[] titles = { "种类", "商品名", "数量","价格"};// 定义数组表示表格标题
		DefaultTableModel model=new DefaultTableModel(titles, 0);//定义表格数据模型的表格标题和行数(为0行)
		购物车fkjm.initTable(model);//调用方法装载数据
		table = new JTable(model);
		scrollPane.setViewportView(table);
		float s=0;
		for(int i=0;i<table.getRowCount();i++) {//table.getRowCount()获取table表的总行数
		TableModel model2=table.getModel();
		String a=(String) model2.getValueAt(i,2);//Integer.parseInt(sl), Float.parseFloat(money)
		String b=(String) model2.getValueAt(i,3);
		s=s+Integer.parseInt(a)*Float.parseFloat(b);
		}//System.out.println(s);
		
		lblNewLabel = new JLabel("总金额："+s);
		lblNewLabel.setBounds(26, 210, 139, 15);
		contentPane.add(lblNewLabel);
		a(s);
		
		btnNewButton_2 = new JButton("全场5折");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "成功打5折,所需付款："+c()*0.5, "付款", JOptionPane.NO_OPTION);
			}
		});
		btnNewButton_2.setBounds(101, 238, 97, 23);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel_1 = new JLabel("\u6D3B\u52A8\u5217\u8868\uFF1A");
		lblNewLabel_1.setBounds(10, 242, 148, 15);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton_1 = new JButton("全场6折");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "成功打6折,所需付款："+c()*0.6, "付款", JOptionPane.NO_OPTION);
			}
		});
		btnNewButton_1.setBounds(220, 238, 97, 23);
		contentPane.add(btnNewButton_1);
		
		desktopPane = new JDesktopPane(){
			@Override
			public void paintComponent(Graphics g) {//重绘面板背景
				//创建一个未初始化的图像图标，参考API
				ImageIcon icon=new ImageIcon("img/cz.jpg");
				//绘制指定图像中已缩放到适合指定矩形内部的图像，参考API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		desktopPane.setBounds(10, 0, 651, 343);
		contentPane.add(desktopPane);
		
		btnNewButton_7 = new JButton("\u5220\u9664");
		btnNewButton_7.setIcon(new ImageIcon(购物车fkjm.class.getResource("/\u56FE\u7247/d6.png")));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {// 是否选择了要删除的行
					  if (JOptionPane.showConfirmDialog(null, "确定要删除数据吗？", "",    JOptionPane.YES_NO_OPTION) == 0) {// 确定对话框
					    model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
					    //从表格数据中删除行,model1为DefaultTableModel类型，排序后不能直接使用表格的getSelectedRow方法获取被选中的行
					  } else {
					    JOptionPane.showMessageDialog(null, "请选择要删除的行");
					  }
					}
				
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("f:/a.txt"))) {
					  for (int i = 0; i < model.getRowCount(); i++) {// 遍历表格数据，加入集合中
					String row = model.getValueAt(i, 0).toString() + "\t" + model.getValueAt(i, 1).toString() + "\t"+ model.getValueAt(i, 2).toString() + "\t"+ model.getValueAt(i, 3).toString() + "\t";// 获取表格中每一行的每一个单元格
					    bw.write(row);// 向文本文件中增加数据
					    bw.newLine();// 写入回车换行
					  }
					} catch (Exception e1) {
					  e1.printStackTrace();
					}
					
			}
		});
		btnNewButton_7.setBounds(389, 209, 83, 23);
		desktopPane.add(btnNewButton_7);
		
		lblNewLabel_2 = new JLabel("\u8BF7\u9009\u62E9\u8981\u5220\u9664\u7684\u8D2D\u7269\u8F66\u5185\u7684\u5546\u54C1");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(354, 191, 181, 15);
		desktopPane.add(lblNewLabel_2);
		
		btnNewButton_8 = new JButton("更新(保存修改)");
		btnNewButton_8.setIcon(new ImageIcon(购物车fkjm.class.getResource("/\u56FE\u7247/r8.png")));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("f:/a.txt"))) {
					  for (int i = 0; i < model.getRowCount(); i++) {// 遍历表格数据，加入集合中
					String row = model.getValueAt(i, 0).toString() + "\t" + model.getValueAt(i, 1).toString() + "\t"+ model.getValueAt(i, 2).toString() + "\t"+ model.getValueAt(i, 3).toString() + "\t";// 获取表格中每一行的每一个单元格
					    bw.write(row);// 向文本文件中增加数据
					    bw.newLine();// 写入回车换行
					  }
					} catch (Exception e1) {
					  e1.printStackTrace();
					}


				
				dispose();
				购物车fkjm w=new 购物车fkjm();
				w.show();
			}
		});
		btnNewButton_8.setBounds(482, 209, 144, 23);
		desktopPane.add(btnNewButton_8);
		
		btnNewButton_4 = new JButton("全场8折");
		btnNewButton_4.setBounds(212, 265, 97, 23);
		desktopPane.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("全场9折");
		btnNewButton_5.setBounds(90, 298, 97, 23);
		desktopPane.add(btnNewButton_5);
		
		btnNewButton_3 = new JButton("全场7折");
		btnNewButton_3.setBounds(90, 265, 97, 23);
		desktopPane.add(btnNewButton_3);
		
		btnNewButton_6 = new JButton("全场免费");
		btnNewButton_6.setBounds(201, 291, 108, 36);
		desktopPane.add(btnNewButton_6);
		
		gwccx = new JTextPane();
		gwccx.setBounds(317, 240, 89, 21);
		desktopPane.add(gwccx);
		
		btnNewButton_9 = new JButton("查询");
		btnNewButton_9.setIcon(new ImageIcon(购物车fkjm.class.getResource("/\u56FE\u7247/15.png")));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u=gwccx.getText();
				TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//设置表格模型排序器
				table.setRowSorter(sorter);//设置表格排序器
				sorter.setRowFilter(null);//不设置过滤条件，显示全部数据
				sorter.setRowFilter(RowFilter.regexFilter(u));//按指定的正则表达式过滤数据  RowFilter.regexFilter(u,0)   0表示过滤第一列的数据
				//按数值排序，下列代码过滤第2个字段小于70的数据
				//sorter.setRowFilter(RowFilter.numberFilter(ComparisonType.BEFORE, 70, 2));
			}
		});
		btnNewButton_9.setBounds(416, 242, 85, 23);
		desktopPane.add(btnNewButton_9);
		
		btnNewButton_10 = new JButton("打印小票(Excel)");
		btnNewButton_10.setIcon(new ImageIcon(购物车fkjm.class.getResource("/\u56FE\u7247/q1.png")));
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "打印成功", "成功", JOptionPane.NO_OPTION);
				File file = new File("f:/aaaa.xlsx");// 定位要操作的excel文件
				Workbook workbook = new XSSFWorkbook();// 创建工作簿对象
				Sheet sheet = workbook.createSheet("test1");// 创建工作表对象
				
				//int i2=0;
				for(int i1 = 0; i1 < model.getRowCount(); i1++) {
					Row row = sheet.createRow(i1);// 创建行对象，下标从0开始
					Cell cell1 = row.createCell(0);// 创建单元格，从0开始
					cell1.setCellValue(model.getValueAt(i1, 0).toString());
					Cell cell2 = row.createCell(1);
					cell2.setCellValue(model.getValueAt(i1, 1).toString());
					Cell cell3 = row.createCell(2);
					cell3.setCellValue(model.getValueAt(i1, 2).toString());
					Cell cell4 = row.createCell(3);
					cell4.setCellValue(model.getValueAt(i1, 3).toString());
					if(i1==0) {Cell cell5=row.createCell(4);
					cell5.setCellValue(c());
					}
				}
				
				
				try(FileOutputStream fos = new FileOutputStream(file);) {
					workbook.write(fos);// 将内容写入到指定的excel文档
				} catch (IOException e5) {
					e5.printStackTrace();
				} 
			}
		});
		btnNewButton_10.setBounds(404, 298, 150, 23);
		desktopPane.add(btnNewButton_10);
		
		btnNewButton = new JButton("付款");
		btnNewButton.setBounds(212, 209, 97, 23);
		desktopPane.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(购物车fkjm.class.getResource("/\u56FE\u7247/qqt.png")));
		
		JTextPane fuk = new JTextPane();
		fuk.setBounds(119, 211, 83, 21);
		desktopPane.add(fuk);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fuk.getText().equals("")) {JOptionPane.showMessageDialog(null, "金额不能为空", "金额不足", JOptionPane.WARNING_MESSAGE);}
			else if(Float.parseFloat(fuk.getText())>=c()&&!fuk.getText().equals("")) {
				JOptionPane.showMessageDialog( null, "付款成功，欢迎下次光临！本次找零："+(Float.parseFloat(fuk.getText())-c()));
				
				for(int i=0;i<table.getRowCount();i++) {//table.getRowCount()获取table表的总行数
					TableModel model2=table.getModel();
					String a1=(String) model2.getValueAt(i,0);//Integer.parseInt(sl), Float.parseFloat(money)种类
					String b1=(String) model2.getValueAt(i,1);//商品名
					String c1=(String) model2.getValueAt(i,2);//数量
					String d1=(String) model2.getValueAt(i,3);//价格
					int c2=Integer.parseInt(c1);
					float d2=Float.parseFloat(d1);
					统计add hh=new 统计add();
					hh.addtj(a1, b1, c2, d2);
					时间add tt=new 时间add();
					Date date = new Date(); // this object contains the current date value 
					SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日 HH:mm");
					tt.sj(a1,b1,c1,d1,formatter.format(date));
					}
				
				File file=new File("f:/a.txt");
				try {
		            if(!file.exists()) {
		                file.createNewFile();
		            }
		            FileWriter fileWriter =new FileWriter(file);
		            fileWriter.write("");
		            fileWriter.flush();
		            fileWriter.close();
		        } catch (IOException e3) {
		            e3.printStackTrace();
		        }
				dispose();
				收账jm u=new 收账jm();
				u.show();}
				else {JOptionPane.showMessageDialog(null, "金额不足请重新付款", "金额不足", JOptionPane.WARNING_MESSAGE);fuk.setText("");}
			}
		});
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "所需付款："+c()*0, "付款", JOptionPane.NO_OPTION);
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "成功打7折,所需付款："+c()*0.7, "付款", JOptionPane.NO_OPTION);
			}
		});
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "成功打9折,所需付款："+c()*0.9, "付款", JOptionPane.NO_OPTION);
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "成功打8折,所需付款："+c()*0.8, "付款", JOptionPane.NO_OPTION);
			}
		});
		
		
		
	}
}

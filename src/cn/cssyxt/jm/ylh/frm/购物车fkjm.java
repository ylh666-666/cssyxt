package cn.cssyxt.jm.ylh.frm;
/**
 * ͨ���ļ�������ɾ��Ĳ���
 * ���ﳵ�Լ����������
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

import cn.cssyxt.pdff.ylh.dao.ʱ��add;
import cn.cssyxt.pdff.ylh.dao.ͳ��add;
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

public class ���ﳵfkjm extends JFrame {

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
					���ﳵfkjm frame = new ���ﳵfkjm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
/**
 * ��ȡ�ļ����ݣ��������model
 * @param model
 */
	public static void initTable(DefaultTableModel model) {
		  try(FileReader fr=new FileReader("f:/a.txt");//ʵ�����ַ��ļ���
		      BufferedReader br=new BufferedReader(fr);){//ʵ����������
		    String row=null;
		    while((row=br.readLine())!=null) {//���ж�ȡ����
		      model.addRow(row.split("\t"));//����ȡ���а��ָ�����ֳ��ַ��������������ģ�ͣ��ؼ�����
		    }
		  }catch(Exception e1) {e1.printStackTrace();}
		}
	/**
	 * ���ﳵ����
	 */
	public ���ﳵfkjm() {
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
		String[] titles = { "����", "��Ʒ��", "����","�۸�"};// ���������ʾ������
		DefaultTableModel model=new DefaultTableModel(titles, 0);//����������ģ�͵ı����������(Ϊ0��)
		���ﳵfkjm.initTable(model);//���÷���װ������
		table = new JTable(model);
		scrollPane.setViewportView(table);
		float s=0;
		for(int i=0;i<table.getRowCount();i++) {//table.getRowCount()��ȡtable���������
		TableModel model2=table.getModel();
		String a=(String) model2.getValueAt(i,2);//Integer.parseInt(sl), Float.parseFloat(money)
		String b=(String) model2.getValueAt(i,3);
		s=s+Integer.parseInt(a)*Float.parseFloat(b);
		}//System.out.println(s);
		
		lblNewLabel = new JLabel("�ܽ�"+s);
		lblNewLabel.setBounds(26, 210, 139, 15);
		contentPane.add(lblNewLabel);
		a(s);
		
		btnNewButton_2 = new JButton("ȫ��5��");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "�ɹ���5��,���踶�"+c()*0.5, "����", JOptionPane.NO_OPTION);
			}
		});
		btnNewButton_2.setBounds(101, 238, 97, 23);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel_1 = new JLabel("\u6D3B\u52A8\u5217\u8868\uFF1A");
		lblNewLabel_1.setBounds(10, 242, 148, 15);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton_1 = new JButton("ȫ��6��");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "�ɹ���6��,���踶�"+c()*0.6, "����", JOptionPane.NO_OPTION);
			}
		});
		btnNewButton_1.setBounds(220, 238, 97, 23);
		contentPane.add(btnNewButton_1);
		
		desktopPane = new JDesktopPane(){
			@Override
			public void paintComponent(Graphics g) {//�ػ���屳��
				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon=new ImageIcon("img/cz.jpg");
				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		desktopPane.setBounds(10, 0, 651, 343);
		contentPane.add(desktopPane);
		
		btnNewButton_7 = new JButton("\u5220\u9664");
		btnNewButton_7.setIcon(new ImageIcon(���ﳵfkjm.class.getResource("/\u56FE\u7247/d6.png")));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {// �Ƿ�ѡ����Ҫɾ������
					  if (JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ��������", "",    JOptionPane.YES_NO_OPTION) == 0) {// ȷ���Ի���
					    model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
					    //�ӱ��������ɾ����,model1ΪDefaultTableModel���ͣ��������ֱ��ʹ�ñ���getSelectedRow������ȡ��ѡ�е���
					  } else {
					    JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ������");
					  }
					}
				
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("f:/a.txt"))) {
					  for (int i = 0; i < model.getRowCount(); i++) {// ����������ݣ����뼯����
					String row = model.getValueAt(i, 0).toString() + "\t" + model.getValueAt(i, 1).toString() + "\t"+ model.getValueAt(i, 2).toString() + "\t"+ model.getValueAt(i, 3).toString() + "\t";// ��ȡ�����ÿһ�е�ÿһ����Ԫ��
					    bw.write(row);// ���ı��ļ�����������
					    bw.newLine();// д��س�����
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
		
		btnNewButton_8 = new JButton("����(�����޸�)");
		btnNewButton_8.setIcon(new ImageIcon(���ﳵfkjm.class.getResource("/\u56FE\u7247/r8.png")));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("f:/a.txt"))) {
					  for (int i = 0; i < model.getRowCount(); i++) {// ����������ݣ����뼯����
					String row = model.getValueAt(i, 0).toString() + "\t" + model.getValueAt(i, 1).toString() + "\t"+ model.getValueAt(i, 2).toString() + "\t"+ model.getValueAt(i, 3).toString() + "\t";// ��ȡ�����ÿһ�е�ÿһ����Ԫ��
					    bw.write(row);// ���ı��ļ�����������
					    bw.newLine();// д��س�����
					  }
					} catch (Exception e1) {
					  e1.printStackTrace();
					}


				
				dispose();
				���ﳵfkjm w=new ���ﳵfkjm();
				w.show();
			}
		});
		btnNewButton_8.setBounds(482, 209, 144, 23);
		desktopPane.add(btnNewButton_8);
		
		btnNewButton_4 = new JButton("ȫ��8��");
		btnNewButton_4.setBounds(212, 265, 97, 23);
		desktopPane.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("ȫ��9��");
		btnNewButton_5.setBounds(90, 298, 97, 23);
		desktopPane.add(btnNewButton_5);
		
		btnNewButton_3 = new JButton("ȫ��7��");
		btnNewButton_3.setBounds(90, 265, 97, 23);
		desktopPane.add(btnNewButton_3);
		
		btnNewButton_6 = new JButton("ȫ�����");
		btnNewButton_6.setBounds(201, 291, 108, 36);
		desktopPane.add(btnNewButton_6);
		
		gwccx = new JTextPane();
		gwccx.setBounds(317, 240, 89, 21);
		desktopPane.add(gwccx);
		
		btnNewButton_9 = new JButton("��ѯ");
		btnNewButton_9.setIcon(new ImageIcon(���ﳵfkjm.class.getResource("/\u56FE\u7247/15.png")));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u=gwccx.getText();
				TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//���ñ��ģ��������
				table.setRowSorter(sorter);//���ñ��������
				sorter.setRowFilter(null);//�����ù�����������ʾȫ������
				sorter.setRowFilter(RowFilter.regexFilter(u));//��ָ����������ʽ��������  RowFilter.regexFilter(u,0)   0��ʾ���˵�һ�е�����
				//����ֵ�������д�����˵�2���ֶ�С��70������
				//sorter.setRowFilter(RowFilter.numberFilter(ComparisonType.BEFORE, 70, 2));
			}
		});
		btnNewButton_9.setBounds(416, 242, 85, 23);
		desktopPane.add(btnNewButton_9);
		
		btnNewButton_10 = new JButton("��ӡСƱ(Excel)");
		btnNewButton_10.setIcon(new ImageIcon(���ﳵfkjm.class.getResource("/\u56FE\u7247/q1.png")));
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "��ӡ�ɹ�", "�ɹ�", JOptionPane.NO_OPTION);
				File file = new File("f:/aaaa.xlsx");// ��λҪ������excel�ļ�
				Workbook workbook = new XSSFWorkbook();// ��������������
				Sheet sheet = workbook.createSheet("test1");// �������������
				
				//int i2=0;
				for(int i1 = 0; i1 < model.getRowCount(); i1++) {
					Row row = sheet.createRow(i1);// �����ж����±��0��ʼ
					Cell cell1 = row.createCell(0);// ������Ԫ�񣬴�0��ʼ
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
					workbook.write(fos);// ������д�뵽ָ����excel�ĵ�
				} catch (IOException e5) {
					e5.printStackTrace();
				} 
			}
		});
		btnNewButton_10.setBounds(404, 298, 150, 23);
		desktopPane.add(btnNewButton_10);
		
		btnNewButton = new JButton("����");
		btnNewButton.setBounds(212, 209, 97, 23);
		desktopPane.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(���ﳵfkjm.class.getResource("/\u56FE\u7247/qqt.png")));
		
		JTextPane fuk = new JTextPane();
		fuk.setBounds(119, 211, 83, 21);
		desktopPane.add(fuk);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fuk.getText().equals("")) {JOptionPane.showMessageDialog(null, "����Ϊ��", "����", JOptionPane.WARNING_MESSAGE);}
			else if(Float.parseFloat(fuk.getText())>=c()&&!fuk.getText().equals("")) {
				JOptionPane.showMessageDialog( null, "����ɹ�����ӭ�´ι��٣��������㣺"+(Float.parseFloat(fuk.getText())-c()));
				
				for(int i=0;i<table.getRowCount();i++) {//table.getRowCount()��ȡtable���������
					TableModel model2=table.getModel();
					String a1=(String) model2.getValueAt(i,0);//Integer.parseInt(sl), Float.parseFloat(money)����
					String b1=(String) model2.getValueAt(i,1);//��Ʒ��
					String c1=(String) model2.getValueAt(i,2);//����
					String d1=(String) model2.getValueAt(i,3);//�۸�
					int c2=Integer.parseInt(c1);
					float d2=Float.parseFloat(d1);
					ͳ��add hh=new ͳ��add();
					hh.addtj(a1, b1, c2, d2);
					ʱ��add tt=new ʱ��add();
					Date date = new Date(); // this object contains the current date value 
					SimpleDateFormat formatter = new SimpleDateFormat("MM��dd�� HH:mm");
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
				����jm u=new ����jm();
				u.show();}
				else {JOptionPane.showMessageDialog(null, "���������¸���", "����", JOptionPane.WARNING_MESSAGE);fuk.setText("");}
			}
		});
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "���踶�"+c()*0, "����", JOptionPane.NO_OPTION);
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "�ɹ���7��,���踶�"+c()*0.7, "����", JOptionPane.NO_OPTION);
			}
		});
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "�ɹ���9��,���踶�"+c()*0.9, "����", JOptionPane.NO_OPTION);
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "�ɹ���8��,���踶�"+c()*0.8, "����", JOptionPane.NO_OPTION);
			}
		});
		
		
		
	}
}

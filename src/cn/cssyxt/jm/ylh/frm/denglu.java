package cn.cssyxt.jm.ylh.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.cssyxt.sjk.ylh.dbc.sjk;
import cn.cssyxt.stljm.ylh.vo.cssyxt;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class denglu extends JFrame {

	private JPanel contentPane;
	private JPasswordField mm����;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					denglu frame = new denglu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * ��¼����
	 */
	public denglu() {
		setTitle("\u8D85\u5E02\u6536\u94F6\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//EXIT->DISPOSE�ɲ�ͬʱ�ر�
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�˺�");
		lblNewLabel.setBounds(10, 41, 41, 15);
		contentPane.add(lblNewLabel);
		
		JTextPane zh���� = new JTextPane();
		zh����.setBounds(61, 35, 137, 21);
		contentPane.add(zh����);
		
		JLabel lblNewLabel_1 = new JLabel("����");
		lblNewLabel_1.setBounds(10, 89, 41, 15);
		contentPane.add(lblNewLabel_1);
		
		mm���� = new JPasswordField();
		mm����.setBounds(61, 86, 137, 21);
		contentPane.add(mm����);
		
		JButton btnNewButton = new JButton("��¼");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String zh=zh����.getText();
				String mm=new String(mm����.getPassword());
				cssyxt u=new cssyxt();
				u.setZh(zh);
				u.setMm(mm);
				
				sjk r=new sjk();
				r.setcssyxt(u);
				if(r.JudgeAdmin()==0) {
                	//�����˺Ż��������Ĵ���
                	JOptionPane.showMessageDialog(null, "�˺Ż��������", "�˺Ż��������", JOptionPane.WARNING_MESSAGE);
                	//���������е���Ϣ
                	mm����.setText("");
                	//����˺ſ��е���Ϣ
                	zh����.setText("");
                	
                	//System.out.println("��½ʧ��");
                } else {
                	//������¼�ɹ��Ĵ���
                	JOptionPane.showMessageDialog(null, "��½�ɹ�", "��½�ɹ�", JOptionPane.NO_OPTION);
                	//���ȷ�������ת��������
                	ll a=new ll();
    				a.show();
                    
                        
                }
				
			}
		});
		btnNewButton.setBounds(21, 137, 63, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ע��");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ע��jm a=new ע��jm();
				a.show();
			}
		});
		btnNewButton_1.setBounds(90, 137, 63, 23);
		contentPane.add(btnNewButton_1);
		
		JDesktopPane desktopPane = new JDesktopPane(){
			@Override
			public void paintComponent(Graphics g) {//�ػ���屳��
				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon=new ImageIcon("img/ppo.jpg");
				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		desktopPane.setBounds(0, 0, 489, 263);
		contentPane.add(desktopPane);
	}
}

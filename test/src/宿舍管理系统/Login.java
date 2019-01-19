package 宿舍管理系统;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;
 
public class Login extends JFrame implements ActionListener{
	
	JLabel labName;
	JLabel labpass;
	JButton button;
	JTextField textName;
	JPasswordField textword;
	
  public static void main(String[] args) {
		Login login = new Login();
		login.initUI();
 
	}
	 
	public void initUI() {
		//Jthis this = new Jthis();
		this.setTitle("Login");
		this.setSize(260, 420);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 10, 10);
		this.setLayout(fl);
		ImageIcon icon = new ImageIcon("E:\\java工作空间\\阿狸.JPG");
		JLabel labIcon = new JLabel(icon);
		//labIcon.setSize(40,40);setSize方法只对窗体有效，如果想设置组件的大小只能用
		Dimension dim = new Dimension(250,250);
		labIcon.setPreferredSize(dim);
		this.add(labIcon);
		labName = new JLabel("账号：");
		this.add(labName);
		textName = new JTextField();
		Dimension dim1 = new Dimension(150,30);
		//textName.setSize(dim);//setSize这方法只对顶级容器有效，其他组件使用无效。
		textName.setPreferredSize(dim1);
		this.add(textName);
		labpass= new JLabel("密码：");
		this.add(labpass);
		
		//实例化JPasswordField
		textword=new JPasswordField();
		textword.setPreferredSize(dim1);
		this.add(textword);
		//实例化JButton组件 
		button=new JButton();
		Dimension dim2 = new Dimension(100,30);
		button.setText("登录");
		button.setSize(dim2);
		this.add(button);
		button.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getActionCommand()=="登录")
        {
            
             login();
           
        }


	}
	
	//清空账号和密码框
    private void clear() {
        // TODO Auto-generated method stub
    	labName.setText("");    //设置为空
    	labpass.setText("");  

    }
    
    private void login() {
    	System.out.println();
    	if(textName.getText().isEmpty()&&textName.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "账号密码为空，请输入！","消息提示",JOptionPane.WARNING_MESSAGE);
        }else {
        	//跳转 某个界面
        }
    }
 
}
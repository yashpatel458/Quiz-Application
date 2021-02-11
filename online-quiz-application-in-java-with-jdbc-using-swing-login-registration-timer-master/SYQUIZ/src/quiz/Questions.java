
package quiz;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;


public class Questions extends JFrame 
{
	
	private JPanel contentPane; 
	private JButton Next;
	private JButton Back;
	private ButtonGroup opg;
	private JRadioButton op1;
	private JRadioButton op2;
	private JRadioButton op3;
	private JRadioButton op4;
	private JLabel question;
	private JLabel username;
	private JSeparator separator;
	 String[][] a;
	 String[][] q;
	static int score=0;
	int count=0;
	int c=0;
	static String usernameq;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run()
			{
				try 
				{
					Questions frame = new Questions();
					frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			
		});
		
	}
	
	public Questions() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        score=0;
        
        Game();
      q =new String[10][5];
      //Questions are stored in q[][]
      q[0][0]="Q1) What is the numerical range of a char in Java?";
      q[0][1]="-128 to 127";
      q[0][2]="0 to 256";
      q[0][3]="0 to 32767";
      q[0][4]="0 to 65535";
      
      q[1][0]="Q2) Which of the following is not a Java features?";
      q[1][1]="Dynamic";
      q[1][2]="Architecture Neutral";
      q[1][3]="Use of pointers";
      q[1][4]="Object-oriented";
      
      q[2][0]="Q3) What does the expression float a = 35 / 0 return?";
      q[2][1]="0";
      q[2][2]="Not a Number";
      q[2][3]="Infinity";
      q[2][4]="Run time exception";
      
      q[3][0]="Q4) Which keyword is used for accessing the features of a package?";
      q[3][1]="package";
      q[3][2]="import";
      q[3][3]="extends";
      q[3][4]="export";
      
      q[4][0]="Q5) How to compile java code in command prompt?";
      q[4][1]="javac filename.java";
      q[4][2]="java filename.java";
      q[4][3]="javac filename";
      q[4][4]="java filename";
      
      q[5][0]="Q6) Java is case sensitive?";
      q[5][1]="True";
      q[5][2]="False";
      q[5][3]="Depends On Complier";
      q[5][4]="May be true or false";
      
      q[6][0]="Q7) jar stands for __________.";
      q[6][1]="Java Application Runner";
      q[6][2]="Java Archive";
      q[6][3]="Java Archive Runner";
      q[6][4]="None of these";
      
      q[7][0]="Q8) Which of the following is not a keyword in Java?";
      q[7][1]="assert";
      q[7][2]="boolean";
      q[7][3]="abstract";
      q[7][4]="finalize";
      
      q[8][0]="Q9) Java is a Successor to which programming language?";
      q[8][1]="JavaScript";
      q[8][2]="R";
      q[8][3]="C++";
      q[8][4]="C#";
      
      q[9][0]="Q10) Byte code is the result of?";
      q[9][1]="Compiling a Java file";
      q[9][2]="Compiling a Class file";
      q[9][3]="Interpreting a Java File";
      q[9][4]="Interpreting a Class file";


      //Answers are stored in a[][]
      a=new String[10][5];
      a[0][1]="0 to 65535";
      a[1][1]="Use of pointers";
      a[2][1]="Infinity";
      a[3][1]="import";
      a[4][1]="javac filename.java";
      a[5][1]="True";
      a[6][1]="Java Archive";
      a[7][1]="finalize";
      a[8][1]="C++";
      a[9][1]="Compiling a Java file";
     


      start(0);
	}
	 
	 public String[][] qarray() {
	        return q.clone();
	    }
	 public String[][] ansarray() {
	        return a.clone();
	    }
	private void Game()
	{	
		setTitle("Complete these 10 MCQ's in 2 Minutes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		opg=new ButtonGroup();
		op1=new JRadioButton();
		op2=new JRadioButton();
		op3=new JRadioButton();
		op4=new JRadioButton();
		question=new JLabel();
		username=new JLabel();
		separator=new JSeparator();
		Next=new JButton();
		Back=new JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        final JLabel timer = new JLabel("02:00");
        final Timer t = new Timer(1000, new ActionListener() {
            int time = 120;
            @Override
            public void actionPerformed(ActionEvent e) {
                time--;
                timer.setText(format(time / 60) + ":" + format(time % 60));
                if(c>=10) {
                    final Timer timer = (Timer) e.getSource();
                	timer.stop();
                }else {
                if (time == 0) {
                	if(c>=10) {
                    final Timer timer = (Timer) e.getSource();
                    timer.stop();
                	}else {
                    JOptionPane.showMessageDialog(null,"Time's Up, Click Ok To Check Your Score","Oops",JOptionPane.ERROR_MESSAGE);
                    System.out.println(score);
        			new Results().setVisible(true);
        			dispose();
                	}
                }
            }
            }
            
        });
        t.start();
       
        opg.add(op1);
        op1.setText("option1");
        op1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op1Selected(evt);
            }

		
        });

        opg.add(op2);
        op2.setText("option2");
        op2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op2selected(evt);
            }

		
        });

        opg.add(op3);
        op3.setText("option3");
        op3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op3selected(evt);
            }

        });

        opg.add(op4);
        op4.setText("option4");
        op4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op4selected(evt);
            }

			
        });

        question.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        question.setText("question");
        username.setText("Student: "+Login.usernameq);
        username.setForeground(Color.red);
        username.setFont(new Font("condensed", Font.PLAIN, 14));
        Next.setText("Next");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextClicked(evt);
            }

        });
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackClicked(evt);
            }

        });
	
	//GUI
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(op1)
                    .addComponent(op3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(op2)
                    .addComponent(op4))
                .addGap(60, 60, 60))
            .addComponent(separator, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                    		.addComponent(timer)
                        .addComponent(question, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(username)
                        .addGap(642, 642, 642)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Next, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                    .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username)
                    .addComponent(Next))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                		.addComponent(timer)
                    .addComponent(question, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Back))
                .addGap(18, 18, 18)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(op1)
                    .addComponent(op2))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(op3)
                    .addComponent(op4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addContainerGap())
        );

	pack();
	}    

	

	protected void BackClicked(ActionEvent evt) {
	
		if(c==0) {
			
		}else {
			if(score==c)
			{
		score--;
		c--;
		start(c);
			}
			else {
				c--;
				start(c);
			}
		}
		
	}
	protected void NextClicked(ActionEvent evt) {
		
		
		if(getSelectedButtonText(opg)==a[c][1]) {
			score++;
			count++;
			c++;
		}
		else
		{
			c++;
			count++;
		}
			if(c!=10)
		{
			start(c);
		System.out.println(score);
		}
		else {
			System.out.println(score);
			new Results().setVisible(true);
			this.dispose();
		}
	}
	protected void op4selected(ActionEvent evt) {
	
		
	}
	protected void op3selected(ActionEvent evt) {
	
		
	}
	protected void op2selected(ActionEvent evt) {
		
		
	}
	protected void op1Selected(ActionEvent evt) {
	
		
	}
	String getSelectedButtonText(ButtonGroup buttonGroup) {
		    for (Enumeration buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
		        AbstractButton button = (AbstractButton) buttons.nextElement();

		        if (button.isSelected()) {
		            return button.getText();
		        }
		    }
		    return null;
	}
	public void start(int i) {
		
		 question.setText(q[i][0]);
        question.setFont(new Font("arial", Font.PLAIN, 20));
        question.setForeground(Color.blue);
	        op1.setText(q[i][1]);
        op1.setFont(new Font("arial", Font.PLAIN, 16));
	        op2.setText(q[i][2]);
        op2.setFont(new Font("arial", Font.PLAIN, 16));
	        op3.setText(q[i][3]);
        op3.setFont(new Font("arial", Font.PLAIN, 16));
	        op4.setText(q[i][4]);
        op4.setFont(new Font("arial", Font.PLAIN, 16));
	        opg.clearSelection();


		
	}
	private static String format(int i) {
        String result = String.valueOf(i);
        if (result.length() == 1) {
            result = "0" + result;
        }
        return result;
    }
	

		 }

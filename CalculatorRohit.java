package newProject;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
//import javax.sound.*;

import java.awt.*;
import java.awt.event.*;
//import java.util.concurrent.ForkJoinTask;
import java.io.File;



public class CalculatorRohit implements ActionListener,MouseListener{

    JFrame main_frame;
    JPanel Head,Body,Foot;
    JTextField main_input;
    JButton num_1,num_2,num_3,num_4,num_5,num_6,num_7,num_8,num_9,num_0,add,sub,div,mul,clr,bkspc,equal,dec;
    ImageIcon frame_icon;

    static float a=0.0f,b=0.0f,result=0.0f;
    static int operator=0;

    
    CalculatorRohit(){


        frame_icon = new ImageIcon("icon-calculator-clipart.png");

        main_frame = new JFrame("Calculator");
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setIconImage(frame_icon.getImage());
        main_frame.getContentPane().setBackground(Color.BLACK);
        main_frame.setLayout(new BorderLayout());
        main_frame.setSize(500,600);
        main_frame.setResizable(false);
        

        Head = new JPanel();
        
        Head.setBackground(Color.BLACK);
        Head.setLayout(new GridLayout(1,1));

        Body = new JPanel();
        
        Body.setBackground(Color.BLACK);
        Body.setLayout(new GridLayout(4,4));

        Foot = new JPanel();

        Foot.setBackground(Color.BLACK);
        Foot.setLayout(new BorderLayout());
        Foot.setBorder(BorderFactory.createEtchedBorder(0,Color.BLACK,Color.DARK_GRAY));

        main_input = new JTextField();
        main_input.setPreferredSize(new Dimension(470,130));
        main_input.setBackground(Color.BLACK);
        main_input.setBorder(BorderFactory.createBevelBorder(0,Color.GRAY,Color.DARK_GRAY));
        main_input.setFont(new Font("Times New Roman",Font.PLAIN,130));
        main_input.setEditable(false);
        //main_input.setCaretColor(Color.WHITE);
        main_input.setForeground(Color.WHITE);


        clr = new JButton("AC");
        
        clr.setBackground(new Color(255,145,43));
        clr.setForeground(Color.WHITE);
        clr.setFont(new Font("Times New Roman",Font.PLAIN,40));
        clr.setForeground(Color.BLACK);
        clr.setFocusable(false);
        clr.setBorder(BorderFactory.createEtchedBorder(0,Color.BLACK,Color.DARK_GRAY));

        bkspc = new JButton("←");
        
        bkspc.setBackground(new Color(255,145,43));
        bkspc.setFont(new Font("Times New Roman",Font.PLAIN,40));
        bkspc.setFocusable(false);
        bkspc.setBorder(BorderFactory.createEtchedBorder(0,Color.BLACK,Color.DARK_GRAY));
        
        num_0 = new JButton("0");
        
        num_0.setPreferredSize(new Dimension(350,75));
        num_0.setBackground(Color.BLACK);
        num_0.setForeground(Color.WHITE);
        num_0.setFont(new Font("Times New Roman",Font.PLAIN,40));
        num_0.setFocusable(false);
        num_0.setBorder(BorderFactory.createEmptyBorder());

        num_1 = new JButton("1");
        
        num_1.setBackground(Color.BLACK);
        num_1.setForeground(Color.WHITE);
        num_1.setFont(new Font("Times New Roman",Font.PLAIN,40));
        num_1.setFocusable(false);
        num_1.setBorder(BorderFactory.createEtchedBorder(0,Color.BLACK,Color.DARK_GRAY));

        num_2 = new JButton("2");
        
        num_2.setBackground(Color.BLACK);
        num_2.setForeground(Color.WHITE);
        num_2.setFont(new Font("Times New Roman",Font.PLAIN,40));
        num_2.setFocusable(false);
        num_2.setBorder(BorderFactory.createEtchedBorder(0,Color.BLACK,Color.DARK_GRAY));

        num_3 = new JButton("3");
        
        num_3.setBackground(Color.BLACK);
        num_3.setForeground(Color.WHITE);
        num_3.setFont(new Font("Times New Roman",Font.PLAIN,40));
        num_3.setFocusable(false);
        num_3.setBorder(BorderFactory.createEtchedBorder(0,Color.BLACK,Color.DARK_GRAY));

        num_4 = new JButton("4");
        
        num_4.setBackground(Color.BLACK);
        num_4.setForeground(Color.WHITE);
        num_4.setFont(new Font("Times New Roman",Font.PLAIN,40));
        num_4.setFocusable(false);
        num_4.setBorder(BorderFactory.createEtchedBorder(0,Color.BLACK,Color.DARK_GRAY));

        num_5 = new JButton("5");
        
        num_5.setBackground(Color.BLACK);
        num_5.setForeground(Color.WHITE);
        num_5.setFont(new Font("Times New Roman",Font.PLAIN,40));
        num_5.setFocusable(false);
        num_5.setBorder(BorderFactory.createEtchedBorder(0,Color.BLACK,Color.DARK_GRAY));

        num_6 = new JButton("6");
        
        num_6.setBackground(Color.BLACK);
        num_6.setForeground(Color.WHITE);
        num_6.setFont(new Font("Times New Roman",Font.PLAIN,40));
        num_6.setFocusable(false);
        num_6.setBorder(BorderFactory.createEtchedBorder(0,Color.BLACK,Color.DARK_GRAY));
        
        num_7 = new JButton("7");
        
        num_7.setBackground(Color.BLACK);
        num_7.setForeground(Color.WHITE);
        num_7.setFont(new Font("Times New Roman",Font.PLAIN,40));
        num_7.setFocusable(false);
        num_7.setBorder(BorderFactory.createEtchedBorder(0,Color.BLACK,Color.DARK_GRAY));

        num_8 = new JButton("8");
        
        num_8.setBackground(Color.BLACK);
        num_8.setForeground(Color.WHITE);
        num_8.setFont(new Font("Times New Roman",Font.PLAIN,40));
        num_8.setFocusable(false);
        num_8.setBorder(BorderFactory.createEtchedBorder(0,Color.BLACK,Color.DARK_GRAY));

        num_9 = new JButton("9");
        
        num_9.setBackground(Color.BLACK);
        num_9.setForeground(Color.WHITE);
        num_9.setFont(new Font("Times New Roman",Font.PLAIN,40));
        num_9.setFocusable(false);
        num_9.setBorder(BorderFactory.createEtchedBorder(0,Color.BLACK,Color.DARK_GRAY));

        dec = new JButton(".");
        
        dec.setPreferredSize(new Dimension(120,90));
        dec.setBackground(new Color(255,145,43));
        dec.setFont(new Font("Times New Roman",Font.PLAIN,40));
        dec.setFocusable(false);
        dec.setBorder(BorderFactory.createEtchedBorder(0,Color.BLACK,Color.DARK_GRAY));

        add = new JButton("+");
        
        add.setBackground(new Color(255,145,43));
        add.setFont(new Font("Times New Roman",Font.PLAIN,40));
        add.setFocusable(false);
        add.setBorder(BorderFactory.createEtchedBorder(0,Color.BLACK,Color.DARK_GRAY));

        sub = new JButton("-");
        
        sub.setBackground(new Color(255,145,43));
        sub.setFont(new Font("Times New Roman",Font.PLAIN,40));
        sub.setFocusable(false);
        sub.setBorder(BorderFactory.createEtchedBorder(0,Color.BLACK,Color.DARK_GRAY));

        mul = new JButton("x");
        
        mul.setBackground(new Color(255,145,43));
        mul.setFont(new Font("Times New Roman",Font.PLAIN,40));
        mul.setFocusable(false);
        mul.setBorder(BorderFactory.createEtchedBorder(0,Color.BLACK,Color.DARK_GRAY));

        div = new JButton("/");
        
        div.setBackground(new Color(255,145,43));
        div.setFont(new Font("Times New Roman",Font.PLAIN,40));
        div.setFocusable(false);
        div.setBorder(BorderFactory.createEtchedBorder(0,Color.BLACK,Color.DARK_GRAY));

        equal = new JButton("=");
        
        equal.setBackground(new Color(255,145,43));
        equal.setFont(new Font("Times New Roman",Font.PLAIN,40));
        equal.setFocusable(false);
        equal.setBorder(BorderFactory.createEtchedBorder(0,Color.BLACK,Color.DARK_GRAY));

        clr.addActionListener(this);
        bkspc.addActionListener(this);

        num_0.addActionListener(this);
        num_1.addActionListener(this);
        num_2.addActionListener(this);
        num_3.addActionListener(this);
        num_4.addActionListener(this);
        num_5.addActionListener(this);
        num_6.addActionListener(this);
        num_7.addActionListener(this);
        num_8.addActionListener(this);
        num_9.addActionListener(this);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        equal.addActionListener(this);
        dec.addActionListener(this);

        clr.addMouseListener(this);
        bkspc.addMouseListener(this);

        add.addMouseListener(this);
        sub.addMouseListener(this);
        mul.addMouseListener(this);
        div.addMouseListener(this);
        equal.addMouseListener(this);

        num_0.addMouseListener(this);
        num_1.addMouseListener(this);
        num_2.addMouseListener(this);
        num_3.addMouseListener(this);
        num_4.addMouseListener(this);
        num_5.addMouseListener(this);
        num_6.addMouseListener(this);
        num_7.addMouseListener(this);
        num_8.addMouseListener(this);
        num_9.addMouseListener(this);

        dec.addMouseListener(this);


        Head.add(main_input);

        Body.add(clr);
        Body.add(bkspc);
        
        
        Body.add(add);
        Body.add(sub);

        Body.add(num_9);
        Body.add(num_8); 
        Body.add(num_7);

        Body.add(mul); 

        Body.add(num_6);
        Body.add(num_5);
        Body.add(num_4);

        Body.add(div);

        Body.add(num_3);
        Body.add(num_2);
        Body.add(num_1);

        Body.add(equal);
        
        
        
        Foot.add(num_0,BorderLayout.WEST);
        Foot.add(dec,BorderLayout.EAST);
        
        //Body.add(equal);
        
        main_frame.add(Head,BorderLayout.NORTH);
        main_frame.add(Body,BorderLayout.CENTER);
        main_frame.add(Foot,BorderLayout.SOUTH);

        main_frame.setVisible(true);

    }

    public void playSound(String soundName)
 {
   try 
   {
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile( ));
    Clip clip = AudioSystem.getClip( );
    clip.open(audioInputStream);
    clip.start( );
   }
   catch(Exception ex)
   {
     System.out.println("Error with playing sound.");
     ex.printStackTrace( );
   }

 }


    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==num_1)
            main_input.setText(main_input.getText().concat("1"));
        if(e.getSource()==num_2)
            main_input.setText(main_input.getText().concat("2"));
        if(e.getSource()==num_3)
            main_input.setText(main_input.getText().concat("3"));
        if(e.getSource()==num_4)
            main_input.setText(main_input.getText().concat("4"));
        if(e.getSource()==num_5)
            main_input.setText(main_input.getText().concat("5"));
        if(e.getSource()==num_6)
            main_input.setText(main_input.getText().concat("6"));
        if(e.getSource()==num_7)
            main_input.setText(main_input.getText().concat("7"));
        if(e.getSource()==num_8)
            main_input.setText(main_input.getText().concat("8"));
        if(e.getSource()==num_9)
            main_input.setText(main_input.getText().concat("9"));
        if(e.getSource()==num_0)
            main_input.setText(main_input.getText().concat("0"));
        if(e.getSource()==add){
            a=Float.parseFloat(main_input.getText());
            operator=1;
            main_input.setText("");
        }
        if(e.getSource()==sub){
            a=Float.parseFloat(main_input.getText());
            operator=2;
            main_input.setText("");
        }
        if(e.getSource()==mul){
            a=Float.parseFloat(main_input.getText());
            operator=3;
            main_input.setText("");
        }
        if(e.getSource()==div){
            a=Float.parseFloat(main_input.getText());
            operator=4;
            main_input.setText("");
        }
        if(e.getSource()==dec){
            main_input.setText(main_input.getText().concat("."));
        }
        if(e.getSource()==equal){
            b=Float.parseFloat(main_input.getText());
            switch(operator){
                case 1: result=a+b;
                break;
                case 2: result=a-b;
                break;
                case 3: result=a*b;
                break;
                case 4: result=a/b;
                break;
                default: result=0;
            }
        main_input.setText(""+result);   
        }   
        if(e.getSource()==clr)
            main_input.setText("");
        if(e.getSource()==bkspc){       
            String s=main_input.getText();
            main_input.setText("");
            for(int i=0;i<s.length()-1;i++)
                main_input.setText(main_input.getText()+s.charAt(i));
            }
        
            }
    @Override
        public void mouseClicked(MouseEvent e) {
            for(int i = 0;i<=5;i++){
                continue;
            }
                
        }
        
        
    @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource()==clr){
                clr.setBackground(Color.BLACK);
                clr.setForeground(new Color(255,145,43));
                clr.setFont(new Font("Times New Roman",Font.BOLD,40));

                playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==bkspc){
                bkspc.setBackground(Color.BLACK);
                bkspc.setForeground(new Color(255,145,43));
                bkspc.setFont(new Font("Times New Roman",Font.BOLD,40));

                playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==add){
                add.setBackground(Color.BLACK);
                add.setForeground(new Color(255,145,43));
                add.setFont(new Font("Times New Roman",Font.BOLD,40));

                playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==sub){
                sub.setBackground(Color.BLACK);
                sub.setForeground(new Color(255,145,43));
                sub.setFont(new Font("Times New Roman",Font.BOLD,40));

                playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==mul){
                mul.setBackground(Color.BLACK);
                mul.setForeground(new Color(255,145,43));
                mul.setFont(new Font("Times New Roman",Font.BOLD,40));

                playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==div){
                div.setBackground(Color.BLACK);
                div.setForeground(new Color(255,145,43));
                div.setFont(new Font("Times New Roman",Font.BOLD,40));

                playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==equal){
                equal.setBackground(Color.BLACK);
                equal.setForeground(new Color(255,145,43));
                equal.setFont(new Font("Times New Roman",Font.BOLD,40));

                playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==num_0){
                num_0.setBackground(Color.WHITE);
                num_0.setForeground(Color.BLACK);
                num_0.setFont(new Font("Times New Roman",Font.BOLD,40));

                playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==num_1){
                num_1.setBackground(Color.WHITE);
                num_1.setForeground(Color.BLACK);
                num_1.setFont(new Font("Times New Roman",Font.BOLD,40));

                playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==num_2){
                num_2.setBackground(Color.WHITE);
                num_2.setForeground(Color.BLACK);
                num_2.setFont(new Font("Times New Roman",Font.BOLD,40));

                playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==num_3){
                num_3.setBackground(Color.WHITE);
                num_3.setForeground(Color.BLACK);
                num_3.setFont(new Font("Times New Roman",Font.BOLD,40));

                playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==num_4){
                num_4.setBackground(Color.WHITE);
                num_4.setForeground(Color.BLACK);
                num_4.setFont(new Font("Times New Roman",Font.BOLD,40));

                playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==num_5){
                num_5.setBackground(Color.WHITE);
                num_5.setForeground(Color.BLACK);
                num_5.setFont(new Font("Times New Roman",Font.BOLD,40));

                playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==num_6){
                num_6.setBackground(Color.WHITE);
                num_6.setForeground(Color.BLACK);
                num_6.setFont(new Font("Times New Roman",Font.BOLD,40));

                playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==num_7){
                num_7.setBackground(Color.WHITE);
                num_7.setForeground(Color.BLACK);
                num_7.setFont(new Font("Times New Roman",Font.BOLD,40));

                playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==num_8){
                num_8.setBackground(Color.WHITE);
                num_8.setForeground(Color.BLACK);
                num_8.setFont(new Font("Times New Roman",Font.BOLD,40));

                playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==num_9){
                num_9.setBackground(Color.WHITE);
                num_9.setForeground(Color.BLACK);
                num_9.setFont(new Font("Times New Roman",Font.BOLD,40));

                playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==dec){
                dec.setBackground(Color.BLACK);
                dec.setForeground(new Color(255,145,43));
                dec.setFont(new Font("Times New Roman",Font.BOLD,40));

                playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
                
        }
        
        
    @Override
         public void mouseExited(MouseEvent e) {
            if(e.getSource()==clr){
                clr.setBackground(new Color(255,145,43));
                clr.setForeground(Color.BLACK);
                clr.setFont(new Font("Times New Roman",Font.PLAIN,40));

                //playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==bkspc){
                bkspc.setBackground(new Color(255,145,43));
                bkspc.setForeground(Color.BLACK);
                bkspc.setFont(new Font("Times New Roman",Font.PLAIN,40));

               //playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==add){
                add.setBackground(new Color(255,145,43));
                add.setForeground(Color.BLACK);
                add.setFont(new Font("Times New Roman",Font.PLAIN,40));

                //playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==sub){
                sub.setBackground(new Color(255,145,43));
                sub.setForeground(Color.BLACK);
                sub.setFont(new Font("Times New Roman",Font.PLAIN,40));

                //playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==mul){
                mul.setBackground(new Color(255,145,43));
                mul.setForeground(Color.BLACK);
                mul.setFont(new Font("Times New Roman",Font.PLAIN,40));

                //playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==div){
                div.setBackground(new Color(255,145,43));
                div.setForeground(Color.BLACK);
                div.setFont(new Font("Times New Roman",Font.PLAIN,40));

                //playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==equal){
                equal.setBackground(new Color(255,145,43));
                equal.setForeground(Color.BLACK);
                equal.setFont(new Font("Times New Roman",Font.PLAIN,40));

                //playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==num_0){
                num_0.setBackground(Color.BLACK);
                num_0.setForeground(Color.WHITE);
                num_0.setFont(new Font("Times New Roman",Font.PLAIN,40));

                //playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==num_1){
                num_1.setBackground(Color.BLACK);
                num_1.setForeground(Color.WHITE);
                num_1.setFont(new Font("Times New Roman",Font.PLAIN,40));

                //playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==num_2){
                num_2.setBackground(Color.BLACK);
                num_2.setForeground(Color.WHITE);
                num_2.setFont(new Font("Times New Roman",Font.PLAIN,40));

                //playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==num_3){
                num_3.setBackground(Color.BLACK);
                num_3.setForeground(Color.WHITE);
                num_3.setFont(new Font("Times New Roman",Font.PLAIN,40));

                //playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==num_4){
                num_4.setBackground(Color.BLACK);
                num_4.setForeground(Color.WHITE);
                num_4.setFont(new Font("Times New Roman",Font.PLAIN,40));

                //playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==num_5){
                num_5.setBackground(Color.BLACK);
                num_5.setForeground(Color.WHITE);
                num_5.setFont(new Font("Times New Roman",Font.PLAIN,40));

                //playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==num_6){
                num_6.setBackground(Color.BLACK);
                num_6.setForeground(Color.WHITE);
                num_6.setFont(new Font("Times New Roman",Font.PLAIN,40));

                //playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==num_7){
                num_7.setBackground(Color.BLACK);
                num_7.setForeground(Color.WHITE);
                num_7.setFont(new Font("Times New Roman",Font.PLAIN,40));

                //playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==num_8){
                num_8.setBackground(Color.BLACK);
                num_8.setForeground(Color.WHITE);
                num_8.setFont(new Font("Times New Roman",Font.PLAIN,40));

                //playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==num_9){
                num_9.setBackground(Color.BLACK);
                num_9.setForeground(Color.WHITE);
                num_9.setFont(new Font("Times New Roman",Font.PLAIN,40));

                //playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }
            if(e.getSource()==dec){
                dec.setBackground(new Color(255,145,43));
                dec.setForeground(Color.BLACK);
                dec.setFont(new Font("Times New Roman",Font.PLAIN,40));

                //playSound("zapsplat_multimedia_button_click_004_78081.wav");
            }

                
        }
        
        
    @Override
        public void mousePressed(MouseEvent e) {
            for(int i = 0;i<=5;i++){
                continue;
            }
                
        }
        
        
    @Override
        public void mouseReleased(MouseEvent e) {
            for(int i = 0;i<=5;i++){
                continue;
            }
                
        }
            

    public static void main(String[]args){
        new CalculatorRohit();
    }


    

}
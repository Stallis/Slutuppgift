import java.awt.event.ActionListener;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.font.TextAttribute;

class BingoGUI extends JPanel implements ActionListener{                // implements ActionListener är en aktiv lyssnare om en knapp trycks ned
    private JFrame window = new JFrame("Bingo");
    private JTextArea banner = new JTextArea();
    private JPanel numPanel = new JPanel();
    private JPanel windowPanel = new JPanel();
    private JTextArea[][] numArea = new JTextArea[5][5];
    private JPanel myPanel = new JPanel();
    private JPanel myPanel2 = new JPanel();
    private JPanel bannerPanel = new JPanel();
    private JLayeredPane layeredPane = new JLayeredPane();
    private JTextArea txth1AreaBingo = new JTextArea();
    private JButton btnBingo = new JButton("Draw Number");
    private JButton btnBingoNewGame = new JButton("New Game");
    private BingoCard game = new BingoCard();                      
    private String str2 = "NUMBERS: ";   
    public int filenumber;
    private int noDraws = 0;
    private Random gen2 = new Random(); 
    private int[][] matrix = new int[((BingoCard.BINGO_col) * (BingoCard.max_row))][2];
    private int randomNum;
    public boolean t = true;
    Font font = new Font("Arial Black", Font.BOLD, 16);
    Font redFont = font.deriveFont(Font.BOLD, 16).deriveFont(Collections.singletonMap(TextAttribute.FOREGROUND, Color.RED));
    Font blackFont = font.deriveFont(Font.BOLD, 16).deriveFont(Collections.singletonMap(TextAttribute.FOREGROUND, Color.BLACK));


    BingoGUI() {
        setLayout(null);
        numPanel.setLayout(null);
        windowPanel.setLayout(null);
        setNumberMat();
        window.setBounds(10, 10, 500, 700);
        windowPanel.setBounds(0, 10, 500, 700);
        windowPanel.setBackground(Color.LIGHT_GRAY);
        myPanel.setBounds(280, 150, 150, 100);
        numPanel.setBounds(10,150,260,260);
        numPanel.setBackground(Color.WHITE);
        myPanel.setBackground(Color.WHITE);
        myPanel2.setBounds(280, 250, 150, 100);
        myPanel2.setBackground(Color.WHITE);
        bannerPanel.setVisible(false);
        //Layer
        layeredPane.add(windowPanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(bannerPanel, JLayeredPane.DRAG_LAYER);
        layeredPane.add(numPanel, JLayeredPane.MODAL_LAYER);
        layeredPane.add(banner, JLayeredPane.DRAG_LAYER);
        
        myPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        myPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        window.add(myPanel);
        window.add(myPanel2);
        numPanel.add(bannerPanel);
        window.add(numPanel);
        window.add(windowPanel);
        windowPanel.add(txth1AreaBingo);
        startCard();

        txth1AreaBingo.setBounds(10, 10, 770, 130);
        txth1AreaBingo.setEnabled(false);    
        txth1AreaBingo.setVisible(true);   
        
        txth1AreaBingo.setFont(font);
        btnBingo.setForeground(Color.blue);
        
        myPanel.add(btnBingo);
        myPanel2.add(btnBingoNewGame);
        myPanel.setOpaque(false);
        myPanel2.setOpaque(false);
          
        btnBingo.addActionListener(this);                                       //Lägger till actionlistner to this = BingoGUI
        btnBingoNewGame.addActionListener(this); 
        btnBingoNewGame.setVisible(false);
        window.setSize(800, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        windowPanel.add(txth1AreaBingo); 
        };//End class BingoGUI

        void gotBINGO(int x,int y){
            
            bannerPanel.setBackground(Color.GREEN);
            bannerPanel.add(banner); 
            bannerPanel.setBounds(0 , y, 260, 35);
            banner.setFont(font);
            banner.setBackground(Color.GREEN);
            banner.setFont(blackFont);
            banner.setEnabled(false);
            banner.setText("B   I   N   G   O");
        }
        void startCard(){
          for (int col = 0; col < numArea[0].length; col++)  {
          
            for (int row = 0; row < numArea.length; row++){
            
            numArea[row][col] = new JTextArea();
            numArea[row][col].setBounds(10 + row * 55 , 10 + col * 55, 40, 35);
            layeredPane.add(numArea[row][col], JLayeredPane.DEFAULT_LAYER);
            numPanel.add(numArea[row][col]);
            numArea[row][col].setOpaque(false);
            numArea[row][col].setEnabled(false);
            numArea[row][col].setFont(font);
            numArea[row][col].setFont(blackFont);
            numArea[row][col].setText(Integer.toString(game.displcard[col][row]));
            }
          }
        }

        void resetCard(){
          for (int col = 0; col < numArea[0].length; col++)  {
          
            for (int row = 0; row < numArea.length; row++){
            numArea[row][col].setFont(font);
            numArea[row][col].setBackground(Color.WHITE);
            numArea[row][col].setFont(blackFont);
            numArea[row][col].setText(Integer.toString(game.displcard[col][row]));
            }
          }
        }

         void displayCard(int drawNum){
          for (int col = 0; col < numArea[0].length; col++)  {
          
            for (int row = 0; row < numArea.length; row++){
              layeredPane.add(numArea[row][col], JLayeredPane.DEFAULT_LAYER);
              numPanel.add(numArea[row][col]);
            if(game.displcard[col][row] == drawNum)
            {
              numArea[row][col].setFont(redFont);
              gotBINGO(numArea[row][col].getLocation().x, numArea[row][col].getLocation().y);
            }
            
            numArea[row][col].setText(Integer.toString(game.displcard[col][row]));
            
        }
      }


         }

            public void setNumberMat() {
              for (int col = 0;col < matrix[0].length ; col++) {
                for (int row = 0; row < matrix.length; row++) { 
                  matrix[row][0] = row +1;                            // lägger till + 1 så att matrisens nollte kolumn går från 1-25 istället för 0 - 24
                  matrix[row][1] = 0;
                }
              }
            }
            
            public boolean trueNumber(int j) {
                for (int row = 0; row < matrix.length; row++) {
                  //testa om nummer har använts tidigare dvs matrix[row][1] == 1
                 if((matrix[row][0] == j) && (matrix[row][1] == 1)) {
                      t = false;
                    }
                    //använd nummer första gången och sätt en flagga för nästa gång nummret används
                   else if((matrix[row][0] == j) && (matrix[row][1] == 0)) {
                      matrix[row][1] = 1;  //flagga för att nummer använts en gång
                      t = true; 
                } // End outer loop
            } 
            return t;
          }
          
          


            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {      //Händelsehantering när när knapp för nytt nummer trycks
                 if(e.getSource() == btnBingo)
                    { 
                        if(!game.ifWon())                                   //Kontrollera om det finns en vågrät rad mha Boolean metod ifWon
                        {     
                              btnBingoNewGame.setVisible(false);
                              btnBingo.setText("Draw Number");
                              btnBingo.setForeground(Color.blue);
                              txth1AreaBingo.setFont(font);
                              //Skapa första slumptal mellan 1-25
                              int j = gen2.nextInt(((BingoCard.BINGO_col) * (BingoCard.max_row)) - 1) + 1;                                        
                              // anropa funktion som kontrollerar om slumptal j använts tidigare, TRUE alt. FALSE
                              while(!trueNumber(j)){
                                 //Skapa nytt slumptal mellan 1-25
                                j = gen2.nextInt(((BingoCard.BINGO_col) * (BingoCard.max_row)) - 1) + 1;          
                                }
                                randomNum =  j;
                                
                              //Dela upp slumptalsraden så att den passar i fönstret                           
                                  if((noDraws > 20) && (noDraws < 22) ){
                                    str2 += randomNum + "\n";
                                  }
                                  else if ((noDraws > 40) && (noDraws < 42) ){
                                        str2 += randomNum + "\n";
                                  } 
                                  else                                  {
                                    str2 += randomNum + " ";
                                  }
                                 
                                  txth1AreaBingo.setFont(blackFont);                                
                                  txth1AreaBingo.setText(str2);
                                                               
                                  game.move(randomNum);   //Anropa funktionen move som markerar med X på CARD som ger ett X i str2
                                  noDraws++; //Number of rounds
                                 displayCard(randomNum);
                                  //Testar om vi fått BINGO och utför följande events
                                  if(game.ifWon()){
                                  str2 += "\nBINGO - YOU ARE A WINNER" + "\n" + "You finished the game on ONLY " + noDraws + " draws!\nPress New Game to play again.";
                                  txth1AreaBingo.setFont(redFont);
                                  txth1AreaBingo.setText(str2);
                                  btnBingoNewGame.setForeground(Color.red);
                                  btnBingo.setVisible(false); 
                                  btnBingoNewGame.setVisible(true);
                                  bannerPanel.setVisible(true);
                                 }
                              
                        } 
    
                    }
                    else if(e.getSource() == btnBingoNewGame)
                    {
                       noDraws = 0;
                        str2 ="NUMBERS: "; 
                         //Omstart av spelet
          
                                                 //str2 innehåller alla dragna nummer och återställs till endast strängen NUMBERS 
                                                      //Återställa index för antal dragna nummer 
                        game.reset();                                            //Amrop till en void function i BingoCard som startar om matrisen card[][] med nya nummer utan X
                        setNumberMat();                                          //Amrop till en void function i BingoGUI som startar om matrisen matrix[][] med nya nummer  
                        resetCard();
                        
                        btnBingoNewGame.setVisible(false);
                        btnBingo.setVisible(true);
                        txth1AreaBingo.setFont(blackFont);
                        txth1AreaBingo.setText(str2);
                        bannerPanel.setVisible(false);

                      }
        
            }



}//End class 

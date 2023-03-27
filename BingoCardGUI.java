import java.util.ArrayList;
import java.util.Random;
 
class BingoCard {
    private int [][] card = new int[5][5];
    private Random gen = new Random();

    //Constructor populate bingo card
    public BingoCard() {
        ArrayList <Integer> possValues = new ArrayList<>();
        int start = 1;

        //Iterate the 2d array (up ad down)
        for (int col = 0; col < card[0].length; col++) {
            fillArray(possValues, start);
            for (int row = 0; row < card.length; row++) {
                int position = gen.nextInt(possValues.size());
                card[row][col] = possValues.get(position);
                possValues.remove(position);
            }//Ends inner loop
            start += 25;
        }//Ends outer loop

        //Set free space
        card [2][2] = 0;

    }//Constructor

    //Fills array with all possible values
    private void fillArray(ArrayList<Integer> possValues, int start){
        possValues.clear();
        for (int i = start; i < start + 25; i++) {
            possValues.add(i);
        }
    }//End fillArray

    //Used to display card values
    public String toString(){
        String str = "B\tN\tN\tG\tO\n";

        for (int row = 0; row < card.length; row++) {
            for (int col = 0; col < card[0].length; col++) {
                if (card[row][col] > 0) {
                    str += card[row][col] + "\t";
                } else {
                    str += "X\t";

                }//End else
            }//End innner loop
            str += "\n";
        }//End outer loop

        return str;
    }
  
}//Ends class

 

























/*
 //Replace entered number in the 
    public void move(int num) {
        for (int row = 0; row < card.length; row++) {
            for (int col = 0; col < card[0].length; col++) {
                if (card[row][col] == num) {
                    card[row][col] = 0;
                }//ends if  
            }//ends inner loop
        }//end outer loop
    }//ends move
    
    
    public boolean ifWon() {
        int sumAcross = 0;
        int sumDown = 0;
        int diaRight = 0;
        int diaLeft = 0;

        for(int row = 0; row < card.length; row++) {
            for(int col = 0; col < card[0].length; col++) {
                sumAcross += card[row][col];
                sumDown += card[col][row];
            }//Ends inner loop
            diaRight += card[row][row];
            diaLeft += card [row][4-row];
        //Check to see if those are zero
        if (sumAcross == 0 || sumDown == 0){
            return true;
        }    
        sumAcross = 0;
        sumDown = 0; 
    }//Ends outter loop
    if(diaRight || diaLeft == 0){
        return true; 
    }
}//Ends isWin */











































































/* 
    private JFrame frame;
    private JPanel panel;
    private ArrayList<JLabel> labels;

   public BingoCardGUI() {
        ArrayList<Integer> bingoCard = new ArrayList<>();
        Random rand = new Random();
        for (int i = 1; i <= 75; i++) {
            bingoCard.add(i);
        }
        for (int i = bingoCard.size() - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            int temp = bingoCard.get(index);
            bingoCard.set(index, bingoCard.get(i));
            bingoCard.set(i, temp);
        }
        ArrayList<Integer> result = new ArrayList<>(bingoCard.subList(0, 25));

        frame = new JFrame("Bingo Card");
        panel = new JPanel();
        labels = new ArrayList<>();
        for (Integer num : result) {
            labels.add(new JLabel(String.valueOf(num)));
        }
        panel.setLayout(new GridLayout(5, 5));
        for (JLabel label : labels) {
            panel.add(label);
        }
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

  public static void main(String[] args) {
        new BingoCardGUI();
    }







Random rand = new Random();
int[][] randomNumbers = new int[5][5];  

System.out.println(" _______________________________________ ");
System.out.println("|B\t|I\t|N\t|G\t|O\t|");
System.out.println("|---------------------------------------|");

for(int i = 0; i < randomNumbers.length; i++) {
    for(int j = 0; j <randomNumbers.length; j++) {
        randomNumbers[i][j] = rand.nextInt(75);
        //print array
        System.out.print("|" + randomNumbers[i][j] + "\t");
     }
     if (i == 4){
        System.out.println("|\n|_______|_______|_______|_______|_______|");
     } else {
        System.out.println("|\n|---------------------------------------|");
     }   
 }
*/  


        

     
     
    
 /*Font h1Font = new Font("BadMofo", Font.PLAIN, 28);
        Font BadMofo;

        try {
        BadMofo = Font.createFont(Font.TRUETYPE_FONT, new File("BadMofo.ttf"));
        GrapicsEnviroment ge = Graphi
        }
        catch (IOException | FontFormatException e)
        {*/

           
         
         /*Ikon
         ImageIcon image = new ImageIcon("Java logo image.jpg");
         frame.setIconImage(image.getImage());*/
         
  
    
     
      /*   
      //Instance
        JLabel h1 = new JLabel();
        h1.setText("BINGO");
        h1.setFont(new Font("Arial",Font.PLAIN,20));

        JFrame frame = new JFrame();
        frame.setTitle("Bingo");
        frame.setLayout(null);

        ImageIcon logo = new ImageIcon("logo.jpg");
        frame.setIconImage(logo.getImage());

        Border redBorder = BorderFactory.createLineBorder(Color.red,3);

        JPanel h1Panel = new JPanel();
        //h1Panel.setBackground(Color.red);
        h1Panel.setBorder(redBorder);
        h1Panel.setBounds(250, 250, 450, 250);
        //h1Panel.setBackground(new Color(0,68,129));
        frame.add(h1Panel);

        //Label "h1" (Settings)
        frame.add(h1);
        
       
         //Settings
         frame.getContentPane().setBackground(new Color(0,68,129));
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true); 
         
         //Margins
         frame.setSize(1000,500);
         
          */


         
        
       
      

 
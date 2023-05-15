import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


class BingoCard {
    public static int BINGO_col = 5;                                              //DEBUG: FIXED För BINGO är detta värde alltid 5. Public så att man kan nå denna data från alla funktioner
    public static int max_row = 5;                                                //DEBUG: Anger antalet rader i spelet, ex max_row x BINGO_col = högsta talet i spelet (5 x 5 = 25). Public så att man kan nå denna data från alla funktioner
    public int[][] card = new int[BINGO_col][max_row];                     //Ny 2d array deklareras, storlek 5x5
    public int[][] displcard = new int[BINGO_col][max_row];                     //Ny 2d array deklareras, storlek 5x5

    private Random gen = new Random();                                      //Ny slump variabel deklareras, "gen"
    

    // Constructor populate bingo card
    public BingoCard() {                                                    //Publik metod
        ArrayList<Integer> possValues = new ArrayList<>();                  //En ny arraylista med int deklareras, "possValues"
        int start = 1;                                                      //Int-variabel "start" deklareras till 1

        // Iterate the 2d array (up and down)                               //Vävd for-loop för att skapa kortet uppifrån och ned
        for (int col = 0; col < card[0].length; col++) {                    //Börjar på col=0, col<5, förflytta till col++, dvs gör uppifrån och ned i varje kolumn 
            fillArray(possValues, start);                                   //Fyller kort med den tomma array-listan
            for (int row = 0; row < card.length; row++) {                   //Samma process fast för row, dvs går över alla rader i kortet
                int position = gen.nextInt(possValues.size());              // Slumpar positions index i possValues Motsvarighet till shuffel
                                                                           //Markerar positionen för varje  ruta. Därefter används nextInt för att hämta en slumpvariabel,        
                 
                card[row][col] = possValues.get(position);                  //dvs "gen" till varje ruta som sedan lagras i array-listan "possvalues".
                displcard[row][col] = card[row][col];
                possValues.remove(position);                                // Tar sedan kortets gränser/storlek och lagrar det för "possvalues" positions-variabel
            } // Ends inner loop                                            //Positionen tas bort från possValues-listan för att undvika att samma värde placeras på flera positioner i samma kolumn och därmed upprepas på kortet.
            start += max_row;
        } // Ends outer loop

        // Set free space
        //card[2][2] = 0;                                                   //DEBUG Tror denna rad skall bort

    }// Constructor

    // Fills array with all possible values
    private void fillArray(ArrayList<Integer> possValues, int start) {
        possValues.clear();
        for (int i = start; i <= (start + max_row - 1); i++) {              // DEBUG: ändrar från 24 till max_row som är 5 vilket säkerställer att kolumnen endast innehåller tillåtna värden B:1-5, I:6-10;N:11-15, G:16-20, O:21-25
            if (i <= start + max_row - 1) {
                possValues.add(i);
                
            }
        }
    }// End fillArray


   
 //Denna funktion tar emot de dragna talen i num och letar upp talet i card och ersätter med en nolla för det dragna talet
 public void move(int num) {
    //System.out.println("test");
    for (int row = 0; row < card.length; row++) {
        for (int col = 0; col < card[0].length; col++) {
            if (card[row][col] == num) {
                card[row][col] = 0;
                 
            }//ends if
        }//ends inner loop
     }//end outer loop

  }//ends move

 // if won letar efter en vågrät rad som innehåller endast nollor dvs om sumacross = noll så har vi en vågrät rad med nollor dvs BINGO. OBS här skunde man ha haft en funktion som testar med X men då måste man kolla att det är 5 st X
  public boolean ifWon() {
    int sumAcross = 0;
    boolean win = false;
    for(int row = 0; row < card.length; row++) 
    {
      for(int col = 0; col < card[0].length; col++) 
        {
          sumAcross += card[row][col];
        }
      if (sumAcross == 0) 
        {   
        win = true; 
        break;                                                                 //DEBUG: Letar endast vågräta rader med 0:or
        }
        else 
        {
            win = false;
        }//Ends inner loop   
      sumAcross = 0;
    }//Ends outter loop
    //Check to see if those are zero
    // if (sumAcross == 0 || sumDown == 0){                                    //DEBUG: Letar vågräta eller rader med 0:or
   
    return win;
  }//Ends ifWon


// Denna funktion ser till att ta bort nollorna i card och ersätta med nya nummer dvs ett nytt spel startar
    public void reset () {
        ArrayList<Integer> possValues2 = new ArrayList<>();                  //En ny arraylista med int deklareras, "possValues"
        
        int start = 1;                                                      //Int-variabel "start" deklareras till 1

        // Iterate the 2d array (up and down)                               //Vävd for-loop för att skapa kortet uppifrån och ned
        for (int col = 0; col < card[0].length; col++) {                    //Börjar på col=0, col<5, förflytta till col++, dvs gör uppifrån och ned i varje kolumn 
            fillArray(possValues2, start);                                   //Fyller kort med den tomma array-listan
            for (int row = 0; row < card.length; row++) {                   //Samma process fast för row, dvs går över alla rader i kortet
                int position = gen.nextInt(possValues2.size());              // Slumpar positions index i possValues Motsvarighet till shuffel
                                                                           //Markerar positionen för varje  ruta. Därefter används nextInt för att hämta en slumpvariabel,        
                 
                card[row][col] = possValues2.get(position);                  //dvs "gen" till varje ruta som sedan lagras i array-listan "possvalues".
                displcard[row][col] = card[row][col];
                possValues2.remove(position);                                // Tar sedan kortets gränser/storlek och lagrar det för "possvalues" positions-variabel
            } // Ends inner loop                                            //Positionen tas bort från possValues-listan för att undvika att samma värde placeras på flera positioner i samma kolumn och därmed upprepas på kortet.
            start += max_row;
        } // Ends outer loop
    }


 
}// Ends class



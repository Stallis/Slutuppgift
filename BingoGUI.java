import java.awt.event.ActionListener;

import javax.swing.*;
//import java.awt.*;


class BingoGUI extends JPanel {
    private JFrame window = new JFrame("Bingo");
    private JTextArea txtAreaBingo = new JTextArea();
    private JTextArea txth1AreaBingo = new JTextArea();
    private JLabel lblEnter = new JLabel("Bingo Number: "); //Utöka till slump mässiga tal som skickas ut
    private JLabel lblNrGen = new JLabel("Gen:");//////
    private JTextField txtNumber = new JTextField ("");
    private JButton btnBingo = new JButton("Enter");
    private BingoCard game = new BingoCard();

    BingoGUI() {
        setLayout(null);

        txtAreaBingo.setBounds(10, 130, 450, 500);
        txth1AreaBingo.setBounds(10, 10, 450, 190);
        lblNrGen.setBounds(10, 70, 100, 30);
        lblEnter.setBounds(10, 240, 100, 30);
        txtNumber.setBounds(120, 240, 100, 30);
        btnBingo.setBounds(230, 240, 100, 30);
        txtAreaBingo.setEnabled(false); //Vad gör denna?
        txth1AreaBingo.setEnabled(false); //Vad gör denna?

       // txth1AreaBingo.setBounds(10, 90, 450, 500);
        add(lblEnter);
        add(lblNrGen);
        add(txtNumber);
        add(btnBingo);
        add(txtAreaBingo);
        add(txth1AreaBingo);
        window.add(this);    

        txtAreaBingo.setText(game.toString());
        //txth1AreaBingo.setText(game.toString());

        /*
         *  // Använd Collections.shuffle() för att blanda ordningen på talen i arrayen
        Collections.shuffle(Arrays.asList(possValues));

        // Skriv ut de slumpmässigt ordnade talen
        for (int i = 0; i < possValues.length; i++) {
            System.out.println(possValues[i]);
        }
         */





        window.setSize(450, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        
            
        };
        
    }








/*btnBingo.addActionListener((ActionListener) new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(txtNumber.getText());
                game.move(num);
                txtAreaBingo.setText(game.toString());

            }

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // TODO Auto-generated method stub
                
            }

             */
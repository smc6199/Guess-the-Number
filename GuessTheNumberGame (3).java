/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessthenumbergame;

/**
 *
 * @author schan_000
 */

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.util.Random;
import java.awt.FlowLayout;
public class GuessTheNumberGame extends JFrame {
    
    private final JTextField userInput;
    private final JLabel guessLabel;
    private final JButton playAgain;
    private int randomNumber;
    private final JLabel range;
    
    
    
    public GuessTheNumberGame(){
        
        super();
        setLayout(new FlowLayout());
        userInput = new JTextField(5);
        add(userInput);
        guessLabel = new JLabel("I have a number between 1 and 1000. Can you guess my number?\nPlease enter your first guess.");
        add(guessLabel);
        playAgain = new JButton("Play Again");
        add(playAgain);
        range = new JLabel();
        add(range);
        Random rand = new Random();
        randomNumber = rand.nextInt(1000) + 1;
        userInput.addActionListener(new TextHandler());
        playAgain.addActionListener(new ButtonHandler());
        
        
        
        }
    private class TextHandler implements ActionListener{
        private int lastGuess  = 0;
        @Override
        public void actionPerformed(ActionEvent event){
            String numGuess_string = userInput.getText();
            int numGuess_int = Integer.parseInt(numGuess_string);
            if (numGuess_int > randomNumber){
                range.setText("Too high");
            }
            else if(numGuess_int < randomNumber){
                range.setText("Too low");
            }
            else{
                range.setText("Correct");
                userInput.setEditable(false);
            }
            
            if(lastGuess == 0 || Math.abs(randomNumber - numGuess_int) == lastGuess){
                getContentPane().setBackground(null);
            }
            else if (Math.abs(randomNumber - numGuess_int) > lastGuess){
                getContentPane().setBackground(Color.BLUE);
            }
            else{
                getContentPane().setBackground(Color.RED);
            }
            lastGuess = Math.abs(randomNumber - numGuess_int);
            
        }
    }
     private class ButtonHandler implements ActionListener{
     
         public void actionPerformed(ActionEvent event){
         
             Random rand = new Random();
             randomNumber = rand.nextInt(1000) + 1;
             userInput.setEditable(true);
             getContentPane().setBackground(null);
             range.setText(null);
             userInput.setText(null);
         }
     
     }
    
    
    
    
            

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            GuessTheNumberGame guessTheNumberGame = new GuessTheNumberGame();
            guessTheNumberGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            guessTheNumberGame.setSize(350,150);
            guessTheNumberGame.setVisible(true);




        // TODO code application logic here
    }
}
    


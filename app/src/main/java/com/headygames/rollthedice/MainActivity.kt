package com.headygames.rollthedice

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/*
 * This activity allows the user to roll the dice and view
 * the result of the dice being rolled on the screen
*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set the button to the button view
        val rollButton: Button = findViewById(R.id.btnRollDice)

        // set the onClickListener for the rollButton
        rollButton.setOnClickListener { rollDice() }
    }

    /* Method that will create the dice, call for the roll of the dice, and then set the text
     * of the textview tvDiceRolledValue to String that represents the numerical value of the
     * dice roll
    */

    private fun rollDice() {
        /*
         * Create a Dice object and set the sides to 6, then call the roll dice method from the
         * Dice Class
         */
        val dice = Dice(6)
        val diceRoll = dice.roll()

        /*
         * finds the tbRolledValue textview and updates the text with the
         * value of the rolled dice
        */
        val resultDiceRoll: TextView = findViewById(R.id.tvRolledValue)
        resultDiceRoll.text = diceRoll.toString()
    }
}

/*
 * This is the Dice class. It takes an val of Int type that represents the number
 * of sides on the dice. The class has a function that rolls the dice, setting a
 * random number between 1 and the number of sides (inclusive) and returns that number
 * as an Int
*/
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
package com.example.pizzapartyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.RadioGroup
import kotlin.math.ceil

// constant value holds number of slices per Pizza.
const val SLICES_PER_PIZZA = 8



/**
 * Main Activity of the program
 *
 * This class will host all of the actions/behaviours of the program.
 *
 * @author Josue B Navarrete
 */
class MainActivity : AppCompatActivity() {
    //Declaration of variables
    private lateinit var numAttendEditText: EditText
    private lateinit var numPizzasTextView: TextView
    private lateinit var howHungryRadioGroup: RadioGroup
    /**
     * Overrides onCreate
     *
     * This function will perform at start of app, ex. Initialization
     *
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numAttendEditText = findViewById(R.id.num_attend_edit_text)
        numPizzasTextView = findViewById(R.id.num_pizzas_text_view)
        howHungryRadioGroup = findViewById(R.id.hungry_radio_group)

    }

    /**
     * calculateClick
     *
     * once button is clicked this function will calculate the appropriate
     * number of pizzas provided the proper components to make such calculation.
     *
     * @param view
     *
     */
    fun calculateClick(view: View) {
        val numAttendStr = numAttendEditText.text.toString()
        val numAttend = numAttendStr.toInt()

        // Determine how many slices on average each person will eat given the input
        val slicesPerPerson = when (howHungryRadioGroup.checkedRadioButtonId) {
            R.id.lightButton -> 2
            R.id.mediumButton -> 3
            else -> 4
        }

        // Determine the total amount of pizza's required given the input
        val totalPizzas = ceil(
            numAttend * slicesPerPerson /
                    SLICES_PER_PIZZA.toDouble()
        ).toInt()

        // set text to calculated number of pizzas
        numPizzasTextView.text = "$totalPizzas"
    }
}
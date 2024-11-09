package com.example.adice

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var numText: TextView
    private lateinit var rollDiceButton: Button
    private lateinit var setSidesButton: Button
    private lateinit var diceSidesText: EditText
    private var diceSides = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize references.
        this.numText = findViewById(R.id.tv_num)
        this.rollDiceButton = findViewById(R.id.btn_roll)
        this.diceSidesText = findViewById(R.id.et_dice_size)
        this.setSidesButton = findViewById(R.id.btn_update)

        // Add click listener to the roll dice button.
        this.rollDiceButton.setOnClickListener {
            this.numText.text = String.format(this.rollDice(this.diceSides).toString())
        }

        this.setSidesButton.setOnClickListener {
            val sides = this.diceSidesText.text.toString().toIntOrNull()
            if (sides != null && sides > 1) {
                this.diceSides = sides
            }
        }
    }

    /**
     * Roll the dice and return the result.
     */
    private fun rollDice(numberOfSides: Int = this.diceSides): Int = Random.nextInt(1, numberOfSides)
}
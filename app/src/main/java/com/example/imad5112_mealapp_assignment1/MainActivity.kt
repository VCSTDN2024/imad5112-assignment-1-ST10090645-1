/*Reference List for .kt file:


*/

package com.example.imad5112_mealapp_assignment1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    // Establishing various private variables to be used within our private functions.
    private var timeEntry: EditText? = null
    private var foodTextPrompt: TextView? = null
    private var foodImageOne: ImageView? = null
    private var faeChatBox: TextView? = null
    private var foodHeaderTextPrompt: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Referencing my private variables by their IDs.
        timeEntry = findViewById(R.id.etTimeEntry)
        foodTextPrompt = findViewById(R.id.tvFood)
        faeChatBox = findViewById(R.id.tvFaeChat)
        foodImageOne = findViewById(R.id.ivFoodOne)
        foodHeaderTextPrompt = findViewById(R.id.tvFoodHeader)

        // Referencing my buttons by their IDs.
        val btnEat = findViewById<Button>(R.id.buttonFeedMe)
        val btnReset = findViewById<Button>(R.id.buttonReset)
        val btnCloseApp = findViewById<Button>(R.id.buttonCloseApp)

        //Adding functionality to my buttons.

        btnReset.setOnClickListener { //Allowing the "Reset" button to clear information from most TextViews and guiding the user on what to do next.
            timeEntry?.text?.clear()
            foodTextPrompt?.text = ""
            foodHeaderTextPrompt?.text = ""
            faeChatBox?.text = "Changed your mind? Need another suggestion? Either way, type in the time of day below, hit the button and I'll help you out!"
            foodImageOne?.setImageDrawable(null)
        }

        btnCloseApp.setOnClickListener { //Allowing the "Close App" button to actually exit the application.
            finishAffinity()
            exitProcess(0)
        }

        btnEat.setOnClickListener { //Adding functionality to my private function.
            TellThemWhatToEat()
        }

    }

    private fun isNotEmpty(): Boolean { //Error handling to inform the user that they need to input text when the text box is empty.
        var b = true
        if (timeEntry?.text.toString().trim().isEmpty()) {
            foodTextPrompt?.text = ""
            foodHeaderTextPrompt?.text = ""
            timeEntry?.error = "Type the time of day!"
            faeChatBox?.text = "I can't read minds, you know! Please type \"Morning\", \"Mid-morning\", \"Afternoon\", \"Mid-afternoon\", \"Dinner\" or \"After Dinner\" in the text box below, then click the button underneath it to get started!"
            foodImageOne?.setImageDrawable(null)
            b = false
        }
        return b
    }

    private fun TellThemWhatToEat() { //Allowing users to receive an output on what to eat based on the time of day input using the If statement. Also acknowledges when the use inputs an invalid string.
        if (isNotEmpty()) {
            when (timeEntry?.text.toString().trim()) {

                "Morning", "morning" -> {
                    foodTextPrompt?.text = "Eggs"
                    foodHeaderTextPrompt?.text = "You should consider eating some..."
                    faeChatBox?.text = "Just woke up? Preparing to head to work or school? Can't go wrong with some eggs! Incredibly versatile and a great source of protein that'll keep you going for a while!"
                    foodImageOne?.setImageResource(R.drawable.eggs)
                }

                "Mid-morning", "mid-morning" -> {
                    foodTextPrompt?.text = "Yoghurt"
                    foodHeaderTextPrompt?.text = "You should consider eating some..."
                    faeChatBox?.text = "If you're feeling a little peckish, then I'd suggest some yoghurt! Picking the right yoghurt will keep you satisfied while providing plenty of calcium. Oh, and don't be afraid to spice it up by adding some of your favorite fruits!"
                    foodImageOne?.setImageResource(R.drawable.yoghurt2)
                }

                "Afternoon", "afternoon" -> {
                    foodTextPrompt?.text = "Pasta Salad"
                    foodHeaderTextPrompt?.text = "You should consider eating some..."
                    faeChatBox?.text = "Whether you've just come back from a grueling day or need some extra fuel to carry on, a hearty pasta salad is sure to give you everything you need. A very balanced meal that can use any of your favorite meats. Yum!"
                    foodImageOne?.setImageResource(R.drawable.pastasalad)
                }

                "Mid-afternoon", "mid-afternoon" -> {
                    foodTextPrompt?.text = "Popcorn"
                    foodHeaderTextPrompt?.text = "You should consider eating some..."
                    faeChatBox?.text = "A bowl or bag of popcorn will work wonders for keeping you satisfied until dinner! With a shockingly low calorie count and generous fiber intake, this is the perfect snack! Just be sure to stay clear of adding extra butter, yeah?"
                    foodImageOne?.setImageResource(R.drawable.popcorn)
                }

                "Dinner", "dinner" -> {
                    foodTextPrompt?.text = "Steak"
                    foodHeaderTextPrompt?.text = "You should consider eating some..."
                    faeChatBox?.text = "It's the classic choice for a reason! A well cooked steak is loaded with protein, iron and other vitamins essential for healthy growth. Add some veggies and starch of your choosing and reward yourself with a filling meal after a long day!"
                    foodImageOne?.setImageResource(R.drawable.steak)
                }

                "After Dinner", "after dinner", "After dinner" -> {
                    foodTextPrompt?.text = "Ice Cream"
                    foodHeaderTextPrompt?.text = "You should consider eating some..."
                    faeChatBox?.text = "Every once in a while, you should treat yourself, and what better way to do so than eating some delicious ice cream? To be honest, the bad usually outweighs the good in terms of health benefits... but we'll just keep that a secret between us, yes?"
                    foodImageOne?.setImageResource(R.drawable.icecream)
                }

                else -> {
                    foodTextPrompt?.text =""
                    foodHeaderTextPrompt?.text = ""
                    faeChatBox?.text = "Sorry... I didn't quite catch that. Make sure you spell correctly and type \"Morning\", \"Mid-morning\", \"Afternoon\", \"Mid-afternoon\", \"Dinner\" or \"After Dinner\" in the text box below."
                    foodImageOne?.setImageDrawable(null)

                }




            }

        }
    }
}
package org.ieselcaminas.josemaria.aboutme

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.ieselcaminas.josemaria.aboutme.ActivityMainBinding
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding4

    private val myName: MyName = MyName("Jose Maria")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName
        //se me olvido el primer push y compartir cuando ya tenia el layout file
        /*findViewById<Button>(R.id.done_button).setOnClickListener{
            addNickname(it)
        }*/
        binding.doneButton.setClickListener{
            addNickname(it)
        }
    }

    private fun addNickname(view: View){
        binding.apply{

            //binding.nicknameText.text = binding.nicknameEdit.text
            myName?.nickname = nicknameEdit.toString()
            invalidateAll()
            binding.nicknameEdit.visibility = View.GONE
            binding.doneButton.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
        }

        //hide the keyboard
        val inm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
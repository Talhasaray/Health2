package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.runBlocking

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)

        val eTPrompt= findViewById<EditText>(R.id.eTPrompt)
        val btnSubmit= findViewById<Button>(R.id.btnSubmit)
        val tVResult= findViewById<TextView>(R.id.tVResult)

        btnSubmit.setOnClickListener {
            val prompt= eTPrompt.text.toString()

            val generativeModel = GenerativeModel (
                // For text-only input, use the gemini-pro model
                modelName = "gemini-2.5-flash",
                apiKey = "AIzaSyBljVCri8_ZgtEh9Cyea6V66PCBqDY3f_k"
                // ENTER YOUR KEY
            )
            runBlocking {
                val response = generativeModel.generateContent(prompt)
                tVResult.text= response.text
            }
        }
    }
}
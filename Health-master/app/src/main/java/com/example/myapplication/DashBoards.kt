package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DashBoards : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dash_boards)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val i =findViewById<Button>(R.id.doktorr)
        i.setOnClickListener {
            val intent = Intent(this,Doktorprof::class.java)
            startActivity(intent)

        }




        val acill =findViewById<Button>(R.id.acil)
        acill.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)

        }



        val saglikk =findViewById<Button>(R.id.randevua)
        saglikk.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)

        }


        val kan =findViewById<Button>(R.id.kan)
        kan.setOnClickListener {
            val intent = Intent(this, KanOrganBagis::class.java)
            startActivity(intent)

        }


        val apiil =findViewById<Button>(R.id.öneri)
        apiil.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)

        }


















    }
}
package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityEklemeSayfasi2Binding
import com.example.myapplication.databinding.ActivityEklemeSayfasi3Binding

class EklemeSayfasi3 : AppCompatActivity() {
    private lateinit var binding: ActivityEklemeSayfasi3Binding
    private lateinit var db: NoteDataBaseHelper3
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        binding= ActivityEklemeSayfasi3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        db = NoteDataBaseHelper3(this)
        binding.saveButton3.setOnClickListener{
            val title =binding.titleEditText3.text.toString()
            val content=binding.contenEditText3.text.toString()
            val note=Note(0,title,content)
            db.insertNote(note)
            finish()
            Toast.makeText(this,"Hedef Eklendi",Toast.LENGTH_SHORT).show()


        }
    }
}
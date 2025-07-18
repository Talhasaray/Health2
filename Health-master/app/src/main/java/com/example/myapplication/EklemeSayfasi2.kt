package com.example.myapplication
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityEklemeSayfasi2Binding
import com.example.myapplication.databinding.ActivityEklemeSayfasiBinding

class EklemeSayfasi2 : AppCompatActivity() {

    private lateinit var binding: ActivityEklemeSayfasi2Binding
    private lateinit var db: NoteDataBaseHelper2
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        binding= ActivityEklemeSayfasi2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        db = NoteDataBaseHelper2(this)
        binding.saveButton2.setOnClickListener{
            val title =binding.titleEditText2.text.toString()
            val content=binding.contenEditText2.text.toString()
            val note=Note(0,title,content)
            db.insertNote(note)
            finish()
            Toast.makeText(this,"Notunuz Eklendi",Toast.LENGTH_SHORT).show()


        }
    }
}
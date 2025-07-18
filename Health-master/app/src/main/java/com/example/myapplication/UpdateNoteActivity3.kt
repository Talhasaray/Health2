package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityUpdateNote2Binding
import com.example.myapplication.databinding.ActivityUpdateNote3Binding

class UpdateNoteActivity3 : AppCompatActivity() {

    private lateinit var binding : ActivityUpdateNote3Binding
    private lateinit var db: NoteDataBaseHelper3
    private var noteId:Int =-1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUpdateNote3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        db= NoteDataBaseHelper3(this)

        noteId=intent.getIntExtra("note_id",-1)

        if(noteId==-1) {
            finish()
            return
        }


        val note=db.getNoteById(noteId)
        binding.updateTitleEditText3.setText(note.title)
        binding.updateContentEditText3.setText(note.content)

        binding.updateSaveButton3.setOnClickListener{
            val newTitle=binding.updateTitleEditText3.text.toString()
            val newContent=binding.updateContentEditText3.text.toString()
            val updateNote=Note(noteId,newTitle,newContent)

            db.updateNote(updateNote)
            finish()
            Toast.makeText(this,"Sağlık Hedefi Güncellendi.",Toast.LENGTH_SHORT).show()
        }








    }
}
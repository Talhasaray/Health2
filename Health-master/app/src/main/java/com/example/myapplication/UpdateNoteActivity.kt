package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityUpdateNoteBinding

class UpdateNoteActivity : AppCompatActivity() {


    private lateinit var binding :ActivityUpdateNoteBinding
    private lateinit var db:NoteDataBaseHelper
    private var noteId:Int =-1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityUpdateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db= NoteDataBaseHelper(this)

        noteId=intent.getIntExtra("note_id",-1)

        if(noteId==-1) {
            finish()
            return
        }


        val note=db.getNoteById(noteId)
        binding.updateTitleEditText.setText(note.title)
        binding.updateContentEditText.setText(note.content)

        binding.updateSaveButton.setOnClickListener{
            val newTitle=binding.updateTitleEditText.text.toString()
            val newContent=binding.updateContentEditText.text.toString()
            val updateNote=Note(noteId,newTitle,newContent)

            db.updateNote(updateNote)
            finish()
            Toast.makeText(this,"Yorumunuz Güncellendi.",Toast.LENGTH_SHORT).show()
        }








    }
}
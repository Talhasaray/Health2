package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityUpdateNote2Binding
import com.example.myapplication.databinding.ActivityUpdateNoteBinding

class UpdateNoteActivity2 : AppCompatActivity() {


    private lateinit var binding : ActivityUpdateNote2Binding
    private lateinit var db: NoteDataBaseHelper2
    private var noteId:Int =-1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUpdateNote2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        db= NoteDataBaseHelper2(this)

        noteId=intent.getIntExtra("note_id",-1)

        if(noteId==-1) {
            finish()
            return
        }


        val note=db.getNoteById(noteId)
        binding.updateTitleEditText2.setText(note.title)
        binding.updateContentEditText2.setText(note.content)

        binding.updateSaveButton2.setOnClickListener{
            val newTitle=binding.updateTitleEditText2.text.toString()
            val newContent=binding.updateContentEditText2.text.toString()
            val updateNote=Note(noteId,newTitle,newContent)

            db.updateNote(updateNote)
            finish()
            Toast.makeText(this,"Acil Durum Notu Güncellendi.",Toast.LENGTH_SHORT).show()
        }








    }
}
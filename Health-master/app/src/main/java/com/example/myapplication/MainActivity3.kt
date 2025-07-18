package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.databinding.ActivityMain3Binding
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    private lateinit var db: NoteDataBaseHelper3
    private lateinit var notesAdapter: NoteAdapter3
    lateinit var homeFAB: ExtendedFloatingActionButton




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        db= NoteDataBaseHelper3(this)
        notesAdapter= NoteAdapter3(db.getAllNotes(),this)


        binding.notesRecyclerView3.layoutManager= LinearLayoutManager(this)
        binding.notesRecyclerView3.adapter=notesAdapter

        binding.addButton3.setOnClickListener{
            val intent =Intent (this, EklemeSayfasi3::class.java)
            startActivity(intent)
        }


    }
    override fun onResume(){
        super.onResume()
        notesAdapter.refreshData(db.getAllNotes())




    }

}
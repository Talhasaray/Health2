package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity2: AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var db: NoteDataBaseHelper2
    private lateinit var notesAdapter: NoteAdapter2
    lateinit var homeFAB: ExtendedFloatingActionButton




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        db= NoteDataBaseHelper2(this)
        notesAdapter= NoteAdapter2(db.getAllNotes(),this)


        binding.notesRecyclerView2.layoutManager= LinearLayoutManager(this)
        binding.notesRecyclerView2.adapter=notesAdapter

        binding.addButton2.setOnClickListener{
            val intent =Intent (this, EklemeSayfasi2::class.java)
            startActivity(intent)
        }


    }
    override fun onResume(){
        super.onResume()
        notesAdapter.refreshData(db.getAllNotes())




    }

}
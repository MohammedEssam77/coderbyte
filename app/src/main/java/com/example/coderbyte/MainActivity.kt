package com.example.coderbyte

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.coderbyte.adapter.NoteAdapter
import com.example.coderbyte.model.NoteModel
import java.util.*

private val noteModels: List<NoteModel> = ArrayList<NoteModel>()
private var mNoteAdapter: NoteAdapter? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        mNoteAdapter = NoteAdapter(this, noteModels)
        recyclerView.setAdapter(mNoteAdapter)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
        when (item.itemId) {

            R.id.AddNote -> {

                mNoteAdapter!!.setNoteModels(noteModels)
            }


        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                val s = data!!.extras!!.getString("Name")
                val n = data!!.extras!!.getString("number")
                val noteModel = NoteModel()
                noteModel.setName(s)
                noteModel.setNumber(n)
                noteModels.add(noteModel)
                mNoteAdapter!!.setNoteModels(noteModels)
            }
            if (resultCode == RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}
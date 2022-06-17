package com.example.coderbyte.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.TextView
import com.example.coderbyte.R
import com.example.coderbyte.model.NoteModel

class NoteAdapter( noteModels: List<NoteModel>) : RecyclerView.Adapter<NoteAdapter.MyViewHolder?>() {
    private var noteModels: List<NoteModel>
    fun setNoteModels(noteModels: List<NoteModel>) {
        this.noteModels = noteModels
        notifyDataSetChanged()
    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_item, parent, false)
        return MyViewHolder(itemView)
    }

    fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val noteModel: NoteModel = noteModels[position]
        holder.name.setText(noteModel.getName())
        holder.number.setText(noteModel.getNumber())
    }

    fun getItemCount(): Int {
        return noteModels.field
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView
        var number: TextView

        init {
            name = view.findViewById(R.id.name)
            number = view.findViewById(R.id.number)
            itemView.setOnClickListener(View.OnClickListener {
                val s = name.text.toString()
                val n = number.text.toString()

            })
        }
    }


    init {
        this.noteModels = noteModels
    }
}
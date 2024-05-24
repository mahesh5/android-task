package com.touchsurgery.thesurgeonstodolist.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import com.touchsurgery.thesurgeonstodolist.utils.Item
import com.touchsurgery.thesurgeonstodolist.R

class AddItemFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val submitButton = view.findViewById<Button>(R.id.submitTodo)
        val todoText = view.findViewById<TextView>(R.id.todoText)
        val seekBar = view.findViewById<SeekBar>(R.id.seekBar)
        val priorityValue = view.findViewById<TextView>(R.id.priorityValue)

        submitButton.setOnClickListener {
            if (view.findViewById<TextView>(R.id.todoText).text.isEmpty()) {
                return@setOnClickListener
            } else {
                val item = Item(seekBar.progress, todoText.text.toString())
                (activity as MainActivity).presenter.addItem(item)
            }
        }
        view.findViewById<SeekBar>(R.id.seekBar).setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                priorityValue.text = i.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
        seekBar.progress = 0
        (activity as MainActivity).fab.hide()
    }
}
package com.example.todo_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.navigation.findNavController
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class NewItem : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ImageButton>(R.id.back_button).setOnClickListener {

            it.findNavController().navigate(R.id.action_newItem_to_itemsList)
        }

        view.findViewById<Button>(R.id.submit_button).setOnClickListener {
            val new_title = view.findViewById<EditText>(R.id.item_title)
            val date_formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            val time_formatter = DateTimeFormatter.ofPattern("HH:mm")
            com.example.todo_list.customAdapter.AddNewItem(ItemInfo(new_title.text.toString(), LocalDate.now().format(date_formatter).toString(), LocalDateTime.now().format(time_formatter).toString()))
            it.findNavController().navigate(R.id.action_newItem_to_itemsList)
        }
    }
}
package com.example.todo_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_list.databinding.FragmentItemsListBinding

data class ItemInfo(var title: String, var date: String, var time: String)
private var dataset = mutableListOf(
    ItemInfo(
        "Wash the dishes", "11.02.2023", "18:03"
    ),
    ItemInfo(
        "Clone this repo", "03.10.2023", "00:07"
    ),
    ItemInfo(
        "cd to the folder", "27.12.2023", "10:00"
    ),
    ItemInfo(
        "npm install", "28.02.2024", "12:30"
    ),
    ItemInfo(
        "npm run dev", "01.03.2024", "09:15"
    )
)
var customAdapter = CustomAdapter(dataset)

class ItemsList : Fragment() {
    private lateinit var binding: FragmentItemsListBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_items_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.adapter = customAdapter
        recyclerView = view.findViewById(R.id.todo_list_viewer)
        recyclerView.adapter = customAdapter

        view.findViewById<Button>(R.id.add_button).setOnClickListener {
            it.findNavController().navigate(R.id.action_itemsList_to_newItem)
        }
    }
}
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

data class ItemInfo(var title: String)
private var dataset = mutableListOf(
    ItemInfo(
        "Wash the dishes"
    ),
    ItemInfo(
        "Clone this repo"
    ),
    ItemInfo(
        "cd to the folder"
    ),
    ItemInfo(
        "npm install"
    ),
    ItemInfo(
        "npm run dev"
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
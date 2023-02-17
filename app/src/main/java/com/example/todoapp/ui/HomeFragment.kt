package com.example.todoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.todoapp.databinding.FragmentHomeBinding
import com.example.todoapp.MainActivity
import com.example.todoapp.adapter.TODOAPPAdapter
import com.example.todoapp.data.model.TodoappItem

class HomeFragment : Fragment(){
    private lateinit var binding: FragmentHomeBinding
    private  lateinit var todoappList: MutableList<TodoappItem>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val main = activity as MainActivity
        todoappList = main.todos

        val deleteTodo = { position: TodoappItem ->
            //phonebookList.remove(position)
            deleteItem(position)
        }


        val phonebookAdapter = TODOAPPAdapter(todoappList, deleteTodo)
        binding.homeTodoappRecycler.adapter = phonebookAdapter

        binding.homeAddButton.setOnClickListener {
            addPhonebookItem(phonebookAdapter)
        }
        // Logo in Actionbar
/*        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setLogo(R.drawable.ic_launcher_background)
        supportActionBar?.setDisplayUseLogoEnabled(true)*/
    }

    //Number delete
/*    private fun deleteNumberItem(adapter: PhonebookAdapter, item: PhonebookItem) {
        val position = phonebookList.indexOf(item)
        phonebookList.remove(item)
        adapter.notifyItemRemoved(position)
    }*/

    //Number delete
    fun deleteItem(position: TodoappItem){
        todoappList.remove(position)
    }

    private fun addPhonebookItem(adapter: TODOAPPAdapter) {
        val name = binding.homeTodoEdit.text.toString()

        if (!name.isNullOrEmpty()){
            val newNumber = TodoappItem(name)
            todoappList.add(newNumber)
            adapter.notifyItemInserted(todoappList.lastIndex)

        }

    }
}
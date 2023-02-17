package com.example.todoapp.data

import com.example.todoapp.data.model.TodoappItem

class Datasource {

    fun getTodoList(): MutableList<TodoappItem> {
        return mutableListOf(
            TodoappItem("Erster Schritt: Tue das..."),
            TodoappItem("Zweiter Schritt: Tue das..."),
            TodoappItem("Dritter Schritt: Tue das...")
        )
    }
}
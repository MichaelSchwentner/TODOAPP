package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.todoapp.databinding.ActivityMainBinding

import com.example.todoapp.data.Datasource

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var todos = Datasource().getTodoList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    }
}
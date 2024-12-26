package com.example.databaseapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    // cписок проектов (используется как база данных)
    private val projectList = mutableListOf(
        Project(1, "Проект 1", "Описание проекта 1"),
        Project(2, "Проект 2", "Описание проекта 2"),
        Project(3, "Проект 3", "Описание проекта 3")
    )

    private lateinit var adapter: ProjectAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = ProjectAdapter(projectList) { project ->
            removeProject(project)
        }
        recyclerView.adapter = adapter

        val fab: FloatingActionButton = findViewById(R.id.fabAddProject)
        fab.setOnClickListener {
            val newProject = Project(projectList.size + 1, "Проект ${projectList.size + 1}", "Описание нового проекта")
            addProject(newProject)
        }
    }

    private fun addProject(newProject: Project) {
        projectList.add(newProject)
        adapter.notifyItemInserted(projectList.size - 1)
    }

    private fun removeProject(project: Project) {
        projectList.remove(project)
        adapter.notifyDataSetChanged()  // Обновляем список
    }
}

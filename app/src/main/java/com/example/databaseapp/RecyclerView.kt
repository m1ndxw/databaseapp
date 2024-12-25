package com.example.databaseapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProjectAdapter(
    private val projectList: List<Project>,
    private val onItemClick: (Project) -> Unit
) : RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.project_item, parent, false)
        return ProjectViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        val project = projectList[position]
        holder.bind(project)
    }

    override fun getItemCount(): Int = projectList.size

    inner class ProjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val projectNameTextView: TextView = itemView.findViewById(R.id.projectName)
        private val projectDescriptionTextView: TextView = itemView.findViewById(R.id.projectDescription)

        init {
            itemView.setOnClickListener {
                val project = projectList[adapterPosition]
                onItemClick(project)
            }
        }

        fun bind(project: Project) {
            projectNameTextView.text = project.name
            projectDescriptionTextView.text = project.description
        }
    }
}

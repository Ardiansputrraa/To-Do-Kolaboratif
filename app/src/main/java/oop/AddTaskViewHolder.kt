package oop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectakhir.databinding.ItemAddTaskBinding

class AddTaskViewHolder(private val binding: ItemAddTaskBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onbind(addTask : AddTask) = with(binding){
        tvToAddTask.text = addTask.listAddTask
    }
}

class taskAdapter (private val data: ArrayList<AddTask>) : RecyclerView.Adapter<AddTaskViewHolder>() {

    // membuat view holder yang memuat tampilan item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddTaskViewHolder {
        val binding = ItemAddTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AddTaskViewHolder(binding)
    }

    // mengambil jumlah item data dalam data source
    override fun getItemCount(): Int = data.size

    // menghubungkan data dari data source dengan item posisi yang sesuai
    override fun onBindViewHolder(holder: AddTaskViewHolder, position: Int) = holder.onbind(data[position])

}
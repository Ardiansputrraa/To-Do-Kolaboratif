package oop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectakhir.databinding.ItemAddTaskBinding
import com.example.projectakhir.databinding.ItemMyTaskBinding

class taskViewHolder(private val binding: ItemMyTaskBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onbind(task : Task) = with(binding){
        tvTitleTask.text = task.titleTask
        tvTaskFor.text = task.nameCreateTask
        tvDeadlineTanggal.text = task.deadlineTanggal
        tvDeadlineJam.text = task.deadlineJam
        tvCreateTasK.text = task.nameCreateTask
    }
}

class myTaskAdapter (private val data: ArrayList<Task>) : RecyclerView.Adapter<taskViewHolder>() {

    // membuat view holder yang memuat tampilan item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): taskViewHolder {
        val binding = ItemMyTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return taskViewHolder(binding)
    }

    // mengambil jumlah item data dalam data source
    override fun getItemCount(): Int = data.size

    // menghubungkan data dari data source dengan item posisi yang sesuai
    override fun onBindViewHolder(holder: taskViewHolder, position: Int) = holder.onbind(data[position])

}
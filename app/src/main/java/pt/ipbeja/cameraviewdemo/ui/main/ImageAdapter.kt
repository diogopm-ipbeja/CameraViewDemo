package pt.ipbeja.cameraviewdemo.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import pt.ipbeja.cameraviewdemo.R
import pt.ipbeja.cameraviewdemo.databinding.ImageGridItemBinding
import java.io.File

class ImageAdapter(private val onItemClicked: (File) -> Unit) : RecyclerView.Adapter<ImageViewHolder>() {

    var data: List<File> = listOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.image_grid_item, parent, false)
        return ImageViewHolder(v, onItemClicked)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

}


class ImageViewHolder(view: View, onItemClicked: (File) -> Unit) : RecyclerView.ViewHolder(view) {

    private lateinit var file: File
    private val binding: ImageGridItemBinding = ImageGridItemBinding.bind(view)

    init {
        binding.root.setOnClickListener {
            onItemClicked(file)
        }
    }

    fun bind(file: File) {
        this.file = file
        // TODO load image
    }
}
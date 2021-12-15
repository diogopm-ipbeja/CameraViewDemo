package pt.ipbeja.cameraviewdemo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import pt.ipbeja.cameraviewdemo.databinding.MainFragmentBinding
import java.io.File



class MainFragment : Fragment() {

    private val adapter: ImageAdapter = ImageAdapter(this::onImageClicked)
    private lateinit var binding: MainFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = MainFragmentBinding.inflate(inflater).let {
        this.binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.takePicture.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToCameraFragment())
        }


        val allFiles = requireContext().filesDir?.listFiles()?.toList() ?: listOf()
        adapter.data = allFiles
        binding.grid.adapter = adapter
    }


    private fun onImageClicked(file: File) {
        findNavController()
            .navigate(MainFragmentDirections.actionMainFragmentToImageFragment(file))
    }
}



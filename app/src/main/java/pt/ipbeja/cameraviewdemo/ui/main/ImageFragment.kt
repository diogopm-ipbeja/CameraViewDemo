package pt.ipbeja.cameraviewdemo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import pt.ipbeja.cameraviewdemo.databinding.FragmentImageBinding


class ImageFragment : Fragment() {

    private val args : ImageFragmentArgs by navArgs()

    private lateinit var binding: FragmentImageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentImageBinding.inflate(inflater).let {
        this.binding = it
        it.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.image.load(args.file)
    }
}
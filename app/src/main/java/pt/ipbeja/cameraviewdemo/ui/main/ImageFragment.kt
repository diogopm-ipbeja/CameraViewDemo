package pt.ipbeja.cameraviewdemo.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import coil.imageLoader
import coil.load
import pt.ipbeja.cameraviewdemo.R
import pt.ipbeja.cameraviewdemo.databinding.FragmentCameraBinding
import pt.ipbeja.cameraviewdemo.databinding.FragmentImageBinding


class ImageFragment : Fragment() {

    private lateinit var binding: FragmentImageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentImageBinding.inflate(inflater).let {
        this.binding = it
        it.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // TODO load image file from arguments
    }
}
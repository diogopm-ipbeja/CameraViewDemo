package pt.ipbeja.cameraviewdemo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.otaliastudios.cameraview.CameraListener
import com.otaliastudios.cameraview.PictureResult
import pt.ipbeja.cameraviewdemo.databinding.FragmentCameraBinding
import java.io.File
import java.util.*


class CameraFragment : Fragment() {


    private lateinit var binding: FragmentCameraBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCameraBinding.inflate(inflater).let {
        this.binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.camera.setLifecycleOwner(viewLifecycleOwner)

        binding.shutter.setOnClickListener {
            binding.camera.takePicture()
        }

        binding.camera.addCameraListener(object : CameraListener() {
            override fun onPictureTaken(result: PictureResult) {

                val folder = requireContext().filesDir

                val file = File(folder, "file_${System.currentTimeMillis()}.jpg")

                result.toFile(file) {
                    // Mostrar preview e pedir ao utilizador para confirmar a foto
                    findNavController().popBackStack()
                }
            }
        })
    }
}
























package com.gmail.pavlovsv93.animationandroid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.transition.ChangeBounds
import androidx.transition.ChangeImageTransform
import androidx.transition.TransitionManager
import com.gmail.pavlovsv93.animationandroid.databinding.FragmentZoomBinding

class ZoomFragment : Fragment() {

	private var _binding: FragmentZoomBinding? = null
	private val binding get() = _binding!!
	private var flag = false

	companion object {
		fun newInstance() = ZoomFragment()
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = FragmentZoomBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onDestroy() {
		super.onDestroy()
		_binding = null
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding.fzImageView.setOnClickListener {
			val cbt = ChangeImageTransform()
			cbt.duration = 1500
			TransitionManager.beginDelayedTransition(binding.containerZoom, cbt)
			flag = !flag
			binding.fzImageView.scaleType = if (flag) {
				ImageView.ScaleType.CENTER_CROP
			} else {
				ImageView.ScaleType.CENTER_INSIDE
			}

		}
	}

}
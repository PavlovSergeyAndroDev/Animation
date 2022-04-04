package com.gmail.pavlovsv93.animationandroid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gmail.pavlovsv93.animationandroid.databinding.FragmentTransitionBinding
import com.gmail.pavlovsv93.animationandroid.databinding.FragmentZoomBinding

class ZoomFragment: Fragment() {

	private var _binding : FragmentZoomBinding? = null
	private val binding get() = _binding!!
	private var flag = false

	companion object{
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

}
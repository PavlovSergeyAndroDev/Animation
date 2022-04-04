package com.gmail.pavlovsv93.animationandroid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.transition.TransitionManager
import com.gmail.pavlovsv93.animationandroid.databinding.FragmentTransitionBinding

class TransitionFragment : Fragment() {

	private var _binding : FragmentTransitionBinding? = null
	private val binding get() = _binding!!
	private var flag = false

	companion object{
		fun newInstance() = TransitionFragment()
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = FragmentTransitionBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onDestroy() {
		super.onDestroy()
		_binding = null
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding.ftBnt.setOnClickListener {
			// todo Анимация внутри контейнера AutoTransition
			TransitionManager.beginDelayedTransition(binding.fragmentTransitionContainer)
			if (!flag) {
				binding.ftTextView.visibility = View.VISIBLE
			} else {
				binding.ftTextView.visibility = View.GONE
			}
			flag = !flag
		}
	}


}
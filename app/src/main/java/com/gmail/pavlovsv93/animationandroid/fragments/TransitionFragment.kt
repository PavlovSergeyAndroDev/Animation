package com.gmail.pavlovsv93.animationandroid.fragments

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.transition.*
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

			val transition = TransitionSet()
			val slide = Slide()
			slide.slideEdge = Gravity.END // Слайд по гравитации вправо
			slide.duration = 2000
			val fade = Fade()
			fade.duration = 2000 // длительность анимации fade
			val changeBounds = ChangeBounds()
			changeBounds.duration = 2000 // длительность анимации changeBounts
			transition.addTransition(slide)
			transition.addTransition(fade)
			transition.addTransition(changeBounds)
			transition.ordering = TransitionSet.ORDERING_TOGETHER // Началь анимацию одновременно у всех элементов
			// todo Анимация внутри контейнера AutoTransition
			TransitionManager.beginDelayedTransition(binding.fragmentTransitionContainer, transition)
			if (!flag) {
				binding.ftTextView.visibility = View.VISIBLE
			} else {
				binding.ftTextView.visibility = View.GONE
			}
			flag = !flag
		}
	}


}
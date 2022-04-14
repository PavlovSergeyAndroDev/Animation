package com.gmail.pavlovsv93.animationandroid.fragments

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Explode
import androidx.transition.Transition
import androidx.transition.TransitionManager
import com.gmail.pavlovsv93.animationandroid.R
import com.gmail.pavlovsv93.animationandroid.databinding.FragmentExplodeBinding

class ExplodeFragment : Fragment() {
	private var _binding: FragmentExplodeBinding? = null
	private val binding get() = _binding!!
	private var flag = false

	companion object {
		fun newInstance() = ExplodeFragment()
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = FragmentExplodeBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onDestroy() {
		super.onDestroy()
		_binding = null
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding.recyclerViewExplode.adapter = ExplodeAdapter()
	}

	private fun explode(clickedItemView: View) {
		val explode = Explode()
		explode.excludeTarget(clickedItemView, true)
		val rect = Rect()
		clickedItemView.getGlobalVisibleRect(rect)
		explode.epicenterCallback = object : Transition.EpicenterCallback() {
			override fun onGetEpicenter(transition: Transition): Rect {
				return rect
			}
		}
		explode.duration = 2000
		TransitionManager.beginDelayedTransition(binding.recyclerViewExplode, explode)
		binding.recyclerViewExplode.adapter = null

	}

	inner class ExplodeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

		override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
			holder.itemView.setOnClickListener {
				explode(holder.itemView)
			}
		}

		override fun getItemCount(): Int {
			return 32
		}

		override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
			return ViewHolder(
				LayoutInflater.from(parent.context)
					.inflate(R.layout.fragment_explode_recycler_item, parent, false)
			)
		}

		inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
	}
}
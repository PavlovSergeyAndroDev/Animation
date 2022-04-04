package com.gmail.pavlovsv93.animationandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.gmail.pavlovsv93.animationandroid.databinding.ActivityMainBinding
import com.gmail.pavlovsv93.animationandroid.fragments.TransitionFragment

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.amBottomNavigationView.setOnItemSelectedListener {
			when (it.itemId) {
				R.id.transition -> {
					showFragment(TransitionFragment.newInstance())
					true
				}
				R.id.zoom -> {
					true
				}
				R.id.trajectory -> {
					true
				}
				R.id.object_animation -> {
					true
				}
				R.id.nimator -> {
					true
				}
				else -> false
			}
		}
		binding.amBottomNavigationView.selectedItemId = R.id.transition
	}


	private fun showFragment(f: Fragment) {
		supportFragmentManager.beginTransaction()
			.replace(R.id.am_container, f)
			.commit()
	}
}
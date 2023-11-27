package vn.edu.hust.lifecycleexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import vn.edu.hust.lifecycleexamples.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var count = 0
    val fragmentOne = OneFragment()
    val fragmentTwo = TwoFragment()

    val viewModel: MyViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.v("TAG", "onCreate")

        binding.buttonOpen.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("COUNT_VALUE")
        }

        binding.textCount.text = "$count"

        binding.buttonIncrease.setOnClickListener {
            count++
            binding.textCount.text = "$count"
        }

        binding.textCount2.text = "${viewModel.count2}"

        binding.buttonIncrease2.setOnClickListener {
            viewModel.increaseCount()
            binding.textCount2.text = "${viewModel.count2}"
        }

        supportFragmentManager.beginTransaction()
            .add(R.id.frame_layout, fragmentOne)
            .commit()

        binding.buttonAdd.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(R.id.frame_layout, fragmentTwo)
                .commit()
        }

        binding.buttonReplace.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, fragmentTwo)
                .commit()
        }

        binding.buttonRemove.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .remove(fragmentOne)
                .commit()
        }

        lifecycle.addObserver(LifeCycleObserver())
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("COUNT_VALUE", count)

        super.onSaveInstanceState(outState)

        Log.v("TAG", "onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        Log.v("TAG", "onRestoreInstanceState")

//        count = savedInstanceState.getInt("COUNT_VALUE")
//        textCount.text = "$count"
    }

    override fun onStart() {
        super.onStart()

        Log.v("TAG", "onStart")
    }

    override fun onRestart() {
        super.onRestart()

        Log.v("TAG", "onRestart")
    }

    override fun onResume() {
        super.onResume()

        Log.v("TAG", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.v("TAG", "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.v("TAG", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.v("TAG", "onDestroy")
    }
}
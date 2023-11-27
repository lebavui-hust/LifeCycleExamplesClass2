package vn.edu.hust.lifecycleexamples

import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    var count2 = 0
    fun increaseCount() {
        count2++
    }
}
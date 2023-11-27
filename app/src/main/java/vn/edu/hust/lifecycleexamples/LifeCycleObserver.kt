package vn.edu.hust.lifecycleexamples

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class LifeCycleObserver: DefaultLifecycleObserver {
    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.v("OBSEVER", "onPause")
    }
}
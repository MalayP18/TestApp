package com.example.testapp.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testapp.util.AppGlobal.Companion.ARG_USER
import com.example.testapp.view.adapter.UserAdapter
import com.example.testapp.view.detail.UserDetailActivity
import com.example.testapp.viewmodel.UserViewModel
import com.google.gson.Gson
import com.testapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var userViewModel: UserViewModel
    private lateinit var adapterUser: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        swipeRefresh.setOnRefreshListener {
            swipeRefresh.isRefreshing = true
            callUserApi(true)
        }

        callUserApi(false)
    }

    private fun callUserApi(isSwipe: Boolean) {
        if (!isSwipe)
            wp7progressBar.showProgressBar()

        userViewModel.getUser()!!.observe(this, Observer { data ->
            if (!isSwipe)
                wp7progressBar.hideProgressBar()

            Log.e("response", Gson().toJson(data))
            adapterUser = UserAdapter(this, data.results!!, this)
            rvUser.adapter = adapterUser
            if (isSwipe)
                swipeRefresh.isRefreshing = false
        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.llUser -> {
                val pos = v.tag as Int
                val data = adapterUser.getItem(pos)
                val options: ActivityOptionsCompat =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                        this@MainActivity,
                        v,  // Starting view
                        getString(R.string.transition) // The String
                    )
                val intent = Intent(this@MainActivity, UserDetailActivity::class.java)
                intent.putExtra(ARG_USER, Gson().toJson(data))
                ActivityCompat.startActivity(this@MainActivity, intent, options.toBundle())
            }
        }
    }
}

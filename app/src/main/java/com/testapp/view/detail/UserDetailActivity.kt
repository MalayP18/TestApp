package com.example.testapp.view.detail

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.testapp.model.UserDetailData
import com.example.testapp.util.AppGlobal
import com.example.testapp.util.AppGlobal.Companion.ARG_USER
import com.google.gson.Gson
import com.testapp.R
import kotlinx.android.synthetic.main.activity_user_detail.*

class UserDetailActivity : AppCompatActivity(), View.OnClickListener {
    private var userData = UserDetailData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)
        init()
    }

    private fun init() {
        if (intent.hasExtra(ARG_USER)) {
            userData = Gson().fromJson(intent.getStringExtra(ARG_USER), UserDetailData::class.java)
            setUserData()
        }
        ivBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivBack -> onBackPressed()
        }
    }

    private fun setUserData() {
        AppGlobal.loadImageUrl(this, ivProfile, userData.picture?.large!!)
        tvUserName.text =
            userData.name?.title + " " + userData.name?.first + " " + userData.name?.last
        tvDOB.text = userData.gender?.capitalize() + ", " + userData.dob?.age + " year old"
        tvLocation.text =
            userData.location?.street?.number + ", " + userData.location?.street?.name + ", " + userData.location?.city + ", " + userData.location?.state + ", " + userData.location?.country + ", " + userData.location?.postcode
        tvEmail.text = userData.email
        tvCall.text = userData.phone
        handler.postDelayed(runnable, 10)

    }

    override fun onBackPressed() {
        ActivityCompat.finishAfterTransition(this)
    }

    val handler = Handler()
    val runnable = object : Runnable {
        override fun run() {
            progressBar.progress = progressBar.progress + 1
            if (progressBar.progress != 100)
                handler.postDelayed(this, 10)
        }

    }
}
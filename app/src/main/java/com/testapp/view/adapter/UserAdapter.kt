package com.example.testapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.model.UserDetailData
import com.example.testapp.util.AppGlobal
import com.testapp.R

class UserAdapter(
    private val context: Context,
    private val mList: List<UserDetailData>,
    private val click: View.OnClickListener
) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_user, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val data = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.run {

            llUser.tag = position
            llUser.setOnClickListener(click)

            AppGlobal.loadImageUrl(context, ivProfile, data.picture?.large!!)
            tvUserName.text = data.name?.title + " " + data.name?.first + " " + data.name?.last
            tvAddress.text =
                data.location?.street?.number + ", " + data.location?.street?.name + ", " + data.location?.city + ", " + data.location?.state + ", " + data.location?.country + ", " + data.location?.postcode
        }

    }

    fun getItem(pos: Int): UserDetailData {
        return mList[pos]
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val ivProfile: ImageView = itemView.findViewById(R.id.ivProfile)
        val tvUserName: TextView = itemView.findViewById(R.id.tvUserName)
        val tvAddress: TextView = itemView.findViewById(R.id.tvAddress)
        val llUser: LinearLayoutCompat = itemView.findViewById(R.id.llUser)
    }
}
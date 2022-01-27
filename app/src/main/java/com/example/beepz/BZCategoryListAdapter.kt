package com.example.beepz

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beepz.data.BZOrder
import java.util.concurrent.Executors

/*Created by Maneesha on 25/01/2022*/

class BZCategoryListAdapter(
    private var dataList: List<BZOrder>,
    private val context: Context,
    private val itemClickListener: BZItemClickListener
) :
    RecyclerView.Adapter<BZCategoryListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.order_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataList.get(position)
        val imageURL: String =
            "https://beepz.ae/Content/uploads/car/December-2021/ylkbomqr.jpeg"
        holder.categoryTextView.text =
            dataModel.category?.categoryName
        holder.detailsTextView.text =
            context.getString(R.string.car_details) + ": " + dataModel.car?.vehicleNickName
        holder.dateTextView.text =
            context.getString(R.string.date_of_services) + ": " + dataModel.bookingDate?.dropLast(11)
        holder.detailsTextView.text =
            context.getString(R.string.car_details) + ": " + dataModel.car?.vehicleNickName
        //hard coded value
        holder.locationTextView.text = context.getString(R.string.driver_on_the_way)

        val handler = Handler(Looper.getMainLooper())
        val executor = Executors.newSingleThreadExecutor()
        // Initializing the image
        var image: Bitmap? = null
        executor.execute {
            try {
                val `in` = java.net.URL(imageURL).openStream()
                image = BitmapFactory.decodeStream(`in`)

                // Only for making changes in UI
                handler.post {
                    holder.categoryImageView.setImageBitmap(image)
                }
            }  // If the URL doesnot point to
            // image or any other kind of failure
            catch (e: Exception) {
                e.printStackTrace()
            }
        }
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClickListener(dataModel)
        }
    }

    /*ViewHolder containing item UI*/
    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var categoryTextView: TextView = itemView.findViewById(R.id.categoryTextView)
        var categoryImageView: ImageView = itemView.findViewById(R.id.categoryImageView)
        var detailsTextView: TextView = itemView.findViewById(R.id.detailsTextView)
        var dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
        var locationTextView: TextView = itemView.findViewById(R.id.locationTextView)
    }
}
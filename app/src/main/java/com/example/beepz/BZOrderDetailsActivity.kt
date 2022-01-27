package com.example.beepz

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.beepz.data.BZOrder

/*Created by Maneesha on 26/01/2022*/

class BZOrderDetailsActivity : AppCompatActivity() {

    private val dataObject: String = "data_object"

    private lateinit var orderNumberTextView: TextView
    private lateinit var bookingConfirmedTextView: TextView
    private lateinit var pickUpTextView: TextView
    private lateinit var scannerTextView: TextView
    private lateinit var carPickedUpTextView: TextView
    private lateinit var reachedGarageTextView: TextView
    private lateinit var serviceStartedTextView: TextView
    private lateinit var serviceEndedTextView: TextView
    private lateinit var dropOffTextView: TextView
    private lateinit var bookingCompletedTextView: TextView

    private lateinit var bookingStatusImageView: ImageView
    private lateinit var driverPickUpImageView: ImageView
    private lateinit var scannerImageView: ImageView
    private lateinit var carPickedUpImageView: ImageView
    private lateinit var reachedImageView: ImageView
    private lateinit var serviceImageView: ImageView
    private lateinit var endedImageView: ImageView
    private lateinit var droppedImageView: ImageView
    private lateinit var completedImageView: ImageView
    private lateinit var leftIcon: ImageView

    private lateinit var order: BZOrder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_details)
        order = intent.extras?.get(dataObject) as BZOrder
        initView()
        setData()
        setClick()
    }
    /*Function to initialize view components*/

    private fun initView() {
        leftIcon = findViewById(R.id.leftIcon)
        orderNumberTextView = findViewById(R.id.orderNumberTextView)
        bookingConfirmedTextView = findViewById(R.id.bookingConfirmedTextView)
        pickUpTextView = findViewById(R.id.pickUpTextView)
        scannerTextView = findViewById(R.id.scannerTextView)
        carPickedUpTextView = findViewById(R.id.carPickedUpTextView)
        reachedGarageTextView = findViewById(R.id.reachedGarageTextView)
        serviceStartedTextView = findViewById(R.id.serviceStartedTextView)
        serviceEndedTextView = findViewById(R.id.serviceEndedTextView)
        dropOffTextView = findViewById(R.id.dropOffTextView)
        bookingCompletedTextView = findViewById(R.id.bookingCompletedTextView)

        bookingStatusImageView = findViewById(R.id.bookingStatusImageView)
        driverPickUpImageView = findViewById(R.id.driverPickUpImageView)
        scannerImageView = findViewById(R.id.scannerImageView)
        carPickedUpImageView = findViewById(R.id.carPickedUpImageView)
        reachedImageView = findViewById(R.id.reachedImageView)
        serviceImageView = findViewById(R.id.serviceImageView)
        endedImageView = findViewById(R.id.endedImageView)
        droppedImageView = findViewById(R.id.droppedImageView)
        completedImageView = findViewById(R.id.completedImageView)


    }

    /*Function to set data on te UI*/
    private fun setData() {
        leftIcon.setImageResource(R.drawable.left)
        orderNumberTextView.text = "#" + order.orderId.toString()
        if (order.orderTrack?.name == getString(R.string.booking_confirmed)) {
            bookingStatusImageView.setImageResource(R.drawable.tick_green)
            bookingConfirmedTextView.setTextColor(ContextCompat.getColor(this, R.color.orange_red))
            if (order.orderTrack?.name == getString(R.string.driver_pickup)) {
                driverPickUpImageView.setImageResource(R.drawable.tick_green)
                pickUpTextView.setTextColor(ContextCompat.getColor(this, R.color.orange_red))
                if (order.orderTrack?.name == getString(R.string.qr_code_scanned)) {
                    scannerImageView.setImageResource(R.drawable.tick_green)
                    scannerTextView.setTextColor(ContextCompat.getColor(this, R.color.orange_red))
                    if (order.orderTrack?.name == getString(R.string.car_picked_up)) {
                        carPickedUpImageView.setImageResource(R.drawable.tick_green)
                        carPickedUpTextView.setTextColor(
                            ContextCompat.getColor(
                                this,
                                R.color.orange_red
                            )
                        )
                        if (order.orderTrack?.name == getString(R.string.reached_garage)) {
                            reachedImageView.setImageResource(R.drawable.tick_green)
                            reachedGarageTextView.setTextColor(
                                ContextCompat.getColor(
                                    this,
                                    R.color.orange_red
                                )
                            )
                            if (order.orderTrack?.name == getString(R.string.service_started)) {
                                serviceImageView.setImageResource(R.drawable.tick_green)
                                serviceStartedTextView.setTextColor(
                                    ContextCompat.getColor(
                                        this,
                                        R.color.orange_red
                                    )
                                )
                                if (order.orderTrack?.name == getString(R.string.service_ended)) {
                                    endedImageView.setImageResource(R.drawable.tick_green)
                                    serviceEndedTextView.setTextColor(
                                        ContextCompat.getColor(
                                            this,
                                            R.color.orange_red
                                        )
                                    )
                                    if (order.orderTrack?.name == getString(R.string.drop_off)) {
                                        droppedImageView.setImageResource(R.drawable.tick_green)
                                        dropOffTextView.setTextColor(
                                            ContextCompat.getColor(
                                                this,
                                                R.color.orange_red
                                            )
                                        )
                                        if (order.orderTrack?.name == getString(R.string.booking_completed)) {
                                            completedImageView.setImageResource(R.drawable.tick_green)
                                            bookingCompletedTextView.setTextColor(
                                                ContextCompat.getColor(
                                                    this,
                                                    R.color.orange_red
                                                )
                                            )

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }

    }

    /*Function to set click event*/
    private fun setClick() {
        leftIcon.setOnClickListener(View.OnClickListener { finish() })
    }
}
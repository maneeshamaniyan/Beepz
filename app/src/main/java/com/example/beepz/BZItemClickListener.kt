package com.example.beepz

import com.example.beepz.data.BZOrder

/*Created by Maneesha on 26/01/2022*/

interface BZItemClickListener {
    /*function to set recyclerview item click*/
    fun onItemClickListener(data: BZOrder)
}
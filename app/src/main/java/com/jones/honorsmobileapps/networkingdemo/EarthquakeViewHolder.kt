package com.jones.honorsmobileapps.networkingdemo

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jones.honorsmobileapps.networkingdemo.databinding.ListItemLayoutBinding
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

class EarthquakeViewHolder(val binding: ListItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentEarthquake: Earthquake

    fun bindEarthquake(earthquake: Earthquake) {
        currentEarthquake = earthquake

        val magnitude = currentEarthquake.magnitude
        val formatter = DecimalFormat("0.0")
        val magString = formatter.format(magnitude)
        binding.magnitudeTextView.text = magString

        val fullLocation = currentEarthquake.location
        val primaryLocationString: String
        val locationOffsetString: String
        if (fullLocation.contains(LOCATION_SEPARATOR)) {
            val parts = fullLocation.split(LOCATION_SEPARATOR).toTypedArray()
            locationOffsetString = parts[0] + LOCATION_SEPARATOR
            primaryLocationString = parts[1]
        } else {
            locationOffsetString = DEFAULT_LOCATION_OFFSET
            primaryLocationString = fullLocation
        }
        binding.primaryLocationTextView.text = primaryLocationString
        binding.locationOffsetTextView.text = locationOffsetString

        val dateObject = Date(currentEarthquake.timeInMilliseconds)
        binding.dateTextView.text = formatDate(dateObject)
        binding.timeTextView.text = formatTime(dateObject)
    }

    private fun formatDate(dateObject: Date): String {
        val dateFormat = SimpleDateFormat("LLL dd, yyyy")
        return dateFormat.format(dateObject)
    }

    private fun formatTime(dateObject: Date): String {
        val timeFormat = SimpleDateFormat("h:mm a")
        return timeFormat.format(dateObject)
    }

    companion object {
        private const val LOCATION_SEPARATOR = " of "
        private const val DEFAULT_LOCATION_OFFSET = "Near the"
    }


}

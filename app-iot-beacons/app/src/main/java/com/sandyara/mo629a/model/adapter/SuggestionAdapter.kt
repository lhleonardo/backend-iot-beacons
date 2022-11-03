package com.sandyara.mo629a.model.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sandyara.mo629a.R
import com.sandyara.mo629a.model.Suggestion


class SuggestionAdapter(private val dataSet: List<Suggestion>) :
    RecyclerView.Adapter<SuggestionAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val place: TextView
        val icon: ImageView

        init {
            place = view.findViewById(R.id.suggestionText)
            icon = view.findViewById(R.id.suggestionIcon)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_places, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.place.text = dataSet[position].place
        val resource = when(dataSet[position].icon){
            "INSTITUTO" -> R.drawable.icon_instituto
            "RESTAURANTE" -> R.drawable.icon_restaurante
            "TRAVESSIA" -> R.drawable.icon_travessia
            else -> R.drawable.icon_ponto
        }
        viewHolder.icon.setImageResource(resource)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}

package com.shanjinur.rxjava.view

import android.R
import android.content.Context
import android.graphics.Color
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.shanjinur.rxjava.network.model.Note
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class NotesAdapter(
    private val context: Context,
    private val notesList: List<Note>
) :
    RecyclerView.Adapter<NotesAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        @BindView(R.id.note)
        var note: TextView? = null

        @BindView(R.id.dot)
        var dot: TextView? = null

        @BindView(R.id.timestamp)
        var timestamp: TextView? = null

        init {
            ButterKnife.bind(this, view!!)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val note = notesList[position]
        holder.note!!.text = note.note

        // Displaying dot from HTML character code
        holder.dot!!.text = Html.fromHtml("&#8226;")

        // Changing dot color to random color
        holder.dot!!.setTextColor(getRandomMaterialColor("400"))

        // Formatting and displaying timestamp
        holder.timestamp!!.text = formatDate(note.timestamp)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    /**
     * Chooses random color defined in res/array.xml
     */
    private fun getRandomMaterialColor(typeColor: String): Int {
        var returnColor: Int = Color.GRAY
        val arrayId = context.resources
            .getIdentifier("mdcolor_$typeColor", "array", context.packageName)
        if (arrayId != 0) {
            val colors = context.resources.obtainTypedArray(arrayId)
            val index = (Math.random() * colors.length()).toInt()
            returnColor = colors.getColor(index, Color.GRAY)
            colors.recycle()
        }
        return returnColor
    }

    /**
     * Formatting timestamp to `MMM d` format
     * Input: 2018-02-21 00:15:42
     * Output: Feb 21
     */
    private fun formatDate(dateStr: String): String {
        try {
            val fmt = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            val date: Date = fmt.parse(dateStr)
            val fmtOut = SimpleDateFormat("MMM d")
            return fmtOut.format(date)
        } catch (e: ParseException) {
        }
        return ""
    }

}

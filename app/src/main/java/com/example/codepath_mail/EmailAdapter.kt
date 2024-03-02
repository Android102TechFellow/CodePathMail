package layout

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.codepath_mail.Email
import com.example.codepath_mail.R

class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val senderTextView: TextView = itemView.findViewById(R.id.senderTv)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTv)
        val summaryTextView: TextView = itemView.findViewById(R.id.summaryTv)
        val readCheckBox: CheckBox = itemView.findViewById(R.id.checkBox)

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
//        init {
//            senderTextView = itemView.findViewById(R.id.senderTv)
//            titleTextView = itemView.findViewById(R.id.titleTv)
//            summaryTextView = itemView.findViewById(R.id.summaryTv)
//            readCheckBox = itemView.findViewById(R.id.checkBox)
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.email_item, parent, false)
        // Return a new holder instance


        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return emails.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val email = emails[position]

        // Set item views based on views and data model
        holder.senderTextView.text = email.sender
        holder.titleTextView.text = email.title
        holder.summaryTextView.text = email.summary
        holder.readCheckBox.isChecked = email.isRead

        val textStyle = if(email.isRead) Typeface.NORMAL else Typeface.BOLD
        holder.senderTextView.setTypeface(null, textStyle)
        holder.titleTextView.setTypeface(null, textStyle)
        holder.summaryTextView.setTypeface(null, textStyle)

        holder.readCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (email.isRead != isChecked) {
                email.isRead = isChecked

                val newTextStyle = if (isChecked) Typeface.NORMAL else Typeface.BOLD
                holder.senderTextView.setTypeface(null, newTextStyle)
                holder.titleTextView.setTypeface(null, newTextStyle)
                holder.summaryTextView.setTypeface(null, newTextStyle)
            }
        }
        }
    }
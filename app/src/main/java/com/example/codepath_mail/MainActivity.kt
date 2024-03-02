package com.example.codepath_mail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import layout.EmailAdapter

class MainActivity : AppCompatActivity() {

    lateinit var emails: MutableList<Email>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailsRV = findViewById<RecyclerView>(R.id.emailsRv)

        emails = EmailFetcher.getEmails()

        val emailAdapter = EmailAdapter(emails)

        emailsRV.adapter = emailAdapter

        emailsRV.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.loadMoreButton).setOnClickListener {
            val newEmails = EmailFetcher.getNext5Emails()
            emails.addAll(newEmails)
            emailAdapter.notifyDataSetChanged()

        }
    }
}
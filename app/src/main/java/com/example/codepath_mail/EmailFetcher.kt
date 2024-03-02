package com.example.codepath_mail

class EmailFetcher {

    companion object{
        val senders = listOf("Dahlia Cline", "Kevin Miranda", "Kaya Austin",
            "Laila Calderon", "Marquise Rhodes", "Fletcher Patel", "Luz Barron",
            "Kamren Dudley", "Jairo Foster", "Lilah Sandoval", "Ansley Blake",
            "Slade Sawyer", "Jaelyn Holmes", "Phoenix Bright", "Ernesto Gould")
        val titles = listOf("Welcome to Kotlin!", "Phone Screen w/ Glassdoor", "ICS 46 Midterm Grades",
            "Medtronic Offer Rejection", "Esri Housing Application", "UCI In the News!", "Empty Title",
            "CodePath Newsletter!", "Welcome to Notion!", "Exam 3 Reminder", "Bulletin Board",
            "Slade from Esri", "ADP Reminder", "LinkedIn Learning Course", "Vote for Gould")
        val summary = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                "molestiae quas vel sint commodi repudiandae consequuntur voluptatum laborum\n" +
                "numquam blanditiis harum quisquam eius sed odit fugiat iusto fuga praesentium\n" +
                "optio, eaque rerum!"

        val isRead = false


        fun getEmails(): MutableList<Email> {
            var emails : MutableList<Email> = ArrayList()
            for (i in 0..9) {
                val email = Email(senders[i], titles[i], summary, isRead)
                emails.add(email)
            }
            return emails
        }

        fun getNext5Emails(): MutableList<Email> {
            var newEmails : MutableList<Email> = ArrayList()
            for (i in 10..14) {
                val email = Email(senders[i], titles[i], summary, isRead)
                newEmails.add(email)
            }
            return newEmails
        }
    }
}
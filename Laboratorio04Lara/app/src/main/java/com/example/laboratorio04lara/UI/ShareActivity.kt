package com.example.laboratorio04lara.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.laboratorio04lara.R
import android.telephony.SmsManager
import android.widget.Toast

class ShareActivity : AppCompatActivity() {
    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var telTextView: TextView
    private lateinit var actionShareImplicit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        nameTextView = findViewById(R.id.name_text_view)
        emailTextView = findViewById(R.id.email_text_view)
        telTextView = findViewById(R.id.tel_text_view)
        actionShareImplicit = findViewById(R.id.action_share_implicit)

        var nameShared = intent.getStringExtra("name").toString()
        var emailShared = intent.getStringExtra("email").toString()
        var telShared = intent.getStringExtra("tel").toString()

        nameTextView.text = "Nombre: ${nameShared}"
        emailTextView.text = "Correo: ${emailShared}"
        telTextView.text = "Teléfono: ${telShared}"

        actionShareImplicit.setOnClickListener{
            val message = "Nombre ${nameShared}" +
                    "Correo ${emailShared}" +
                    "Teléfono ${telShared}"

            try {
                val smsManager:SmsManager
                smsManager = this.getSystemService(SmsManager::class.java)
                smsManager.sendTextMessage("88887777", null, message, null, null)
                Toast.makeText(applicationContext, "Message Sent", Toast.LENGTH_LONG).show()
            }catch (e: Exception){
                Toast.makeText(applicationContext, "Please enter all the data.."+e.message.toString(), Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}
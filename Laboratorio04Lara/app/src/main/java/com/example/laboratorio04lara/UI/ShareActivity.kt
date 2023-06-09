package com.example.laboratorio04lara.UI

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.laboratorio04lara.R


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
            val myIntent = Intent(Intent.ACTION_SEND)
            myIntent.type = "text/plain"
            val body = "Nombre: ${nameShared}" +
                        "Correo: ${emailShared}" +
                        "Teléfono: ${telShared}"
            val sub = "Información"
            myIntent.putExtra(Intent.EXTRA_SUBJECT,sub)
            myIntent.putExtra(Intent.EXTRA_TEXT,body)
            startActivity(Intent.createChooser(myIntent, "Compartir información"))
        }
    }
}
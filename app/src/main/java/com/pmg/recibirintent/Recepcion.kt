package com.pmg.recibirintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Recepcion : AppCompatActivity() {
    private lateinit var editTextMessage: EditText
    private lateinit var textViewReceivedMessage: TextView
    private lateinit var buttonSendMessage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recibir)

        editTextMessage = findViewById(R.id.editTextMessage)
        textViewReceivedMessage = findViewById(R.id.textViewReceivedMessage)
        buttonSendMessage = findViewById(R.id.buttonSendMessage)

        buttonSendMessage.setOnClickListener {
            val intent = Intent()
            intent.putExtra("message", editTextMessage.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }

        val receivedMessage = intent.getStringExtra("message")
        textViewReceivedMessage.text = receivedMessage
    }
}
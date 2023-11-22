package com.pmg.recibirintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var editTextMessage: EditText
    private lateinit var textViewReceivedMessage: TextView
    private lateinit var buttonSendMessage: Button

    private lateinit var startForResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextMessage = findViewById(R.id.editTextMessage)
        textViewReceivedMessage = findViewById(R.id.textViewReceivedMessage)
        buttonSendMessage = findViewById(R.id.buttonSendMessage)

        startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val receivedMessage = result.data?.getStringExtra("message")
                textViewReceivedMessage.text = receivedMessage
            }
        }

        buttonSendMessage.setOnClickListener {
            val intent = Intent(this, Recepcion::class.java)
            intent.putExtra("message", editTextMessage.text.toString())
            startForResult.launch(intent)
        }
    }
}
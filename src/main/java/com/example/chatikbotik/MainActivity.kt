package com.example.chatikbotik

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var dialogueTextView: TextView
    private lateinit var aiCheckbox: CheckBox
    private lateinit var messageEditText: EditText
    private lateinit var sendButton: Button
    private lateinit var sbot: SimpleBot

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sbot = SimpleBot()

        // Находим представления по их идентификаторам
        dialogueTextView = findViewById(R.id.dialogue)
        aiCheckbox = findViewById(R.id.ai_checkbox)
        messageEditText = findViewById(R.id.message_input)
        sendButton = findViewById(R.id.send_button)

        // Настраиваем обработчик нажатия на кнопку отправки сообщения
        sendButton.setOnClickListener {
            val message = messageEditText.text.toString().trim()
            if (message.isNotEmpty()) {
                sendMessage(message)
            }
        }
    }

    private fun sendMessage(message: String) {
        // TODO: Добавьте код для отправки сообщения и получения ответа от чат-бота
        // Здесь можно использовать объект sbot и вызывать его методы для обработки сообщения и получения ответа
        // Пример:

        val response = sbot.sayInReturn(message, aiCheckbox.isChecked)
        displayMessage(message)
        displayMessage(response)
    }

    private fun displayMessage(message: String) {
        dialogueTextView.append("$message\n")
        // Прокручиваем текст вниз, чтобы показать последнее сообщение
        dialogueTextView.post { dialogueTextView.scrollTo(0, dialogueTextView.bottom) }
        // Очищаем поле ввода сообщения
        messageEditText.text.clear()
    }
}


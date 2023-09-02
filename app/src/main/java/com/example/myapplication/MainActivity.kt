package com.example.myapplication
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var compareButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialización de vistas y ViewModel
        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        compareButton = findViewById(R.id.compareButton)
        resultTextView = findViewById(R.id.resultTextView)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // Configuración del evento click del botón
        compareButton.setOnClickListener {
            val text1 = editText1.text.toString().trim()
            val text2 = editText2.text.toString().trim()

            viewModel.setText1(text1)
            viewModel.setText2(text2)
            viewModel.compareTexts()
        }

        // Observación de LiveData y actualización de vistas
        viewModel.text1.observe(this) { text1 ->
            editText1.setText(text1)
        }

        viewModel.text2.observe(this) { text2 ->
            editText2.setText(text2)
        }

        viewModel.comparisonResult.observe(this) { result ->
            resultTextView.text = result
        }
    }
}

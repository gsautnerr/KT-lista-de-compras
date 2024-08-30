package br.com.fiap.listadecompras

import ItemsViewModel
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Lista de Compras"

        val viewModel: ItemsViewModel by viewModels()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)

        button.setOnClickListener {
            if (editText.text.isEmpty()) {
                editText.error = "Preencha um valor"
                return@setOnClickListener
            }


            viewModel.addItem(editText.text.toString())
            editText.text.clear()
        }

        /**
         * Observa as alterações na lista de itens na ViewModel.
         * Quando a lista de itens é alterada, atualiza o ItemsAdapter com a nova lista.
         */
            viewModel.itemsLiveData.observe(this) {
                    items -> itemsAdapter.updateItems(items)
        }
    }
}
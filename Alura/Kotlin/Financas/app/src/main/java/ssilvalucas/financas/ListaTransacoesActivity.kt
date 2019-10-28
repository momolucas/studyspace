package ssilvalucas.financas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import ssilvalucas.financas.ui.adapter.ListaTransacoesAdapter

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val lista = listOf("Item 1 - R$1,00", "Item 2 - R$20,00")

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista)


        lista_transacoes_listview.setAdapter(ListaTransacoesAdapter(lista, this))
    }
}

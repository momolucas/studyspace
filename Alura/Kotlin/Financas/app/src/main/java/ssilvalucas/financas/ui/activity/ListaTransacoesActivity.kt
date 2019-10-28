package ssilvalucas.financas.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import ssilvalucas.financas.R
import ssilvalucas.financas.model.Transacao
import ssilvalucas.financas.ui.adapter.ListaTransacoesAdapter
import java.math.BigDecimal
import java.util.*

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val lista = listOf(Transacao(BigDecimal(20.50), "comida", Calendar.getInstance()),
            Transacao(BigDecimal(100.0), "Economia", Calendar.getInstance()))

        lista_transacoes_listview.setAdapter(ListaTransacoesAdapter(lista, this))
    }
}

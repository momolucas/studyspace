package ssilvalucas.financas.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import ssilvalucas.financas.R
import ssilvalucas.financas.model.Tipo
import ssilvalucas.financas.model.Transacao
import ssilvalucas.financas.ui.adapter.ListaTransacoesAdapter
import java.math.BigDecimal

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val lista = listOf(Transacao(valor = BigDecimal(20.50), tipo = Tipo.DESPESA),
            Transacao(valor = BigDecimal(100.0), categoria = "Economia", tipo = Tipo.RECEITA))

        lista_transacoes_listview.adapter = ListaTransacoesAdapter(lista, this)
    }
}

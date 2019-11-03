package ssilvalucas.financas.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import ssilvalucas.financas.R
import ssilvalucas.financas.model.Tipo
import ssilvalucas.financas.model.Transacao
import ssilvalucas.financas.ui.ResumoView
import ssilvalucas.financas.ui.adapter.ListaTransacoesAdapter
import java.math.BigDecimal

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes: List<Transacao> = transacoesDeExemplo()

        configuraResumo(transacoes)

        configuraLista(transacoes)
    }

    private fun configuraResumo(transacoes: List<Transacao>) {

        val view = window.decorView
        val resumoView = ResumoView(this, view, transacoes)

        resumoView.atualiza()
    }

    private fun configuraLista(lista: List<Transacao>) {
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(lista, this)
    }

    private fun transacoesDeExemplo() =
        listOf(
            Transacao(valor = BigDecimal(170), tipo = Tipo.DESPESA),
            Transacao(
                valor = BigDecimal(160.0),
                categoria = "Almoço de final de semana",
                tipo = Tipo.RECEITA
            )
        )
}

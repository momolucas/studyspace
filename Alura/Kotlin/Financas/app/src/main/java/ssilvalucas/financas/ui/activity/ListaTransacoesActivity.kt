package ssilvalucas.financas.ui.activity

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.form_transacao.view.*
import ssilvalucas.financas.R
import ssilvalucas.financas.extension.formataParaBrasileiro
import ssilvalucas.financas.model.Tipo
import ssilvalucas.financas.model.Transacao
import ssilvalucas.financas.ui.ResumoView
import ssilvalucas.financas.ui.adapter.ListaTransacoesAdapter
import java.math.BigDecimal
import java.util.*

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes: List<Transacao> = transacoesDeExemplo()

        configuraResumo(transacoes)

        configuraLista(transacoes)

        lista_transacoes_adiciona_receita
            .setOnClickListener {
                val view : View = window.decorView
                val viewCriada = LayoutInflater.from(this)
                    .inflate(R.layout.form_transacao,
                        view as ViewGroup,
                        false)

                val ano = 2017
                val mes = 9
                val dia = 18

                val hoje = Calendar.getInstance()

                viewCriada.form_transacao_data
                    .setText(hoje.formataParaBrasileiro())

                viewCriada.form_transacao_data
                    .setOnClickListener {
                        DatePickerDialog(this,
                            DatePickerDialog.OnDateSetListener { view, ano, mes, dia ->
                                val dataSelecionada = Calendar.getInstance()
                                dataSelecionada.set(ano, mes, dia)
                                viewCriada.form_transacao_data
                                    .setText(dataSelecionada.formataParaBrasileiro())
                            }
                            , ano, mes, dia).show()
                    }


                val adapter = ArrayAdapter.createFromResource(this, R.array.categorias_de_receita, android.R.layout.simple_spinner_dropdown_item)
                viewCriada.form_transacao_categoria.adapter = adapter

                AlertDialog.Builder(this)
                    .setTitle(R.string.adiciona_receita)
                    .setView(viewCriada)
                    .setPositiveButton("Adicionar", null)
                    .setNegativeButton("Cancelar", null)
                    .show()
            }
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
            Transacao(valor = BigDecimal(20.50), tipo = Tipo.DESPESA),
            Transacao(
                valor = BigDecimal(100.0),
                categoria = "Almoço de final de semana",
                tipo = Tipo.RECEITA
            )
        )
}

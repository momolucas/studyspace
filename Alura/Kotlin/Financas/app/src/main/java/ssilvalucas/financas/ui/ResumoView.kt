package ssilvalucas.financas.ui

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.resumo_card.view.*
import ssilvalucas.financas.R
import ssilvalucas.financas.extension.formataParaBrasileiro
import ssilvalucas.financas.model.Resumo
import ssilvalucas.financas.model.Transacao
import java.math.BigDecimal

class ResumoView(private val context: Context,
                 private val view: View,
                 transacoes: List<Transacao>) {

    private val resumo: Resumo = Resumo(transacoes)
    private val corReceita = ContextCompat.getColor(context, R.color.receita)
    private val corDespesa = ContextCompat.getColor(context, R.color.despesa)

    fun adicionaReceita() {
        val totalReceita = resumo.receita()
        with(view.resumo_card_receita){
            setTextColor(corReceita)
            text = totalReceita.formataParaBrasileiro()
        }
    }

    fun adicionaDespesa() {
        val totalDespesa = resumo.despesa()
        with(view.resumo_card_despesa){
            setTextColor(corDespesa)
            text = totalDespesa.formataParaBrasileiro()
        }
    }

    fun adicionaTotal(){
        val total = resumo.total()
        val cor = corPor(total)
        with(view.resumo_card_total){
            setTextColor(cor)
            text = total.formataParaBrasileiro()
        }
    }

    private fun corPor(valor: BigDecimal): Int {
        if (valor >= BigDecimal.ZERO) {
            return corReceita
        } else {
            return corDespesa
        }
    }
}
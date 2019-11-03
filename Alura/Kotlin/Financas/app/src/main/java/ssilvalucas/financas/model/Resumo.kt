package ssilvalucas.financas.model

import java.math.BigDecimal

class Resumo(private val transacoes: List<Transacao>) {

    fun receita() : BigDecimal{

        /*
        ** Ação correspondente a função lambda abaixo
        *
        var totalReceira = BigDecimal.ZERO
        for (transacao in transacoes) {
            if (transacao.tipo == Tipo.RECEITA) {
                totalReceira = totalReceira.plus(transacao.valor)
            }
        }
        */

        return somaPor(Tipo.RECEITA)
    }

    /* Single expression equivalente a função receita */
    val despesa: BigDecimal get() = somaPor(Tipo.DESPESA)


    fun somaPor(tipo: Tipo) : BigDecimal{
        return BigDecimal(transacoes
            .filter { transacao -> transacao.tipo == tipo }
            .sumByDouble { transacao -> transacao.valor.toDouble() })
    }

    val total: BigDecimal get() = receita().subtract(despesa)
}
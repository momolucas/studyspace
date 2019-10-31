package ssilvalucas.financas.model

import java.math.BigDecimal

class Resumo(private val transacoes: List<Transacao>) {

    fun receita() : BigDecimal{
        var totalReceira = BigDecimal.ZERO
        for (transacao in transacoes) {
            if (transacao.tipo == Tipo.RECEITA) {
                totalReceira = totalReceira.plus(transacao.valor)
            }
        }
        return totalReceira
    }

    fun despesa() : BigDecimal{
        var totalDespesa = BigDecimal.ZERO
        for (transacao in transacoes) {
            if (transacao.tipo == Tipo.DESPESA) {
                totalDespesa = totalDespesa.plus(transacao.valor)
            }
        }
        return totalDespesa
    }

    fun total() : BigDecimal{
        return receita().subtract(despesa())
    }
}
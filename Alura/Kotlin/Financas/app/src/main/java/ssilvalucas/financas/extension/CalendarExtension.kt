package ssilvalucas.financas.extension

import java.text.SimpleDateFormat
import java.util.*

fun Calendar.formataParaBrasileiro() : String{
    val formatoBrasileiro = "dd/mm/yyyy"
    val format = SimpleDateFormat(formatoBrasileiro)
    return format.format(this.time)
}
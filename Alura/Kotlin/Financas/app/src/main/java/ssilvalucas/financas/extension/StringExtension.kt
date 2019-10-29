package ssilvalucas.financas.extension

fun String.limitaEmAte(caracteres: Int) : String{
    return if(this.length > caracteres){
        "${this.substring(0, caracteres)}..."
    } else{
        this
    }
}
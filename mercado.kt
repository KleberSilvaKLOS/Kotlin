// Listas e Filtros com Data classes.
// Vamos criar uma lista de produtos e fazer três operações: filtrar os caros, transoformar os nomes em maiúsculas e calcular o preço total dos produtos.

data class Item(val nome: String, val preco: Double)

fun main() {
    val carrinho = listOf(
        Item("Arroz", 20.0),
        Item("Feijão", 15.0),
        Item("Macarrão", 2.0)
        Item("Bolacha", 7.0)
        Item("Refrigerante", 15.0)
        Item("Chocolate", 10.0)
        Item("Leite", 5.0)
    )

    // 1. Filtrar apenas itens acima de 10 reais
    val itensCaros = carrinho.filter { it.preco > 10.0 }

    // 2. Pegar apenas os nomes e colocar em maiúsculas
    val nomesDestaque = itensCaros.map {it.nome.uppercase()}

    // 3. Somar o valor total de TUDO no carrinho.
    val total = carrinho.sumOf {it.preco}

    println("---Itens Caros (acima de 10 reais)---")
    itensCaros.forEach {println("${it.nome} - R$ ${it.preco}")}

    println
}
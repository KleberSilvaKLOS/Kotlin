// Listas e Filtros com Data classes.
// Vamos criar uma lista de produtos e fazer três operações: filtrar os caros, transoformar os nomes em maiúsculas e calcular o preço total dos produtos.

data class Item(val nome: String, val preco: Double)

fun main() {
    val carrinho = listOf(
        Item("Arroz", 20.0),
        Item("Feijão", 15.0),
        Item("Macarrão", 2.0),
        Item("Bolacha", 7.0),
        Item("Refrigerante", 15.0),
        Item("Chocolate", 10.0),
        Item("Leite", 5.0),
        Item("Café", 30.0),
        Item("Pão", 5.65),
        Item("Carne", 59.60),
        Item("Ovos", 12.10),
        Item("Sabão em pó", 14.49),
        Item("Pneu", 311.19),
        Item("Leite condensado", 5.65),
        Item("Manteiga", 12.40),
        Item("Cerveja", 8.99),
        Item("Vinho", 45.00),
        Item("Frango", 25.00),
        Item("Peixe", 40.00),
        Item("Detergente", 3.50),
        Item("Amaciante", 9.99),
        Item("Camiseta", 29.90),
        Item("Calça", 79.90),
        Item("Tênis", 199.90)           
    )

    // 1. Filtrar apenas itens acima de 10 reais
    val itensCaros = carrinho.filter { it.preco > 50.0 }

    // 2. Pegar apenas os nomes e colocar em maiúsculas
    val nomesDestaque = itensCaros.map {it.nome.uppercase()}

    // 3. Somar o valor total de TUDO no carrinho.
    val total = carrinho.sumOf {it.preco}

    println("---Itens Caros (acima de 50 reais)---")
    itensCaros.forEach {println("${it.nome} - R$ ${it.preco}")}

    println("\n--- Nomes em Destaque (Maiúsculas) ---")
    println(nomesDestaque)

    println("\n--- Valor Total do Carrinho ---")
    println("R$ $total")
}
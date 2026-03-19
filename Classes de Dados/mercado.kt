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

// O QUE ESTAMOS APRENDENDO AQUI?
// 1. "listOf": Cria uma lista imutável (você não pode adicionar itens depois de criada, o que evita bugs acidentais).
// 2. "filter": Cria uma nova lista apenas com o que atende á sua condição (no caso, preço acima de 50 reais).
// 3. "map": Transforma os dados. Aqui, transformamos uma lista de "Item" em uma lista de "String" (os nomes em maiúsculas).
// 4. "it": É o nome para o objeto atual dentro da chave {}. É muito prático!
// 5. "sumOf": Uma função especifica para somar valores numéricos de uma coleção. Aqui, somamos o preço de todos os itens do carrinho."
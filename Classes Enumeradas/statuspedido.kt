// Vamos criar um sistema simples de pedidos (como o que você faria no seu app de finanças ou em um e-commerce) para entender como as Enums guardam dados extras.

// Define a enum com um construtor para guardar uma descrição amigável.

enum class StatusPedido(val descricao: String) {
    AGUARDANDO_PAGAMENTO("O financeiro está processando o boleto/cartão"),
    PROCESSANDO("O produto está sendo embalado"),
    ENVIADO("O produto já saiu para entrega"),
    ENTREGUE("Cliente recebeu o produto");

    // Podemos ter funções dentro da Enum
    fun imprimirResumo() {
        println("Status atual: $name | Info: $descricao")
    }
}

fun main() {
    val meuPedido = StatusPedido.ENVIADO

    // 1. Acessando propriedades da enum
    println("O status do seu pedido é: ${meuPedido.descricao}")

    // 2. Usando com o 'when' (o compilador sabe se você esqueceu algum status!)
    when (meuPedido) {
        StatusPedido.AGUARDANDO_PAGAMENTO -> println("Atneção! Prepare o dinheiro!")
        StatusPedido.ENVIADO -> println("Fique de olho no portão!")
        else -> println("Status vierificado.")
    }

    // 3. Listando todas as opções disponiveis (útil para menus)
    println("\n--- Opções de Status no Sistema ---")
    StatusPedido.entries.forEach { status ->
        println("- ${status.name}")
    }
}

// O QUE APRENDEMOS AQUI

// 1. val descricao: String: Cada item da lista (constante) é obrigado a passar um valor para esse construtor.

// 2. name e ordinal: Toda enum já vem com essas propriedades. name é o nome exato (ex: "ENVIADO") e ordinal é a posição (0,1,2...).file

// 3. Segurança no when: Se você usar uma enum em um when, o Kotlin te avisa se você não tratar todos os casos possíveis. Isso evita bugs gigantescos no futuro.
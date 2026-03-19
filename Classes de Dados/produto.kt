// Data Classes, que são classes usadas para armazenar dados, são uma parte fundamental do Kotlin. 
// Elas fornecem uma maneira conveniente de criar classes que são principalmente usadas.file

// 'data' Antes de 'class' gera automaticamente roString, equals, hashCode e copy.
data class Produto(val nome: String, val preco: Double)

fun main() {
    val p1 = Produto("Fone de Ouvido", 199.99)
    val p2 = Produto("Teclado mecânico", 368.99)
    val p3 = p1.copy(preco = 149.99) // Criando uma cópia de p1 com um preço diferente. O metodo 'copy' permite copiar só o que queremos.file
    
    println("--- Comparação de Objetos ---")
    println("p1 é igual p2? ${p1 == p2}") // false, pois são objetos diferentes

    println("\n--- Exibição Automática (toString) ---")
    println(p1) // Produto(nome=Fone de Ouvido, preco=199.99)

    println("\n--- Produto com desconto (Cópia) ---")
    println(p3) // Produto(nome=Fone de Ouvido, preco=149.99)

    // Destructuring: Você pode "desmontar" a classe em variáveis.file
    val (nomeProduto, precoProduto) = p2
    println("\nExtraido do p2: Nome: $nomeProduto, Preço: $precoProduto")
}

//POR QUE USAR DATA CLASSES?
// 1. Legibilidade: O "println(p1)" já mostra os dados formatados, o que ajuda muito no debug.
// 2. Imutabilidade: É muito comun usarmos "val" em data classes para garantir que os dados não mudem por acidente durante a execução do programa.
// 3. "copy()": Esse método é icrivel. Em vez de alterar um objeto, você cria um novo baseado no antigo, mudando apenas sum detalhe (como o preço no exemplo acima).
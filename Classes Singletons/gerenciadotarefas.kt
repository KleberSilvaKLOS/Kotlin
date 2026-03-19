// Nesse exercico vamos misturar Data class e Singleton.
// Terá tambem uma lista para armazenar e exibir os dados.

// 1. Nossa Data Class (simples e direta)
data class Tarefa(val id: Int, val descricao: String, var concluida: Boolean = false)

// 2. Nosso Singleton (Gerenciador Único)
object RepositorioTarefas {
    private val tarefas = mutableListOf<Tarefa>()

    fun adicionar(tarefa: Tarefa) {
        tarefas.add(tarefa)
        println("Tarefa adicionada: ${tarefa.descricao}")
    }

    fun listarTodas() {
        println("\n--- Lista de Tarefas ---")
        tarefas.forEach { println(it) } // O toString() de Data Class brilha aqui!
    }

    fun concluirTarefa(id: Int) {
        // Procuramos a tarefa e ateramos o status.file
        val tarefa = tarefas.find { it.id == id }
        tarefa?.concluida = true
    }
}

fun main() {
    // Adicionando tarefas ao nosso Singleton
    RepositorioTarefas.adicionar(Tarefa(1, "Estudar Kotlin"))
    RepositorioTarefas.adicionar(Tarefa(2, "Comprar Café"))

    // Marcando uma como concluida.
    RepositorioTarefas.concluirTarefa(1)

    // Exibir Tudo
    RepositorioTarefas.listarTodas()

    // Teste de Cópia (Data Class)
    val tarefaOriginal = Tarefa(3, "Ler um livro")
    val tarefaUrgente = tarefaOriginal.copy(descricao = "Ler um livro AGORA!")

    println("\nCópia alterada: $tarefaUrgente")
}

// O QUE ESTAMOS APRENDENDO AQUI?
// Estado Global: O "RepositorioTarefas" mantém os dados vivos enquanto o programa rodar. Se você acessar ele de qualquer outro 
// arquivo, a lista será a mesma.

// Segurança: Usamos "private val lista" dentro do Singleton para que niguém de fora possa apagar a lista inteira por acidente,
// apenas usar os métodos "adicionar" e "listar".
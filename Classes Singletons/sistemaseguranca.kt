// Imagine um sistema onde você tem um Singleton que controla quem está logado e registra todas as ações (logs). 
// Como o Singleton é único, ele garante que a sessão seja a mesma em qualquer parte do código.

// Nesta atividade, vamos usar:
// 1. **Data Class** para representar um usuário.
// 2. **Singleton** para gerenciar a sessão de segurança e os logs de atividades.
// 3. lógica de cotrole: Validar se o usuário pode ou não realizar ações.

// 1. Repesenta os dados do usuário.
data class Usuario(val id: Int, val nome: String, val nivelAcesso: String)

// 2. Singleton que gerencia a sessão única no sistema
object GerenciadorSessão {
    private var usuarioLogado: Usuario? = null
    private val logs = mutableListOf<String>()

    fun login(usuario: Usuario) {
        usuarioLogado = usuario
        registrarAcao("Usuário ${usuario.nome} (ID: ${usuario.id}) Realizou o login.")
    }

    fun Logout() {
        registrarAcao("Usuário ${usuarioLogado?.nome} Saiu do sistema.")
        usuarioLogado = null
    }

    // Apenas o Singleton pode adicionar ao histórico internamente.
    private fun registrarAcao(mensagem: String) {
        logs.add("[LOG] $mensagem")
    }

    fun realizarAcao(acao: String) {
        if (usuarioLogado !== null) {
            registrarAcao("Ação relaizada: $acao")
            println("Sucesso: $acao executada por ${usuarioLogado?.nome}.")
        } else {
            println("Erro: Você precisa estar logado para realizar: $acao")
        }
    }

    fun imprimirRelatorio() {
        println("\n--- Relatório Final Do Sistema ---")
        if (logs.isEmpty()) {
            println("Nenhuma ação registrada.")
        } else {
            logs.forEach { println(it) }
        }
    }
}


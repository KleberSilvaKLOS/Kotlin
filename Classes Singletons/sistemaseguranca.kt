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

fun main() {
    // Tentando ação sem estar logado
    GerenciadorSessao.realizarAcao("Acessar Banco de Dados") // Deve mostrar erro

    // Criando usuário com Data Classes
    val u1 = Usuario(1, "Alice", "Admin")
    val u2 = Usuario(2, "Bob", "Editor")

    // Realizando login com o singleton
    println("\n--- Iniciando Sessão ---")
    gerenciadorSessao.login(u1) // Alice loga

    // Realizando ações
    GerenciadorSessao.realizarAcao("Atualizar Configurações") // Deve ser permitido
    GerenciadorSessao.realizarAcao("Exportar Relatório Mensal") // Deve ser permitido

    // Trocando de usuário (Simulando persistência do Singleton)
    GerenciadorSessao.logout()
    GerenciadorSessao.login(u2) // Bob loga
    GerenciadorSessao.realizarAcao("Editar Perfil") // Deve ser permitido

    // Verificando todos os logs acumulados no Singleton
    GerenciadorSessao.imprimirRelatorio()
}

// O QUE ESTAMOS APRENDENDO AQUI?
// 1. Estado Persistente: Note que o "GerenciadorSessão" guarda o "historicoAcoes". 
// Mesmo que você mude de usuário ou chame funções diferentes, os logs antigos continuam lá porque o objeto é único 

// 2. Encapsulamento: O "historicoAcoes" é privado. 
// Ninguém no "main" consegue apagar os logs, apenas o próprio Singleton pode adicionar mensagens via "registrarAcao". 
// Isso é um exemplo de encapsulamento, onde controlamos como os dados são acessados e modificados.

// 3. Flexibilidade: Usamos as propriedades do "Usuario" de forma fácil dentro das strings do Singleton.
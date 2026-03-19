// Aqui vamos simular um sistema de configuração onde não faz sentido ter dois objetos diferentes controlando o tema ou o volume.file

// Usamos 'object' em vez de 'class' para criar um Singleton, ou seja, uma classe que só pode ter uma instância.
object ConfiguracaoSistema {
    var nomeDoApp = "MyFinances"
    var volume: Int = 50
    var modoEscuro: Boolean = true

    fun exibirResumo() {
        println("App: $nomeDoApp | Volume: $volume | Dark Mode: $modoEscuro")
    }
}

fun main () {
    // 1. Você NÃO usa "val c = ConfiguracaoSistema()", porque não é uma classe, é um objeto. Você acessa diretamente.
    // 2. Você acessa direto pelo nome do objeto.file
    ConfiguracaoSistema.volume = 80
    ConfiguracaoSistema.exibirResumo()

    // 3. Prova de que é o mesmo objeto:
    val ref1 = ConfiguracaoSistema
    val ref2 = ConfiguracaoSistema

    println("\nSão a mesma instância? ${ref1 === ref2}") // true, pois ambos apontam para o mesmo objeto
}

// O QUE ESTAMOS APRENDENDO AQUI?
// 1. Ponto Único de Verdade: Ótimo para gerenciar estados globais, como sessões de usuário, Configurações ou conexões com banco de dados.
// 2. Thread-Safe: O Kotlin garante que a criação do "Object" seja segura mesmo que várias partes do programa tente acessá-lo ao mesmo tempo.
// 3. Sem Boilerplate: Você economiza umas 10 linhas de código comparado ao Java.file

// DIFERENÇA ENTRE "object" E "companion object":
// "object": É um Singleton independente. Ele sozinho é o objeto, e você acessa diretamente pelo nome.
// "companion object": É um "Singleton" que vive dentro de uma classe. Ele serve para funçoes e variáveis que pertecem á classe, mas você ainda pode criar
// Várias instâncias (objetos) dessa classe.
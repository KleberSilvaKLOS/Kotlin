// Nesse exercício, vamos criar uma classe de Computador que possui uma classe aninhada Processador. O processador é um componente físico, mas aqui ele funcionará apenas como um agrupador de informações.

class Computador(val marca: String) {
  val modelo = "Gamer Pro"

  // Esta é a classe aninhada (Nested Class).
  class Processador {
    val nome = "Intel Core i9"

    fun detalhes() {
      // Tente descomentar a linha abaixo e verá um erro:
      // println("Processador do computador $marca") // ERRO: Não é possível acessar 'marca' aqui, pois Processador é uma classe aninhada, não uma classe interna.

      println("Componente: $nome")
    }
  }
}

fun main() {
  // Para instanciar a classe aninhada, usamos a sintaxe: ClasseExterna.ClasseAninhada()
  // Note que não precisamos criar um "Computadir" primeiro!
  val cpu = Computador.Processador()

  cpu.detalhes()
}

// O QUE ESTAMOS APRENDENDO AQUI?

// 1. independência: Perceba que no 'main' nós instanciamos 'Computador.Processador()' diretamente. Não precissamos de um objeto 'Computador' vivo para criar o 'Processador'.

// 2. Sem acesso à classe pai: Se você tentar acessar a variável marca ou modelo dentro da classe processador, o Kotlin dará erro. Ela é isolada.

// 3. Organização: Usamos isso quando o Processador é um conceito que pertence ao universo do computador, mas não precisa "conversar" com as propriedades dele o tempo todo.
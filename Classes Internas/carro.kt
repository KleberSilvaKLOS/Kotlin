// Cenário: Carro e Motor
// Um motor não faz sentido sozinho e ele precisa saber a potência do carro ao qual pertence.

class Carro(val modelo: String) {
  private val cavalos = 150

  // Usamos 'inner' para dar acesso aos membros da classe Carro
  inner class Motor {
    fun detalhes() {
      // Agora conseguimos acessar 'modelo' e 'cavalos' diretamente!
      println("Motor do modelo: $modelo")
      println("Potência: $cavalos cv")
    }
  }
}

fun main() {
  // REPARA NA DIFERENÇA AQUI!
  // Para criar o Motor, precisamos obrigatoriamente de um Carro antes.
  val meuCarro = Carro("Nissan Sentra")

  // A instância do motor é ligada à instância do carro.
  val motor = meuCarro.Motor()
  println(motor)
  motor.detalhes()

}

// O QUE APRENDEMOS AQUI?

// 1. Acesso Total: A classe Motor, agora lê Modelo e até a variável private val cavalos.

// 2. Dependência de Instância: Você não pode mais fazer Carro.Motor(). O Kotlin exige que você tenha um objeto Carro criado primeiro (meuCarro.Motor()), porque o motor precisa morar dentro de um carro específico.
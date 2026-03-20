

import Gerente// 'abstract' define que essa classe é apenas um molde.
abstract class Funcionario(val nome: String, val salarioBase: Double) {

  // Método Abstrato: Não tem corpo {}, a classe filha DEVE  implementar
  abstract fun calcularBonus(): Double

  // Método Comum: Todas as classes filhas herdam essa lógica pronta
  fun exibirDados() {
    println("Funcionário: $nome | Salário Base: R$ $salarioBase | Bônus: R$ ${calcularBonus()}")
  }
}

// Classe Gerente herda de Funcionario
class Gerente(nome: String, salarioBase: Double) : Funcionario(nome, salarioBase) {
  override fun calcularBonus(): Double {
    return salarioBase * 0.2 // Gerente ganha 20% de bônus.
  
  }
}

// Classe Programador herda de Funcionario
class Programador(nome: String, salarioBase: Double) : Funcionario(nome, salarioBase) {
  override fun calcularBonus(): Double {
    return salarioBase * 0.1 // Programador ganha 10% de bônus.
  }
}

class CEO(nome: String, salarioBase: Double) : Funcionario(nome, salarioBase) {
  override fun calcularBonus(): Double {
    return salarioBase * 0.79 // CEO ganha 79% de bônus.
  }
}

fun main() {
  // val f - Funcionario("Alguém", 1000.0)  // Isso daria Erro!

  val g = Gerente("Gerente", 5000.0)
  val p = Programador("Programador", 3000.0)
  val c = CEO("CEO", 10000.0)

  g.exibirDados()
  p.exibirDados()
  c.exibirDados()

  println("total salario gerente e programador: ${g.salarioBase + p.salarioBase}")
  println("total salario CEO: ${c.salarioBase}")
}

// O QUE APRENDEMOS AQUI?

// 1. Padroniuzação: Você garante que todo Funcionario terá um nome, um salário e, obrigatoriamente, uma forma de calcular bônus.file

// 2. Reuso de Código: A função exibirDados() foi escrita uma única vez na classe abstrata e serviu para todos os tipos de funcionários.
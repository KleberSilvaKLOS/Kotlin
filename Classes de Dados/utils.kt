// Criando uma classe que simula um sistema de criptografia simples.
// Queremos que a chave de criptografia seja a mesma para o sistam inteiro, sem que precise criar um ojeto novo toda vez.

class Criptografia {
    // O Companion Object é usando com um "balcão de informações" da classe.
    companion object {
        private const val CHAVE_MESTRA = "ROCKET-123"
        var totalOperacoes = 0

        fun descriptografar(codigo: String) : String {
            totalOperacoes++
            return if (codigo == "12345") "ACESSO_LIBERADO" else "ACESSO_NEGADO"
        }
    }
}

fun main() {
    //REPARA NISSO: Eu não usei "val c = Criptografia()".
    // Eu chamo direto pelo nome da classe, porque o método é estático (companion object).

    val resultado1 = Criptografia.descriptografar("12345")
    println("Tentativa 1: $resultado1")

    val resultado2 = Criptografia.descriptografar("999")
    println("Tentativa 2: $resultado2")

    println("\nTotal de operações ralizadas no sistema: ${Criptografia.totalOperacoes}")
}
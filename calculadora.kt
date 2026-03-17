// Arquivo: Calculadora.kt
// Desafio 1: Criar uma função infix para calcular distancia.
infix fun Int.distancia(outro: Int): Int {
    val resultado = this - outro
    return if (resultado < 0) -resultado else resultado
}

fun main() {
    val numeroA = 10
    val numeroB = 5

    // Teste a função infix aqui!
    val diff = numeroA distancia numeroB
    
    println("A diferença entre $numeroA e $numeroB é $diff")

}
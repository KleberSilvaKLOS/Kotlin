sealed class Result {
    data class Sucess(val data: String) : Result()
    data class Error(val exception: Exception) : Result()
    data object Loading : Result()
}

fun handleResult(result: Result) {
    println(
        when(result) {
            is Result.Error -> "Houve um erro! ${result.exception.message}"
            Result.Loading -> "Carregando..."
            is Result.Sucess -> "Sucesso! ${result.data}"
        }
    )
}

object Database {

    fun getContacts(): Result {
        return Result.Sucess(data = listOf("Maria", "João", "Pedro").joinToString())
    }

    fun insertContact(contact: String) : Result {
        return Result.Error(exception = IllegalArgumentException("O contato a ser inserido é inválido!"))
    }
}

fun main() {

    val contacts: Result = Database.getContacts()
    val inContactInserted: Result = Database.insertContact(contact = "Ana")

    handleResult(contacts)
    handleResult(inContactInserted)
}

// O Que aprendemos aqui?

// 1. Classes seladas são uma forma de representar um tipo que pode ser um de vários tipos, mas que é restrito a um conjunto específico de tipos. 
// Elas são úteis para modelar situações onde um valor pode ser de diferentes tipos, mas onde esses tipos são conhecidos e limitados.

// 2. Classes seladas são definidas usando a palavra-chave "sealed" e podem conter subclasses que são definidas dentro do mesmo arquivo. 
// Essas subclasses podem ser data classes, classes normais ou objetos.

// 3. Classes seladas são úteis para modelar resultados de operações, como sucesso, erro ou carregamento, como mostrado no exemplo. 
// Isso permite que o código seja mais expressivo e fácil de entender, pois cada tipo de resultado é claramente definido e tratado de forma diferente.
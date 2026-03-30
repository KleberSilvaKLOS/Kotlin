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
// Vamos criar uma classe onde a senha do usuário nunca pode ter menos de 6 caracteres. 
// Se tentaremos criar um usuário com uma senha menor que 6 caracteres, o programa deve lançar uma exceção.
class Usuario {
    var nome: String = ""

    // O segredo está aqui: o Setter customizado.
    var senha: String = ""
        set(value) {
            if (value.length < 6) {
                println("Erro: A senha deve conter pelo menos 6 caracteres.")
            } else {
                println("Senha alterada com sucesso para o usuário $nome.")
            }
        }
}

fun main() {
    val kleber = Usuario()
    kleber.nome = "Kleber Lucas"

    println("--- Teste 1: Senha Curta ---")
    kleber.senha = "123" // Senha curta - deve lançar erro

    println("\n--- Teste 2: Senha Válida ---")
    kleber.senha = "123456" // Senha válida - deve ser aceita

    println("\nNome: ${kleber.nome}")
    println("Senha: ${kleber.senha}")
}

// O QUE ESTAMOS APRENDENDO AQUI?
// 1. **Encapsulamento**: Estamos usando um setter customizado para controlar o acesso à propriedade `senha`. 
// Isso é um exemplo de encapsulamento, onde controlamos como os dados são acessados e modificados.

// *field*: No kotlin, você não acessa a variável diretamente dentro do *set*. Você usa a palavra reservada *field*.
// Se usasse *senha = value*, o código entraria em um loop infinito chamadno o setter de novo.file

// *value*: É o valor que alguém esta tentando atribuir(o que vem depois do = no main)
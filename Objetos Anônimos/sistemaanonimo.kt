// Vamos usar a interfac "Notificavel" que você criou no exercício anterior. Imagine que, em um caso muito específico do seu app, 
// você queira enviar uma notificação apenas para o console de debug, sem precisar criar uma classe "DebugNotificacao".

interface Notificavel {
    fun enviar(mensagem: String)
}

fun main() {
    // Criando um objeto anônimo
    // Nota a sintaxe: "object: NomeDaInterface"
    val logDeSistema = object : Notificavel {
        override fun enviar(mensagem: String) {
            println("[SISTEMA INTERNO]: $mensagem")
        }
    }

    // Usando o objeto como se fosse uma instância comum
    logDeSistema.enviar("Iniciando carregamento de módulos...")
    logDeSistema.enviar("Conexão com banco de dados estabelecida.")
}

// O QUE APRENDEMOS AQUI?

// 1. Listeners e Callbacks: Muito comum em android ou interfaces gráficas (ex: setOnClickListener).
// 2. Teste Rápidos: Quando você precisa de um "Mock" ou um objeto temporário para testar uma função.
// 3. Singleton Temporário: Se você precisa de um objeto com várias propriedades e métodos que só existem dentro de uma função específica.
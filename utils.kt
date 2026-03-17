class Criptografia {
    // O Companion Object é usando com um "balcão de informações" da classe.
    companion object {
        private const val CHAVE_MESTRA = "ROCKET-123"
        var totalOperacoes = 0

        fun descriptografar(codigio: String) : String {
            totalOperacoes++
            return if (codigo == "12345") "ACESSO_LIBERADO" else "ACESSO_NEGADO"
        }
    }
}
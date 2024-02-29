// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

/**
 * Enumeração que representa os níveis de dificuldade de um conteúdo educacional.
 */
enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

/**
 * Classe que representa um usuário.
 * @property nome O nome do usuário.
 */
data class Usuario(val nome: String)

/**
 * Classe que representa um conteúdo educacional.
 * @property nome O nome do conteúdo educacional.
 * @property nivel O nível de dificuldade do conteúdo educacional.
 * @property duracao A duração do conteúdo educacional em minutos.
 */
data class ConteudoEducacional(val nome: String, val nivel: Nivel, val duracao: Int = 60)

/**
 * Classe que representa uma formação, que é um conjunto de conteúdos educacionais.
 * @property nome O nome da formação.
 * @property nivel O nível de dificuldade da formação.
 * @property conteudos A lista de conteúdos educacionais da formação.
 * @property inscritos A lista de usuários inscritos na formação.
 */
data class Formacao(val nome: String, val nivel: Nivel, var conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {

    private var inscritos = mutableListOf<Usuario>()

    /**
     * Método para matricular um ou mais usuários na formação.
     * @param usuarios Os usuários a serem matriculados.
     */
    fun matricular(vararg usuarios: Usuario) {
        for (usuario in usuarios) {
            if (!inscritos.contains(usuario)) {
                inscritos.add(usuario)
            } else {
                println("O usuário ${usuario.nome} já está matriculado.")
            }
        }
    }

    /**
     * Método para adicionar um conteúdo educacional à formação.
     * @param conteudo O conteúdo educacional a ser adicionado.
     */
    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
    }

    /**
     * Método para listar os usuários inscritos na formação.
     */
    fun listarInscritos() {
        println("Inscritos na formação $nome:")
        inscritos.forEach { println(it.nome) }
    }
}


fun main() {
    // Criando alguns conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Programação em Kotlin", Nivel.BASICO, 120)
    val conteudo2 = ConteudoEducacional("Desenvolvimento Android", Nivel.INTERMEDIARIO, 180)
    val conteudo3 = ConteudoEducacional("Arquitetura de Software", Nivel.AVANCADO, 240)

    // Criando uma formação
    val formacao = Formacao("Desenvolvimento Android com Kotlin", Nivel.INTERMEDIARIO)

    // Adicionando conteúdos à formação
    formacao.adicionarConteudo(conteudo1)
    formacao.adicionarConteudo(conteudo2)
    formacao.adicionarConteudo(conteudo3)

    // Criando alguns usuários
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")

    // Matriculando os usuários na formação
    formacao.matricular(usuario1, usuario2)

    // Tentando matricular o mesmo usuário novamente
    formacao.matricular(usuario1)

    // Listando os inscritos na formação
    formacao.listarInscritos()
}
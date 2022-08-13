package colecoes

class Colecoes() {
    private val alunos: List<Aluno>

    init {
        alunos = listOf(
            Aluno("Carlos Alberto", Genero.M, 3.5),
            Aluno("Maria Rita", Genero.F, 5.5),
            Aluno("Pedro Augusto", Genero.M, 10.0),
            Aluno("Júlia Anchieta", Genero.F, 7.8),
            Aluno("Felipe Rocha", Genero.M, 4.0),
            Aluno("Talita Pereira", Genero.F, 9.2),
            Aluno("Marcos Silva", Genero.M, 8.9),
            Aluno("Fabiola Nogueira", Genero.F, 4.5),
            Aluno("Silvero Teixeira", Genero.F, 8.4),
            Aluno("Linda Oliveira", Genero.M, 10.0),
            Aluno("Carol Chaves", Genero.F, 8.3),
            Aluno("Juliano Ávila", Genero.M, 4.8),
            Aluno("Tatiana Junqueira", Genero.F, 10.0),
            Aluno("Ricardo Moraes", Genero.M, 6.5),
            Aluno("Priscila Salgado", Genero.F, 3.8)
        )
    }
    fun iniciar() {
        println("--- Curso Kotlin for Java Developers: Coleções ---")
        listarAlunos()
        somarNotasPorGenero()
        calcularMediaPorGenero()
        listarAprovadosPorGenero()
        listarReprovadosPorGenero()
        contarAlunosPorTamanhoDoNome()
        println("------")
    }
    private fun contarAlunosPorTamanhoDoNome() {
        alunos.groupingBy { it.nome.length  }.eachCount()
            .forEach { (key, value) -> println("$key letras: $value") }
    }
    private fun listarReprovadosPorGenero() {
        println("Alunos reprovados por gênero:")
        println("Feminino:")
        alunos.filter { it.genero == Genero.F && it.media < 6.0 }
            .forEach(::println)
        println("Masculino:")
        alunos.filter { it.genero == Genero.M && it.media < 6.0 }
            .forEach(::println)
    }
    private fun listarAprovadosPorGenero() {
        println("Alunos aprovados por gênero:")
        println("Feminino:")
        alunos.filter { it.genero == Genero.F && it.media >= 6.0 }
            .forEach(::println)
        println("Masculino:")
        alunos.filter { it.genero == Genero.M && it.media >= 6.0 }
            .forEach(::println)
    }
    private fun listarAlunos() {
        println("Alunos matriculados:")
        alunos.forEach(::println)
    }
    private fun somarNotasPorGenero() {
        println("Soma das notas por gênero:")
        val somaFeminina = alunos.filter { it.genero == Genero.F }
            .sumOf { it.media }
        println("Soma feminina: $somaFeminina")
        val somaMasculina = alunos.filter { it.genero == Genero.M }
            .sumOf { it.media }
        println("Soma masculina: $somaMasculina")
    }
    private fun calcularMediaPorGenero() {
        println("Média das notas por gênero:")
        val mediaFeminina = alunos.filter { it.genero == Genero.F }
            .map(Aluno::media)
            .average()
        println("Média feminina: $mediaFeminina")
        val mediaMasculina = alunos.filter { it.genero == Genero.M }
            .map(Aluno::media)
            .average()
        println("Média masculina: $mediaMasculina")
    }
}
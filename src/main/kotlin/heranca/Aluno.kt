package heranca

class Aluno(
    nome: String,
    rg: String,
    cpf: String,
    var idade: Int,
    turma: Turma
): Pessoa(nome, rg, cpf) {
    var turma = turma
        set(value) {
            field = value
            notas.clear()
            setNotas()
        }
    private var notas: HashMap<String, Double> = HashMap()
    private var media = 0.0
        get() {
            calcularMedia()
            return field
        }
    init {
        setNotas()
    }
    private fun setNotas() {
        for (disciplina in turma.disciplinas) {
            notas.put(disciplina.nome, 0.0)
        }
    }
    private fun calcularMedia() {
        var somatorio = 0.0
        for (nota in notas.values) {
            somatorio += nota
        }
        media = somatorio/notas.size
    }
    fun registrarNotas() {
        println("------ Registro de notas para $nome ------")
        println("Digite a nota de cada disciplina:")
        var nota = 0.0
        for (disciplina in notas.keys) {
            print("$disciplina: ")
            nota = readln().toDouble()
            notas.replace(disciplina, nota)
        }
        println("------")
    }
    fun consultarBoletim() {
        println("------ Situação escolar ------")
        println(nome)
        println("Idade: $idade")
        println("Turma: ${turma.descricao}")
        println("Notas:")
        notas.forEach {(disciplina, nota) -> println("$disciplina: $nota")}
        println("Média: $media")
        println("Situação: ${getSituacao()}")
        println("------")
    }
    private fun getSituacao() = if (media >= 7) "Aprovado" else "Reprovado"
    override fun toString(): String {
        return "$nome [RG: $rg, CPF: $cpf, Idade: $idade, Turma: ${turma.descricao}]"
    }
    override fun equals(other: Any?) = (other is Aluno && other.nome == nome && other.cpf == cpf)
}
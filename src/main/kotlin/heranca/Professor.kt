package heranca

class Professor (
    nome: String,
    rg: String,
    cpf: String,
    var area: String,
    var salario: Double
): Pessoa(nome, rg, cpf){
    var turmas = ArrayList<Turma>()
    var disciplinas = ArrayList<Disciplina>()
    fun listarTurmas() {
        println("Professor(a) $nome")
        println("Turmas:")
        turmas.forEach { _ -> println() }
    }
    fun listarDisciplinas() {
        println("Professor(a) $nome")
        println("Disciplinas:")
        disciplinas.forEach { _ -> println() }
    }
    override fun toString(): String {
        return "$nome [RG: $rg, CPF: $cpf, Área: $area, Turmas: ${turmas.size}, Disciplinas: ${disciplinas.size}]"
    }
    override fun equals(other: Any?) = (other is Professor && other.nome == nome && other.cpf == cpf)
}
package heranca

class Turma(
    val codigo: Int,
    val descricao: String,
    val turno: Turno,
    val disciplinas: List<Disciplina>
) {
    override fun toString(): String {
        return "$descricao [#$codigo]"
    }
}
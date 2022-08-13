package heranca

class Funcionario(
    nome: String,
    rg: String,
    cpf: String,
    var cargo: String,
    var salario: Double
): Pessoa(nome, rg, cpf){
    override fun toString(): String {
        return "$nome [RG: $rg, CPF: $cpf, Cargo: $cargo, Salário: R$ $salario]"
    }
    override fun equals(other: Any?) = (other is Funcionario && other.nome == nome && other.cpf == cpf)
}
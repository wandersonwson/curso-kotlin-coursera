package heranca

import java.util.Optional

class Escola (private var nome: String){
    private var alunos = ArrayList<Aluno>()
    private var turmas = ArrayList<Turma>()
    private var professores = ArrayList<Professor>()
    private var funcionarios = ArrayList<Funcionario>()

    fun adicionarAluno(nome: String, rg: String, cpf: String, idade: Int, turma: Turma) {
        val novoAluno = Aluno(nome, rg, cpf, idade, turma)
        val index = getIndexAluno(novoAluno)
        if (index == -1) {
            alunos.add(novoAluno)
            println("Cadastro: novo(a) aluno(a) cadastrado(a)")
        } else {
            atualizarAluno(index, novoAluno)
            println("Atualização: as alterações do(a) aluno(a) foram salvas")
        }
    }
    private fun atualizarAluno(index: Int, novoAluno: Aluno) {
        val aluno = alunos[index]
        aluno.nome = novoAluno.nome
        aluno.rg = novoAluno.rg
        aluno.cpf = novoAluno.cpf
        aluno.idade = novoAluno.idade
        if (aluno.turma.descricao != novoAluno.turma.descricao) aluno.turma = novoAluno.turma
    }
    fun buscarAluno(nome: String, cpf: String): Optional<Aluno> {
        for (aluno in alunos) {
            if (aluno.nome == nome && aluno.cpf == cpf) return Optional.of(aluno)
        }
        return Optional.empty()
    }
    private fun getIndexAluno(novoAluno: Aluno): Int {
        if (alunos.isEmpty()) return -1
        for (aluno in alunos) {
            if (aluno.equals(novoAluno)) return alunos.indexOf(aluno)
        }
        return -1
    }
    fun removerAluno(nome: String, cpf: String) {
        val aluno = buscarAluno(nome, cpf)
        if (aluno.isEmpty) {
            println("Exclusão: aluno(a) não encontrado(a)")
        } else {
            alunos.remove(aluno.get())
            println("O cadastro do(a) aluno(a) ${aluno.get().nome} foi excluído")
        }
    }
    fun consultarBoletimAluno(nome: String, cpf: String) {
        val aluno = buscarAluno(nome, cpf)
        if (aluno.isEmpty) {
            println("Consulta ao boletim: aluno(a) não encontrado(a)")
        } else {
            aluno.get().consultarBoletim()
        }
    }
    fun lancarNotasAluno(nome: String, cpf: String) {
        val aluno = buscarAluno(nome, cpf)
        if (aluno.isEmpty) {
            println("Registro de notas: aluno(a) não encontrado(a)")
        } else {
            aluno.get().registrarNotas()
        }
    }
    fun adicionarProfessor(nome: String, rg: String, cpf: String, area: String, salario: Double) {
        val novoProfessor = Professor(nome, rg, cpf, area, salario)
        val index = getIndexProfessor(novoProfessor)
        if (index == -1) {
            professores.add(novoProfessor)
            println("Cadastro: novo(a) professor(a) cadastrado(a)")
        } else {
            atualizarProfessor(index, novoProfessor)
            println("Atualização: as alterações do(a) professor(a) foram salvas")
        }
    }
    private fun atualizarProfessor(index: Int, novoProfessor: Professor) {
        val professor = professores[index]
        professor.nome = novoProfessor.nome
        professor.rg = novoProfessor.rg
        professor.cpf = novoProfessor.cpf
        professor.area = novoProfessor.area
        professor.salario = novoProfessor.salario
    }
    fun buscarProfessor(nome: String, cpf: String): Optional<Professor> {
        for (professor in professores) {
            if (professor.nome == nome && professor.cpf == cpf) return Optional.of(professor)
        }
        return Optional.empty()
    }
    private fun getIndexProfessor(novoProfessor: Professor): Int {
        if (professores.isEmpty()) return -1
        for (professor in professores){
            if (professor.equals(novoProfessor)) return professores.indexOf(professor)
        }
        return -1
    }
    fun removerProfessor(nome: String, cpf: String) {
        val professor = buscarProfessor(nome, cpf)
        if (professor.isEmpty) {
            println("Exclusão: professor(a) não encontrado(a)")
        } else {
            professores.remove(professor.get())
            println("O cadastro do(a) professor(a) ${professor.get().nome} foi excluído")
        }
    }
    fun definirDisciplinasProfessor(nome: String, cpf: String, disciplinas: ArrayList<Disciplina>) {
        val professor = buscarProfessor(nome, cpf)
        if (professor.isEmpty) {
            println("Registro de disciplinas: professor(a) não encontrado(a)")
        } else {
            professor.get().disciplinas = disciplinas
            println("Registro de disciplinas: lista de ${professor.get().nome} atualizada")
        }
    }
    fun definirTurmasProfessor(nome: String, cpf: String, turmas: ArrayList<Turma>) {
        val professor = buscarProfessor(nome, cpf)
        if (professor.isEmpty) {
            println("Registro de turmas: professor(a) não encontrado(a)")
        } else {
            professor.get().turmas = turmas
            println("Registro de turmas: lista de ${professor.get().nome} atualizada")
        }
    }
    fun adicionarFuncionario(nome: String, rg: String, cpf: String, cargo: String, salario: Double) {
        val novoFuncionario = Funcionario(nome, rg, cpf, cargo, salario)
        val index = getIndexFuncionario(novoFuncionario)
        if (index == -1) {
            funcionarios.add(novoFuncionario)
            println("Cadastro: novo(a) funcionário(a) cadastrado(a)")
        } else {
            atualizarFuncionario(index, novoFuncionario)
            println("Atualização: as alterações do(a) funcionário(a) foram salvas")
        }
    }
    private fun atualizarFuncionario(index: Int, novoFuncionario: Funcionario) {
        val funcionario = funcionarios[index]
        funcionario.nome = novoFuncionario.nome
        funcionario.rg = novoFuncionario.rg
        funcionario.cpf = novoFuncionario.cpf
        funcionario.cargo = novoFuncionario.cargo
        funcionario.salario = novoFuncionario.salario
    }
    fun buscarFuncionario(nome: String, cpf: String): Optional<Funcionario> {
        for (funcionario in funcionarios) {
            if (funcionario.nome == nome && funcionario.cpf == cpf) return Optional.of(funcionario)
        }
        return Optional.empty()
    }
    fun getIndexFuncionario(novoFuncionario: Funcionario): Int {
        if (funcionarios.isEmpty()) return -1
        for (funcionario in funcionarios) {
            if (funcionario.equals(novoFuncionario)) return funcionarios.indexOf(funcionario)
        }
        return -1
    }
    fun removerFuncionario(nome: String, cpf: String) {
        val funcionario = buscarFuncionario(nome, cpf)
        if (funcionario.isEmpty) {
            println("Exclusão: funcionário(a) não encontrado(a)")
        } else {
            funcionarios.remove(funcionario.get())
            println("O cadastro do(a) funcionário(a) ${funcionario.get().nome} foi excluído")
        }
    }
    fun adicionarTurma(codigo: Int, descricao: String, turno: Turno, disciplinas: ArrayList<Disciplina>) {
        val novaTurma = Turma(codigo, descricao, turno, disciplinas)
        turmas.add(novaTurma)
        println("Cadastro: nova turma cadastrada")
    }
    fun buscarTurma(codigo: Int): Optional<Turma> {
        for (turma in turmas){
            if (turma.codigo == codigo) return Optional.of(turma)
        }
        return Optional.empty()
    }
    fun listarDados() {
        println("------ $nome ------")
        println("Nº de alunos: ${alunos.size}")
        println("Nº de turmas: ${turmas.size}")
        println("Nº de professores: ${professores.size}")
        println("Nº de funcionários: ${funcionarios.size}")
        println("------")
    }
    fun listarAlunos() {
        println("------ $nome ------")
        println("Alunos:")
        alunos.forEach(::println)
        println("------")
    }
    fun listarTurmas() {
        println("------ $nome ------")
        println("Turmas:")
        turmas.forEach(::println)
        println("------")
    }
    fun listarProfessores() {
        println("------ $nome ------")
        println("Professores:")
        professores.forEach(::println)
        println("------")
    }
    fun listarFuncionarios() {
        println("------ $nome ------")
        println("Funcionários:")
        funcionarios.forEach(::println)
        println("------")
    }
}
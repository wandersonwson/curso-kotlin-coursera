package colecoes

class Aluno (var nome: String, var genero: Genero, var media: Double){
    override fun toString(): String {
        return "$nome [Gênero: $genero, Média: $media]"
    }
}
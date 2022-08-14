package abstracao

class Vampiro(nome: String, score: Int): Personagem(nome, 20, score) {
    override fun atacar() {
        println("$nome: Causei 20 de dano.")
        println("$nome: Seu personagem está sangrando!")
    }
    override fun apanhar(dano: Int, tipoDano: Dano) {
        if (statusDeVida) {
            if (tipoDano == Dano.PERFURANTE){
                score -= dano*2
                println("$nome: Recebi ${dano*2} de dano.")
            } else {
                score -= dano
                println("$nome: Recebi $dano de dano.")
            }
        } else {
            println("$nome: Que pena, não resisti aos ataques dos meus inimigos.")
        }
        setCondicaoDeVida()
    }
    override fun interagir() {
        println("$nome: O que é um homem?")
    }
}
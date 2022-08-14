package abstracao

class Gigante(nome: String, score: Int): Personagem(nome, 25, score) {
    override fun atacar() {
        println("$nome: Causei 25 de dano.")
        println("$nome: Seu personagem está atordoado!")
    }
    override fun apanhar(dano: Int, tipoDano: Dano) {
        if (statusDeVida) {
            if (tipoDano == Dano.FOGO){
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
        println("$nome: Me desculpe.")
    }
}
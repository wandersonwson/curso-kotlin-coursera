package abstracao

class Cobra(nome: String, score: Int): Personagem(nome, 10, score) {
    override fun atacar() {
        println("$nome: Causei 10 de dano.")
        println("$nome: Seu personagem está envenenado!")
    }
    override fun apanhar(dano: Int, tipoDano: Dano) {
        if (statusDeVida) {
            if (tipoDano == Dano.PANCADA){
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
        println("$nome: Se você acender a chama a maldição acaba.")
    }
}
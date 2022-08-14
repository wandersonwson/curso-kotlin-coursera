package abstracao

abstract class Personagem(protected var nome: String, protected val DANO: Int, protected var score: Int){
    protected var statusDeVida = true
    fun getDano() = DANO
    abstract fun atacar()
    abstract fun apanhar(dano: Int, tipoDano: Dano)
    abstract fun interagir()
    fun setCondicaoDeVida() {
        statusDeVida = (score <= 0)
    }
}
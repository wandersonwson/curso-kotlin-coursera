package abstracao

class CampoDeBatalha {
    private val cobra: Personagem
    private val gigante: Personagem
    private val vampiro: Personagem
    init {
        cobra = Cobra("Ananconda", 200)
        gigante = Gigante("Golias", 250)
        vampiro = Vampiro("Conde Dracula", 230)
    }
    fun realizarAtaque(atacante: TipoDePersonagem, vitima: TipoDePersonagem, tipoDano: Dano) {
        println("--- Ataque ---")
        getPersonagem(atacante).atacar()
        getPersonagem(vitima).apanhar(getPersonagem(atacante).getDano(), tipoDano)
    }
    fun realizarInteracao(emissor: TipoDePersonagem, receptor: TipoDePersonagem) {
        println("--- Interação ---")
        getPersonagem(emissor).interagir()
        getPersonagem(receptor).interagir()
    }
    fun getPersonagem(tipoDePersonagem: TipoDePersonagem): Personagem {
        return when(tipoDePersonagem) {
            TipoDePersonagem.COBRA -> cobra
            TipoDePersonagem.GIGANTE -> gigante
            TipoDePersonagem.VAMPIRO -> vampiro
        }
    }
}
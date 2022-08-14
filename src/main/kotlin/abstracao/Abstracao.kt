package abstracao

class Abstracao {
    fun iniciar() {
        val hogwarts = CampoDeBatalha()
        //Ataque
        hogwarts.realizarAtaque(TipoDePersonagem.VAMPIRO, TipoDePersonagem.GIGANTE, Dano.PANCADA)
        hogwarts.realizarAtaque(TipoDePersonagem.COBRA, TipoDePersonagem.VAMPIRO, Dano.PERFURANTE)
        hogwarts.realizarAtaque(TipoDePersonagem.GIGANTE, TipoDePersonagem.COBRA, Dano.FOGO)
        //Interação
        hogwarts.realizarInteracao(TipoDePersonagem.COBRA, TipoDePersonagem.VAMPIRO)
        hogwarts.realizarInteracao(TipoDePersonagem.GIGANTE, TipoDePersonagem.COBRA)
        hogwarts.realizarInteracao(TipoDePersonagem.VAMPIRO, TipoDePersonagem.COBRA)
    }
}
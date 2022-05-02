//Henrique Vinícius Haag
/*Deixar essa classe pequena assim foi difícil, era muito tentador sempre fazer algum menu ou imagem direto aqui para acelerar o processo. 
   Mas é só isso que ela faz, cria o jogo, abre a tela inicial, e permite que ele rode, fora isso ela não faz mais nada. */
public class Principal{
    public static void main(String[] args){
        Jogo jogo1 = new Jogo();
        jogo1.telaInicial();
    }
}
//Henrique Vinícius Haag
// Essa classe é meu playground, eu usei ela só pra testas os métodos das outras classes e as features
public class PrincipalTeste{
    public static void main(String[] args){
        Dados dado1 = new Dados("Verde");
        
        System.out.println(dado1.roladaDado());
        
        Jogador jogador1 = new Jogador("Robertinho");
        System.out.println(jogador1.getDVermelho().getCor());
        
        
        Jogo teste = new Jogo();
        teste.comecaJogo();
        //teste.resetaJogo();
        teste.jogaDadosP1();
        teste.jogaDadosP2();
        teste.jogaDadosP1();
        teste.passaRodada();
        teste.jogaDadosP1();
        teste.jogaDadosP2();
        teste.resultado();
        /*teste.jogaDadosP1();
        teste.jogaDadosP1();
        teste.jogaDadosP1();
        teste.jogaDadosP1();
        teste.jogaDadosP1();
        teste.jogaDadosP1();
        teste.jogaDadosP1();*/
        //teste.passaRodada();
        //teste.jogaDadosP2();
    }
}
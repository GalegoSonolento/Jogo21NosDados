//Henrique Vinícius Haag
public class Jogo{
    private Jogador player1, player2; //Atributos da classe, esses jogadores aqui são as chaves para fazer o jogo funcionar

    public Jogo(){
        //Esse código já existe por natureza, ele não seria necessário, mas criei mesmo assim para ficar mais legível (e para eu não me perder também)
    }
    
    public void comecaJogo(){ //Esse é o sistema que inicia o jogo de verdade,ele cria os objetos jogadores e permite o sistema funcionar
        System.out.println("Novo jogo! Escreva o nome dos jogadores: ");
        this.player1 = new Jogador(Teclado.leString("Nome do jogador 1: "));
        this.player2 = new Jogador(Teclado.leString("Nome do jogador 2: "));
    }
    
    public void resetaJogo(){ /*Para o caso de algo dar errado, esse método pode ser chamado a qualquer hora durante o jogo e, uma vez que cria objetos 
        novos e os atribui aos atributos, todo o desenvolvimento anterior é descartado*/
        System.out.println("Jogo resetado! Reescreva o nome dos jogadores: ");
        this.player1 = new Jogador(Teclado.leString("Nome do jogador 1: "));
        this.player2 = new Jogador(Teclado.leString("Nome do jogador 2: "));
    }
    
    public void rodaJogo(){
        for (int i=1; i<=3; i++){
                    System.out.println("-=-=-=-= "+i+"° RODADA!"+" -=-=-=-=");
                    System.out.println("--- AÇÃO DO "+player1.getNome()+"---");
                    while (true){
                        System.out.println("Pressione: "+"\n"+
                        "1 - Pular a rodada"+"\n"+
                        "2 - Jogar os dados");
                        int escolha = Teclado.leInt("Digite sua escolha: ");
                        if (escolha == 1){
                            passaRodada();
                            break;
                        }
                        else if (escolha == 2){
                            jogaDadosP1();
                            break;
                        }
                        else System.out.println("Escolha inválida!");
                    }
                    System.out.println("--- AÇÃO DO "+player2.getNome()+"---");
                    while (true){
                        System.out.println("Pressione: "+"\n"+
                        "1 - Pular a rodada"+"\n"+
                        "2 - Jogar os dados");
                        int escolha = Teclado.leInt("Digite sua escolha: ");
                        if (escolha == 1){
                            passaRodada();
                            break;
                        }
                        else if (escolha == 2){
                            jogaDadosP2();
                            break;
                        }
                        else System.out.println("Escolha inválida!");
                    }
                }
    }
    
    public void passaRodada() { //Simplesmente pula a rodada. Aqui ele não faz nada, mas no menu ele conta como ação e continua o jogo
    	System.out.println("Rodada pulada!");
    }
    
    /*As próximas duas classes são o coração do game, elas fazem o principal do jogo: jogar dados e adicioná-los ao total de pontos obtidos pelos 
    jogadores. Quantas vezes elas vão rodar e quando erão chamadas dependerá das ações do player no menu do jogo, que está montado na classe principal*/
    public void jogaDadosP1() {
    	int valorBranco = player1.getDBranco().roladaDado();
    	System.out.println(player1.getNome()+" tirou "+valorBranco+" no dado branco");
    	player1.setPontos(player1.getPontos()+valorBranco);
    	int valorRed = player1.getDVermelho().roladaDado();
    	if (valorRed == 6) {
    		valorRed = valorRed * 2;
    		System.out.println(player1.getNome()+" tirou  6 no dado! Seu valor dobra!");
    	}
    	else System.out.println(player1.getNome()+" tirou "+valorRed+" no dado vermelho");
    	player1.setPontos(player1.getPontos()+valorRed);
    	System.out.println(player1.getNome()+" tem "+player1.getPontos()+" pontos!");
    }
    public void jogaDadosP2() {
    	int valorBranco = player2.getDBranco().roladaDado();
    	System.out.println(player2.getNome()+" tirou "+valorBranco+" no dado branco");
    	player2.setPontos(player2.getPontos() + valorBranco);
    	int valorRed = player2.getDVermelho().roladaDado();
    	if (valorRed == 6) {
    		valorRed = valorRed * 2;
    		System.out.println(player2.getNome()+" tirou  6 no dado! Seu valor dobra!");
    	}
    	else System.out.println(player2.getNome()+" tirou "+valorRed+" no dado vermelho");
    	player2.setPontos(player2.getPontos()+valorRed);
    	System.out.println(player2.getNome()+" tem "+player2.getPontos()+" pontos!");
    }
    
    public void resultado() { //Aqui é onde todo o trabalho culmina. Ele analisa os pontos e descreve o vencedor
    	String resultado = "";
    	System.out.println(player1.getNome()+" fez "+player1.getPontos()+" pontos totais!");
    	System.out.println(player2.getNome()+" fez "+player2.getPontos()+" pontos totais!");
    	if (player1.getPontos() > 21 && player2.getPontos() > 21) resultado = "Os jogadores empataram!";
    	else if (player1.getPontos() == player2.getPontos()) resultado = "Os jogadores empataram!";
    	else if (player1.getPontos() <= 21 && player2.getPontos() <= 21) {
    		if (player1.getPontos() < player2.getPontos()) resultado = player2.getNome()+" venceu!";
    		else if (player1.getPontos() > player2.getPontos()) resultado = player1.getNome()+" venceu!";
    	}
    	else {
    		if (player1.getPontos() > 21) resultado = player2.getNome()+" venceu!";
    		else if (player2.getPontos() > 21) resultado = player1.getNome()+" venceu!";
    	}
    	System.out.println(resultado+"\n"+"");
    	System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠛⠛⠛⠋⠉⠈⠉⠉⠉⠉⠛⠻⢿⣿⣿⣿⣿⣿⣿⣿"+"\n"+
                            "⣿⣿⣿⣿⣿⡿⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⢿⣿⣿⣿⣿"+"\n"+
                            "⣿⣿⣿⣿⡏⣀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣤⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠙⢿⣿⣿"+"\n"+
                            "⣿⣿⣿⢏⣴⣿⣷⠀⠀⠀⠀⠀⢾⣿⣿⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿"+"\n"+
                            "⣿⣿⣟⣾⣿⡟⠁⠀⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣷⢢⠀⠀⠀⠀⠀⠀⠀⢸⣿"+"\n"+
                            "⣿⣿⣿⣿⣟⠀⡴⠄⠀⠀⠀⠀⠀⠀⠙⠻⣿⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⣿"+"\n"+
                            "⣿⣿⣿⠟⠻⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠶⢴⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⣿"+"\n"+
                            "⣿⣁⡀⠀⠀⢰⢠⣦⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⣿⣿⣿⣿⣿⡄⠀⣴⣶⣿⡄⣿"+"\n"+
                            "⣿⡋⠀⠀⠀⠎⢸⣿⡆⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣿⣿⣿⠗⢘⣿⣟⠛⠿⣼"+"\n"+
                            "⣿⣿⠋⢀⡌⢰⣿⡿⢿⡀⠀⠀⠀⠀⠀⠙⠿⣿⣿⣿⣿⣿⡇⠀⢸⣿⣿⣧⢀⣼"+"\n"+
                            "⣿⣿⣷⢻⠄⠘⠛⠋⠛⠃⠀⠀⠀⠀⠀⢿⣧⠈⠉⠙⠛⠋⠀⠀⠀⣿⣿⣿⣿⣿"+"\n"+
                            "⣿⣿⣧⠀⠈⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠟⠀⠀⠀⠀⢀⢃⠀⠀⢸⣿⣿⣿⣿"+"\n"+
                            "⣿⣿⡿⠀⠴⢗⣠⣤⣴⡶⠶⠖⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡸⠀⣿⣿⣿⣿"+"\n"+
                            "⣿⣿⣿⡀⢠⣾⣿⠏⠀⠠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠛⠉⠀⣿⣿⣿⣿"+"\n"+
                            "⣿⣿⣿⣧⠈⢹⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣿"+"\n"+
                            "⣿⣿⣿⣿⡄⠈⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣾⣿⣿⣿⣿⣿"+"\n"+
                            "⣿⣿⣿⣿⣧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿"+"\n"+
                            "⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿"+"\n"+
                            "⣿⣿⣿⣿⣿⣦⣄⣀⣀⣀⣀⠀⠀⠀⠀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿"+"\n"+
                            "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡄⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿"+"\n"+
                            "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠙⣿⣿⡟⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿"+"\n"+
                            "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠁⠀⠀⠹⣿⠃⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿"+"\n"+
                            "⣿⣿⣿⣿⣿⣿⣿⣿⡿⠛⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⢐⣿⣿⣿⣿⣿⣿⣿⣿⣿"+"\n"+
                            "⣿⣿⣿⣿⠿⠛⠉⠉⠁⠀⢻⣿⡇⠀⠀⠀⠀⠀⠀⢀⠈⣿⣿⡿⠉⠛⠛⠛⠉⠉"+"\n"+
                            "⣿⡿⠋⠁⠀⠀⢀⣀⣠⡴⣸⣿⣇⡄⠀⠀⠀⠀⢀⡿⠄⠙⠛⠀⣀⣠⣤⣤⠄");
    }
    
    public void imprimeRegras(){
        System.out.println("Simples. Neste jogo podem jogar quantos jogadores desejarem, cada um com dois dados: um"+"\n"+
                            "branco e um vermelho. Todos os jogadores começam com 0 pontos. O jogo é dividido em 3 rodadas."+"\n"+
                            "A cada rodada, cada jogador tem a opção de escolher se vai jogar o dado ou passar a vez:"+"\n"+
                            "   • Se o jogador passar a vez, não joga os dados"+"\n"+
                            "   • Se o jogador escolher jogar os dados, joga primeiro o dado branco. O valor do dado"+"\n"+
                            "     branco soma-se aos pontos que ele possui (por exemplo, se o jogador tinha 5 pontos e tirou 3 no"+"\n"+
                            "     dado branco, agora ele tem 8 pontos). Logo em seguida, o jogador joga o dado vermelho. Se o"+"\n"+
                            "     valor do dado vermelho for 6, este valor é duplicado e somado aos pontos que ele já possui (por"+"\n"+
                            "     exemplo, se o jogador tinha 8 pontos após jogar o dado branco, e tirou 6 no dado vermelho, ele"+"\n"+
                            "     agora tem 8 + (2 x 6) = 20 pontos). Qualquer outro valor no dado vermelho é simplesmente"+"\n"+
                            "     somado aos pontos do jogador, assim como o dado branco."+"\n"+""+"\n"+
                            "Depois que um jogador passa a vez ou joga os dois dados, é a vez do outro escolher se joga ou se"+"\n"+
                            "passa a vez, e assim o jogo continua. Uma rodada termina quando todos os jogadores fizerem sua ação"+"\n"+
                            "(seja esta ação passar a vez ou jogar). O jogo termina após 3 rodadas."+"\n"+""+"\n"+
                            "Após as 3 rodadas, o resultado do jogo é o seguinte:"+"\n"+
                            "   ▪ o jogador que passar de 21 pontos perde (se todos passarem, o jogo empata)."+"\n"+
                            "   ▪ se nenhum dos jogadores passar dos 21 pontos, o que mais se aproximar de 21 pontos ganha"+"\n"+
                            "     (caso mais de um jogador faça o mesmo número de pontos, o jogo termina empatado)");
    }
    
    public void creditos(){
        System.out.println("Henrique Vinicius Haag"+"\n"+
        "2022"+"\n"+
        "Trabalho de algorítmos e programação: fundamentos - Universidade do Vale do Rio dos Sinos (Unisinos)"+"\n"+
        "Projeto reailzado dentro das normas impostas pela matéria."+"\n"+
        "Todos os direitos reservados®");
    }
    
    //Apenas dois getters que precisei criar a fim de acessar os nomes dos jogadores mais facilmente dentro do menu
    public String getPlayer1(){
        return player1.getNome();
    }
    public String getPlayer2(){
        return player2.getNome();
    }
    
    public void easterEgg(){
        System.out.println( "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠻⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿"+"\n"+
                            "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠁⠄⠄⠄⠄⠈⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿"+"\n"+
                            "⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠁⠄⠄⠄⠄⠄⠄⠄⠄⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿"+"\n"+
                            "⣿⣿⣿⣿⣿⣿⣿⡿⠋⠄⠄⠄⢠⣶⣶⣶⣶⡄⠄⠄⠄⠙⠻⣿⣿⣿⣿⣿⣿⣿"+"\n"+
                            "⣿⣿⣿⣿⣿⠟⠁⠄⠄⠄⠄⠄⠈⠛⠚⠛⠚⠁⡀⠄⠄⠄⠄⠈⠻⢿⣿⣿⣿⣿"+"\n"+
                            "⣿⣿⣿⡟⠁⠄⠄⠄⠄⠄⠄⠐⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠙⢿⣿⣿"+"\n"+
                            "⣿⣿⠏⠄⠄⡀⠄⠄⠄⠄⠄⢠⡄⠄⠄⠄⠄⠄⣆⠄⠄⠄⠄⠄⠄⡀⠄⠘⣿⣿"+"\n"+
                            "⣿⣟⠄⢠⣾⠄⠄⠄⠄⠄⠄⣼⡇⠄⠄⠄⠄⢰⣿⣆⠄⠄⠄⠄⠄⢻⣆⠄⢹⣿"+"\n"+
                            "⣿⠄⣰⣿⣿⡄⠂⠄⠄⢀⣼⣿⣿⡀⠄⠄⢀⣾⣿⣿⣧⡀⠄⠄⠄⣾⣿⣆⠄⣿"+"\n"+
                            "⣿⣴⣿⣿⣿⣧⠄⠄⢠⣾⣿⣿⣿⣿⣶⣶⣿⣿⣿⣿⣿⣷⠄⠄⣼⣿⣿⣿⣦⣸"+"\n"+
                            "⣿⣿⣿⣿⣿⣿⣿⠄⠈⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠄⣿⣿⣿⣿⣿⣿⣿"+"\n"+
                            "⣿⣿⣿⣿⣿⣿⡟⠄⠄⠄⠈⠛⠻⠿⣿⣿⠿⠿⠛⠋⠄⠄⠄⢹⣿⣿⣿⣿⣿⣿"+"\n"+
                            "⣿⣿⣿⣿⣿⣿⣧⠄⠄⠄⠄⠄⠄⠄⣰⣶⠄⠄⠄⠄⠄⠄⠄⣸⣿⣿⣿⣿⣿⣿"+"\n"+
                            "⣿⣿⣿⣿⣿⣿⣿⣷⣦⣤⣀⣀⣀⣤⣿⣿⣦⣄⣀⣠⣤⣤⣾⣿⣿⣿⣿⣿⣿⣿");
    }
}

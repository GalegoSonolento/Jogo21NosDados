//Henrique Vinícius Haag
public class Jogo{
    private Jogador player1, player2; //Atributos da classe, esses jogadores aqui são as chaves para fazer o jogo funcionar

    public Jogo(){
        //Esse código já existe por natureza, ele não seria necessário, mas criei mesmo assim para ficar mais legível (e para eu não me perder também)
    }
    
    /* Imagem do menu, uma das várias coisas que eu quebrei a fim de facilitar a leitura dos métodos que realmente englobam a lógica do jogo*/
    public void imagemDeMenu(){
        System.out.println("______  ________________   ______  __   "+"\n"+
                           " ___   |/  /__  ____/__  | / /_  / / /   "+"\n"+
                           " __  /|_/ /__  __/  __   |/ /_  / / /    "+"\n"+
                           " _  /  / / _  /___  _  /|  / / /_/ /     "+"\n"+
                           " /_/  /_/  /_____/  /_/ |_/  |____/      ");
                                        
    }
    
    /*É o método do menu do jogo. O que ele faz é basicamente associar as escolhas do jogador aos métodos corretos. */
    public void funcionamentoDoJogo(){
        int opcao = -1;
        do{
            imagemDeMenu();
            System.out.println("O que deseja fazer a seguir?"+"\n"+
            "1 - Regras"+"\n"+
            "2 - Começar"+"\n"+
            "3 - Créditos"+"\n"+
            "4 - Resetar os jogadores"+"\n"+
            "5 - Sair");
            opcao = Teclado.leInt("Digite sua opção (apenas números): ");
            if (opcao == 1) {
                imprimeRegras();
                System.out.println(""+"\n"+""+"\n");
                char escolha = Teclado.leChar("Deseja voltar ao menu?(S/N) ");
                if (escolha == 'N') break;
            }
            else if (opcao == 2){
                rodaJogo();
                System.out.println(""+"\n"+""+"\n");
                char escolha = Teclado.leChar("Deseja voltar ao menu?(S/N) ");
                if (escolha == 'N') break;
            }
            else if (opcao == 3){
                creditos();
                System.out.println(""+"\n"+""+"\n");
                char escolha = Teclado.leChar("Deseja voltar ao menu?(S/N) ");
                if (escolha == 'N') break;
            }
            else if (opcao == 4){
                break;
            }
            else if (opcao == 5)
                break;
            else if (opcao == 55413){//Isso aqui é só um easter egg
                easterEgg();
                System.out.println(""+"\n"+""+"\n");
                char escolha = Teclado.leChar("Deseja voltar ao menu?(S/N) ");
                if (escolha == 'N') break;
            }
            else {
                System.out.println("Escolha inválida!");
                System.out.println("Retornando ao menu..."); 
                try{
                     Thread.sleep(1000);
                }catch(Exception e){}
            }
        }while (true);
        if (opcao == 4) comecaJogo();
    }
    
    public void comecaJogo(){ //Esse é o sistema que inicia o jogo de verdade,ele cria os objetos jogadores e permite o sistema funcionar
        System.out.println("Novo jogo!");
        System.out.println("Digite o nome dos jogadores: ");
        this.player1 = new Jogador(Teclado.leString("Nome do jogador 1: "));
        this.player2 = new Jogador(Teclado.leString("Nome do jogador 2: "));
        funcionamentoDoJogo();
    }
    
    /*Esse método tinha uma função mais forte na primeira versão, mas ela ficou bem bugada e não valia a pena. Acabou que ela serviu para mudar os 
       nomes dos jogadores enquanto eles estivessem no menu.*/
    public void resetaJogo(){ 
        System.out.println("Jogo resetado!");
        comecaJogo();
    }
    
    /*Mais um dos métodos criados especificamente para facilitar a leitura do código. A única coisa que ele faz é dar tchau e imprimir esse ASCII gigante 
       Sans.*/
    public void acabaJogo(){
      System.out.println("Obrigado por jogar!"+"\n"+"");
      System.out.println("              ██████████████████                                                                                      "+"\n"+
                         "           ████                  ████                                                                                  "+"\n"+
                         "         ██                          ██                                                                                "+"\n"+
                         "         ██                          ██                                                                                "+"\n"+
                         "       ██░░                          ░░▓▓                                                                              "+"\n"+
                         "   ░░  ██  ░░░░                        ██                                                                              "+"\n"+
                         "   ░░░░░░░░░░░░░░░░          ▓▓▓▓▓▓    ██                                                                              "+"\n"+
                         " ░░░░░░░░░░░░░░░░░░░░        ██████    ██                                                                              "+"\n"+
                         "     ░░██░░  ░░░░░░    ██    ██████    ██                                                                              "+"\n"+
                         "       ░░▓▓  ░░      ▓▓████          ▓▓                                                                                "+"\n"+
                         "       ████  ██                  ██  ████        ████████                      ██  ██                                  "+"\n"+
                         "       ██    ██████████████████████    ██        ██                            ██  ██                                  "+"\n"+
                         "       ██      ██  ██  ██  ██  ██      ██        ██  ▓▓▓▓  ▓▓▓▓▓▓  ██▓▓▓▓  ▓▓▓▓██  ██▓▓▓▓  ▓▓  ██  ▓▓▓▓▓▓              "+"\n"+
                         "       ▒▒████    ██████████████    ████▒▒        ██    ██  ██  ██  ██  ██  ██  ██  ██  ██  ██  ██  ██  ██              "+"\n"+
                         "     ▒▒▒▒▒▒▒▒████      ▓▓  ▓▓  ████▒▒▒▒▒▒▒▒      ████████  ██████  ██████  ██████  ██████  ██████  ██████              "+"\n"+
                         "   ░░▒▒██▒▒▒▒▓▓▓▓██████████████▓▓▓▓▒▒▒▒██▒▒                                                    ██  ██                  "+"\n"+
                         "     ░░░░██████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████  ██      ████████████████████████████████████████  ██████  ██████    ██  ██  ██"+"\n"+
                         "  ░░░░  ██  ▓▓██████▒▒▒▒▒▒██████    ██  ██▓▓                                                                          "+"\n"+
                         "   ██      ██▓▓▓▓▓▓    ██    ██    ██      ██░░                                                                        "+"\n"+
                         " ██    ████  ████▓▓▓▓▓▓      ██████  ████  ░░░░                                                                        "+"\n"+
                         " ██        ██    ██▓▓▓▓▓▓  ████    ██        ░░░░                                                                      "+"\n"+
                         " ██          ██  ██    ▓▓▓▓  ██  ██          ██                                                                        "+"\n"+
                         "   ██      ██    ████████▓▓▓▓▓▓▓▓  ██      ██                                                                          "+"\n"+
                         "     ▓▓▓▓  ██    ████████████▓▓    ██  ▓▓▓▓                                                                            "+"\n"+
                         "       ██████    ██████████████    ██████                                                                              "+"\n"+
                         "       ██████████████████████████████████                                                                              "+"\n"+
                         "     ██████████████████████████████████████                                                                            "+"\n"+
                         "     ██████████████████  ██████████████████                                                                            "+"\n"+
                         "       ██████████████      ██████████████                                                                              "+"\n"+
                         "   ██████          ██      ██          ██████                                                                          "+"\n"+
                         "   ██            ████      ████            ██                                                                          "+"\n"+
                         "     ▓▓▓▓▓▓▓▓▓▓▓▓              ▓▓▓▓▓▓▓▓▓▓▓▓                                                                            ");
    }
    
    /*Esse é o método que tem a lógica do jogo de verdade, ele culmina os métodos importantes e faz o jogo rodar basicamente. NA primeira versão ele tinha
       uma pargunta de continue após cada rolada de dados, mas ela ficou bugada depois de um tempo (tive problemas de loop infinito). 
       Enfim, Aqui o jogador vai passar a maior parte do tempo dele.*/
    public void rodaJogo(){
        player1.setPontos(0);
        player2.setPontos(0);
        char decisao = 's';
        for (int i=1; i<=3; i++){
                    System.out.println("");
                    System.out.println("-=-=-=-= "+i+"° RODADA!"+" -=-=-=-=");
                    System.out.println("Turno do "+player1.getNome()+" em 3...");
                    try{
                         Thread.sleep(1000);
                    }catch(Exception e){}
                    System.out.println("2...");
                    try{
                         Thread.sleep(1000);
                    }catch(Exception e){}
                    System.out.println("1...");
                    try{
                         Thread.sleep(1000);
                    }catch(Exception e){}
                    System.out.println("--- AÇÃO DO "+player1.getNome()+"---");
                    while (true){
                        System.out.println("Pressione: "+"\n"+
                        "1 - Pular a rodada"+"\n"+
                        "2 - Jogar os dados");
                        int escolha = Teclado.leInt("Digite sua escolha: ");
                        if (escolha == 1) {
                            passaRodada();
                            break;
                        }
                        else if (escolha == 2) {
                            jogaDadosP1();
                            break;
                        }
                        else System.out.println ("Escolha inválida!");
                    }
                    System.out.println("");
                    System.out.println("Turno do "+player2.getNome()+" em 3...");
                    try{
                         Thread.sleep(1000);
                    }catch(Exception e){}
                    System.out.println("2...");
                    try{
                         Thread.sleep(1000);
                    }catch(Exception e){}
                    System.out.println("1...");
                    try{
                         Thread.sleep(1000);
                    }catch(Exception e){}
                    System.out.println("--- AÇÃO DO "+player2.getNome()+"---");
                    while (true){
                        System.out.println("Pressione: "+"\n"+
                        "1 - Pular a rodada"+"\n"+
                        "2 - Jogar os dados");
                        int escolha = Teclado.leInt("Digite sua escolha: ");
                        if (escolha == 1) {
                            passaRodada();
                            break;
                        }
                        else if (escolha == 2) {
                            jogaDadosP2();
                            break;
                        }
                        else System.out.println ("Escolha inválida!");
                    }
                }
        System.out.println("calculando o resultado...");
        try{
             Thread.sleep(1000);
        }catch(Exception e){}
        resultado();
    }
    
    public void passaRodada() { //Simplesmente pula a rodada. Aqui ele não faz nada, mas no menu ele conta como ação e continua o jogo
        System.out.println("Rodada pulada!");
    }
    
    /*As próximas duas classes são o coração do game, elas fazem o principal do jogo: jogar dados e adicioná-los ao total de pontos obtidos pelos 
    jogadores. Quantas vezes elas vão rodar e quando erão chamadas dependerá das ações do player no menu do jogo, que está montado na classe principal. 
    As ações por baixo dos panos que impedem o jogo de explodir em erros. */
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
        if (resultado.equals("Os jogadores empataram!")){
            System.out.println("░░░░░░░░░░░░▄▄▄▄▄▄▄▄▄▄▄▄▄░░░░░░░░░░░░"+"\n"+
                            "░░░░░░▄▄████▀▀▀▀▀░░░░░░▀▀█▄▄░░░░░░░░░"+"\n"+
                            "░░░▄██▀▀░░░░░░░░░░░░░░░░░░▀██▄░░░░░░░"+"\n"+
                            "░░▄█▀░░░░░░░░░░░░░░░░░░░░░░░░▀█▄░░░░░"+"\n"+
                            "░██░░░░░░░░░░░░░░░░░░░░░░░░░░░▀█▄░░░░"+"\n"+
                            "██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▀█▄░░░"+"\n"+
                            "██░░░░░░░░░░░░░░░░░░░░░░░░░▄▄▄░░▀█░░░"+"\n"+
                            "█░░░░░░░░░░░░░░░░░░░░░░░░░░▀██▄░░██░░"+"\n"+
                            "█░░░░░████░░░░░░░░░░░░░░░░░░░░░░░░█▄░"+"\n"+
                            "█░░░░░▀▀▀█░░░░░░░░░░░░░░░░░░░░░░░░██░"+"\n"+
                            "█░░░░░░░░░░░░░░░░░░░░░░░▄▄▄▄█████▀░█▄"+"\n"+
                            "█░░░░░░░░░░▄▄▄▄▄██████▀▀▀▀▀▀░░░░░░░██"+"\n"+
                            "█░░░░▄█████▀▀▀▀▀░▄▄▄████░░░░░░░░░░░██"+"\n"+
                            "██░░░░░░░░░░░░░░░░▀░░░░░░░░░░░░░░░░██"+"\n"+
                            "▀█▄░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█▀"+"\n"+
                            "░▀█░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▄█░"+"\n"+
                            "░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░"+"\n"+
                            "░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░▄█░░"+"\n"+
                            "░░░░▀██▄░░░░░░░░░░░░░░░░░░░░░░▄▄█▀░░░"+"\n"+
                            "░░░░░░▀██▄░░░░░░░░░░░░░░░░░▄▄█▀░░░░░░"+"\n"+
                            "░░░░░░░░░▀██▄░░░░░░░░░░░▄▄█▀░░░░░░░░░"+"\n"+
                            "░░░░░░░░░░░░▀██▄▄▄▄▄▄▄▄█▀░░░░░░░░░░░░"+"\n"+
                            "░░░░░░░░░░░░░░░░░░█░░░░░░░░░░░░░░░░░░"+"\n"+
                            "░░░░░░░░░░░░░░░░░░█░░░░░░░░░░░░░░░░░░"+"\n"+
                            "░░░░░░░░░░░░░░░░░░█░░░░░░░░░░░░░░░░░░"+"\n"+
                            "░░░░░░░░░░░░░░░░░░█░░░░░░░░░░░░░░░░░░"+"\n"+
                            "░░░░░░░░░░░░░░░░░░█░░░░░░░░░░░░░░░░░░"+"\n"+
                            "░░░░░░░░░░░░░░░░░░█░░░░░░░░░░░░░░░░░░");
        }
        else {
            System.out.println(resultado+"\n"+"");
            System.out.println("  _______________"+"\n"+
                               " |@@@@|     |####|"+"\n"+
                               " |@@@@|     |####|"+"\n"+
                               " |@@@@|     |####|"+"\n"+
                               " |@@@@|     |####/"+"\n"+
                               "  '@@@|     |###/"+"\n"+
                               "   `@@|_____|##'"+"\n"+
                               "        (O)"+"\n"+
                               "     .-'''''-."+"\n"+
                               "   .'  * * *  `."+"\n"+
                               "  :  *       *  :"+"\n"+
                               " : ~  P A R A  ~ :"+"\n"+
                               " : ~  B É N S  ~ :"+"\n"+
                               "  :  *       *  :"+"\n"+
                               "  `.  * * *  .'"+"\n"+
                               "     `-.....-'");
            }
    }
    
    
    /*À princípio essa tela ficava toda dentro da classe principal, mas pelo que eu vi isso era muita forçação de barra, então ele acabou aqui mesmo, 
       para que eu pudesse chamar antes do menu abrir. */
    public void telaInicial(){
        titulo();
        char entrar = Teclado.leChar("Digite 'S' para entrar no jogo! Ou outra tecla para cancelar: ");
        if (entrar == 'S'){
            System.out.println("Bem vindo ao jogo 21 nativo de JAVA!");
            comecaJogo();
            acabaJogo();
        }
        else {
            mongus();
        }
    }
    
    /*É a primeira coisa que aparece para o jogador, dá para dizer que é a tela inicial.*/
    public  void titulo(){
        System.out.println("██████╗  ██╗     ██████╗ ██████╗  ███╗   ███╗    ██████╗  █████╗ ██████╗  ██████╗ ███████╗"+"\n"+
                           "╚════██╗███║    ██╔════╝██╔═══██╗████╗ ████║    ██╔══██╗██╔══██╗██╔══██╗██╔═══██╗██╔════╝"+"\n"+
                            "█████╔╝╚██║    ██║      ██║   ██║ ██╔████╔██║    ██║  ██║███████║██║  ██║██║   ██║███████╗"+"\n"+
                           "██╔═══╝  ██║    ██║      ██║   ██║ ██║╚██╔╝██║    ██║  ██║██╔══██║██║  ██║██║   ██║╚════██║"+"\n"+
                           "███████╗ ██║    ╚██████╗╚██████╔╝ ██║ ╚═╝ ██║    ██████╔╝██║  ██║██████╔╝╚██████╔╝███████║"+"\n"+
                           "╚══════╝ ╚═╝     ╚═════╝ ╚═════╝  ╚═╝     ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚══════╝");
        try{
             Thread.sleep(500);
        }catch(Exception e){}
        System.out.println("Feito em Java!");
        try{
             Thread.sleep(500);
        }catch(Exception e){}
        System.out.println("");
        try{
             Thread.sleep(1000);
        }catch(Exception e){}
    }
    
    /*Mensagem de saída prematura do jogo (ainda não passou pelo menu)*/
    public void mongus(){
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣶⣿⣿⣷⣶⣄⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣾⣿⣿⡿⢿⣿⣿⣿⣿⣿⣿⣿⣷⣦⡀⠀⠀⠀⠀⠀"+"\n"+
                                "⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⡟⠁⣰⣿⣿⣿⡿⠿⠻⠿⣿⣿⣿⣿⣧⠀⠀⠀⠀"+"\n"+
                                "⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⠏⠀⣴⣿⣿⣿⠉⠀⠀⠀⠀⠀⠈⢻⣿⣿⣇⠀⠀⠀"+"\n"+
                                "⠀⠀⠀⠀⢀⣠⣼⣿⣿⡏⠀⢠⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⡀⠀⠀"+"\n"+
                                "⠀⠀⠀⣰⣿⣿⣿⣿⣿⡇⠀⢸⣿⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⡇⠀⠀"+"\n"+
                                "⠀⠀⢰⣿⣿⡿⣿⣿⣿⡇⠀⠘⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⢀⣸⣿⣿⣿⠁⠀⠀"+"\n"+
                                "⠀⠀⣿⣿⣿⠁⣿⣿⣿⡇⠀⠀⠻⣿⣿⣿⣷⣶⣶⣶⣶⣶⣿⣿⣿⣿⠃⠀⠀⠀"+"\n"+
                                "⠀⢰⣿⣿⡇⠀⣿⣿⣿⠀⠀⠀⠀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠁⠀⠀⠀⠀"+"\n"+
                                "⠀⢸⣿⣿⡇⠀⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠉⠛⠛⠛⠉⢉⣿⣿⠀⠀⠀⠀⠀⠀"+"\n"+
                                "⠀⢸⣿⣿⣇⠀⣿⣿⣿⠀⠀⠀⠀⠀⢀⣤⣤⣤⡀⠀⠀⢸⣿⣿⣿⣷⣦⠀⠀⠀"+"\n"+
                                "⠀⠀⢻⣿⣿⣶⣿⣿⣿⠀⠀⠀⠀⠀⠈⠻⣿⣿⣿⣦⡀⠀⠉⠉⠻⣿⣿⡇⠀⠀"+"\n"+
                                "⠀⠀⠀⠛⠿⣿⣿⣿⣿⣷⣤⡀⠀⠀⠀⠀⠈⠹⣿⣿⣇⣀⠀⣠⣾⣿⣿⡇⠀⠀"+"\n"+
                                "⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣿⣦⣤⣤⣤⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀"+"\n"+
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⢿⣿⣿⣿⣿⣿⣿⠿⠋⠉⠛⠋⠉⠉⠁⠀⠀⠀⠀"+"\n"+
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠁");
            System.out.println("Ok. Até a próxima.");
    }
    
    /*As regras do jogo, resolvi não printá-las de uma vez só porque talvez ficasse muita informação na tela. */
    public void imprimeRegras(){
        System.out.println("O jogo é composto por 2 jogadores já identificados, sendo que cada um possui dois dados, um vermelho e um branco."+"\n"+
                            "Todos começam com zero pontos e quem chegar mais perto de 21 dentro de 3 rodadas é o vencedor (só não vale passar de 21)"+"\n"+
                            "A cada rodada, cada jogador tem a opção de escolher se vai jogar o dado ou passar a vez:"+"\n"+
                            "   • Se o jogador passar a vez, não joga os dados"+"\n"+
                            "   • Se o jogador escolher jogar os dados, joga primeiro o dado branco e depois o vermelho, os valores são"+"\n"+
                            "     somados aos pontos do jogador"+"\n"+
                            "     Porém, se no dado vermelho o jogador tirar 6, o valor desse dado dobra, fazendo o jogador somar 12 pontos."+"\n"+
                            "Uma rodada só termina quando ambos os jogadores fizerem sua jogada.");
    }
    
    //Créditos. É só isso.
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
    
    //Igual o nome diz, é um easter egg para as gerações futuras.
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

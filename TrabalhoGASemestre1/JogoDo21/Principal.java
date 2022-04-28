//Henrique Vinícius Haag
public class Principal{
    public static void main(String[] args){
        System.out.println("Bem vindo ao 21 nativo de JAVA!");
        Jogo jogo1 = new Jogo();
        do{
            System.out.println("O que deseja fazer a seguir?"+"\n"+
            "1 - Regras"+"\n"+
            "2 - Começar"+"\n"+
            "3 - Créditos"+"\n"+
            "4 - Sair");
            int opcao = Teclado.leInt("Digite sua opção (apenas números): ");
            if (opcao == 1) {
                jogo1.imprimeRegras();
                char desejo = Teclado.leChar("Deseja voltar ao menu?(S/N) ");
                if (desejo == 'N') {
                    System.out.println("Obrigado por jogar!");
                    break;
                }
            }
            else if (opcao == 2){
                jogo1.comecaJogo();
                jogo1.rodaJogo();
                jogo1.resultado();
                char desejo = Teclado.leChar("Deseja voltar ao menu?(S/N) ");
                if (desejo == 'N') {
                    System.out.println("Obrigado por jogar!");
                    break;
                }
            }
            else if (opcao == 3){
                jogo1.creditos();
                char desejo = Teclado.leChar("Deseja voltar ao menu?(S/N) ");
                if (desejo == 'N') {
                    System.out.println("Obrigado por jogar!");
                    break;
                }
            }
            else if (opcao == 4){
                System.out.println("Obrigado por jogar!");
                break;
            }
            else if (opcao == 55413){
                jogo1.easterEgg();
                char desejo = Teclado.leChar("Deseja jogar novamente?(S/N) ");
                if (desejo == 'N') {
                    System.out.println("Obrigado por jogar!");
                    break;
                }
            }
            else System.out.println("Escolha inválida!");
        }while (true);
    }
}
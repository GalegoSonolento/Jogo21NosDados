//Henrique Vinicius Haag
public class Jogador{
    private String nome;
    private int pontos = 0; // Coloquei zero pontos de atribuição básica para evitar qualquer erro
    // Nesses atributos eu criei direto dois dados diferentes, o vermelho e o branco. Aparentemente esse método funciona e será importante mais tarde
    private Dados dVermelho = new Dados("Vermelho"), dBranco = new Dados("Branco");
    
    //Criador de objeto jogador, provavelmente também será usado dentro da classe jogo para criar os jogadores que o jogarão
    public Jogador(String nome) {
        this.nome = nome;
    }
    
    //Daqui para baixo também existem apenas getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

        public int getPontos() {
        return pontos;
    }
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public Dados getDVermelho() {
        return dVermelho;
    }
    public void setDVermelho(Dados dVermelho) {
        this.dVermelho = dVermelho;
    }

    public Dados getDBranco() {
        return dBranco;
    }
    public void setDBranco(Dados dBranco) {
        this.dBranco = dBranco;
    }
}
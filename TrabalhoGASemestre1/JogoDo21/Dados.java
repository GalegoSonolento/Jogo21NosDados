//Henrique Vinicius Haag
public class Dados {
    private int lado = 6;
    private String cor;
    // atributos dessa classe para a criação de um objeto

    // Criação do objeto dado que será usado no jogador
    public Dados(String cor){
        this.cor = cor;
    }

    //Esse método é o de rolagem do dado. Funciona basicamente para rolar um 
    // valor aleatório para ele (entre 1 e 6)
    public int roladaDado(){
        int min = 1;
        int range = (lado - min) + 1;
        lado = (int)(Math.random() * range) + min;
        return lado;
    }
    
    //Daqui para baixo são apenas os getters e setter dessa classe
    public int getLado(){
        return lado;
    }
    public String getCor(){
        return cor;
    }
    
    public void setLado(int lado){
        this.lado = lado;
    }
    public void setCor(String cor){
        this.cor = cor;
    }
}
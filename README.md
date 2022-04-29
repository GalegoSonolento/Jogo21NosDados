# Jogo21NosDados
Jogadores começam com zero pontos

São 3 rodadas

2 opções -> passar ou jogar

Passar a vez não joga os dados

primeiro o branco (soma direto ao valor contido no jogador)

em seguida joga o vermelho -> entre 1 e 5, apenas soma. se tirar 6, multiplica por dois e soma

um jogador joga dois dados de cada vez, ou seja, primeiro um escolhe se quer jogar, depois o outro

são 3 rodadas

Quem chegar mais perto de 21 vence

quem passar de 21 perde automaticamente 

Se ambos passarem de 21, eles empatam


Classe principal:
- Imprimir as regras do jogo
- Começar o jogo
- Terminar o jogo
- Menu de opções -> primeiro o do jogador 1 e depois o do 2
- Perguntar o que deseja fazer na próxima rodada (talvez fazer um for ou while dentro do main) -> criar um menu com do/while
- A pergunta se quer ver os pontos vem ao final da rodada, um após o outro, só depois pergunta-se se quer jogar ou passar a vez

Classe Jogo
- 2 atribuições - os dois jogadores
- método: construtor do jogo
- método: comecaJogo() -> cria os dois jogadores
- método: passa a rodada
- método: joga os dados -> primeiro o branco
- método: quer ver seus pontos? -> pergunta para os jogadores se eles querem ver seus pontos
- método: resultado -> analisa os pontos dos jogadores e devolve quem ganhou 

Coisas a fazer:
- implementar o botão de resetar
- Dx o jogo bonito
- ASCII od jigsaw?
- Preciso criar um método pra conter o menu e chamá-lo dentro do começa jogo

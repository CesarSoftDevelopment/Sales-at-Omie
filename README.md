
# Teste Android

# Visão Geral

O aplicativo foi desenvolvido usando Kotlin em MVVM + Clean architecture, seguindo as boas 
práticas de desenvolvimento android.

O projeto tem 3 branches main, xml-project, compose-project. A branch xml-project foi onde criei
o projeto e mesclei para a main. A branch compose-project é para refatoração no projeto.

Algumas das tecnologias utilizadas no projeto foram:

- Dagger Hilt para injeção de dependência
- Mockito para criação de testes unitários
- Room para salvar os dados local no dispositivo


# Instalação

Para instalar o projeto você precisa:

1. clonar o projeto na sua máquina : git clone {caminho} ou baixar no github

2. Executar a aplicação em um celular ou emulador

3. Também tem um pasta `apk_test` onde tem uma build do aplicativo


# Recursos

- O aplicativo permiti que o usuário registre um pedido com vários itens, incluindo a descrição de
  cada item, a quantidade, o valor unitário e o valor total de cada item.

- O aplicativo calcular o valor total do pedido somando o valor total de cada item.

- O aplicativo permiti que o usuário visualize todos os pedidos registrados, incluindo a
  descrição dos itens do pedido, a quantidade, o valor unitário e o valor total de cada item,
  bem como o valor total do pedido.
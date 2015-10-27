# Jogo resta um desenvolvido em java

Jogo de resta um desenvolvido em java para fins de estudo

### Requisitos
antes de tudo, tenha certeza que está com o ANT do apache devidamente configurado em seu computador, se não tem essa certeza, execute o seguinte comando:
```
$ ant -version
```
caso o comando não seja encontrado, [Clique Aqui](https://ant.apache.org/bindownload.cgi) para instalar o Apache-Ant, após, adicione o caminho nas suas variáveis de ambiente.

### Instalação
Após tudo estar devidamente configurado, deve-se compilar o projeto através do arquivo de buil.xml
```
$ ant compile
```
esta tarefa está criada dentro do arquivo `build.xml`.
Após a compilação, será criada a pasta a bin, que é onde estão todos os arquivos compilados. Ainda utilizando o `build.xml` podemos rodar a aplicação java, apenas executando o comando:
```
$ ant
```
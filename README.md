# Biblioteca :book:

<p> Sistema para alguel de livros por alunos de uma escola. </p>

## 

## Objetivo 🎯:

  <p> Salvar no MySql cadastro dos alunos e livros utilizando @Beans.</p>
  <p> Possibiliar os alunos alugarem livros e atualizar seus dados no MySql através das dependências <b style="text-weight: bold"> mysql-connector-java</b> e <b style="text-weight: bold">spring-boot-starter-data-jpa</b> </p>
  <p> Mapear alunos e livros como @OneToMany / @ManyToOne => Gerar uma tabela do relacionamento</p>
  
##

## Tecnologias e Dependências 💻 :

<ul>
  <li>Java 11</li>
  <li>Spring 2.7</li>
  <li>MySql 8.0.29</li>
  <li>spring-boot-starter-data-jpa</li>
  <li>spring-boot-starter-web</li>
  <li>spring-boot-starter-test</li>
  <li>spring-boot-devtools</li>
  
</ul>

## RunTime :zap: :

<ul>
  <li> EndPoint livros
  
  ![EndPoint livros](https://github.com/puds09/biblioteca-spring-java/blob/main/git-images/listaLivros.png)
  
  </li>
  <li> EndPoint alunos com livros alugados
  
  ![EndPoint alunos](https://github.com/puds09/biblioteca-spring-java/blob/main/git-images/listaAlunos_aluguel.png)

  </li>
  <li> Tabela do relacionamento
  
  ~~~Java
	@OneToMany()
	@JoinTable(name = "livro_alugado",
              joinColumns = @JoinColumn(name = "alunoId"),
              inverseJoinColumns = @JoinColumn(name = "livroId")
              )
	public List<Livro> emprestimos;
  ~~~
  
  ![JoinTable](https://github.com/puds09/biblioteca-spring-java/blob/main/git-images/livro_alugado.png)

  </li>

<ul>

##

## EndPoints 👨‍💻:

<p> Especificados em: 

![AlunoController](https://github.com/puds09/biblioteca-spring-java/blob/main/src/main/java/com/puds/biblioteca/controllers/AlunoController.java)

![LivroController](https://github.com/puds09/biblioteca-spring-java/blob/main/src/main/java/com/puds/biblioteca/controllers/LivroController.java)

</p>

##

## Dúvidas/ Contato ❓:

<div style="display: inline_block" align="center"><br>
  
  <a href="https://www.linkedin.com/in/pedro-ribeiro-b522671b1/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a> 
  
  <a href = "mailto:ph.pedro09@gmail.com"><img src="https://img.shields.io/badge/-Gmail-%23333?style=for-the-badge&logo=gmail&logoColor=white" target="_blank"></a>

</div>


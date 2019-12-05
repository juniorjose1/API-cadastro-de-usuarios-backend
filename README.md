# PROJETO BACK-END FINALIZADO

## Sistema de convidados para casamento utilizando Spring Framework

### Funcionamento
<p>Foi desenvolvido uma API RESTful em que é responsável por todas as funções do sistema, ou seja, é nela que foi desenvolvido os seguintes itens:</p>
<ul>
  <li>Métodos para cadastrar, alterar, excluir, pesquisar, exportar e listar</li>
  <li>Armazenamento de todos os registros cadastrados em um banco de dados</li>
  <li>Programado as mensagens de erros e/ou incompatibilidades que acontecem com a interação do usuário ao sistema</li>
  <li>Trabalhado a segurança da API utilizando Basic Authentication</li>
</ul> 

### Tecnologias e Hospedagem
<p>A API RESTful foi desenvolvido em Java utilizando Spring Boot, Spring Data JPA, Spring MVC e Spring Security</p>
<p>Para fazer a exportação dos dados cadastrados em um relatório em PDF, foi usado o Jaspersoft que utiliza a biblioteca do JasperReports</p>
<p>Para desenvolver as pesquisas e os relatórios em gráficos, foi utilizado uma API do JPA, chamada CriteriaBuilder, onde fazemos consultas fortemente tipadas ao banco.</p>
<p>Para fazer todos os testes da API, foi utilizado o Postman, que é uma ferramenta para testar requisições via HTTP</p>
<p>A API está hospedada em um servidor chamado Heroku em uma versão FREE, mas que suporta JAVA</p>
<p>Foi utilizado o GIT para fazer o versionamento, e também para fazer o deploy para o Heroku</p>
<p>Para acessar o sistema, basta entrar em http://alejunqueira.com.br e aguardar de 30 segundos a 1 minuto no máximo para que a API Restful seja carregada, e assim listar os convidados cadastrados, pois a API Back-end está hospedada em um servidor FREE.</p>

<p align="center">
     <a href="https://pep.ifsp.edu.br/">
    <img src="PEP LIFE.png" alt="IFSP_LIFE">
</p>

# **IFSP LIFE** - *Sistema para Gerenciamento de Farmácias*

<h2> Linguagens e Ferramentas Utilizados no Projeto: <img src = "https://raw.githubusercontent.com/rahulbanerjee26/githubProfileReadmeGenerator/main/gifs/code.gif" width = 32px height=32px> </h2>
<a href= https://github.com/?tab=repositories&q=&type=&language=java&sort= > <img width ='32px' height='32px' src ='https://raw.githubusercontent.com/rahulbanerjee26/githubAboutMeGenerator/main/icons/java.svg'> </a>
<a href= https://github.com/?tab=repositories&q=&type=&language=mysql&sort= > <img width ='32px' height='32px' src ='https://raw.githubusercontent.com/rahulbanerjee26/githubAboutMeGenerator/main/icons/mysql.svg'> </a>



# Capítulo 1 - INTRODUÇÃO
O principal objetivo do sistema é melhorar a segurança e a eficiência nas redes farmacêuticas. O projeto visa desenvolver uma gestão eficaz. Desenvolvemos este sistema para garantir um policiamento eficaz, fornecendo estatísticas dos medicamentos em estoque.

**Descrição do Sistema:** 
O sistema utilizado pode gerar relatórios, conforme a necessidade do usuário. O software pode imprimir notas fiscais, contas, recibos etc. Ele também pode manter o registro de medicamentos enviados pelo fornecedor. Aqui, o administrador que está lidando com a organização. Será responsável por gerenciar os registros dos funcionários. Cada funcionário receberá um nome de usuário e senha separados.

**Objetivos**
-> **Principais Objetivos**<br>
• Desenvolver um sistema que possa ser utilizado em qualquer farmácia.<br>
• Sistema de Gerenciamento Eficaz.

# Capítulo 2 - DOCUMENTAÇÃO
o Levantamento de Dados -  
o Escopo - <br>
o Protótipo - <br>
o Modelo Lógico - <br>
o Diagrama Caso de Uso - <br>
o Diagrama Caso de Atividade - <br> 
o Diagrama de Classes - <br>
o Doc. Semana Nacional de Ciência e Tecnologia - 


# Capítulo 3 - IMPLEMENTAÇÃO 
**Descrição das Implementações**<br>
Funções que serão implementadas. <br>
**Lista de Módulos:**
o  Interface de Login
o  Interface Home<br>
o  Interface das Empresas<br>
o  Interface de Compra<br>
o  Interface dos Medicamentos<br>
o  Interface de Compra<br>
o  Interface de Venda<br>
o Interface do Úsuario

# Capítulo 4 - DEFINIÇÃO DE FUNÇÕES 
**Descrição das Funções**
Todos as funções que serão implementadas no sistema.
**Lista de Funções:**<p>

o Função Fundamental 1.0 - Efetuar Compra

    Descrição » Essa função permite que o administrador inclua as mercadorias compradas, que estarão a venda no estabelecimento. Ademais, permite que a compra possa ser cancelada ou alterada.
    Itens de Informações » 
    - Código Fornecedor - conjunto numérico
    - Código Usuário - conjunto numérico
    - Nota Fiscal do Fornecedor - conjunto numérico
    - Valor Total - conjunto numérico - dd/mm/aaaa

    Para cada Mercadoria » 
    - Código - conjunto numérico
    - Valor - conjunto numérico
    - Valor da Compra - conjunto numérico
    - Status - texto com tamanho máximo de 15
    - Descrição - texto com tamanho máximo de 45
    - Tamanho - texto com tamanho máximo de 10
    - Marca - texto com tamanho máximo de 15

o Função Fundamental 1.1 - Efetuar Venda

    Descrição » Essa função permite que o usuário inclua uma nova venda no sistema, após realizar o atendimento ao cliente. Além de, permite que a venda possa ser alterada ou cancelada.
    Itens de Informações » 
    - Código Usuário- conjunto numérico;

    Para cada Mercadoria » 
    - Código - conjunto numérico
    - Valor - conjunto numérico;
    - Valor da Compra - conjunto numérico;
    - Status - texto com tamanho máximo de 15
    - Descrição - texto com tamanho máximo de 45;
    - Tamanho - texto com tamanho máximo de 10;
    - Marca - texto com tamanho máximo de 15;
    - Número Nota Fiscal - conjunto numérico;
    - Valor total - conjunto numérico decimal;
    - Forma de pagamento - texto com tamanho máximo de 45;
    - Data - dd/mm/aaaa;

o Função Básica 1.2 - Manter Usuario

    Descrição » Essa função permite a consulta dos dados de um usuário, como também, a inclusão, alteração e exclusão.

    Itens de Informações » 
    - Nome do Usuário  - texto com tamanho máximo de 45;
    - Telefone - texto com tamanho máximo de 17;
    - CPF - texto com tamanho máximo de 14;
    - Endereço  - texto com tamanho máximo de 45;
    - Cidade - texto com tamanho máximo de 45;
    - CEP - texto com tamanho máximo de 9;
    - Estado - texto com tamanho máximo de 2;
    - Tipo - texto com tamanho máximo 1;. A: administrador e F: funcionário;
    - Senha - texto com tamanho máximo de 45;
    - Email - texto com tamanho máximo de 45;

o Função Básica 1.3 - Manter Fornecedor

    Descrição » Essa função permite a consulta dos dados de um fornecedor como, também, a inclusão, alteração e exclusão

    Itens de Informações » 
    - Nome do fornecedor  - texto com tamanho máximo de 45;
    - Telefone - texto com tamanho máximo de 17;
    - CNPJ - texto com tamanho máximo de 14;
    - Endereço  - texto com tamanho máximo de 45;
    - Estado - texto com tamanho máximo de 2;
    - Cidade - texto com tamanho máximo de 45;
    - Email - texto com tamanho máximo de 45;
    - CEP - texto com tamanho máximo de 9;

o Função Básica 1.4 - Manter Mercadoria

    Descrição » Essa função permite a consulta dos dados de uma peça, como também, a alteração e exclusão. A inclusão será realizada no momento da realização da compra.

    Itens de Informações » 
    - Código - conjunto numérico;
    - Valor - conjunto numérico;
    - Valor da Compra - conjunto numérico;
    - Status - texto com tamanho máximo de 15;
    - Descrição - texto com tamanho máximo de 45;
    - Tamanho - texto com tamanho máximo de 10;
    - Marca - texto com tamanho máximo de 15;

# Capítulo 5 - CONCLUSÕES
 Este projeto foi projetado com uma alta usabilidade, de forma que os usuários não terão dificuldades em utilizar nenhuma das funcionalidades. O sistema, em geral otimiza as atividades da rede, de forma que, facilita atividades como o *[FUNÇÃO AQUI*]. O ganho de produtividade e a redução do tempo de entrega dos resultados são muito expressivos. Reduzindo erros procedimentais. Espera-se que o projeto venha a ser concluído com todas as funções até dezembro de 2023.

    o A coleta de informações detalhadas deve ser feita. Sem isso, o propósito de usar o sistema não será adequada.

## Stack utilizada

**Front-end:** Java

**Back-end:** MySQL


## Quais Melhorias foram feitas

»

»


»

»




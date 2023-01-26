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

**Objetivos:**<br>
-> **Principais Objetivos**<br>
• Desenvolver um sistema que possa ser utilizado em qualquer farmácia.<br>
• Sistema de Gerenciamento Eficaz.

# Capítulo 2 - DOCUMENTAÇÃO
**Descrição das Documentações:**<br>
o Levantamento de Dados -  
o Escopo - <br>
o Protótipo - <br>
o Modelo Lógico - <br>
o Diagrama Caso de Uso - <br>
o Diagrama Caso de Atividade - <br> 
o Diagrama de Classes - <br>
o Doc. Semana Nacional de Ciência e Tecnologia - 


# Capítulo 3 - IMPLEMENTAÇÃO 
**Descrição das Implementações:**<br>
**Lista de Módulos:**<br>
o  Interface de Login<br>
o  Interface Home<br>
o  Interface das Empresas<br>
o  Interface de Compra<br>
o  Interface dos Medicamentos<br>
o  Interface de Venda<br>
o  Interface de Úsuarios

# Capítulo 4 - DEFINIÇÃO DE FUNÇÕES 
**Descrição das Funções**
Todos as funções que serão implementadas no sistema.
**Lista de Funções:**<p>

o Função Fundamental 1.0 - Efetuar Compra

    Descrição » Essa função permite que o administrador inclua as mercadorias compradas, que estarão a venda no estabelecimento.
    Itens de Informações » 
    - Código do Produto - conjunto numérico;

    Para cada Mercadoria » 
    - Nome do Produto - texto com tamanho máximo de 45;
    - Tipo do Produto - texto com tamanho máximo de 45;
    - Nome da Empresa - texto com tamanho máximo de 45;
    - Quantidade do Produto - conjunto númerico;
    - Data de Produção - DD/MM/AAAA;
    - Data de Vencimento - DD/MM/AAAA;
    - Preço de Custo - conjunto númerico;
    - Preço de Venda - conjunto númerico

o Função Fundamental 1.1 - Efetuar Venda

    Descrição » Essa função permite que o usuário inclua uma nova venda no sistema, após realizar o atendimento ao cliente.
    Itens de Informações » 
    - Código Usuário - conjunto numérico;

    Para cada Produto » 
    - Código do produto - conjunto numérico
    - Valor do produto - conjunto numérico;
    - Valor da Compra dos produtos - conjunto numérico;
    - Número Nota Fiscal do produto - conjunto numérico;
    - Valor total do produto - conjunto numérico decimal;
    - Forma de pagamento do produto - texto com tamanho máximo de 45;
    - Data da compra - dd/mm/aaaa;

o Função Básica 1.2 - Manter Usuario

    Descrição » Essa função permite a consulta dos dados de um usuário, como também, a inclusão, alteração e exclusão.

    Itens de Informações » 
    - Id do Usuário - texto com tamanho máximo de 1;
    - CPF - texto com tamanho máximo de 14;
    - Nome do Usuário  - texto com tamanho máximo de 45;
    - Data de Nascimento do Usuário - texto com tamanho máximo de 8;
    - Telefone do Usuário - texto com tamanho máximo de 17;
    - Salário  - texto com tamanho máximo de 45;
    - Senha - texto com tamanho máximo de 45;
    - Tipo - texto com tamanho máximo 1;. A: administrador e F: funcionário;
    - Endereço  - texto com tamanho máximo de 45;

o Função Básica 1.3 - Manter Fabricantes

    Descrição » Essa função permite a consulta dos dados de uma Fabricante como, também, a inclusão, alteração e exclusão

    Itens de Informações » 
    - Nome do Fabricante  - texto com tamanho máximo de 45;
    - Telefone - texto com tamanho máximo de 17;
    - CNPJ - texto com tamanho máximo de 14;
    - Endereço  - texto com tamanho máximo de 45;
    - Email - texto com tamanho máximo de 45;

o Função Básica 1.3 - Manter Convênio

    Descrição » Essa função permite a consulta dos dados de um fornecedor como, também, a inclusão, alteração e exclusão

    Itens de Informações » 
    - Nome do Convênio  - texto com tamanho máximo de 45;
    - Telefone - texto com tamanho máximo de 17;
    - CNPJ - texto com tamanho máximo de 14;
    - Endereço  - texto com tamanho máximo de 45;
    - Porcentagem de Desconto - conjunto númerico;

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




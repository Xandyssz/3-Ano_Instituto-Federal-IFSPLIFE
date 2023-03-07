<p align="center">
     <a href="https://pep.ifsp.edu.br/">
    <img src="PEP LIFE.png" alt="IFSP_LIFE">
</p>

# **IFSP LIFE** - *Sistema para Gerenciamento de Farmácias*

<h2> Linguagens e Ferramentas Utilizados no Projeto: <img src = "https://raw.githubusercontent.com/rahulbanerjee26/githubProfileReadmeGenerator/main/gifs/code.gif" width = 32px height=32px> </h2>
<a href= https://github.com/?tab=repositories&q=&type=&language=java&sort= > <img width ='32px' height='32px' src ='https://raw.githubusercontent.com/rahulbanerjee26/githubAboutMeGenerator/main/icons/java.svg'> </a>
<a href= https://github.com/?tab=repositories&q=&type=&language=mysql&sort= > <img width ='32px' height='32px' src ='https://raw.githubusercontent.com/rahulbanerjee26/githubAboutMeGenerator/main/icons/mysql.svg'> </a>



# Capítulo 1 - INTRODUÇÃO
**Descrição do Sistema:**<br>
O sistema IFSP-LIFE será utilizado em uma farmácia com o principal objetivo de realizar a venda dos produtos. O projeto visa desenvolver uma gestão eficaz do sistema.<p>

Durante o atendimento ao cliente, esse escolhe o(s) produto(s) disponível(is) na farmácia e em seguida, o funcionário localiza o valor dos produtos previamente cadastrados no sistema. Quando a venda ao cliente é finalizada, o valor total da venda  é calculado. Após a totalização do pedido, o funcionário solicita ao cliente a forma de pagamento. Caso seja cartão, o total da venda é registrado. Em contrapartida, se for dinheiro, o sistema calcula o troco que será devolvido ao cliente. <p>

O sistema também possui funcionalidades para gerenciar convênios e fornecedores. O Administrador pode cadastrar novos convênios e fornecedores e atualizar as informações dos já existentes, como dados de contato e informações de pagamento. O sistema permite que os convênios tenham descontos especiais nos produtos e serviços da farmácia, e que os fornecedores possam enviar pedidos de compra de produtos de forma automatizada.

O sistema conta também com recursos para gerar relatórios gerenciais, que permitem ao Administrador analisar o desempenho da farmácia em diversos aspectos, como vendas, estoque, convênios, fornecedores e desempenho dos funcionários. Esses relatórios são gerados de forma automática a partir dos dados armazenados no sistema e podem ser acessados por meio de uma interface amigável e intuitiva. Com essas informações em mãos, o Administrador pode tomar decisões estratégicas e implementar melhorias para otimizar o desempenho da farmácia e garantir a satisfação dos clientes.

Por fim, o sistema tem dois níveis de acesso, o Administrador e o Funcionário. O nível de acesso Funcionário tem permissão para atender aos clientes e realizar pedidos no estabelecimento, enquanto o nível de acesso Administrador tem controle total do sistema, incluindo a manutenção dos dados de usuários, convênios, fornecedores e produtos, além de realizar a compra de novos produtos. Em resumo, o IFSP-LIFE é um software completo que visa melhorar a eficiência e a segurança nas redes farmacêuticas.

**Objetivos:**<br>
-> **Principais Objetivos**<br>
• Desenvolver um sistema que possa ser utilizado em qualquer farmácia.<br>
• Sistema de Gerenciamento Eficaz.

# Capítulo 2 - DOCUMENTAÇÃO
**Descrição das Documentações:**<br>
o Levantamento de Dados -  
o Escopo | ✅<br> 
o Protótipo - <br>
o Modelo Lógico | ✅<br>
o Modelo Fisico | ✅<br>
o Diagrama Caso de Uso - <br>
o Diagrama Caso de Atividade - <br> 
o Diagrama de Classes - <br>
o Doc. Semana Nacional de Ciência e Tecnologia - 


# Capítulo 3 - IMPLEMENTAÇÃO 
**Descrição das Implementações:**<br>
**Lista de Módulos:**<br>
o Interface de Login - [LOGIN] & [SPLASHSCREEN] | ✅<br>
o Interface Home - | ❎<br>
o Interface dos Fornecedores  - [Fornecedores] |  ✅<br>
o Interface de Compra - [ComprarProdutos] | ✅<br>
o Interface dos Medicamentos - [BuscarProdutos] | ✅<br>
o Interface de Venda - [NF] | ✅<br>
o Interface de Úsuarios - [Usuarios] | ✅<br>
o Interface Convênios - [Convênios] | ✅

# Capítulo 4 - DEFINIÇÃO DE FUNÇÕES 
**Descrição das Funções**
Todos as funções que serão implementadas no sistema.
**Lista de Funções:**<p>

o Função Fundamental 1.0 - Efetuar Compra

    Descrição » Essa função permite que o administrador inclua os produtos comprados, que estarão a venda no estabelecimento.

    Itens de Informações » 
    - Código de Compra - conjunto númerico;
    - Código do Fornecedor - conjunto númerico;
    - Código do Produto - conjunto númerico;
    - Quantidade do Produto - conjunto númerico;
    - Data da Compra - dd/mm/aaaa;

o Função Fundamental 1.1 - Efetuar Venda

    Descrição » Essa função permite que o usuário inclua uma nova venda no sistema, após realizar o atendimento ao cliente.

    Itens de Informações » 
    - Código da Venda - conjunto númerico;
    - Código do Produto - conjunto númerico;
    - Código do Funcionario - conjunto númerico;
    - Código do Convênio - conjunto númerico;
    - Valor da venda - conjunto númerico;
    - Data da venda - dd/mm/aaaa;

o Função Básica 1.0 - Manter Produtos

    Descrição » Essa função permite a consulta dos produtos do estabelecimento como, também, alteração e exclusão

    Itens de Informações » 
    - Código do Produto - conjunto númerico;
    - Nome do Produto - texto com tamanho máximo de 45;
    - Dosagem do Produto (se tiver) - conjunto númerico;
    - Quantidade do Produto - conjunto númerico;
    - Preco do Produto - conjunto númerico;

o Função Básica 1.1 - Manter Fornecedor

    Descrição » Essa função permite a consulta dos dados dos fornecedores como, também, a inclusão, alteração e exclusão

    Itens de Informações » 
    - Código do Fornecedor - conjunto númerico;
    - Nome do Fornecedor - texto com tamanho máximo de 45;
    - Email do Fornecedor - texto com tamanho máximo de 45;
    - CNPJ do Fornecedor - conjunto númerico;
    - Endereco do Fornecedor - conjunto númerico;
    - Contato do Fornecedor - conjunto númerico;


o Função Básica 1.2 - Manter Funcionario

    Descrição » Essa função permite a consulta dos dados de um funcionario, como também, a inclusão, alteração e exclusão.

    Itens de Informações » 
    - Código do Funcionario - conjunto númerico;
    - Nome do Funcionario - texto com tamanho máximo de 45;
    - CPF do Funcionario - conjunto númerico;
    - Endereco do Funcionario - texto com tamanho máximo de 45;
    - Telefone do Funcionario - conjunto númerico;
    - Cargo do Funcionario - texto com tamanho máximo de 45;

o Função Básica 1.3 - Manter Convênios

    Descrição » Essa função permite a consulta dos dados de um dos convênios, como, também, a inclusão, alteração e exclusão

    Itens de Informações » 
    - Código do Convênio - conjunto númerico;
    - Nome do Convênio - texto com tamanho máximo de 45;
    - Telefone do Convênio - conjunto númerico;
    - Desconto(%) - conjunto númerico;

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




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

Durante o atendimento ao cliente, esse escolhe o(s) produto(s) disponível(is) na farmácia e em seguida, o funcionário localiza o valor dos produtos previamente cadastrados no sistema. Quando a venda ao cliente é finalizada, o valor total da venda é calculado. Após a totalização do pedido, o funcionário solicita ao cliente a forma de pagamento. Caso seja cartão, o total da venda é registrado. Em contrapartida, se for dinheiro, o sistema calcula o troco que será devolvido ao cliente. <p>

O sistema também possui funcionalidades para gerenciar convênios e fornecedores. O Administrador pode cadastrar novos convênios e fornecedores e atualizar as informações dos já existentes, como dados de contato e informações de pagamento. O sistema permite que os convênios tenham descontos especiais nos produtos e serviços da farmácia. <p>

O sistema conta também com recursos para gerar relatórios gerenciais, que permitem ao Administrador analisar o desempenho da farmácia em diversos aspectos, como vendas, estoque,
convênios, fornecedores. Esses relatórios são gerados a partir dos dados armazenados no sistema e podem ser acessados por meio de uma interface amigável e intuitiva. Com essas informações em mãos, o Administrador pode tomar decisões estratégicas e implementar melhorias para otimizar o
desempenho da farmácia e garantir a satisfação dos clientes. <p>

Por fim, o sistema tem dois níveis de acesso, o Administrador e o Funcionário. O nível de acesso Funcionário tem permissão para atender aos clientes e realizar pedidos no estabelecimento, enquanto o nível de acesso Administrador tem controle total do sistema, incluindo a manutenção dos dados de usuários, convênios, fornecedores e produtos, além de realizar a compra de novos produtos. Em resumo, o IFSP-LIFE é um software completo que visa melhorar a eficiência e a segurança nas redes farmacêuticas.<p>

**Objetivos:**<br>
-> **Principais Objetivos**<br>
• Desenvolver um sistema que possa ser utilizado em qualquer farmácia.<br>
• Sistema de Gerenciamento Eficaz.

# Capítulo 2 - DOCUMENTAÇÃO
**Descrição das Documentações:**<br>
o Levantamento de Dados |  ✅<br>  
o Escopo |  ✅<br> 
o Modelo Lógico |  ✅<br>
o Modelo Fisico |  ✅<br>
o Diagrama de Classes |  ✅<br>
o Diagrama Caso de Uso |  ✅<br>
o Diagrama Caso de Atividade - <br> 
o Doc. Semana Nacional de Ciência e Tecnologia - 

# Capítulo 3 - DEFINIÇÃO DE FUNÇÕES 
**Descrição das Funções**
Todos as funções que serão implementadas no sistema.
**Lista de Funções:**<p>

o Função Fundamental 1.0 - Efetuar Compra

    Descrição » Essa função permite ao administrador incluir um novo pedido para
     um determinado fornecedor. Quando é efetuado uma nova compra, é gerado informações sobre o pedido dos produtos comprados, como também é realizado a atualização do estoque. Essa função também permite que a compra possa ser alterada.
     
    Itens de Informações » 
     - Identificação da Compra - Código numérico com no máximo 4 casas
     - Identificação do Fornecedor - Código numérico com no máximo 4 casas
     - Valor da compra - conjunto numérico;
     - Forma de Pagamento – texto com tamanho máximo de 45;
     - Data de Compra - dd/mm/aaaa;<p>
     
     -PARA CADA TEM COMPRADO » 
     - Identificação da Compra – Código numérico com no máximo 4 casas;
     - Identificação do Produto – Código numérico com no máximo 4 casas;
     - Quantidade – conjunto numérico;
     - Preço – Conjunto numérico;

o Função Fundamental 1.1 - Efetuar Pagamento Compra

    Descrição » Essa função tem como objetivo realizar o pagamento de uma compra, registrando as informações relevantes para esse processo. A função      requer os seguintes itens de informações:
     
    Itens de Informações » 
     - Identificação da Compra – Código numérico com no máximo 4 casas;
     - Identificação do Caixa – Código numérico com no máximo 4 casas;
     - Parcela da Compra – conjunto numérico;
     - Data de Vencimento da Parcela – dd/mm/aaaa;
     - Valor da Compra (Parcela) – conjunto numérico;

o Função Fundamental 1.2 - Efetuar Venda

    Descrição » Essa função permite ao funcionário incluir uma nova venda para um determinado cliente. Quando é efetuada uma nova venda, é gerada informação sobre o pagamento dos produtos comprados, como também é realizada a atualização do estoque. Essa função também permite que a venda possa ser excluída ou alterada.

    Itens de Informações » 
     - Identificação da Venda – Código numérico com no máximo 4 casas;
     - Data da venda - dd/mm/aaaa;
     - Valor da venda - conjunto numérico;
     - Convênio – 1 letra – S – Possui, N – Não Possui
     - Forma de Pagamento – texto com tamanho máximo de 45;
     PARA CADA ITEM VENDIDO »
     - Identificação da Venda – Código numérico com no máximo 4 casas;
     - Identificação do Produto – Código numérico com no máximo 9 casas
     - Preço – Conjunto numérico
     - Quantidade do Produto – Valor numérico inteiro

o Função Fundamental 1.3 - Gerenciar Caixa
    Descrição » Essa função permite ao funcionário abrir e fechar o caixa
    
    Itens de Informações » 
     - Código do Caixa – dd/mm/aaaa;
     - Status – texto com tamanho máximo 45;
     - Horário de abertura - hh;mm:ss
     - Valor de abertura – conjunto numérico;
     - Total de entradas – conjunto numérico;
     - Horário de fechamento - hh;mm:ss
     - Total de saídas – conjunto numérico;
     - Saldo – conjunto numérico; <p>
     PARA CADA SANGRIA/SUPLEMENTAÇÃO »
     - Código do Caixa – conjunto numérico;
     - Código Movimentação – conjunto numérico;
     - Motivo – texto com tamanho máximo de 250;
     - Valor – conjunto numérico;
     - Tipo de Movimentação – texto com tamanho máximo de 45;
    
o Função Básica 1.0 - Manter Produtos

    Descrição » Essa função permite a consulta dos produtos do estabelecimento como, também, alteração e exclusão

    Itens de Informações » 
    - Código do Produto - conjunto numérico;
    - Nome do Produto - texto com tamanho máximo de 255;
    - Dosagem do Produto (se tiver) - texto com tamanho máximo de 255;
    - Descrição do Produto - texto com tamanho máximo de 255;
    - Lote do Produto - conjunto númerico;
    - Data de Fabricação - DATE;
    - Data de Validade - DATE;
    - Quantidade do Produto - conjunto numérico;
    - Valor unitário do Produto - conjunto numérico;

o Função Básica 1.1 - Manter Fornecedores

    Descrição » Essa função permite a consulta dos dados dos fornecedores como, também, a inclusão, alteração e exclusão

    Itens de Informações » 
    - Código Fornecedor – conjunto numérico;
    - Nome – texto com tamanho máximo de 45;
    - CNPJ – texto com tamanho máximo de 20;
    - Telefone – texto com tamanho máximo de 20;
    - E-mail – texto com tamanho máximo de 45;
    - Endereço – texto com tamanho máximo de 45;
    - Cidade – texto com tamanho máximo de 45;
    - CEP – texto com tamanho máximo de 12
    - UF – texto com tamanho máximo de 20;


o Função Básica 1.2 - Manter Funcionários

    Descrição » Essa função permite a consulta dos dados de um funcionario, como também, a inclusão, alteração e exclusão.

    Itens de Informações » 
    - Código Funcionário – conjunto numérico;
    - Nome – texto com tamanho máximo de 255;
    - CPF - texto com tamanho máximo de 15;
    - Nivel Acesso – texto com tamanho máximo de 45;
    - Telefone – texto com tamanho máximo de 20;
    - Endereço – texto com tamanho máximo de 45;
    - Cidade – texto com tamanho máximo de 45;
    - CEP – texto com tamanho máximo de 12;
    - UF – texto com tamanho máximo de 20;
    - Salário – texto com tamanho máximo de 45; 
    - Login – texto com tamanho máximo de 45;
    - Senha – texto com tamanho máximo de 45;

o Função Básica 1.3 - Manter Convênios

    Descrição » Essa função permite a consulta dos dados de um dos convênios, como, também, a inclusão, alteração e exclusão

    Itens de Informações » 
    - Código do Convênio - conjunto númerico;
    - Nome do Convênio - texto com tamanho máximo de 255;
    - E-mail – texto com tamanho máximo de 255;
    - CNPJ - conjunto númerico;
    - Endereco - texto com tamanho máximo de 255;
    - Telefone - texto com tamanho máximo de 255;
    - Desconto - conjunto númerico (float);
    - Desconto(%) - conjunto númerico;
    
o Função Saída 1.0 - Gerar Relatório de Produtos

        Descrição » Essa função emite um relatório que permite a visualização de todos os produtos com o estoque abaixo do mínimo.

    Itens de Informações » 
    - Código do Produto - conjunto numérico;
    - Nome do Produto - texto com tamanho máximo de 45;
    - Dosagem do Produto (se tiver) - conjunto numérico;
    - Quantidade do Produto - conjunto numérico;
    - Valor unitário do Produto - conjunto numérico;

o Função Saída 1.1 - Gerar Relatório de Venda

        Descrição » Essa função emite um relatório de todas as vendas feitas dentro de um determinado período de tempo.

    Itens de Informações » 
    - Número da nota fiscal - conjunto numérico;
    - Código da Venda - conjunto numérico;
    - Valor da venda- conjunto numérico;
    - Valor da compra - conjunto numérico;
    - Quantidade - conjunto numérico;
    - Valor total - conjunto numérico;
    - Data - dd/mm/aaaa;


o Função Saída 1.2 - Gerar Relatório de Compra

        Descrição » Essa função emite um relatório de todas as compras feitas dentro de um determinado período de tempo.
        
    Itens de Informações » 
    - Nome do fornecedor – texto com tamanho máximo de 50;
    - Código da Compra - conjunto numérico;
    - Valor - conjunto numérico;
    - Valor da compra - conjunto numérico;
    - Marca - texto com tamanho máximo de 50;
    - Descrição - texto com tamanho máximo de 50;
    - Quantidade - conjunto numérico;
    - Data - dd/mm/aaaa;

# Capítulo 5 - CONCLUSÕES
 Este projeto foi projetado com uma alta usabilidade, de forma que os usuários não terão dificuldades em utilizar nenhuma das funcionalidades. O sistema, em geral otimiza as atividades da rede, de forma que, facilita atividades como o *[FUNÇÃO AQUI*]. O ganho de produtividade e a redução do tempo de entrega dos resultados são muito expressivos. Reduzindo erros procedimentais. Espera-se que o projeto venha a ser concluído com todas as funções até dezembro de 2023.

    o A coleta de informações detalhadas deve ser feita. Sem isso, o propósito de usar o sistema não será adequada.

## Stack utilizada

**Front-end:** Java

**Back-end:** MySQL

## Quais Melhorias foram feitas
Tarefas:
→ Verificar necessidade de adicionar "Cidade, CEP, Estado" | *Convênio;<br>
→ - Acertar alinhamento do sumário
→ "O projeto visa desenvolver uma gestão eficaz do sistema." sem sentido<br>
→ "e que os fornecedores possam enviar pedidos de compra de produtos" Os fornecedores nao tem acesso ao seu sistema eles nao enviam nada<br>
→ "o IFSP-LIFE é um software completo que visa melhorar a eficiência e a segurança nas redes farmacêuticas." VOCE NAO PODE AFIRMAR ISSO<br>
→ MELHORAR AS FUNÇÕES DE SAIDA<br>
→ Legenda de todas as figuras deve ser acima acima da Imagem<br>
→ Remover do projeto o que nao foi solicitado ainda | (Caso de Uso - Diagrama de classe e outros)<br>
<BR>PENDENTE:
→ Registrar JPA | Compra, Venda, Perfil & Caixa;<br> 

TELAS:
→ Fazer as Telas | Notificação<br>

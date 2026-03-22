# 📦 Gerenciamento de Produtos

Sistema desktop de gerenciamento de estoque desenvolvido em Java com interface gráfica Swing, banco de dados MySQL e containerização via Docker.

---

## 🖥️ Tecnologias

- **Java 25**
- **Swing** — interface gráfica desktop
- **FlatLaf** (GitHub Dark Theme) — tema visual moderno
- **JDBC** — comunicação com banco de dados
- **MySQL 8** — banco de dados relacional
- **Docker / Docker Compose** — containerização do banco
- **Maven** — gerenciamento de dependências
- **dotenv-java** — gerenciamento de variáveis de ambiente

---

## ✨ Funcionalidades

- ✅ Listar todos os produtos em tabela
- ✅ Busca em tempo real por nome
- ✅ Adicionar produto com validação de campos
- ✅ Editar produto (campos opcionais — deixe em branco o que não quiser alterar)
- ✅ Deletar produto com confirmação
- ✅ Sidebar retrátil com ícones e navegação por CardLayout

---

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas:

```
src/main/java/
├── br/gerenciamento/produtos/
│   └── GerenciamentoProdutos.java   # Ponto de entrada (main)
├── model/
│   └── Produto.java                 # Entidade de domínio
├── repository/
│   └── ProdutoDAO.java              # Acesso ao banco de dados
├── service/
│   └── ProdutoService.java          # Regras de negócio
├── exception/
│   ├── EntradaInvalidaException.java
│   ├── NomeVazioException.java
│   ├── PrecoMenor0Exception.java
│   ├── ProdutoDuplicadoException.java
│   ├── ProdutoNaoEncontradoException.java
│   └── QuantidadeMenor0Exception.java
├── ui/
│   ├── MainFrame.java               # Janela principal com sidebar
│   ├── FormProdutos.java            # Tela de listagem
│   ├── FormAdicionar.java           # Tela de cadastro
│   └── AtualizarProduto.java        # Janela de edição
└── util/
    ├── ConnectionFactory.java        # Conexão com o banco
    ├── ConversorService.java         # Conversão e validação de tipos
    └── UIConfig.java                 # Configuração de tema e fonte
```

---

## ⚙️ Como executar

### Pré-requisitos

- Java 17+
- Maven
- Docker e Docker Compose

### 1. Clone o repositório

```bash
git clone https://github.com/davidanielMnds/gerenciamento-produtos.git
cd gerenciamento-produtos
```

### 2. Configure as variáveis de ambiente

Copie o arquivo de exemplo e preencha com suas credenciais:

```bash
cp .env.example .env
```

### 3. Suba o banco de dados

```bash
docker-compose up -d
```

O banco será criado automaticamente com a tabela e dados de exemplo a partir do `backup.sql`.

### 4. Execute o projeto

```bash
mvn exec:java
```

---

## 🗄️ Banco de dados

```sql
CREATE TABLE IF NOT EXISTS produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    quantidade INT DEFAULT 0
);
```

---

## 📸 Telas

| Tela | Descrição |
|------|-----------|
| **Lista de Produtos** | Tabela com todos os produtos, busca em tempo real e ações de editar/deletar |
| **Adicionar Produto** | Formulário com validação de nome, quantidade e preço |
| **Editar Produto** | Janela com campos pré-preenchidos — apenas os campos alterados são atualizados |

---

## 🔒 Variáveis de ambiente

O projeto usa `dotenv-java` para carregar as credenciais do banco a partir do arquivo `.env` na raiz do projeto.

---

## 👤 Autor

**Davi Daniel**  
Estudante de Ciência da Computação  
[GitHub](https://github.com/davidanielMnds) · [LinkedIn](https://www.linkedin.com/in/davi-daniel-2822b83b7/)

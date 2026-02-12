# 👋 Bem-vindo ao Sistema de Cadastro de Usuários!

Esse é um projeto simples mas completo de uma API REST para gerenciar usuários. Criei ele usando Spring Boot, e a ideia é que você consiga cadastrar, buscar, atualizar e deletar usuários de forma bem tranquila.

##  O que tem por aqui?

Usei algumas tecnologias bem legais nesse projeto:

- **Java** - 
- **Spring Boot** - 
- **Spring Data JPA** - 
- **Lombok** - 
- **Banco de dados relacional**

##  Antes de começar

Você vai precisar ter instalado na sua máquina:

- Java 17 ou mais recente
- Maven (versão 3.6 pra cima)
- Um banco de dados (PostgreSQL, MySQL ou até o H2 para testar)

## 🚀 Como rodar o projeto

Bom, primeiro você precisa clonar o repositório (óbvio né):

```bash
git clone <url-do-repositorio>
cd cadastro-usuario
```

Agora vai no arquivo `application.properties` e configura seu banco de dados. Fica assim:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

E pronto! Agora é só rodar:

```bash
mvn spring-boot:run
```

Se tudo deu certo, a aplicação vai estar rodando em `http://localhost:8080` 🎉

## 💬 Como usar a API

Aqui estão as coisas que você consegue fazer com a API. É bem simples!

### Cadastrar um novo usuário

Quer adicionar alguém? É só fazer um POST assim:

```http
POST /usuario
Content-Type: application/json

{
  "nome": "João Silva",
  "email": "joao@example.com"
}
```

### Procurar alguém pelo email

Precisa encontrar um usuário? Usa o email dele:

```http
GET /usuario?email=joao@example.com
```

E você vai receber algo assim de volta:

```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao@example.com"
}
```

### Atualizar os dados de um usuário

Mudou de nome ou email? Sem problemas! Você pode atualizar assim:

```http
PUT /usuario/usuarios/{id}
Content-Type: application/json

{
  "nome": "João Silva Santos",
  "email": "joao.santos@example.com"
}
```

*Dica: Você não precisa enviar todos os campos, só os que quer mudar!*

### Remover um usuário

Se precisar deletar alguém, é só passar o email:

```http
DELETE /usuario?email=joao@example.com
```

## 📂 Como está organizado

O projeto segue uma estrutura bem organizada, separando as responsabilidades direitinho:

```
tecnoiso.demo
├── business
│   └── UsuarioService.java          # Aqui fica toda a lógica de negócio
├── controller
│   └── UsuarioController.java       # Os endpoints da API moram aqui
├── infrastructure
│   ├── entitys
│   │   └── Usuario.java             # A classe que representa nosso usuário
│   └── repository
│       └── UsuarioRepository.java   # Quem conversa com o banco de dados
└── CadastroUsuarioApplication.java  # O coração do projeto, onde tudo começa
```

## 💾 Como funciona o banco de dados

A gente tem uma tabela bem simples chamada `usuario`:

| Campo | Tipo    | O que é?                           |
|-------|---------|-------------------------------------|
| id    | Integer | O identificador único (gerado automaticamente) |
| email | String  | O email do usuário (não pode repetir!) |
| nome  | String  | O nome da pessoa                    |



## ✨ O que dá pra fazer

- ✅ Cadastrar usuários novos
- ✅ Encontrar um usuário pelo email
- ✅ Atualizar os dados (nome ou email)
- ✅ Deletar um usuário
- ✅ O sistema não deixa cadastrar emails duplicados (porque seria uma bagunça!)


Vou te mostrar como testar usando o cURL (aquele comando do terminal). Se você preferir, pode usar o Postman ou Insomnia também!

**Criando um usuário novo:**
```bash
curl -X POST http://localhost:8080/usuario \
  -H "Content-Type: application/json" \
  -d '{"nome":"Maria Santos","email":"maria@example.com"}'
```

**Buscando esse usuário:**
```bash
curl -X GET "http://localhost:8080/usuario?email=maria@example.com"
```

**Atualizando o nome dela:**
```bash
curl -X PUT http://localhost:8080/usuario/usuarios/1 \
  -H "Content-Type: application/json" \
  -d '{"nome":"Maria Santos Silva"}'
```

**E se precisar remover:**
```bash
curl -X DELETE "http://localhost:8080/usuario?email=maria@example.com"
```

## ⚠️ E se der erro?

Olha, a API ainda é meio "crua" no tratamento de erros. Por enquanto, se você tentar:
- Buscar um email que não existe, vai receber uma mensagem dizendo "email não encontrado"
- Atualizar um usuário com ID inválido, vai receber "Usuario não encontrado"

É simples, mas funciona! (Mas sim, dá pra melhorar isso 😅)

## 🤝 Quer contribuir?

Adoraria ter sua ajuda pra melhorar esse projeto! Se quiser contribuir:

1. Faz um fork do projeto
2. Cria uma branch nova (`git checkout -b feature/MinhaIdeia`)
3. Commita suas mudanças (`git commit -m 'Adicionei uma coisa legal'`)
4. Dá um push (`git push origin feature/MinhaIdeia`)
5. Abre um Pull Request

Toda contribuição é bem-vinda! 💙



Esse é um projeto de estudos/portfólio feito com muito carinho. Se tiver dúvidas, sugestões ou quiser trocar uma ideia sobre Spring Boot, chama aí!

---

Feito com ☕ e muita dedicação!

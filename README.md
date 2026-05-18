# Nexo Core 

O **Nexo Core** é a API REST que gerencia o ecossistema da **Nexo Art**, uma plataforma voltada para ilustradores e concept artists compartilharem seus portfólios, gerenciarem comissões e interagirem com a comunidade. O backend foi projetado seguindo as melhores práticas de arquitetura, segurança e escalabilidade.

##  Tecnologias e Dependências

- **Linguagem:** Java 17 / 21
- **Framework:** Spring Boot 3.x
- **Persistência de Dados:** Spring Data JPA / Hibernate
- **Banco de Dados:** PostgreSQL (Ambiente conteinerizado com Docker)
- **Segurança:** Spring Security + Autenticação Baseada em Tokens JWT
- **Upload de Mídias:** Cloudinary SDK (Armazenamento em nuvem)
- **Documentação:** Springdoc OpenAPI (Swagger UI)

##  Arquitetura e Fluxo de Dados

A API utiliza a arquitetura padrão MVC/Service Layer. Um dos principais destaques do projeto é o fluxo assíncrono e otimizado de postagens de mídia:
1. **Upload Desacoplado:** O cliente envia o arquivo de imagem bruto para a rota `/upload`.
2. **Armazenamento em Nuvem:** O `CloudinaryService` processa e envia a mídia para os servidores da Cloudinary, retornando uma URL segura de internet.
3. **Persistência Leve:** O cliente consome a rota `/posts` enviando apenas a descrição e a URL gerada, mantendo o banco de dados PostgreSQL leve e focado em dados relacionais de texto.

##  Como Executar o Projeto

### Pré-requisitos
- Docker e Docker Compose instalados.
- JDK 17 ou superior.
- Uma IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code).

## 1. Configuração do Banco de Dados (Docker)
O projeto conta com o suporte nativo do Spring Boot ao Docker Compose. Para subir a instância do PostgreSQL manualmente ou isolar o ambiente, navegue até a raiz do projeto e execute:
```bash
docker compose up -d
```
## 2. Variáveis de Ambiente (application.properties)

Certifique-se de que o arquivo src/main/resources/application.properties contenha as credenciais corretas para o banco e para a nuvem.

#### Configurações do Banco de Dados
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/nexo_db
spring.datasource.username=nexo_user
spring.datasource.password=nexo_pass
spring.jpa.hibernate.ddl-auto=update
```
### Configurações do Cloudinary
```bash
cloudinary.cloud_name=seu_cloud_name
cloudinary.api_key=sua_api_key
cloudinary.api_secret=seu_api_secret
```
### Upload limits
```bash
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
```
> [!IMPORTANT]
>Não se esqueça de que o application.properties sempre deve ser inserido  na lista do seu gitignore pois ele tem chaves muito importantes

## 3. Executando a Aplicação

Execute o comando Maven na raiz do projeto ou dê Play através de sua IDE na classe NexoCoreApplication.java.
```Bash
./mvnw spring-boot:run
``` 
### Documentação da API (Swagger)

Com a aplicação rodando, a documentação interativa com todas as rotas de autenticação, posts e uploads estará disponível em:
```bash
http://localhost:8080/swagger-ui.html
```

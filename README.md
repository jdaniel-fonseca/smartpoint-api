<div align="center">

# 🕒 SmartPoint API

API REST para registro de ponto eletrônico e gerenciamento de jornadas de trabalho.

![Java](https://img.shields.io/badge/Java-25-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)

</div>

## Sobre

A SmartPoint é minha API de controle de ponto eletrônico. A ideia é permitir o registro de entradas, saídas e intervalos, além de facilitar a consulta das jornadas de trabalho.

Quero usar este projeto para explorar funcionalidades mais completas, como geolocalização no registro de ponto, relatórios em PDF e integração com IA para analisar dados de jornada. Tudo isso será implementado por etapas.

## Tecnologias

- Java 25
- Spring Boot 4
- Spring Web MVC e Spring Data JPA
- Flyway
- Maven e Lombok
- Dockerfile e Docker Compose
- PostgreSQL e H2 

## O que pretendo implementar

- [ ] Consolidar o cadastro de empresas e funcionários
- [ ] Registrar entrada, saída e intervalos
- [ ] Consultar histórico e calcular horas trabalhadas
- [ ] Implementar autenticação e perfis de acesso com Spring Security + JWT
- [ ] Integrar geolocalização aos registros de ponto
- [ ] Gerar relatórios em PDF
- [ ] Integrar IA para consultas e análises das jornadas
- [ ] Adicionar Swagger / OpenAPI
- [ ] Criar testes unitários e de integração
- [ ] Validar o ambiente Docker
- [ ] deploy na AWS

## Como executar

```bash
git clone https://github.com/jdaniel-fonseca/smartpoint-api.git
cd smartpoint-api
./mvnw spring-boot:run
```

No Windows, utilize `mvnw.cmd spring-boot:run`. Verifique as configurações da aplicação e as variáveis de ambiente antes de executar. O repositório também contém arquivos para Docker, mas a configuração ainda está em evolução.

## Autor

[José Daniel](https://github.com/jdaniel-fonseca)

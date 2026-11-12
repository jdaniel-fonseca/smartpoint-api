<div align="center">

# 🕒 SmartPoint API

**API REST para controle de ponto eletrônico e gestão de jornadas de trabalho.**

![Java](https://img.shields.io/badge/Java-25-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.6-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-Driver-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Configuração_iniciada-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Status](https://img.shields.io/badge/Status-Em_desenvolvimento-yellow?style=for-the-badge)

</div>

## 📖 Sobre o projeto

A **SmartPoint API** é um projeto back-end de controle de ponto eletrônico, pensado para apoiar o registro de jornadas de trabalho e a evolução de processos de gestão de frequência.

Seu roadmap inclui **geolocalização**, **geração de relatórios em PDF** e **integração com inteligência artificial**, com foco em construir uma aplicação mais completa, modular e preparada para integrações.

> 🚧 **Em desenvolvimento:** este README distingue tecnologias presentes no repositório das funcionalidades previstas para próximas versões.

## 🛠️ Tecnologias

Identificadas no repositório e no `pom.xml`:

- **Java 25** e **Spring Boot 4.0.6**
- **Spring Web MVC** para endpoints HTTP
- **Spring Data JPA** para persistência
- **MySQL** e **H2** (drivers declarados)
- **Flyway** (dependência de migrações de banco)
- **Lombok** e **Maven**
- **Dockerfile** e **docker-compose.yml** presentes no repositório (execução ainda não verificada)

## 🎯 Visão do produto

O objetivo é evoluir o sistema para oferecer:

- Cadastro e gestão de funcionários
- Registro de entradas, saídas e intervalos
- Consulta de histórico de jornadas
- Relatórios de frequência e horas trabalhadas
- Registro de localização, com consentimento e regras de privacidade
- Análises de jornadas apoiadas por IA

**Importante:** esta seção descreve a visão do produto, não uma lista de funcionalidades já concluídas.

## 🧱 Fluxo planejado de registro de ponto

```text
Aplicação cliente
    |
    | Solicitação de registro + localização autorizada
    v
SmartPoint API (Spring Boot)
    |
    | Autenticação, validações e regras de jornada
    v
Camada de persistência (JPA)
    |
    v
Banco de dados
```

A aplicação cliente poderá utilizar a **Geolocation API do navegador** para solicitar coordenadas. O back-end poderá calcular distâncias até locais autorizados, sem depender necessariamente de um serviço de mapas. Geolocalização do dispositivo exige cuidados com precisão, fraude e proteção de dados pessoais.

## ▶️ Como executar

**Pré-requisito:** JDK 25 e as configurações de ambiente adequadas.

```bash
git clone https://github.com/jdaniel-fonseca/smartpoint-api.git
cd smartpoint-api
./mvnw spring-boot:run
```

No Windows, utilize `mvnw.cmd spring-boot:run`.

O repositório também contém `Dockerfile`, `docker-compose.yml` e `.env.example`. Confira as variáveis necessárias antes de tentar subir os containers. **Os comandos e serviços não foram testados neste ambiente.**

## 🗺️ Roadmap

- [ ] Consolidar e documentar funcionalidades de registro de ponto
- [ ] Implementar autenticação JWT e perfis de acesso
- [ ] Integrar geolocalização e regras de validação de local
- [ ] Desenvolver relatórios em PDF
- [ ] Integrar IA para análises e consultas sobre jornadas
- [ ] Criar testes unitários e de integração
- [ ] Validar ambiente Docker e Docker Compose
- [ ] Realizar deploy na AWS

> Para uso real em empresas no Brasil, será necessário avaliar LGPD e regras legais aplicáveis ao registro eletrônico de ponto.

## 👨🏽‍💻 Autor

Desenvolvido por **José Daniel de Oliveira Fonseca**.

[GitHub](https://github.com/jdaniel-fonseca) · [Repositório](https://github.com/jdaniel-fonseca/smartpoint-api)

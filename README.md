# exam-service — Radiology Workflow Backend (WIP)

> 🚧 **Status: actively in development.** This is a personal learning project I'm building incrementally to deepen my backend engineering skills, drawing on my background in radiology support/workflows. I'm documenting progress here as I go — expect commits most days.

## What this is

A Spring Boot backend that models a real radiology imaging workflow: patient arrival → check-in → room entry → exam in progress → images captured → exam completed. The domain is one I have hands-on operational experience with, so the goal is a project that's realistic rather than another generic CRUD/e-commerce demo.

The project starts as a single service and will evolve into a small microservices system (Patient Service, Exam/Order Service, Modality/Resource Service) as it grows.

## Why I'm building this

I'm a backend-leaning developer with a support/troubleshooting background, working to deepen my production-level Java/Spring skills after some time away from active development. Rather than studying topics in isolation, I'm building one evolving system that surfaces as many real-world backend concepts as possible — and being upfront that this is a learning project, not a claim of pre-existing expertise in every technology listed below.

## Tech stack (current + planned)

**Core**
- Java 21
- Spring Boot 3
- Spring Web, Spring Data JPA, Spring Validation
- Oracle Database (XE), via Docker
- Maven

**Testing**
- JUnit 5, Mockito, AssertJ
- JaCoCo (coverage), SonarQube (static analysis) — planned

**Architecture & Patterns**
- Layered architecture (entity / repository / service / controller / DTO)
- SOLID principles, Clean Code practices
- Design patterns surfaced through real features (Strategy, Builder, Observer, State, Factory, Decorator, Adapter, Template Method, Chain of Responsibility, Proxy) — in progress

**Planned — Microservices & Cloud-Native**
- Service split: Patient / Exam / Modality services
- Spring Cloud: Eureka (service discovery), Gateway, Config Server, Resilience4j, Feign
- Distributed tracing with Zipkin
- Docker Compose, Kubernetes basics
- Observability: Actuator, Prometheus, Grafana, Elasticsearch

**Planned — Domain-specific concerns**
- HIPAA/PHI-aware design: audit logging, access control on patient data, PHI-safe logging
- Repository layer designed for eventual NoSQL swap-in (MongoDB)

## Progress log

| Date | Milestone |
|------|-----------|
| _(fill in)_ | Project scaffolded, Oracle connected via Docker, base entities (`Patient`, `Exam`, `Modality`) modeled with JPA relationships |
| _(fill in)_ | Repository layer with Spring Data JPA, verified against real Oracle instance via integration test |

_(This table will grow as the project progresses — see commit history for day-to-day detail.)_

## Running locally

Requires Docker Desktop and Java 21.

**1. Start the Oracle database:**
```bash
docker-compose up -d
```

**2. Set the required environment variable(s):**

Database credentials are externalized rather than hardcoded. Before running the app, set:

```bash
# macOS/Linux
export DB_PASSWORD=RadiologyPass123

# Windows PowerShell (current session)
$env:DB_PASSWORD="RadiologyPass123"

# Windows PowerShell (persistent)
[System.Environment]::SetEnvironmentVariable("DB_PASSWORD", "RadiologyPass123", "User")
```

`DB_USERNAME` also exists as an override but defaults to `radiology_user` if not set.

If running from IntelliJ, add `DB_PASSWORD` under **Run → Edit Configurations → Environment variables** instead.

**3. Run the app:**
```bash
./mvnw spring-boot:run
```

## Notes

This README will be updated as new phases are completed. Design tradeoffs and decisions along the way will show up both here and in commit messages/PR-style notes, rather than being written after the fact.
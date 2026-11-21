# Teste de Software — 2º Bimestre

Aqui estão as atividades de **TDD** (desenvolver escrevendo o teste primeiro) e de **testes de integração** da matéria de Teste de Software.

**Dupla:**

- Fernando Queiroz — RA: 24038237-2
- Vitor Hugo Assis da Silva — RA: 24140023-2

## O que tem aqui

| Pasta | O que é | Como rodar |
|---|---|---|
| `Atividade semana 10/bubblesort-tdd` | Ordenação de números com Bubble Sort | `mvn test` |
| `Atividade semana 10/carrinho-compras-tdd` | Carrinho com total, remoção e desconto de 10% | `mvn test` |
| `Atividade semana 10/conta-bancaria-tdd-maven` | Conta com depósito e saque | `mvn test` |
| `Atividade semana 10/estoque-tdd` | Controle de estoque de produtos | `mvn test` |
| `Atividade semana 11/exercicios_integracao_springboot` | Testes de integração com Spring Boot, H2 e MockMvc | `mvn test` |

Cada pasta é um projeto Maven independente: entre na pasta do projeto e rode `mvn test` lá.

## O que você precisa ter instalado

- Java 17 ou mais novo
- Maven

## Ciclo do TDD (usado nas atividades da semana 10)

```text
RED      → escreva um teste que falha
GREEN    → escreva o mínimo de código para ele passar
REFACTOR → deixe o código mais limpo, com os testes ainda passando
```

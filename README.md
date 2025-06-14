# Bolsa de Valores - Estrutura de Dados (Projeto UT2)

Este projeto tem como objetivo processar e analisar dados históricos da BOVESPA utilizando **estruturas de dados implementadas manualmente** em Java, conforme os princípios aprendidos na disciplina de **Estrutura de Dados**.

## 🎯 Objetivo

- Realizar **transformações** e **filtragens** em um grande volume de registros de ações da bolsa.
- Aplicar **algoritmos de ordenação** e **estruturas de dados não-nativas** (sem usar ArrayList, HashMap, etc.).
- Justificar o uso de cada estrutura de dados com base em sua eficiência e aplicabilidade prática.

---

## 🗂 Estrutura do Projeto

```
projeto_organizado/
├── data/                      # Arquivos .csv de entrada e saída
├── src/
│   └── main/
│       └── java/
│           ├── bovespa/              # Classes principais do projeto
│           ├── bovespa.ordenacoes/  # Algoritmos de ordenação
│           └── estruturas/          # Estruturas de dados manuais
├── pom.xml                   # Projeto Maven
└── README.md                 # Este arquivo
```

---

## ⚙️ Tecnologias Utilizadas

- Java 17
- Maven
- Eclipse IDE
- Git e GitHub

---

## 🧠 Estruturas de Dados Implementadas

| Estrutura       | Finalidade                                                                 |
|----------------|------------------------------------------------------------------------------|
| `ListaLigada`   | Substitui arrays estáticos para leitura dinâmica de registros do CSV       |
| `HashTable`     | Agrupa rapidamente registros por data, com inserção e acesso em tempo médio O(1) |
| `MaxHeap`       | Permite obter rapidamente o registro com maior volume dentro de um grupo   |

---

## 📌 Onde foram usadas

- `ListaLigada`: substitui arrays em `Funcoes.java` e manipulações nos filtros.
- `HashTable`: utilizada para agrupar `Registro` por data em `FiltrarRegistro` e `FiltrarMediaDiaria`.
- `MaxHeap`: utilizada em `FiltrarRegistro` para obter o registro com maior volume por data.

---

## 📁 Arquivos de entrada/saída

> Todos os arquivos `.csv` estão em `data/`:

- `b3stocks_1994_2020.csv`: base original de dados da BOVESPA
- `b3stocks_F1.csv`: resultado do filtro de maior volume por dia
- `b3stocks_T1_Filtrado.csv`: resultado do filtro de volume acima da média diária

---

## 🚀 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/danilodnf157/bolsa-valores-estrutura-dados-Projeto-UT2.git
   ```
2. Importe no Eclipse como **Maven Project**
3. Execute a classe `Main.java` em `bovespa`

---

## 📚 Relatório Técnico resumido.

### Justificativas:
- Arrays fixos foram substituídos por listas ligadas para melhor uso de memória.
- A HashTable permite agrupar registros por data com mais performance que ordenações.
- MaxHeap é ideal para extrair o registro com maior volume sem varrer o grupo inteiro.

### Restrições atendidas:
✅ Não utilizamos nenhuma estrutura nativa (como ArrayList ou HashMap).  
✅ Todas as estruturas estão no pacote `estruturas`.

---

## 👨‍💻 Autores

- Danilo Nascimento — [danilodnf157@gmail.com](mailto:danilodnf157@gmail.com)
- Projeto UT2 — Estrutura de Dados (UEPB)

---

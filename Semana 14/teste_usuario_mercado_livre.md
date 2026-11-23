# Teste de Usuário Final — Mercado Livre (busca, comparação e simulação de compra)

**Disciplina:** Teste de Software — Semana 14
**Site avaliado:** https://www.mercadolivre.com.br (versão desktop, em navegador web)
**Data do registro:** 14/11/2026
**Participante:** 1 usuário final (o autor deste relatório), com a conta do Mercado Livre já logada

## 1. Objetivo

Avaliar a facilidade de uso, a eficiência e a clareza da interface do Mercado Livre durante a **busca, a comparação e a simulação de compra** de um produto, aplicando conceitos de IHC e de testes de usabilidade.

## 2. Cenário

Comprar um **fone de ouvido sem fio** para uso diário: encontrar um modelo bem avaliado, comparar opções e simular a compra **até o carrinho e o início do checkout, sem finalizar o pagamento**.

## 3. Tarefas executadas

1. Acessar o site.
2. Pesquisar "fone de ouvido Bluetooth".
3. Usar os filtros: apenas entrega **Full** e ordenação pelos **melhores avaliados**.
4. Escolher um produto e abrir os detalhes.
5. Adicionar o item ao carrinho.
6. Simular o início da compra (sem concluir o pagamento).
7. Voltar à tela inicial.

**Produto escolhido:** Fone de Ouvido Bluetooth AGOLD A39 In-ear Preto com Microfone — nota 4,7 (79 opiniões), "+100 vendidos", R$ 63,17 no Pix, enviado pelo Full.

## 4. Planilha de observação

Legenda da coluna Sucesso: **S** = concluída; **Parcial** = concluída com adaptação; **N** = não concluída.

| Tarefa | Tempo (s) | Sucesso | Erros | Observações |
|---|---:|:---:|:---:|---|
| 1. Acessar o site | 7 | S | 0 | A página inicial carregou sem dificuldade. |
| 2. Buscar produto | 5 | S | 0 | O campo de busca fica em destaque no topo. A busca retornou 2.371 itens. |
| 3. Aplicar filtros | 37 | **Parcial** | 1 | O filtro **Full** foi fácil de achar (chave no topo da lateral). Já a ordenação por avaliação **não existe**: o menu "Ordenar por" só oferece *Mais relevantes*, *Menor preço* e *Maior preço*, e a lateral não tem filtro de avaliação. Procurei a opção por um tempo antes de concluir que ela não existia (perda de caminho). Contornei comparando as notas exibidas em cada card. |
| 4. Abrir detalhes | 8 | S | 0 | A nota e a quantidade vendida, mostradas no card, ajudaram na escolha. |
| 5. Adicionar ao carrinho | 36 | S | 1 | O primeiro clique funcionou, mas a tela anterior continuou visível por alguns segundos. Cliquei de novo e acabei acertando uma recomendação ("smartwatch") da tela de confirmação. Conferi o carrinho: 1 item, correto. |
| 6. Simular compra | 38 | S | 0 | Carrinho → tela de **seguro** (não prevista no fluxo) → "Finalize sua compra". Parei antes de "Pagar e finalizar". |
| 7. Voltar à tela inicial | 13 | S | 0 | O logotipo leva à home, que já mostra "Compre seu carrinho" com o item. |
| **Total** | **144 (2 min 24 s)** | | **2** | |

## 5. Métricas e critérios de sucesso

| Métrica | Resultado |
|---|---|
| Tempo de execução | **2 min 24 s** |
| Taxa de sucesso (fluxo concluído sem ajuda) | Fluxo concluído sem ajuda, com uma adaptação na tarefa 3 (não há ordenação por avaliação). |
| Erros cometidos | 2 (1 perda de caminho por confusão nos filtros; 1 clique incorreto depois de adicionar ao carrinho). |
| Satisfação (SUS) | **82,5 / 100**, acima da média de referência (68), o que indica boa usabilidade. O cálculo está no Anexo A. |

| Critério de sucesso | Meta | Resultado | Atendido? |
|---|---|---|:---:|
| Usuários que adicionam o produto ao carrinho | ≥ 90% | 1 de 1 (100%) | Sim* |
| Tempo médio para concluir o teste | ≤ 4 min | 2 min 24 s | Sim* |

\* Com **um único participante**, os percentuais e a média não têm valor estatístico. Servem apenas como registro desta execução.

## 6. Problemas de usabilidade encontrados

Os problemas estão classificados por gravidade (alta, média ou baixa) e relacionados às heurísticas de Nielsen.

| # | Gravidade | Problema | Heurística |
|---|:---:|---|---|
| 1 | **Alta** | **A tarefa "ordenar pelos melhores avaliados" não pôde ser feita como descrita.** O menu de ordenação não tem esse critério e não existe filtro de avaliação. A nota só aparece dentro de cada card, o que obriga a comparar manualmente. | Flexibilidade e eficiência de uso; compatibilidade com o mundo real |
| 2 | Média | **A tela de seguro aparece antes do checkout**, com a opção de 2 anos **já pré-selecionada** e marcada como "Recomendado". O botão "Agora não" é secundário, enquanto "Adicionar" ganha o destaque azul. Isso acrescenta uma etapa e induz a aceitar. | Controle e liberdade do usuário; prevenção de erros |
| 3 | Média | **O feedback ao adicionar ao carrinho é lento e ambíguo.** A página anterior continua visível até a tela de confirmação carregar, o que levou a um segundo clique em um elemento errado. | Visibilidade do status do sistema |
| 4 | Média | **Mensagens e valores confusos no carrinho.** Aparece "Você atingiu a quantidade máxima disponível" com 1 unidade e "+50 disponíveis". A mensagem "Aproveite o frete grátis adicionando mais produtos" surge ao lado de um frete que já é grátis. O resumo mostra "Total R$ 367,80" junto de "R$ 214,63 no Pix". | Consistência e padrões; reconhecimento em vez de memorização |
| 5 | Média | **O preço muda entre as telas.** São R$ 214,63 (Pix) na página do produto e **R$ 221,27** no total do checkout, até o usuário escolher a forma de pagamento (o Pix não vem selecionado). A relação com o desconto do Pix não é óbvia. | Visibilidade do status do sistema; prevenção de erros |
| 6 | Baixa | **Anúncios patrocinados ("Ad") misturados** aos primeiros resultados e um banner de marca grande que empurra a lista para baixo. | Estética e design minimalista |
| 7 | Baixa | **O rótulo "FULL com frete grátis"** mistura dois conceitos (tipo de envio e frete grátis) e fica logo acima de outro filtro, "Frete grátis", o que pode confundir. | Consistência e padrões |
| 8 | Baixa | **O banner de cookies fica fixo** e cobre a parte inferior de todas as páginas até o usuário responder. | Estética e design minimalista |

## 7. Pontos positivos

- Campo de busca em destaque e resultado imediato.
- Filtro Full simples (chave liga/desliga), com feedback claro: contador de resultados (2.371), indicador de carregamento e URL que reflete o filtro.
- Cards com **nota, quantidade vendida, preço, desconto e frete**, que facilitam a comparação.
- Página de detalhes completa: avaliação, opiniões, preço, parcelamento, prazo de entrega, estoque, vendedor e política de devolução. Os dois botões ("Comprar agora" e "Adicionar ao carrinho") têm hierarquia visual clara.
- Checkout em **tela única** (entrega, pagamento e resumo juntos), com o endereço já preenchido e o botão "Pagar e finalizar" bem visível.
- Carrinho **persistente**: a home passa a mostrar "Compre seu carrinho".

## 8. Recomendações

1. Incluir **"Melhores avaliados"** no menu "Ordenar por" e/ou um filtro por nota (por exemplo, 4 estrelas ou mais).
2. Não pré-selecionar o seguro e dar o mesmo peso visual a "Agora não" e "Adicionar".
3. Dar **confirmação imediata** ao adicionar ao carrinho (estado de carregamento no botão ou aviso "Adicionado!") antes de trocar de tela.
4. Revisar as mensagens do carrinho (quantidade máxima e frete grátis) e o resumo de valores, mostrando **um único total a pagar**.
5. Explicar no checkout que o desconto do Pix só é aplicado quando esse meio de pagamento é escolhido.

## 9. Conclusão

O fluxo foi concluído em 2 min 24 s, dentro da meta de 4 minutos, com 2 erros e SUS de 82,5. O principal problema foi a falta da ordenação por melhores avaliados (tarefa 3), que obrigou a comparar as notas manualmente. Os demais problemas (seguro pré-selecionado, feedback lento ao adicionar ao carrinho e valores diferentes entre as telas) têm gravidade média ou baixa e não impediram a simulação da compra. Como houve apenas um participante, os resultados valem como registro desta execução, não como conclusão geral sobre o site.

## 10. Limitações

- Foram apenas **um participante** e **uma execução**. Os tempos, os erros e a pontuação SUS (1 respondente) não podem ser generalizados.
- O site tinha campanhas sazonais (Black Friday 2026) e conteúdo personalizado por conta, então a interface e os resultados podem variar entre usuários e datas.
- Nenhum pagamento foi realizado: parei na tela "Finalize sua compra".

---

## Anexo A — Formulário SUS

Escala de 1 (discordo totalmente) a 5 (concordo totalmente).

| # | Afirmação | 1 | 2 | 3 | 4 | 5 |
|---|---|:-:|:-:|:-:|:-:|:-:|
| 1 | Acho que gostaria de usar este sistema com frequência. | | | |x| |
| 2 | Achei o sistema desnecessariamente complexo. | |x| | | |
| 3 | Achei o sistema fácil de usar. | | | | |x|
| 4 | Acho que precisaria de ajuda de uma pessoa técnica para usar o sistema. | |x| | | |
| 5 | Achei que as várias funções do sistema estavam bem integradas. | | | | |x|
| 6 | Achei que havia muita inconsistência no sistema. |x| | | | |
| 7 | Imagino que a maioria das pessoas aprenderia a usar o sistema rapidamente. | | | |x| |
| 8 | Achei o sistema muito complicado de usar. | |x| | | |
| 9 | Senti-me muito confiante ao usar o sistema. | | | |x| |
| 10 | Precisei aprender muitas coisas antes de conseguir usar o sistema. | |x| | | |

### Cálculo da pontuação SUS

Itens ímpares: contribuição = resposta − 1. Itens pares: contribuição = 5 − resposta.
A soma das contribuições × 2,5 dá a pontuação (de 0 a 100; acima de ~68 indica boa usabilidade).

| Item | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | Soma |
|---|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
| Resposta | 4 | 2 | 5 | 2 | 5 | 1 | 4 | 2 | 4 | 2 | |
| Contribuição | 3 | 3 | 4 | 3 | 4 | 4 | 3 | 3 | 3 | 3 | **33** |

**Pontuação SUS = 33 × 2,5 = 82,5**

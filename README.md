# projeto

Para utilizar a aplicação é preciso importar no eclipse ou a ide utilizada e "rodar" a classe "EscolaAlfApplication".
Os testes podem ser feitos tanto no postman ou em qualquer aplicativo de teste de api.


Funcionalidades/endpoints da aplicação:
Método post: "/gabarito/cadastro"
Cadastrar o gabarito de cada prova;
exemplo de request:

{
    "questoes": [
            {
             "alternativa": "A",
             "peso": 3
            },
            {
             "alternativa": "B",
             "peso": 4
            },
            {
             "alternativa": "C",
             "peso": 5
            },
            {
             "alternativa": "D",
             "peso": 1
            },
            {
             "alternativa": "D",
             "peso": 2
            }
        ]
}

Response esperado: "Gabarito cadastrado com sucesso"

Método post: "/alunos/prova-aluno"
Cadastrar as respostas de cada aluno para cada prova;

[
        {
            "nomeDoAluno": "Matael",
            "provas": [
                "A",
                "B",
                "C",
                "A",
                "D"
            ]
        },
        {
            "nomeDoAluno": "Uriel",
            "provas": [
                "B",
                "B",
                "B",
                "B",
                "B"
            ]
        },
        {
            "nomeDoAluno": "Tyrael",
            "provas": [
                "D",
                "D",
                "D",
                "D",
                "D"
            ]
        }
]


Response esperado: "Provas cadastrada com sucesso"

Método get: "/alunos/provas-nota-final"
Verificar a nota final de cada aluno;

Response esperado: "[{"nomeDoAluno":"Matael","provas":["A","B","C","A","D"],"nota":9},{"nomeDoAluno":"Uriel","provas":["B","B","B","B","B"],"nota":6},{"nomeDoAluno":"Tyrael","provas":["D","D","D","D","D"],"nota":4}]"

Método get: "/alunos/provas-notas-alunos"
Listar os alunos aprovados.

Response esperado: "[
    [
        "Matael"
    ]
]"

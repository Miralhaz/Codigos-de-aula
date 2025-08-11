# Lista ou vetor: mutável, ordenado, indexado de 0 a n
lista = [10, 20, 30] # Vetor
print(lista[2])


# Tupla: não mutável, ordenado, indexado de 0 a n
tupla = (10, 20, 30) # Tupla
print(tupla[0])
# Forçando erro: tupla[1] = 6


# Dicionário: é mutável, é ordenado (a partir da v3.7), é indexado pela chave
dicionario = {"num01":10, "num02":20, "num03":30} # Dicionário
dicionarioAluno = {"nome": "Bob", "idade": 23, "peso": 71.4}
print(dicionarioAluno["peso"])


# Matriz: vetor de vetor, ou vetor com mais de uma dimensão, nesse caso, 2
matriz = [[10], [20], [30]] # Matriz
# Matriz 3x3
matriz01 = [
    [10, 20, 30],
    [40, 50, 60],
    [70, 80, 90]
]


print(type(lista))
print(type(tupla))
print(type(dicionario))
print(type(matriz))
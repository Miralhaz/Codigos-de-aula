#  ____  _____ ____    _    _____ ___ ___    ___ __  __  ____ 
# |  _ \| ____/ ___|  / \  |  ___|_ _/ _ \  |_ _|  \/  |/ ___|
# | | | |  _| \___ \ / _ \ | |_   | | | | |  | || |\/| | |    
# | |_| | |___ ___) / ___ \|  _|  | | |_| |  | || |  | | |___ 
# |____/|_____|____/_/   \_\_|   |___\___/  |___|_|  |_|\____|

# PARTE 1 - CÁLCULO DO IMC

# Solicite ao usuário que digite:
# • Peso (em kg)
# • Altura (em metros)
# • Calcule o IMC usando a fórmula: imc = peso/(altura**2)

peso = input("Digite seu peso (kg): ")
altura = input("Digite sua altura (m): ")

peso_inteiro = int(peso)
altura_decimal = float(altura)

imc = peso_inteiro / (altura_decimal ** 2)

print(f"Seu IMC é: {round(imc, 2)}")


# Parte 2 - Classificação do IMC
# Após calcular o IMC, informe a classificação correspondente conforme a imagem abaixo:


  
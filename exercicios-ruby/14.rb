# Funções, bocks e lambdas


# parametros default de uma função
def produzir(tamanho = :M, cor = :azul, quantidade)
    puts "produzindo roupas de tamanho #{tamanho}, cor #{cor} e quantidade #{quantidade}"
end

produzir('G', 'vermelha', 10)
produzir(:P, :preta, 10)
produzir(10)


# parametros variáveis de uma função
def imprimir_nomes(escola, *nomes)
    nomes.each { |n| puts n}
    puts "São estudantes do #{escola}"
end

lista = ['IEMS', 'pedro', 'gabriel', 'joao', 'vinicius', 'agnes', 'dieffany', 'tamilys']

imprimir_nomes('IEMS')
imprimir_nomes('IEMS', lista)
imprimir_nomes('IEMS', 'pedro', 'gabriel', 'joao', 'vinicius', 'agnes', 'dieffany', 'tamilys')


# Parametros com palavra chave na função
def produzir_de_novo(quantidade, tamanho: :m, cor: :azul)
    puts "produzindo roupas de tamanho #{tamanho}, cor #{cor} e quantidade #{quantidade}"
end

produzir_de_novo(10, tamanho: 'P', cor: 'verde')
produzir_de_novo(cor: 'branca', 16, tamanho: 'M')

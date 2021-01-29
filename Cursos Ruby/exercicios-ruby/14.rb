# Funções, blocks e lambdas


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


# Blocks
require 'net/http'
require 'json'

def listar_usuarios()
    uri = URI('http://jsonplaceholder.typicode.com/users')
    response = Net::HTTP.get(uri)
    yield JSON.parse(response) if block_given?
    puts "Finalizando listagem de usuarios"
end

listar_usuarios do |usuarios|
    usuarios.each do |usuario|
        puts "Nome: #{usuario['name']}"
    end
end


# Blocks e Procs
def listar_usuarios2(quantidade, proc)
    uri = URI('http://jsonplaceholder.typicode.com/users')
    response = Net::HTTP.get(uri)
    proc.call(quantidade)
    yield JSON.parse(response) if block_given?
    puts "Finalizando listagem de usuarios"
end

debug = Proc.new { |variavel| puts "Debugando variável #{variavel}" }

listar_usuarios2 10, debug do |response|
        puts "Total de usuarios: #{response.size}"
end

listar_usuarios2 10, debug


# Lambdas
lamb = -> (nome) { puts "Meu nome é #{nome}" }
lamb.call("pedro")


# Constantes = letras maiusculas
MaxUser = 10

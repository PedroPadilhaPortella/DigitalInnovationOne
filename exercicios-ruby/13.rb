# Arrays

#declaracao
lista = []
lista = Array.new
lista = [1, 2, 3, 4, 5]
lista = [1, true, 'pedro', :nome, 8.3]

lista = %w(pedro henrique padilha portella da cruz)
puts lista

# metodos de listas
puts lista.size
puts lista.empty?
puts lista[0]

lista[0] = "daniel"
lista.push('kadjin')
puts lista

puts lista.join(', ')



# Module Enumerable
lista = [1, 6, 5, 4]
lista.each { |i| puts i}

puts lista.sort
puts lista.reduce(0) { |resultado, proximo| resultado + proximo }
puts lista.map { |numero| numero * numero}

# Hash 
hash = {}
hash = {nome: 'Pedro', idade: 19, sexo: 'M'}
puts hash[:nome]
hash[:sobrenome] = 'Henrique'

hash.each do |chave, valor| puts "#{chave}: #{valor}" end
puts hash.map { |chave, valor| "#{valor}: #{chave}"}

# Range
intervalo = 1..5

puts intervalo.class
puts intervalo
puts intervalo.include? 3
puts intervalo.include? 7
intervalo.each { |i| puts i}
puts intervalo.map {|i| i * i} 

# range em case when
entrada = gets.to_i
case entrada 
    when 1..2 then puts "entre 1 e 2"
    when 2..5 then puts "entre 2 e 5"
    else puts "outro"
end
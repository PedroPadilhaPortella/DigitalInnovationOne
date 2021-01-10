# Tipos de Dados

t = true.class
f = false.class
n = 10.class
float = 1.5.class
binario = 0b1010
octal = 0o45
hexadecimal = 0xad1f
big = 1_000_000_000

puts t, f, n, float, binario, octal, hexadecimal, big



# Interpolação de Strings
marca = 'jeep'
modelo = 'renegade'
motor = 2.0
frase = "#{marca} #{modelo} tem motor #{motor}"

puts frase
puts frase.encoding # encoding de strings

puts "'nome': \"Pedro Portella\"" # aspas em strings

multilines = <<EOS 
    lorem lorem 
    lorem lorem lorem lorem lorem 
    lorem lorem lorem lorem lorem 
    lorem lorem lorem lorem lorem 
    lorem lorem lorem lorem lorem
EOS
puts multilines 


# Operadores de Strings
puts "Pedro".downcase
puts "Pedro".upcase
puts "     white spaces      ".strip
puts 'jeep renegade'.capitalize

nome = "edwin portella"
nome['edwin'] = 'daniel'
puts nome

puts "kaiak".chars
puts nome.split(' ')


# Symbols
# string global, com :nome

"nome".to_sym # converter string para symbol
:nome.to_s # converter symbol para string
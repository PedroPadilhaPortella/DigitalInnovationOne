# Estrutura de Repeticao e Iteracao For e Each

for i in [10,20,30]
    puts i
end


for i in 1..10
    puts i
end


["laranja", "maca", "pera", "banana"].each do |fruta|
    puts fruta
end


["abacaxi", "mamao", "uva", "limao"].each { |fruta| puts fruta} 


10.upto(100) { |i| puts i}


loop do
    puts "loop infinito"
    break
end
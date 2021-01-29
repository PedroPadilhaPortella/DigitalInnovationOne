# Tratamento de excessoes


def divide(a, b)
    raise "Divisao por 0 inválida" if b == 0
    a / b
end


begin
    resultado = divide(10, 5)
    puts resultado
    resultado = divide(8, 0)
    puts resultado
rescue Exception => e
    puts "Erro ao dividir: " + e.message
else
    puts "Ok, divisão realizada!"
ensure
    puts "Essa linha sempre será executada (finally)"
end
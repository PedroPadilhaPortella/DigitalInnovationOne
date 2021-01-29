# classes em Ruby

class Carro
    def velocidade_maxima
        250
    end
    def add_marca(marca)
        @marca = marca
    end
    def marca
        @marca
    end
end

novo_carro = Carro.new
puts "Velocidade máxima do carro: #{novo_carro.velocidade_maxima}"
novo_carro.add_marca("Ferrari")
puts "Marca: #{novo_carro.marca}"

a = "RUBY PARA INICIANTES"
b = a

b.downcase!
puts a

c = a.clone
c.upcase!
puts c
puts a
# Métodos acessores de classe Ruby

class Carro

    # attr_accessor :marca, :modelo
    attr_reader :marca, :modelo
    attr_writer :marca, :modelo

    # construtor
    def initialize(modelo, marca)
        @modelo = modelo
        @marca = marca
    end

    def descricao
        "Marca #{@marca} e Modelo #{@modelo}"
    end

    def velocidade_maxima
        250
    end
end

carro = Carro.new("Chevrolet", "Tesla")
puts carro.descricao
carro.marca = "Ford"
carro.modelo = "T560"
puts "Marca: " + carro.marca
puts "Modelo: " + carro.modelo
puts carro.descricao
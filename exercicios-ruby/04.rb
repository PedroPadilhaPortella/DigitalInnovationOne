# Herança de Classe

class Automovel

    # metodo estático
    def self.tipo_cambio
        puts "Manual"
    end

    def acelerar
        puts "Acelerando automovel"
    end
end

class Carro < Automovel
    def acelerar
        puts "Ligando Carro"
        super
    end
end

carro = Carro.new
carro.acelerar

Automovel.tipo_cambio
Carro.tipo_cambio
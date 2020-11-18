# Visibilidade de Metodos

class Automovel
    def self.tipo_cambio
        puts "Manual"
    end

    # metodo publico, pode ser acessado por todos
    public
    def acelerar
        puts "Acelerando automovel"
    end

    # metodo privado, não pode ser acessado fora da classe, mas pode ser acessado pela classe filha
    private
    def venderAutomovel
        puts "Vendido por $$ 50.000,00"
    end
end

carro = Automovel.new
carro.venderAutomovel
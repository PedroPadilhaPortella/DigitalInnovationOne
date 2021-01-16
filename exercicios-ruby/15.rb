# Módulos
module Shared
    def imprimir
        puts "Teste"
    end
end

class Teste
    include Shared
    def executar
        puts "Testando..."
    end
end

c = Teste.new
c.imprimir
c.executar
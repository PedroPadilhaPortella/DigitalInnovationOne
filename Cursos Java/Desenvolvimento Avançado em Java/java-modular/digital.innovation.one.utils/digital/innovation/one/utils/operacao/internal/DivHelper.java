package digital.innovation.one.utils.operacao.internal;

public class DivHelper implements Operacao {

	@Override
	public int execute(int a, int b) {
		int div = 0;
		try {
			div = a / b;			
		}
		catch(Exception e) {
			System.out.println("Erro ao processar divisão");
		}
		return div;
	}

}

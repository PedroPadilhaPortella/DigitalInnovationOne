package digital.innovation.one.utils.operacao;

import digital.innovation.one.utils.operacao.internal.DivHelper;
import digital.innovation.one.utils.operacao.internal.ProdHelper;
import digital.innovation.one.utils.operacao.internal.SubHelper;
import digital.innovation.one.utils.operacao.internal.SumHelper;

public class Calculadora {

	private SumHelper sumHelper;
	private SubHelper subHelper;
	private ProdHelper prodHelper;
	private DivHelper divHelper;
	
	public Calculadora() {
		sumHelper = new SumHelper();
		subHelper = new SubHelper();
		prodHelper = new ProdHelper();
		divHelper = new DivHelper();
	}
	
	public int sum(int a, int b) {
		return sumHelper.execute(a, b);
	}
	
	public int sub(int a, int b) {
		return subHelper.execute(a, b);
	}
	
	public int prod(int a, int b) {
		return prodHelper.execute(a, b);
	}
	
	public int div(int a, int b) {
		return divHelper.execute(a, b);
	}
}

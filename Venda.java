import java.io.Serializable;

public class Venda implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Produto produto;
	private Vendedor vendedor;
	private float desconto;
	private float valorDesconto;
	private int quantidadeItens;
	private float valor;
	private float valorComissao;
	
	
	


	public Venda (Vendedor vendedor, Produto produto, int quantidadeItens)
	{
		this.vendedor = vendedor;
		this.produto = produto;
		this.quantidadeItens = quantidadeItens;
	}
	
	public void calcularValor(){
		
		valor = quantidadeItens*produto.getValorVenda();
	}
	
	public void calcularComissao(){
		
		vendedor.setComissao(10);
		if(produto.isPromocao() == true)
		{
			vendedor.setComissao(10/2);
		}
		valorComissao = (valor*vendedor.getComissao()/100);
	}
	
	public void efetuarDesconto(float desconto){
		
		if(produto.isPromocao() == true)
		{
			float resultado = produto.getValorVenda()-(produto.getValorVenda()*desconto/100);
			
			if(resultado > produto.getValorCusto())
			{
				this.valorDesconto = (produto.getValorVenda()*desconto/100);
				this.desconto = desconto;
				produto.setValorVenda(resultado);
			}
			else
			{
				System.out.println("\nO valor de venda é menor que o de custo");
				
				this.desconto = 0;
				this.valorDesconto = 0;
				
				
			}
		}else{System.out.println("O produto n esta em promoção");}
		
	}
	

	public void imprimir(){
		
		System.out.println("Vendendor: " + vendedor.getNome()
						+ "\nCodigo: "  + vendedor.getCodigo()
						+ "\nComissao: "+ vendedor.getComissao()+  "%" +
						" Valor " + valorComissao + "$");
		
		System.out.println("Quantidade de itens: " + quantidadeItens);
		
		System.out.println("Código do produto: " + produto.getCodigo()
						+ "\nDescrição do produto: " + produto.getDescricao()
						+ "\nValor de venda do produto: " + produto.getValorVenda()+ "$" + "\n");
		
		System.out.println(produto.isPromocao() == true ? "Promoção: Sim" : "Promoção: Não");
		
		System.out.println("Desconto do produto: " + desconto+ "%" +
						"\nValor total: " + valor + "$\n\n");
		
		if(produto.isPromocao() == true)
		{
			produto.setValorVenda(produto.getValorVenda() + valorDesconto);
		}
		
		
		
	}
	
	
	
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public float getDesconto() {
		return desconto;
	}
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	public int getQuantidadeItens() {
		return quantidadeItens;
	}
	public void setQuantidadeItens(int quantidadeItens) {
		this.quantidadeItens = quantidadeItens;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public float getValorComissao() {
		return valorComissao;
	}

	public void setValorComissao(float valorComissao) {
		this.valorComissao = valorComissao;
	}
	
	public float getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(float valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	

}

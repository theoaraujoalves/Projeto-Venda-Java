import java.util.ArrayList;
import java.util.Scanner;

public class Principal 
{
	
	public static void main(String[] args) 
	{
		ArrayList<Venda> listavendas = new ArrayList<Venda> ();
		ArrayList<Vendedor> listavendedor = new ArrayList<Vendedor> ();
		ArrayList<Produto> listaproduto = new ArrayList<Produto> ();
		SalvarLer salvaler = new SalvarLer();
		Scanner leitor = new Scanner(System.in);
		

		

			
			System.out.println(" 1 - Cadastrar Produto"
							+ "\n2 - Cadastrar Vendedor"
							+ "\n3 - Realizar Venda"
							+ "\n99 - Sair");
			
			while(true)
			{
				int resposta;
				try
				{
					resposta = leitor.nextInt();
				}
				catch(Exception e)
				{
					System.out.println("Por favor digite uma op��o v�lida");
					resposta = 0;
				}
				
				if(resposta == 1) //Cadastrar Produto ###############
				{
					int codigo = 0;
					String descricao="";
					float valorcusto=0;
					float valorvenda=0;
					boolean promocao = false;
					
					while(true)
					{
						boolean pass = true;
						System.out.println("Digite o c�digo do produto:");
						try{codigo = leitor.nextInt();}
						catch(Exception e)
						{
							System.out.println("Porfavor digite um c�digo v�lido");
							pass = false; 
							
						}
						if(pass == true){break;}
						
					}
					
					while(true)
					{
						boolean pass = true;
						System.out.println("Digite a descri��o do produto:");
						try{descricao = leitor.nextLine();}
						catch(Exception e)
						{
							System.out.println("Porfavor digite caracteres v�lidos");
							pass = false; 
						}
						if(pass == true){break;}
					}
					
					while(true)
					{
						boolean pass = true;
						System.out.println("Digite o valor de custo do produto:");
						try{valorcusto = leitor.nextFloat();}
						catch(Exception e)
						{
							System.out.println("Porfavor digite um valor v�lido");
							pass = false; 
						}
						if(pass == true){break;}
					}
					
					while(true)
					{
						boolean pass = true;
						System.out.println("Digite o valor de venda do produto:");
						try{valorvenda = leitor.nextFloat();}
						catch(Exception e)
						{
							System.out.println("Porfavor digite um valor v�lido");
							pass = false; 
						}
						if(pass == true){break;}
					}
					
					
					while(true)
					{
						int escolha = 3;
						boolean pass = true;
						System.out.println("Digite o produto est� na promo��o? 1-Sim ou 0-N�o");
						try{escolha = leitor.nextInt();}
						catch(Exception e)
						{
							System.out.println("Porfavor digite um valor v�lido");
							pass = false; 
						}
						if(pass == true)
						{
							if(escolha == 1)
							{
								promocao = true;
								break;
								
							}
							else if(escolha == 0)
							{
								promocao = false;
								break;
								
							}
							else{System.out.println("Porfavor digite uma op��o v�lida");}
						}
				
					}
					
					Produto produto = new Produto (codigo,descricao, valorvenda, valorcusto, promocao);
					listaproduto.add(produto);
				}
				
				else if(resposta == 2) // Cadastrar Vendedor #################
				{
					String nome ="";
					String endereco = "";
					int codigo = 0;
					
					while(true)
					{
						boolean pass = true;
						System.out.println("Digite o nome do vendedor:");
						try{nome = leitor.nextLine();}
						catch(Exception e)
						{
							System.out.println("Porfavor digite um nome v�lido");
							pass = false; 
							
						}
						if(pass == true){break;}
						
					}
					
					while(true)
					{
						boolean pass = true;
						System.out.println("Digite o endereco do vendedor:");
						try{nome = leitor.nextLine();}
						catch(Exception e)
						{
							System.out.println("Porfavor digite um endere�o v�lido");
							pass = false; 
							
						}
						if(pass == true){break;}
						
					}
					
					while(true)
					{
						boolean pass = true;
						System.out.println("Digite o c�digo do vendedor:");
						try{codigo = leitor.nextInt();}
						catch(Exception e)
						{
							System.out.println("Porfavor digite um c�digo v�lido");
							pass = false; 
							
						}
						if(pass == true){break;}
						
					}
					
					
					Vendedor vendedor = new Vendedor (nome,endereco, codigo);
					listavendedor.add(vendedor);
				}
				
				else if(resposta == 3) //Realizar venda ########
				{
					Produto produto = null;
					Vendedor vendedor = null;
					int quantidadeItens = 0;
					float desconto = 0;
					
					
					while(true)
					{
						int i;
						int escolha;
						boolean pass = true;
						System.out.println("Escolha um produto: ");
						for(i = 0; i<listaproduto.size(); i++)
						{
							System.out.println(i + " " + listaproduto.get(i).getDescricao());
						}
						System.out.println("Escolha o numero do seu produto");
						try
						{
							escolha = leitor.nextInt();
							if(listaproduto.get(escolha) != null)
							{
								if(listaproduto.get(escolha).isPromocao())
								{
									System.out.println("Este item esta na promo��o quanto desconto este item est� ?");
									while(true)
									{
										try
										{
											desconto = leitor.nextFloat();
										}
										catch(Exception e)
										{
											System.out.println("Digite um desconto v�lido");
										}
									}
									
								}
								produto = listaproduto.get(escolha);
							}
							else{pass = false;}
						}
						catch(Exception e)
						{
							System.out.println("Porfavor digite um numero v�lido");
							pass = false; 
							
						}
						if(pass == true){break;}
						
					}
					
					
					while(true)
					{
						boolean pass = true;
						System.out.println("Digite o c�digo do vendedor:");
						try{quantidadeItens = leitor.nextInt();}
						catch(Exception e)
						{
							System.out.println("Porfavor digite uma quantidade v�lida");
							pass = false; 
							
						}
						if(pass == true){break;}
						
					}
					
					
					
					while(true)
					{
						int i;
						int escolha;
						boolean pass = true;
						System.out.println("Qual o vendedor: ");
						for(i = 0; i<listavendedor.size(); i++)
						{
							System.out.println(i + " " + " - " + listavendedor.get(i).getNome());
						}
						System.out.println("Escolha o vendedor pelo numero");
						try
						{
							escolha = leitor.nextInt();
							if(listavendedor.get(escolha) != null)
							{
								vendedor = listavendedor.get(escolha);
							}
							else{pass = false;}
						}
						catch(Exception e)
						{
							System.out.println("Porfavor digite um numero v�lido");
							pass = false; 
							
						}
						if(pass == true){break;}
						
					}
					
					Venda venda = new Venda (vendedor, produto, quantidadeItens);
					venda.calcularValor();
					venda.calcularComissao();
					venda.efetuarDesconto(desconto);
					listavendas.add(venda);
					salvaler.salvar("nota1", venda);
				}
				
				else if(resposta == 99)
				{
					break;
				}
				
				else{ System.out.println("Porfavor digite uma op��o v�lida");}
			
			}
			leitor.close();
			
	}

	
}


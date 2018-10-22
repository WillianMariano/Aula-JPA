package br.unifenas.sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import br.unifenas.aulajpa2.dao.CarroDAO;
import br.unifenas.aulajpa2.dao.ClienteDAO;
import br.unifenas.aulajpa2.dao.EnderecoDAO;
import br.unifenas.aulajpa2.dao.JPAUtil;
import br.unifenas.aulajpa2.dao.OrcamentoDAO;
import br.unifenas.aulajpa2.dao.PecaDAO;
import br.unifenas.aulajpa2.model.Carro;
import br.unifenas.aulajpa2.model.Cliente;
import br.unifenas.aulajpa2.model.Endereco;
import br.unifenas.aulajpa2.model.Orcamento;
import br.unifenas.aulajpa2.model.Peca;
import br.unifenas.aulajpa2.model.TipoCombustivel;

public class TestaJPA {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		TipoCombustivel aux;
		List<Carro> listacarro=new ArrayList<>();
		List<Peca> listapeca=new ArrayList<>();
		System.out.println("=======================Sistema Oficina======================");
		System.out.println("1 - Cadastrar cliente");
		System.out.println("2 - Cadastrar peça");
		System.out.println("3 - Cadastrar orçamento");
		System.out.println("Digite o valor da opção desejada:");
		int opcao=input.nextInt();
		switch(opcao) {
			case 1:
				System.out.println("Quantos carros o cliente possui?");
				int c=input.nextInt();
				for(int i=0;i<c;i++)
				{
					System.out.println("Modelo:");
					String mo=input.next();
					System.out.println("Marca:");
					String ma=input.next();
					System.out.println("Combustivel:");
					String com=input.next();
					if(com=="Gasolina")
					{
						aux=TipoCombustivel.GASOLINA;
					}
					else {
						aux=TipoCombustivel.ALCOOL;
					}
					System.out.println("Valor:");
					float val=input.nextFloat();
					Carro car=new Carro(mo,ma,aux,val);
					listacarro.add(car);
				}
				System.out.println("Endereço");
				System.out.println("Rua:");
				String r=input.next();
				System.out.println("Numero:");
				String n=input.next();
				System.out.println("Bairro:");
				String b=input.next();
				System.out.println("Cidade:");
				String cid=input.next();
				Endereco end=new Endereco(r,b,n,cid);
				System.out.println("Dados do cliente");
				System.out.println("Nome:");
				String nom=input.next();
				System.out.println("CPF:");
				String cpf=input.next();
				Cliente cli=new Cliente(nom, cpf, end, listacarro);
				ClienteDAO cliDAO=new ClienteDAO();
				cliDAO.create(cli);
				break;
			case 2:
				System.out.println("Quantos peças serão cadastradas?");
				int p=input.nextInt();
				for(int i=0;i<p;i++)
				{
					System.out.println("Descrição:");
					String des=input.next();
					System.out.println("Valor:");
					float val=input.nextFloat();
					Peca pec=new Peca(des, val);
					PecaDAO pecaDAO=new PecaDAO();
					pecaDAO.create(pec);
				}
				break;
			case 3:
				PecaDAO pecaDAO=new PecaDAO();
				listapeca.add(pecaDAO.readId(1));
				listapeca.add(pecaDAO.readId(4));
				CarroDAO carroDAO=new CarroDAO();
				Carro car=carroDAO.readId(3);
				ClienteDAO clienteDAO=new ClienteDAO();
				Cliente cl=clienteDAO.readId(2);
				Orcamento orc=new Orcamento(cl,20,car,listapeca);
				OrcamentoDAO orcamentoDAO=new OrcamentoDAO();
				orcamentoDAO.create(orc);
			default:
				System.out.println("Esta opção não é valida");
		}
	}
}
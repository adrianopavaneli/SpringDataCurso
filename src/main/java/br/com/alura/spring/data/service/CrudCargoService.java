package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {
	private Boolean system = true;
	private final CargoRepository cargoRepository;

	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	public void inicial(Scanner sc) {
		while (system) {
			System.out.println("Qual a operação de cargo você quer executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");

			int action = sc.nextInt();
			switch (action) {
			case 1:
				salvar(sc);
				break;
			case 2:
				atualizar(sc);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(sc);
				break;	
			default:
				system = false;
				break;

			}

		}

	}

	

	public void salvar(Scanner sc) {
		System.out.println("Descricao do cargo: ");
		String descricao = sc.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Salvo!");

	}

	public void atualizar(Scanner sc) {
		System.out.println("Id: ");
		int id = sc.nextInt();
		System.out.println("Descricao do cargo: ");
		String descricao = sc.next();
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Salvo!");

	}

	public void visualizar() {
		Iterable<Cargo> cargos = cargoRepository.findAll();
		cargos.forEach(cargo -> System.out.println(cargo));
	}
	private void deletar(Scanner sc) {
		System.out.println("Digite o Id do cargo a deletar: ");
		int id = sc.nextInt();
		cargoRepository.deleteById(id);
		System.out.println("Deletado");
		
		
	}
}

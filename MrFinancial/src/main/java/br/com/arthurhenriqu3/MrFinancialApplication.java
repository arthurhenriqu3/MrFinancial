package br.com.arthurhenriqu3;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.arthurhenriqu3.model.BookEntry;
import br.com.arthurhenriqu3.model.Category;
import br.com.arthurhenriqu3.model.Wallet;
import br.com.arthurhenriqu3.model.enums.StatusEnum;
import br.com.arthurhenriqu3.model.enums.TypeEnum;
import br.com.arthurhenriqu3.repository.BookEntryRepository;
import br.com.arthurhenriqu3.repository.CategoryRepository;
import br.com.arthurhenriqu3.repository.WalletRepository;

@SpringBootApplication
public class MrFinancialApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private WalletRepository walletRepository;

	@Autowired
	private BookEntryRepository bookEntryRepository;

	public static void main(String[] args) {
		SpringApplication.run(MrFinancialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// CARTEIRA
		Wallet wPrincipal = new Wallet("Principal", StatusEnum.ATIVO, null);
		Wallet wSecundaria = new Wallet("Secundária", StatusEnum.ATIVO, null);

		walletRepository.saveAll(Arrays.asList(wPrincipal, wSecundaria));

		// CATEGORIA DE DESPESAS
		Category dCustoFixo = new Category(null, "Custo Fixo", null, null, StatusEnum.ATIVO, TypeEnum.DESPESA, null);
		Category dConforto = new Category(null, "Conforto", null, null, StatusEnum.ATIVO, TypeEnum.DESPESA, null);
		Category dMetas = new Category(null, "Metas", null, null, StatusEnum.ATIVO, TypeEnum.DESPESA, null);
		Category dPrazeres = new Category(null, "Prazeres", null, null, StatusEnum.ATIVO, TypeEnum.DESPESA, null);
		Category dLiberdadeFinanceira = new Category(null, "Liberdade Financeira", null, null, StatusEnum.ATIVO,
				TypeEnum.DESPESA, null);
		Category dConhecimento = new Category(null, "Conhecimento", null, null, StatusEnum.ATIVO, TypeEnum.DESPESA,
				null);

		// CATEGORIA DE DESPESAS
		Category rSalario = new Category(null, "Salário", null, null, StatusEnum.ATIVO, TypeEnum.RECEITA, null);
		Category rRendimento = new Category(null, "Rendimentos", null, null, StatusEnum.ATIVO, TypeEnum.RECEITA, null);

		// INSERT BD CATEGORIAS
		categoryRepository.saveAll(Arrays.asList(dCustoFixo, dConforto, dMetas, dPrazeres, dLiberdadeFinanceira,
				dConhecimento, rSalario, rRendimento));

		// LANÇAMENTOS
		/**
		 * 
		 * 
		 * BookEntry(Category category, Wallet wallet, String name, BigDecimal value,
		 * LocalDate date, StatusEnum status) {
		 * 
		 */
		BookEntry beAluguel1 = new BookEntry(dCustoFixo, wPrincipal, "Aluguel 01/12", null, new BigDecimal(2800),
				LocalDate.of(2023, 9, 3), StatusEnum.ATIVO);

		BookEntry beCondominio1 = new BookEntry(dCustoFixo, wPrincipal, "Condominio 01/12", null, new BigDecimal(2800),
				LocalDate.of(2023, 9, 3), StatusEnum.ATIVO);

		BookEntry beAluguel2 = new BookEntry(dCustoFixo, wPrincipal, "Aluguel 02/12", null, new BigDecimal(2800),
				LocalDate.of(2023, 10, 3), StatusEnum.ATIVO);

		BookEntry beCondominio2 = new BookEntry(dCustoFixo, wPrincipal, "Condominio 02/12", null, new BigDecimal(2800),
				LocalDate.of(2023, 9, 3), StatusEnum.ATIVO);

		BookEntry beEsporte = new BookEntry(dPrazeres, wPrincipal, "Provas", null, new BigDecimal(1500),
				LocalDate.of(2023, 10, 9), StatusEnum.ATIVO);

		BookEntry beSalario1 = new BookEntry(rSalario, wPrincipal, "Salario", null, new BigDecimal(5000),
				LocalDate.of(2023, 9, 2), StatusEnum.ATIVO);

		BookEntry beSalario2 = new BookEntry(rSalario, wPrincipal, "Salario", null, new BigDecimal(5000),
				LocalDate.of(2023, 10, 2), StatusEnum.ATIVO);

		bookEntryRepository.saveAll(
				Arrays.asList(beAluguel1, beCondominio1, beAluguel2, beCondominio2, beEsporte, beSalario1, beSalario2));

	}

}

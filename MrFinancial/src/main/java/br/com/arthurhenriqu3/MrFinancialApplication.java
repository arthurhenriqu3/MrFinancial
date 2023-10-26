package br.com.arthurhenriqu3;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.arthurhenriqu3.model.BookEntry;
import br.com.arthurhenriqu3.model.Category;
import br.com.arthurhenriqu3.model.User;
import br.com.arthurhenriqu3.model.Wallet;
import br.com.arthurhenriqu3.model.enums.StatusEnum;
import br.com.arthurhenriqu3.model.enums.TypeEnum;
import br.com.arthurhenriqu3.repository.BookEntryRepository;
import br.com.arthurhenriqu3.repository.CategoryRepository;
import br.com.arthurhenriqu3.repository.UserRepository;
import br.com.arthurhenriqu3.repository.WalletRepository;

@SpringBootApplication
public class MrFinancialApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private WalletRepository walletRepository;

	@Autowired
	private BookEntryRepository bookEntryRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(MrFinancialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// USUÁRIO
		User user = new User("Arthur", "arthur@gmail.com", "6198300", LocalDate.of(1990, 8, 11), "123456",
				StatusEnum.INATIVO);
		User user2 = new User("Barros", "barros@gmail.com", "6198250", LocalDate.of(1980, 5, 1), "1234",
				StatusEnum.INATIVO);
		

		// CARTEIRA
		Wallet wPrincipal = new Wallet(null, user, "Principal", StatusEnum.ATIVO, new ArrayList<BookEntry>());
		user.getWallets().add(wPrincipal);
		
		Wallet wSecundaria = new Wallet(null, user2, "Secundária", StatusEnum.ATIVO, new ArrayList<BookEntry>());
		user2.getWallets().add(wSecundaria);
		
		// CATEGORIA DE DESPESAS
		Category dCustoFixo = new Category(null, null, "Custo Fixo", null, null, StatusEnum.ATIVO, TypeEnum.DESPESA,
				new ArrayList<Category>());
		Category dConforto = new Category(null, null, "Conforto", null, null, StatusEnum.ATIVO, TypeEnum.DESPESA,
				new ArrayList<Category>());
		Category dMetas = new Category(null, null, "Metas", null, null, StatusEnum.ATIVO, TypeEnum.DESPESA,
				new ArrayList<Category>());
		Category dPrazeres = new Category(null, null, "Prazeres", null, null, StatusEnum.ATIVO, TypeEnum.DESPESA,
				new ArrayList<Category>());
		Category dLiberdadeFinanceira = new Category(null, null, "Liberdade Financeira", null, null, StatusEnum.ATIVO,
				TypeEnum.DESPESA, new ArrayList<Category>());
		Category dConhecimento = new Category(null, null, "Conhecimento", null, null, StatusEnum.ATIVO,
				TypeEnum.DESPESA, new ArrayList<Category>());

		// CATEGORIA DE DESPESAS
		Category rSalario = new Category(null, null, "Salário", null, null, StatusEnum.ATIVO, TypeEnum.RECEITA,
				new ArrayList<Category>());
		Category rRendimento = new Category(null, null, "Rendimentos", null, null, StatusEnum.ATIVO, TypeEnum.RECEITA,
				new ArrayList<Category>());

		// LANÇAMENTOS
		/**
		 * 
		 * 
		 * BookEntry(Category category, Wallet wallet, String name, BigDecimal value,
		 * LocalDate date, StatusEnum status) {
		 * 
		 */
		BookEntry beAluguel1 = new BookEntry(null, dCustoFixo, wPrincipal, "Aluguel 01/12", null, new BigDecimal(2800),
				LocalDate.of(2023, 9, 3), StatusEnum.ATIVO);

		BookEntry beCondominio1 = new BookEntry(null, dCustoFixo, wPrincipal, "Condominio 01/12", null,
				new BigDecimal(2800), LocalDate.of(2023, 9, 3), StatusEnum.ATIVO);

		BookEntry beAluguel2 = new BookEntry(null, dCustoFixo, wPrincipal, "Aluguel 02/12", null, new BigDecimal(2800),
				LocalDate.of(2023, 10, 3), StatusEnum.ATIVO);

		BookEntry beCondominio2 = new BookEntry(null, dCustoFixo, wPrincipal, "Condominio 02/12", null,
				new BigDecimal(2800), LocalDate.of(2023, 9, 3), StatusEnum.ATIVO);

		BookEntry beEsporte = new BookEntry(null, dPrazeres, wPrincipal, "Provas", null, new BigDecimal(1500),
				LocalDate.of(2023, 10, 9), StatusEnum.ATIVO);

		BookEntry beSalario1 = new BookEntry(null, rSalario, wPrincipal, "Salario", null, new BigDecimal(5000),
				LocalDate.of(2023, 9, 2), StatusEnum.ATIVO);

		BookEntry beSalario2 = new BookEntry(null, rSalario, wPrincipal, "Salario", null, new BigDecimal(5000),
				LocalDate.of(2023, 10, 2), StatusEnum.ATIVO);

		
		userRepository.saveAll(Arrays.asList(user, user2));
		
		walletRepository.saveAll(Arrays.asList(wPrincipal, wSecundaria));

		// INSERT BD CATEGORIAS
		categoryRepository.saveAll(Arrays.asList(dCustoFixo, dConforto, dMetas, dPrazeres, dLiberdadeFinanceira,
				dConhecimento, rSalario, rRendimento));

		bookEntryRepository.saveAll(
				Arrays.asList(beAluguel1, beCondominio1, beAluguel2, beCondominio2, beEsporte, beSalario1, beSalario2));
	}
}
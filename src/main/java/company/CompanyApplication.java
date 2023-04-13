package company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompanyApplication {

	// TODO: 12.04.2023 как в dto передавать связки объектов??
	// TODO: 12.04.2023 возможны проблемы с парсингом RQ
	// TODO: 12.04.2023 на github заливать какую-то старую базу

	public static void main(String[] args) {
		SpringApplication.run(CompanyApplication.class, args);
	}

}

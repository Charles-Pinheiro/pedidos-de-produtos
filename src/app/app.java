package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import models.Client;
import models.Order;
import models.OrderItem;
import models.Product;
import models.enums.OrderStatus;

public class app {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Dados do Cliente:");
		System.out.print("Nome: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Data de Nascimento (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());

		Client cliente = new Client(clientName, email, birthDate);

		System.out.println("Dados do Pedido:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());

		Order order = new Order(new Date(), status, cliente);

		System.out.print("Quantos itens para esse pedido? ");
		Integer qtdItems = sc.nextInt();

		for (int i = 0; i < qtdItems; i++) {
			System.out.println("Dados do " + (i+1) + "º item:");
			System.out.print("Nome do Produto: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Preço do Produto: ");
			Double price = sc.nextDouble();
			System.out.print("Quantidade: ");
			Integer quantity = sc.nextInt();

			Product product = new Product(name, price);

			OrderItem orderItem = new OrderItem(quantity, product.getPrice(), product);

			order.addItem(orderItem);
		}

		System.out.println();
		System.out.println("Dados do Pedido:");
		System.out.println(order.toString());

		sc.close();
	}

}

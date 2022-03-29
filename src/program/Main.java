package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.OrderStatus;
import entities.Product;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		System.out.print("Birth Date (dd/mm/yyyy): ");
		Date birthDate = sdf.parse(sc.next());

		Client client = new Client(name, email, birthDate);
		System.out.println("Status: ");
		String status = sc.next();
		System.out.println("How many items to this order? ");
		int x = sc.nextInt();
		Order items = new Order(new Date(), OrderStatus.valueOf(status), client);

		for (int i = 1; i <= x; i++) {
			System.out.println("\nProduct name #" + i + ": ");
			String name1 = sc.next();
			System.out.println("Product price: ");
			Double price = sc.nextDouble();
			System.out.println("Product quantity: ");
			int quantity = sc.nextInt();
			Product product = new Product(name1, price);
			OrderItem orderItem = new OrderItem(quantity, price, product);
			items.addItem(orderItem);
		}

		System.out.println("\n\nOrder moment: " + sdf2.format(items.getMoment()));
		System.out.println("Order status: " + items.getStatus());
		System.out.println(client.getClientInfo());
		System.out.print("Order items: ");
		int j = 1;
		for (OrderItem o : items.getItems()) {
			System.out.println("\n");
			System.out.println("Produto " + j + ": " + o.getProduct().getName());
			System.out.println("Unity price: $" + o.getProduct().getPrice());
			System.out.println("Quantidade pedida: " + o.getQuantity());
			System.out.println("Subtotal do produto: $" + o.subTotal());
			j++;
		}
		System.out.println("\n\nValor total do pedido: $" + items.totalPrice());
		sc.close();
	}

}

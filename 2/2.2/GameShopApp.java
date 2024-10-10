public class GameShopApp {
    public static void main(String[] args) {
        GameShop shop = new GameShop();
        shop.addGame(new BoardGame("Chess", 20.0));
        shop.addGame(new BoardGame("Monopoly", 30.0));
        shop.addGame(new BoardGame("Catan", 40.0));
        shop.addGame(new BoardGame("Carcassonne", 25.0));
        shop.addGame(new BoardGame("Pandemic", 35.0));

        List<Customer> customers = Arrays.asList(
            new Customer("John", 50.0),
            new Customer("Anna", 10.0),
            new Customer("Mike", 30.0),
            new Customer("Sarah", 45.0)
        );

        for (Customer customer : customers) {
            if (!shop.getGames().isEmpty()) {
                BoardGame game = shop.getGames().get(new Random().nextInt(shop.getGames().size()));
                if (customer.canAfford(game)) {
                    customer.buyGame(game);
                    shop.sellGame(game.getName());
                    System.out.println(customer.getName() + " купил " + game.getName() + " за $" + game.getPrice());
                } else {
                    System.out.println(customer.getName() + " не хватает средств на " + game.getName());
                }
            }
        }

        System.out.println("Общая прибыль: $" + shop.getEarnings());
    }
}
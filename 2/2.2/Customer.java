class Customer {
    private final String name;
    private double wallet;

    public Customer(String name, double wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public boolean canAfford(BoardGame game) {
        return wallet >= game.getPrice();
    }

    public void buyGame(BoardGame game) {
        wallet -= game.getPrice();
    }

    public String getName() {
        return name;
    }

    public double getWallet() {
        return wallet;
    }

    @Override
    public String toString() {
        return name + " ($" + wallet + ")";
    }
}
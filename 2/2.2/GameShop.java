class GameShop {
    private final List<BoardGame> games = new ArrayList<>();
    private double earnings;

    public void addGame(BoardGame game) {
        games.add(game);
    }

    public BoardGame sellGame(String gameName) {
        for (BoardGame game : games) {
            if (game.getName().equalsIgnoreCase(gameName)) {
                games.remove(game);
                earnings += game.getPrice();
                return game;
            }
        }
        return null;
    }

    public double getEarnings() {
        return earnings;
    }

    public List<BoardGame> getGames() {
        return new ArrayList<>(games);
    }
}
package source;

/**
 *
 * @author Marlic
 */
public class AlphaBetaSearch {

    public static void alphaBetaSearch(int player) {
        int map = Map.map;
        Map.computerPlayer = player;

        int value = Integer.MIN_VALUE;

        for (int move : Map.moves) {
            int newValue = minValue(Map.setTile(map, move, player), (player + 1) % 2, Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (newValue > value) {
                Map.returnMove = move;
                value = newValue;
            }
        }
    }

    private static int maxValue(int map, int player, int alpha, int beta) {
        // Terminal test
        int result = Map.utility(map);
        if (result != 100) {
            return result;
        }
        Map.visitedStates++;
        int value = Integer.MIN_VALUE;
        // Calculate available moves and execute when found
        for (int position = 0; position < 9; position++) {
            if ((map & (1 << position + 9)) != (1 << position + 9) && (map & (1 << position)) != (1 << position)) {
                value = Math.max(value, minValue(Map.setTile(map, position, player), (player + 1) % 2, alpha, beta));

                if (value >= beta) {
                    return value;
                }
                alpha = Math.max(alpha, value);
            }
        }

        return value;
    }

    private static int minValue(int map, int player, int alpha, int beta) {
        // Terminal test
        int result = Map.utility(map);
        if (result != 100) {
            return result;
        }

        Map.visitedStates++;
        int value = Integer.MAX_VALUE;

        // Calculate available moves and execute when found
        for (int position = 0; position < 9; position++) {
            if ((map & (1 << position + 9)) != (1 << position + 9) && (map & (1 << position)) != (1 << position)) {
                value = Math.min(value, maxValue(Map.setTile(map, position, player), (player + 1) % 2, alpha, beta));

                if (value <= alpha) {
                    return value;
                }

                beta = Math.min(beta, value);
            }
        }
        return value;
    }
}
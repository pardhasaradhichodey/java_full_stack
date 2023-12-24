import java.util.*;
class Item {
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
class Result {
    int value;
    List<Item> items;

    public Result(int value, List<Item> items) {
        this.value = value;
        this.items = items;
    }
}
class Knapsack {
    public static Result knapsack(int W, List<Item> items) {
        int n = items.size();
        int[][] dp = new int[n+1][W+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (items.get(i-1).weight > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-items.get(i-1).weight] + items.get(i-1).value);
                }
            }
        }
        int i = n, j = W;
        List<Item> selectedItems = new ArrayList<>();
        while (i > 0 && j > 0) {
            if (dp[i][j] != dp[i-1][j]) {
                selectedItems.add(items.get(i-1));
                j -= items.get(i-1).weight;
            }
            i--;
        }
        Collections.reverse(selectedItems);

        return new Result(dp[n][W], selectedItems);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int W = scanner.nextInt();

        List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int weight = scanner.nextInt();
            int value = scanner.nextInt();
            items.add(new Item(weight, value));
        }

        Result result = knapsack(W, items);
        System.out.println("Maximum value: " + result.value);
        System.out.println("Selected items: ");
        for (Item item : result.items) {
            System.out.println(item.weight + " " + item.value);
        }
    }
}

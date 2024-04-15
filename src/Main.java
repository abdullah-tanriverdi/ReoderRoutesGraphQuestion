import java.util.*;

// Solution sınıfını tanımlıyoruz
class Solution {
    // Kenarları temsil etmek için bir set ve komşuluk ilişkilerini temsil etmek için bir harita tanımlıyoruz
    private Set<List<Integer>> edges;
    private Map<Integer, List<Integer>> neighbours;
    // Ziyaret edilen düğümleri saklamak için bir küme ve ters yönlendirilmiş kenar sayısını hesaplamak için bir sayaç tanımlıyoruz
    private Set<Integer> visited;
    private int counter;

    // Minimum ters yönlendirilmiş kenar sayısını hesaplayacak metodu tanımlıyoruz
    public int minReorder(int n, int[][] connections) {
        // Tanımladığımız veri yapılarını oluşturuyoruz
        edges = new HashSet<>();
        neighbours = new HashMap<>();
        visited = new HashSet<>();
        counter = 0;

        // Verilen bağlantıları kullanarak kenarları oluşturuyoruz
        for (int[] connection : connections) {
            edges.add(Arrays.asList(connection[0], connection[1]));
        }

        // Her şehir için boş bir liste oluşturarak komşuluk ilişkilerini başlatıyoruz
        for (int city = 0; city < n; city++) {
            neighbours.put(city, new ArrayList<>());
        }

        // Bağlantıları kullanarak her şehrin komşularını belirliyoruz
        for (int[] connection : connections) {
            neighbours.get(connection[0]).add(connection[1]);
            neighbours.get(connection[1]).add(connection[0]);
        }

        // Başlangıç düğümünü ziyaret edildi olarak işaretliyoruz ve DFS algoritmasını başlatıyoruz
        visited.add(0);
        dfs(0);
        // Ters yönlendirilmiş kenar sayısını döndürüyoruz
        return counter;
    }

    // Derinlik öncelikli arama (DFS) algoritması
    private void dfs(int city) {
        // Her bir komşuyu kontrol ediyoruz
        for (int neighbour : neighbours.get(city)) {
            // Eğer komşu zaten ziyaret edildiyse, işlemi atlıyoruz
            if (visited.contains(neighbour)) {
                continue;
            }

            // Eğer kenar (city, neighbour) ters yönlendirilmiş bir kenar değilse, sayaç artırılıyor
            if (!edges.contains(Arrays.asList(neighbour, city))) {
                counter++;
            }

            // Komşuyu ziyaret edildi olarak işaretliyoruz ve DFS algoritmasını tekrar çağırıyoruz
            visited.add(neighbour);
            dfs(neighbour);
        }
    }
}

// Ana sınıfımız
public class Main {
    public static void main(String[] args) {
        // Solution sınıfını oluşturuyoruz
        Solution solution = new Solution();
        // Örnek girdiyi belirliyoruz
        int n = 6; // Toplam şehir sayısı
        int[][] connections = {
                {0,1}, {0,2}, {1,3}, {2,4}, {3,5}, {4,5}
        }; // Bağlantılar
        // minReorder metodu çağırılarak sonucu alıyoruz
        int result = solution.minReorder(n, connections);
        // Sonucu yazdırıyoruz
        System.out.println("Result: " + result);
    }
}

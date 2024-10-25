import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    public List<EconomicData> loadData(String filename) {
        List<EconomicData> dataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(","); // Split by comma
                if (fields.length < 5) continue; // Skip incomplete lines
                String state = fields[0];
                int year = Integer.parseInt(fields[1]);
                int personalIncome = Integer.parseInt(fields[2]);
                int population = Integer.parseInt(fields[3]);
                int perCapitaPersonalIncome = Integer.parseInt(fields[4]);


                dataList.add(new EconomicData(state, year, personalIncome, population, perCapitaPersonalIncome));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }
}






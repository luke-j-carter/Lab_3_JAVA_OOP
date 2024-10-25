import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DataProcessor {

    // Calculate average personal income for each state
    public Map<String, Double> getAveragePersonalIncome(List<EconomicData> dataList) {
        return dataList.stream()
                .collect(Collectors.groupingBy(EconomicData::getState,
                        Collectors.averagingInt(EconomicData::getPersonalIncome)));
    }

    // Calculate minimum personal income for each state
    public Map<String, Integer> getMinPersonalIncome(List<EconomicData> dataList) {
        return dataList.stream()
                .collect(Collectors.groupingBy(EconomicData::getState,
                        Collectors.mapping(EconomicData::getPersonalIncome, Collectors.minBy(Integer::compareTo))))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> entry.getValue().orElse(0))); // Safely extract value
    }

    // Calculate maximum personal income for each state
    public Map<String, Integer> getMaxPersonalIncome(List<EconomicData> dataList) {
        return dataList.stream()
                .collect(Collectors.groupingBy(EconomicData::getState,
                        Collectors.mapping(EconomicData::getPersonalIncome, Collectors.maxBy(Integer::compareTo))))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> entry.getValue().orElse(0))); // Safely extract value
    }

    // Filter data by year
    public List<EconomicData> filterByYear(List<EconomicData> dataList, int year) {
        return dataList.stream()
                .filter(data -> data.getYear() == year)
                .collect(Collectors.toList());
    }

    // Sort data by personal income in ascending order
    public List<EconomicData> sortByPersonalIncome(List<EconomicData> dataList) {
        return dataList.stream()
                .sorted((data1, data2) -> Integer.compare(data1.getPersonalIncome(), data2.getPersonalIncome()))
                .collect(Collectors.toList());
    }

    // Calculate per capita personal income
    public void calculatePerCapitaPersonalIncome(List<EconomicData> dataList) {
        for (EconomicData data : dataList) {
            if (data.getPopulation() > 0) {
                int perCapita = data.getPersonalIncome() / data.getPopulation();
                data.setPerCapitaPersonalIncome(perCapita);
            } else {
                data.setPerCapitaPersonalIncome(0); // Handle division by zero
            }
        }
    }
}






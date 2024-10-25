public class EconomicData {
    private String state;
    private int year;
    private int personalIncome;
    private int population;
    private int perCapitaPersonalIncome;

    public EconomicData(String state, int year, int personalIncome, int population, int perCapitaPersonalIncome) {
        this.state = state;
        this.year = year;
        this.personalIncome = personalIncome;
        this.population = population;
        this.perCapitaPersonalIncome = 0;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPersonalIncome() {
        return personalIncome;
    }

    public void setPersonalIncome(int personalIncome) {
        this.personalIncome = personalIncome;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getPerCapitaPersonalIncome() {
        return perCapitaPersonalIncome;
    }

    public void setPerCapitaPersonalIncome(int perCapitaPersonalIncome) {
        this.perCapitaPersonalIncome = perCapitaPersonalIncome;
    }
}

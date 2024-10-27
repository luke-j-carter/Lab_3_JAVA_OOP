import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class EconomicDataApp {

    private List<EconomicData> economicDataList;
    private JTable table;
    private JTextArea detailsArea;

    public EconomicDataApp(List<EconomicData> data) {
        this.economicDataList = data;
        initializeUI();
    }

    private void initializeUI() {
        JFrame frame = new JFrame("Economic Data Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Table Panel
        String[] columnNames = {"State", "Description", "Personal Income", "Population", "Per Capita Income"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        updateTableData();

        table.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                EconomicData data = economicDataList.get(selectedRow);
                detailsArea.setText(data.toString());
            }
        });

        JScrollPane tableScrollPane = new JScrollPane(table);
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        // Details Panel
        detailsArea = new JTextArea();
        detailsArea.setEditable(false);
        mainPanel.add(detailsArea, BorderLayout.SOUTH);

        // Add main panel to frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void updateTableData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data
        for (EconomicData data : economicDataList) {
            model.addRow(new Object[]{data.getState(), data.getDescription(), data.getPersonalIncome(), data.getPopulation(), data.getPerCapitaPersonalIncome()});
        }
    }

    public static void main(String[] args) {
        try {
            String csvFile = "C:\\Users\\lukej\\IdeaProjects\\Java OOP Lab 3\\Economic Data 1980-2014.csv";
            List<EconomicData> data = CSVReader.readCSV(csvFile);
            SwingUtilities.invokeLater(() -> new EconomicDataApp(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


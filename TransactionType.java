package application;
import java.io.*;
import java.io.PrintWriter;
import java.util.*;

public class TransactionType {
	private String name = "";
	private static ArrayList<TransactionType> transactionTypeList = new ArrayList<TransactionType>();

    public TransactionType(String typeName) {
        name = typeName;
    }

    public String getName() {
        return name;
    }
    
    public static void storeTransactionType(TransactionType newType) throws IOException {
        transactionTypeList.add(newType);

        File typesFile = new File("TransactionTypes.csv");
        
        try (PrintWriter out = new PrintWriter(new FileWriter(typesFile, true))) {
            out.println(newType.getName());
        }
    }
    
    public static List<String> getAllTransactionTypes() throws IOException {
        File typesFile = new File("TransactionTypes.csv");
        List<String> typeNames = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(typesFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                typeNames.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No transaction types file found.");
        }

        return typeNames;
    }

}

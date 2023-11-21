import java.io.*;
import java.util.*;

 class Demo {
    // ... (rest of your class remains unchanged)

    public static void main(String[] args) throws Exception {

        InstructionTable instr = new InstructionTable();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Chetan\\eclipse-workspace\\PassOne\\src\\input.txt"));) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");

                System.out.println(Arrays.toString(parts));
            }
        }
      }
}
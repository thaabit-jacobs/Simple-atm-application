package net.atm.transactions.printer;

import net.atm.transactions.Transaction;
import net.atm.user.User;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class Printer {

    public static void createReceipt(User u, Transaction t)
    {
        try
        {
            FileWriter fileWriter = new FileWriter("/home/codex/Desktop/atm/Simple-atm-application/src/main/resources/receipts/" + u.getUserName() + LocalTime.now()+ ".txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.write(t.receipt());
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

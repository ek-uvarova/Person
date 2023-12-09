package org.example;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        char separator = ';';
        int departmentId = 1;
        String csvFilePath = "foreign_names.csv";
        List<Person> people = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

        boolean flag = false;
        try (InputStream in = Main.class.getClassLoader().getResourceAsStream(csvFilePath);
             CSVReader reader = in == null ? null :
                     new CSVReaderBuilder(new InputStreamReader(in))
                             .withCSVParser(new CSVParserBuilder()
                                     .withSeparator(separator)
                                     .build())
                             .build()) {
            if (reader == null) {
                throw new FileNotFoundException(csvFilePath);
            }
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (!flag) {
                    flag = true;
                } else {
                    System.out.println(Arrays.toString(nextLine));
                    Person person = new Person(Integer.parseInt(nextLine[0]), String.valueOf(nextLine[1]),
                            String.valueOf(nextLine[2]), new Division(departmentId++, String.valueOf(nextLine[4])),
                            Integer.parseInt(nextLine[5]), formatter.parse(nextLine[3]));
                    people.add(person);
                }
            }
        } catch (IOException | CsvValidationException a) {
            a.printStackTrace();
        } catch (ParseException a) {
            throw new RuntimeException(a);
        }

        System.out.println("List of persons");
        System.out.println(Arrays.toString(people.toArray()));
    }

}


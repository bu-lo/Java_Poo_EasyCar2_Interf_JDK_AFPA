package com.afpa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.Scanner;

public class SerializationActions {

    public static void main(String... args) {
    }

    /**
     * Action selector: 1 | Serialization ; 2 | Deserialization ; 3 | Esc.
     * @param customers ArrayList<Customer> App.java
     */
    public static void serializationActionFct(ArrayList<Customer> customers){

        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("Would you like to use informations about Customers with a saving file ?/n");
            System.out.println("- 1 | Serialization/n");
            System.out.println("- 2 | Deserialization/n");
            System.out.println("- 3 | Esc/n");
            System.out.println("Tap 1, 2 or 3 ?/n");
            int answerSerialization = sc.nextInt();
            
            if (answerSerialization == 1) {  //SWITCH CASE -> BREAK / RETURN
                // SERIALIZATION
                serializationFct(customers);
            } else if (answerSerialization == 2) {
                // DESERIALIZATION
                deserializationFct();
            } else { // answer is 3 or something else
                System.out.println("No actions liked to Serialization selected.");
                sc.close();
                return;
            }
        }
    }
        
      /**
       * Serialize - https://ydisanto.developpez.com/tutoriels/java/serialisation-binaire/
       * @param p ArrayList<Customer>
       */  
    public static void serializationFct(ArrayList<Customer> p) {
        try {
            // ouverture d'un flux de sortie vers le fichier "personne.serial"
            FileOutputStream fos = new FileOutputStream("customer.serial");

            // création d'un "flux objet" avec le flux fichier
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            try {
                // sérialisation : écriture de l'objet dans le flux de sortie
                oos.writeObject(p);
                // on vide le tampon
                oos.flush();
                System.out.println(p + " a ete serialise");
            } finally {
                // fermeture des flux
                try {
                    oos.close();
                } finally {
                    fos.close();
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Deserialize - https://ydisanto.developpez.com/tutoriels/java/serialisation-binaire/
     * @return Deserialized ArrayList<Customer>
     */
    public static ArrayList<Customer> deserializationFct(){
        
        ArrayList<Customer> p = null;
            try {
                // ouverture d'un flux d'entrée depuis le fichier "personne.serial"
                FileInputStream fis = new FileInputStream("customer.serial");
                // création d'un "flux objet" avec le flux fichier
                ObjectInputStream ois= new ObjectInputStream(fis);
                try {    
                    // désérialisation : lecture de l'objet depuis le flux d'entrée
                    p = (ArrayList<Customer>) ois.readObject(); 
                } finally {
                    // on ferme les flux
                    try {
                        ois.close();
                    } finally {
                        fis.close();
                    }
                }
            } catch(IOException ioe) {
                ioe.printStackTrace();
            } catch(ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
            }
            if(p != null) {
                System.out.println(p + " a ete deserialise");
            }

            return p;
    }
}

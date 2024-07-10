package com.afpa;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serialization {

    static public void main(String... args) {
    }

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
}

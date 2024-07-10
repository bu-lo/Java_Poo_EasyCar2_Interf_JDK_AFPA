package com.afpa;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {

    static public void main(String ...args) {
        try {
            // création d'une personne
            Customer p = new Customer("Brice", "Clavières", "All. de Pierras", "Auziellecity", "31650");
            System.out.println("creation de : " + p);

            // ouverture d'un flux de sortie vers le fichier "personne.serial"
            FileOutputStream fos = new FileOutputStream("customer.serial");

            // création d'un "flux objet" avec le flux fichier
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            try {
                // sérialisation : écriture de l'objet dans le flux de sortie
                oos.writeObject(p); 
                // on vide le tampon
                oos.flush();
                System.out.println(p + " a ete serialise");
            } finally {
                //fermeture des flux
                try {
                    oos.close();
                } finally {
                    fos.close();
                }
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

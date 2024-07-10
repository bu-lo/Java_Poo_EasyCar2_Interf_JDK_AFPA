package com.afpa;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Deserialization {
    
    static public void main(String ...args) {
    }
    
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
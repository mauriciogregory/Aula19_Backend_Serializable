import model.Cachorro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Programa {
    public static void main(String[] args) {
        List<Cachorro> cachorros = new ArrayList<>();

        Cachorro c1 =new Cachorro();
        c1.setNome("Rex");
        c1.setRaca("Vira-lata");
        c1.setEndereco("Rua Carcará");
        c1.setIdade(4);

        Cachorro c2 = new Cachorro("Phi", "Pastor Alemão", 3,"Rua das Hortências");

        cachorros.add(c1);
        cachorros.add(c2);

        // salvar a coleção cachorros em um arquivo
        FileOutputStream fo = null;
        try {
            // prepara para recebe um aquivo
            fo = new FileOutputStream("Arquivo_gerado.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(cachorros);
        }
        // precisa lançar duas exceções
        catch (FileNotFoundException e){
            System.out.println("Error:" + e.getMessage());
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        // Recuperar a coleção cachorros de um arquivo, em outra lista
        // para não sobrescrever o
        List<Cachorro> recuperaDados = new ArrayList<>();
        FileInputStream fi = null;

        try{
            fi =new FileInputStream("Arquivo_gerado.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);
            recuperaDados = (ArrayList) ois.readObject();
        }catch (FileNotFoundException e){
            System.out.println("Error:" + e.getMessage());
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        for(Cachorro c : recuperaDados){
            System.out.println(
                    " | " + c.getNome()
                    + " | " + c.getRaca()
                    + " | " + c.getIdade()
                    + " | " + c.getEndereco()
            );
        }
    }
}

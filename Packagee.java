
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.stream.Stream;

public class Packagee {

        public static void main(String[] args) throws Exception {
        Packagee pa = new Packagee();
        System.out.println("foreachlooptask: " + pa.forEachLoopTask());
        System.out.println("iteratorlooptask: " + pa.iteratorLoopTask());
        System.out.println("streamtask: " + pa.streamTask());
        
/*
        double zipcodesAbove15385 = transactions
                .stream()
                .filter(t -> t.Zipcode >= 15385)
                .mapToDouble(t -> t.ID)

        double averageWeightOfID3452Plus = transactions
                .stream()
                .filter(t -> t.ID >= "MB3452")
                .mapToDouble(PackageTransaction::getWeight)
                .average();

        System.out.println(zipcodesAbove15385);
        System.out.println(averageWeightOfID3452Plus);*/
    }
    
    List<Package> packages;
    protected double weight;
    protected String ID, Zipcode;

    class Package {

        List<Package> packages;
        protected double weight;
        protected String ID, Zipcode;

        public Package(double weight, String ID, String Zipcode) throws Exception {
            Scanner infile = new Scanner(new File("Collections.txt"));
        while (infile.hasNextLine() && (infile.next() != null)) {
            weight = infile.nextDouble();
            ID = infile.next();
            Zipcode = infile.next();
            } 
        }

        public double getWeight() {
            return weight;
        }

        public String toString() {
            return String.format("%s\t%s\t$%f", ID, Zipcode, weight);
        }
    }
    

    public int forEachLoopTask() {
        int count = 0;
        for (Package pa : packages) {
            if (pa.getWeight() > 20.2) {
                count++;
            }
        }
        return count;
    }
    

    public int iteratorLoopTask() {
        Iterator<Package> it = packages.iterator();
        int count = 0;
        while (it.hasNext()) {
            Package pa = it.next();
            if (pa.getWeight() > 20.2) {
                count++;
            }
        }
        return count;
    }

    public int streamTask() {
        return (int) packages
                .stream()
                .mapToDouble(Package::getWeight)
                .filter(pa -> pa > 20.2)
                .count();
    }


}

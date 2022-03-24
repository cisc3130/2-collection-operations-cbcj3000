
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.stream.Stream;

public class PackageInfo {

    List<Package> packages;

    public PackageInfo() throws FileNotFoundException {
        Scanner infile = new Scanner(new File("Collections.txt"));
        packages = new ArrayList<Package>(100);
        /* (!infile.hasNext()) {
            return null;
        }*/
        double weight = infile.nextDouble();
        String ID = infile.next();
        String Zipcode = infile.next();
        packages.add(new Package(weight, ID, Zipcode));
    }

class Package {
    protected double weight;
    protected String ID, Zipcode;
    
    Package(double weight, String ID, String Zipcode){
			this.weight=weight;
			this.ID = ID;
			this.Zipcode = Zipcode;
		}
    
    
public double getWeight() {
        return weight;
    }

    public String getID() {
        return ID;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public String toString() {
        return String.format("%s\t%s\t$%f", weight, ID, Zipcode);
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
        Iterator<Package> pa = packages.iterator();
        int count = 0;
        while (pa.hasNext()) {
            Package p = pa.next();
            if (p.getWeight() > 20.2) {
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

    public static void main(String[] args) throws Exception {
        PackageInfo pa = new PackageInfo();
        System.out.println("foreachlooptask: " + pa.forEachLoopTask());
        System.out.println("iteratorlooptask: " + pa.iteratorLoopTask());
        System.out.println("streamtask: " + pa.streamTask());

        /*
        System.out.println(zipcodesAbove15385);
        System.out.println(averageWeightOfID3452Plus);*/
    }
}

/*
forEachLoopTask(): 7 lines
iteratorLoopTask(): 9 lines
streamTask(): 6 lines

The forEachLoopTask seems best suited for this task





 */

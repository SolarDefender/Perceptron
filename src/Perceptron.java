import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Perceptron {
    private double obliqueness;
    private double learningRate;
    private List<Double> vector;
    private List<Double> weight;

    public Perceptron( double learningRate) {
        Random rand = new Random();
        this.obliqueness = rand.nextDouble(1);
        this.learningRate = learningRate;
        this.vector=new ArrayList<>();
        this.weight=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            double value=rand.nextDouble(1);
            this.weight.add(value);
            System.out.println(value);
        }
        System.out.println("obliqueness: "+obliqueness);

    }

    public void start() {
       calculate("perceptron.data",true);
        System.out.println(calculate("perceptron.test.data",false)+"%");
    }

    public int calculate(String filePath,boolean learn){
        try {
            int durationOfLearning=1;
            int counter = 0;
            int succesCounter = 0;
            if (learn) {
                Scanner sc = new Scanner(System.in);
                durationOfLearning = sc.nextInt();
                sc.close();
            }
            for (int i = 0; i < durationOfLearning; i++) {

                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));

                for (String str; (str = reader.readLine()) != null;counter++ ) {
                    String[] splited = str.split(",");


                    int awaited = splited[splited.length-1].equals("Iris-versicolor") ? 0 : 1;

                    for (int j = 0; j < weight.size(); j++)
                        vector.add(Double.parseDouble(splited[j]));

                    double net = 0;
                    for (int j = 0; j < weight.size(); j++)
                        net += (vector.get(j) * weight.get(j));
                    net -= obliqueness;

                    net=net>0?1:0;

                    if (learn) {
                        for (int k = 0; k < weight.size(); k++)
                            weight.set(k, weight.get(k) + learningRate * (awaited - net) * vector.get(k));
                        obliqueness = obliqueness - learningRate * (awaited - net);
                    }
                    else
                        succesCounter += ((int) net == awaited ? 1 : 0);

                    vector=new ArrayList<>();
                }

            }
            //System.out.println(learn+" "+ counter+" "+succesCounter);

            return succesCounter*100/counter;
        }
        catch (Exception e)
        {

            e.printStackTrace();
        }
        return 0;
    }


}

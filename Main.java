/* AUTHOR https://github.com/code-blooded */

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class random_graph {
    public int nodes;
    private List connected;
    private List unconnected;
    private PrintWriter writer;

    random_graph(int n){
        nodes = n;
        connected = new ArrayList();
        unconnected = new ArrayList();
        connected.add(1);
        for (int i = 2; i <= nodes; i++) {
            unconnected.add(i);
        }
        try {
            writer = new PrintWriter("the-file-name.txt", "UTF-8");
        }catch (Exception e) {
            System.out.println("File Error");
        }
    }
    void generate(double percentage){
        int extra_edges,edges;
        extra_edges = (int)(nodes*nodes*(percentage/100.0));
        System.out.println(extra_edges);
        edges = 0;
        Random R = new Random(4587);
        while(!unconnected.isEmpty()){
            int temp1 = R.nextInt(connected.size());
            int temp2 = R.nextInt(unconnected.size());
            int u = (int)connected.get(temp1);
            int v = (int)unconnected.get(temp2);
            addEdge(u,v);
            unconnected.remove(temp2);
            connected.add(v);
            edges++;
        }
        while(extra_edges>0){
            int temp1 = R.nextInt(nodes);
            int temp2 = R.nextInt(nodes);
            addEdge(temp1,temp2);
            extra_edges--;
        }
        writer.close();
    }
    void addEdge(int u,int v){
        //System.out.println(u+" "+v);
        writer.println(u+" "+v);
    }
}

public class Main {

    public static void main(String[] args) {

        random_graph g = new random_graph(1000);
        g.generate(0.1);

    }
}

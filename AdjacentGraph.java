package Graphs;
import java.util.*;

public class AdjacentGraph {
    static class Edge{
        int src; // source
        int des; //destination
        int wt;  // weight;
        public Edge(int src, int des, int wt){
            this.src = src;
            this.des = des;
            this.wt = wt;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2, 2));

        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, -1));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3,2, -1));
    }
    // to print neighbours
    public static void printneighbours(ArrayList<Edge> graph[], int s){
        for(int i=0;i<graph[s].size();i++){
            Edge e = graph[s].get(i);
            System.out.println(+e.des+", "+e.wt);
        }

    }
    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
       printneighbours(graph, 2);
    }
}

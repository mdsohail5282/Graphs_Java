//shortest path
package Graphs;

import java.util.*;

public class BellmanFord {
    static class Edge{
        int src; // source
        int des; //destination
        int wt; //weight
       
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
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2,-4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4,4));

        graph[4].add(new Edge(4, 1,-1));
    }
   
    public static void bellmanFord(ArrayList<Edge> graph[], int src, int v){
        int dist[] = new int[v];
        for(int i=0;i<dist.length;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<v-1;i++){
            for(int j=0;j<v;j++){
                for(int n = 0;n<graph[j].size();n++){
                    Edge e = graph[j].get(n);
                    int s = e.src;
                    int d = e.des;
                    if(dist[s]!=Integer.MAX_VALUE && dist[s]+e.wt < dist[d]){
                        dist[d] = dist[s]+e.wt;
                    }
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
    }
    
    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        bellmanFord(graph, 0, v);
    } 
}


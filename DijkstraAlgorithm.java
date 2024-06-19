//shortest path
package Graphs;

import java.util.*;

public class DijkstraAlgorithm {
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

        graph[1].add(new Edge(1, 3,7));
        graph[1].add(new Edge(1, 2,1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5,1));

        graph[4].add(new Edge(4, 3,2));
        graph[4].add(new Edge(4, 5,5));

    }
   
    public static class Pair implements Comparable<Pair> {
        int Node;
        int dist;
        public Pair(int Node, int dist){
            this.Node = Node;
            this.dist = dist;
        }
        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist;
        }
    }

    public static void Dijkstra(ArrayList<Edge> graph[], int src, int v){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean visit[] = new boolean[v];
        int dist[] = new int[v];
        for(int i=0;i<v;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!visit[curr.Node]){
                visit[curr.Node] = true;
                for(int i=0;i<graph[curr.Node].size();i++){
                    Edge e = graph[curr.Node].get(i);
                    int s = e.src;
                    int d = e.des;
                    if(dist[s]+e.wt < dist[d]){
                        dist[d] = dist[s]+e.wt;
                        pq.add(new Pair(d, dist[d]));
                    }
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
    }
    
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        Dijkstra(graph, 0, v);
    } 
}


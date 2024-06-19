
package Graphs;

import java.util.*;

public class CycleDetectionForUndirectedGraph {
    static class Edge{
        int src; // source
        int des; //destination
       
        public Edge(int src, int des){
            this.src = src;
            this.des = des;
            
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        

        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));
    }
    public static boolean checkCycle(ArrayList<Edge> graph[], int curr, int par, boolean visit[]){
        visit[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(visit[e.des]==true && e.des != par){
                return true;
            }
            else if(!visit[e.des]){
                checkCycle(graph, e.des, curr, visit){
                    return true;
                }
            }
        }
        return false;
    }
   
 
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        boolean visit[] = new boolean[v];
        boolean result = checkCycle(graph, 0, -1, visit);  
        System.out.println(result);
    } 
}

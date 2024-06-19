package Graphs;

import java.util.*;

public class cycleGraph {
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
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));

    }
    public static boolean checkCycle(ArrayList<Edge> graph[], boolean visit[], boolean res[], int curr){
        visit[curr] = true;
        res[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(res[e.des]){
                return true;
            }
            else if(!visit[e.des]){
                if(checkCycle(graph, visit, res, e.des)){
                    return true;
                }
            } 
        }
        res[curr] = false;
        return false;
    }
    
    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
       
        boolean visit[] = new boolean[v];
        boolean res[] = new boolean[v];
        boolean result = checkCycle(graph, visit, res, 0);
        System.out.println(result);
    } 
}

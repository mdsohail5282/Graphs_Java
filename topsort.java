package Graphs;

import java.util.*;

public class topsort {
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
       

        graph[2].add(new Edge(2, 3));
  
        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }
    public static void topsortutil(ArrayList<Edge> graph[], Stack<Integer> stack, boolean visit[], int curr ){
        visit[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visit[e.des]){
                topsortutil(graph, stack, visit, e.des);
            }
        }
        stack.push(curr);
    }
    
    public static void topsort(ArrayList<Edge> graph[], int v){
        Stack<Integer> stack = new Stack<>();
        boolean visit[] = new boolean[v];
        for(int i=0;i<v;i++){
            if(!visit[i]){
                topsortutil(graph, stack, visit, i);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
 
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        topsort(graph, v);        
    } 
}

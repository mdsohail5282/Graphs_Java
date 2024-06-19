package Graphs;

import java.util.*;

public class GraphDFS {
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
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6,5));
    }
    public static void printDFS(ArrayList<Edge> graph[], int curr, boolean visit[]){
        System.out.print(curr +" ");
        visit[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(visit[e.des]==false){
                printDFS(graph, e.des, visit);
            }
        }
    }
    public static void findallpath(ArrayList<Edge> graph[], boolean visiedarr[], int curr, int des, String path){
        if(curr == des){
            System.out.println(path);
            return;
        }
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visiedarr[e.des]){
                visiedarr[curr] = true;  
                findallpath(graph, visiedarr, e.des, des, path+e.des);
                visiedarr[curr] = false;
            }
        }
    }
    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        boolean visit[] = new boolean[v];
       
        boolean visitedarr[] = new boolean[v];
        int src = 0;
        int des = 5;
        findallpath(graph, visit, src, des, "0");
        
    } 
}
